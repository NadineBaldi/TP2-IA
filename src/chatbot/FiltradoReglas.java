package chatbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import criteriosSistemaProduccion.Estrategia;
import nlp.NLP;
import reglas.Regla;
import reglas.ReglaPregunta;
import reglas.ReglaRespuesta;
import reglas.TipoFiltroPregunta;
import reglas.TipoRespuestaUsuario;
import utils.EscribirTxt;

public class FiltradoReglas {
	
	private ArrayList<ReglaPregunta> reglasPreguntas; //reglas de tipo pregunta que estan disponibles
	private ArrayList<ReglaRespuesta> reglasRespuestas; //reglas de tipo respuesta que estan disponibles
	private ArrayList<Regla> reglasPreguntasUsadas; //reglas de tipo pregunta que ya se usaron
	private ArrayList<Regla> reglasRespuestasUsadas; //reglas de tipo respuesta que ya se usaron
	private TipoFiltroPregunta tipoPreg; //es la pregunta actual (la ultima que el bot pregunto)
	private ArrayList<TipoFiltroPregunta> preguntadas; //guardamos en una lista los tipos de preguntas que ya fueron hechos
	private FiltradoServicios filtradoServicios;
	private NLP nlp;
	
	public FiltradoReglas() {
		
		this.inicializarVariables();
		
		//estas dos listas se instancian una unica vez, por eso no va dentro del metodo inicializarVariables, ya que tiene las reglas disponibles y no es necesario instanciarlas cada vez que quiero usarlas
		this.reglasPreguntas = new ArrayList<ReglaPregunta>(); 
		this.reglasRespuestas = new ArrayList<ReglaRespuesta>();
		BaseDeDatosDeReglas BDR = BaseDeDatosDeReglas.getInstance(); //obtengo una instancia de la base de datos
		this.reglasPreguntas.addAll(BDR.getReglasPreg());
		this.reglasRespuestas.addAll(BDR.getReglasRes());
		this.nlp = new NLP();
		this.filtradoServicios = new FiltradoServicios();
		
	}
	
	public void inicializarVariables() {
		this.reglasPreguntasUsadas = new ArrayList<Regla>();
		this.reglasRespuestasUsadas = new ArrayList<Regla>();
		this.tipoPreg = TipoFiltroPregunta.TIPOSERVICIO; //se arranca siempre preguntando por el tipo de servicio
		this.preguntadas = new ArrayList<TipoFiltroPregunta>();
	}

	// Getters and setters
	public ArrayList<ReglaPregunta> getReglasPreguntas() {
		return reglasPreguntas;
	}

	public void setReglasPreguntas(ArrayList<ReglaPregunta> reglasPreguntas) {
		this.reglasPreguntas = reglasPreguntas;
	}

	public ArrayList<ReglaRespuesta> getReglasRespuestas() {
		return reglasRespuestas;
	}

	public void setReglasRespuestas(ArrayList<ReglaRespuesta> reglasRespuestas) {
		this.reglasRespuestas = reglasRespuestas;
	}

	public ArrayList<Regla> getReglasPreguntasUsadas() {
		return reglasPreguntasUsadas;
	}

	public void setReglasPreguntasUsadas(ArrayList<Regla> reglasPreguntasUsadas) {
		this.reglasPreguntasUsadas = reglasPreguntasUsadas;
	}

	public ArrayList<Regla> getReglasRespuestasUsadas() {
		return reglasRespuestasUsadas;
	}

	public void setReglasRespuestasUsadas(ArrayList<Regla> reglasRespuestasUsadas) {
		this.reglasRespuestasUsadas = reglasRespuestasUsadas;
	}

	public TipoFiltroPregunta getTipoPreg() {
		return tipoPreg;
	}

	public void setTipoPreg(TipoFiltroPregunta tipoPreg) {
		this.tipoPreg = tipoPreg;
	}

	public ArrayList<TipoFiltroPregunta> getPreguntadas() {
		return preguntadas;
	}

	public void setPreguntadas(ArrayList<TipoFiltroPregunta> preguntadas) {
		this.preguntadas = preguntadas;
	}

	public FiltradoServicios getFiltradoServicios() {
		return filtradoServicios;
	}

	public void setFiltradoServicios(FiltradoServicios filtradoServicios) {
		this.filtradoServicios = filtradoServicios;
	}
	
	//Metodo que se ejecuta cada vez que el usuario ingresa una respuesta/oracion
	public String nuevoCicloDeRespuesta(String res) {
		String respuesta = "";
		Estrategia est = new Estrategia();
		EscribirTxt escTxt = new EscribirTxt(); //se escribe el archivo txt para mostrar las reglas y todo lo que se va implementando
		//ArrayList<String> palabras = new ArrayList<String>(Arrays.asList("necesitar", "hotel"));
		ArrayList<String> palabras = nlp.aplicarNLP(res);
				
		//chequeo con que reglas matchean las palabras ingresadas
		ArrayList<Regla> reglasRespuestasMatcheadas = this.verificarReglasRespuestas(palabras);
		
		if (reglasRespuestasMatcheadas.isEmpty()) { //si no hay reglas matcheadas, mostrarle al usuario alguna frase de "no entiendo"
			return generarNoComprendo();
		} else {
			//voy escribiendo el archivo de texto para mostrar el proceso de seleccion
			escTxt.escribirBusquedaRespuestas(reglasRespuestasMatcheadas, palabras, this.tipoPreg, this.preguntadas, this.reglasRespuestasUsadas);
			
			//ahora se elige una regla segun las distintas estrategias
			est.setReglasActivas(reglasRespuestasMatcheadas); //seteo las reglas posibles
			est.setReglasUsadas(reglasRespuestasUsadas); //seteo con las reglas que ya fueron usadas
			ReglaRespuesta reglaEncontrada = (ReglaRespuesta) est.buscarRegla(); //busco una regla
			reglasRespuestasUsadas.add(reglaEncontrada); //agrego la regla encontrada (la que se va a usar) a la lista de reglas usadas
			preguntadas.add(this.tipoPreg); //agrego el tipo de pregunta al arreglo de tipos preguntados
			reglasPreguntasUsadas = this.filtrarReglas();
			respuesta += reglaEncontrada.getSalida();
			
			//ahora escribo la solucion de ejecutar la regla seleccionada
			escTxt.escribirResultadoRespuestas(preguntadas, reglaEncontrada);
			
			//ahora agrego a la lista de tipos ya preguntados, el servicio elegido por el usuario (lo hago a mano porque nunca va a estar del lado derecho de las reglas)
			if (reglaEncontrada.getFiltroRespuesta() == TipoRespuestaUsuario.PASAJE) {
				this.preguntadas.add(TipoFiltroPregunta.PASAJE);
			} else if (reglaEncontrada.getFiltroRespuesta() == TipoRespuestaUsuario.HOTEL) {
				this.preguntadas.add(TipoFiltroPregunta.HOTEL);
			} else if (reglaEncontrada.getFiltroRespuesta() == TipoRespuestaUsuario.PAQUETETURISTICO) {
				this.preguntadas.add(TipoFiltroPregunta.PAQUETETURISTICO);
			}
			
			//ahora veo tambien si se responde por internacional, para asi agregarlo a las preg hechas y dps poder hacer la pregunta de si necesitan saber la documentacion necesaria
			if (reglaEncontrada.getFiltroRespuesta() == TipoRespuestaUsuario.INTERNACIONAL) {
				this.preguntadas.add(TipoFiltroPregunta.INTERNACIONAL);
			}
			
			filtradoServicios.filtrar(reglaEncontrada.getFiltroPregunta(), reglaEncontrada.getFiltroRespuesta());
			
			//Luego de tener la respuesta y ejecutarla, elijo una pregunta
			// entonces busco entre las posibles preguntas
			ArrayList<Regla> reglasPreguntasMatcheadas = this.verificarReglasPreguntas();
			this.setearNovedad(reglasRespuestasMatcheadas, reglasPreguntasMatcheadas);
			
			if (!reglasPreguntasMatcheadas.isEmpty() /*&& filtradoServicios.verificarRecomendaciones()*/) { //si todavia quedan preguntas que matcheen
				escTxt.escribirBusquedaPreguntas(palabras, reglasPreguntasMatcheadas, this.tipoPreg, this.preguntadas, this.reglasRespuestasUsadas);
			
				//ahora se elige una regla segun las distintas estrategias
				est.setReglasActivas(reglasPreguntasMatcheadas); //seteo las posibles reglas
				est.setReglasUsadas(reglasPreguntasUsadas); //seteo con las reglas que ya fueron usadas
				ReglaPregunta reglaPregEncontrada = (ReglaPregunta) est.buscarRegla(); //busco una regla
				this.tipoPreg = reglaPregEncontrada.getFiltroPregunta();
				respuesta += "\n" + reglaPregEncontrada.getSalida();
				
				//ahora escribo la solucion de ejecutar la regla seleccionada
				escTxt.escribirResultadoPreguntas(reglaPregEncontrada);
			} else {
				//si no hay mas preguntas que matcheen, recomiendo una opcion
				String recomendacion = filtradoServicios.recomendacion();
				if (recomendacion.isEmpty()) {
					respuesta += "\nNo puedo recomendarte ningun servicio";
				} else {
					respuesta = "\nRecomendacion: \n" + recomendacion;
				}
				
				
				respuesta += "\n \n Puedo ayudarte con algo mas? \n Puedo ayudar con: PASAJES - HOTELES - PAQUETES TURISTICOS";
				//vuelvo a inicializar todas las variables una vez que se ejecuta la recomendacion
				filtradoServicios.inicializar();
				this.inicializarVariables();
			}
			
			return respuesta;
		}
	}
	
	// Metodo que genera alguna frase para que el bot exprese que no entiende lo que el usuario ingreso
	public static String generarNoComprendo() {
        ArrayList<String> aux = new ArrayList<>();

        aux.add("Disculpa, no te entiendo.");
        aux.add("Perdon, no entiendo lo que quisiste decir.");
        aux.add("Podrias intentar decirlo de otra manera?");
        aux.add("Lo siento, no pude comprender tu respuesta.");
        aux.add("Lo siento, me es dificil entender tu respuesta.");

        return aux.get(new Random(System.currentTimeMillis()).nextInt(aux.size()));

    }
	
	public ArrayList<Regla> verificarReglasPreguntas() {
		ArrayList<Regla> aux = new ArrayList<Regla>();
		for (ReglaPregunta rp: reglasPreguntas) {
			if (rp.verificarCondicion(this.preguntadas)) {
				aux.add(rp);
			}
		}
		
		//Antes de retornar aux, elimino las reglas repetidas
		boolean encontrado = false;
		if (!reglasPreguntasUsadas.isEmpty()) {
			ArrayList<Regla> noRepetidas = new ArrayList<Regla>();
			for (Regla a: aux) {
				for (Regla rpu: reglasPreguntasUsadas) {
					if (a.getId() == rpu.getId()) {
						encontrado = true;
					}
				}
				if (!encontrado) {
					noRepetidas.add(a);
				}
				encontrado = false;
			}
			return noRepetidas; //devuelvo el conjunto de reglas no repetidas
		} else {
			return aux; //si todavia no se usaron reglas, devuelvo la lista de reglas
		}
	}
	
	public ArrayList<Regla> verificarReglasRespuestas(ArrayList<String> palabrasIngresadasUsuario) {
		ArrayList<Regla> aux = new ArrayList<Regla>();
		for (ReglaRespuesta rr: reglasRespuestas) {
			if (rr.verificarCondicion(palabrasIngresadasUsuario, tipoPreg)) {
				aux.add(rr);
			}
		}
		return aux;
	}
	
	private void setearNovedad(ArrayList<Regla> reglasRes, ArrayList<Regla> reglasPreg) {
		for (Regla rr: reglasRes) {
			((ReglaRespuesta) rr).setearNovedad(this.tipoPreg);
		}
		for (Regla rp: reglasPreg) {
			((ReglaPregunta) rp).setearNovedad(this.tipoPreg);
		}
	}
	
	// Metodo que llama a recomendacion de la clase filtradoServicios (muestra por pantalla la recomendacion)
	// y vuelve a reiniciar todas las variables
	public String recomendar() {
		String respuesta = "";
		String filtrado = filtradoServicios.recomendacion();
		respuesta += filtrado;
		this.inicializarVariables();
		this.filtradoServicios.inicializar();
		return respuesta;
	}
	
	// Metodo que setea la lista de reglas usadas cuando se van usando las distintas reglas
	public ArrayList<Regla> filtrarReglas() {
		ArrayList<Regla> aux = new ArrayList<Regla>();
		for (ReglaPregunta rp: this.reglasPreguntas) {
			for (TipoFiltroPregunta fp: this.preguntadas) {
				if (fp.equals(rp.getFiltroPregunta())) {
					aux.add(rp);
				}
			}
		}
		return aux;
	}
	
}
