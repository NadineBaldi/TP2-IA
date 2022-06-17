package utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import reglas.Regla;
import reglas.ReglaPregunta;
import reglas.ReglaRespuesta;
import reglas.TipoFiltroPregunta;

public class EscribirTxt {
	
	FileWriter archivo = null;
	PrintWriter printArchivo = null;
	String nombre = "";
	
	public EscribirTxt() {
	}
	
	//Metodo que imprime en el txt la fase de cotejo, es decir q imprime la busqueda que hace
	//el bot entre todas las posibles respuestas (entre todas las frases que creamos)
	public void escribirBusquedaRespuestas(ArrayList<Regla> reglasResPosiblesAEjecutar, 
											ArrayList<String> palabrasIngresadasUsuario, 
											TipoFiltroPregunta ultimaPreguntaRealizada, 
											ArrayList<TipoFiltroPregunta> preguntadas, 
											ArrayList<Regla> reglasRespuestasUsadas) 
	{
		try {
			nombre = "log.txt";
			archivo = new FileWriter(nombre, true);
			printArchivo = new PrintWriter(archivo);
			String eleccionUsuario = "";
			
			//for que recorre todas las reglas de respuestas que el bot ya utilizo
			for (Regla r: reglasRespuestasUsadas) {
				eleccionUsuario+="Respuesta/eleccion del usuario: " + ((ReglaRespuesta) r).getFiltroRespuesta() + ". ";
				//eleccionUsuario guarda las distintas respuestas que el usuario va dando (por ej: hotel si escribe querer hotel)
			}
			
			TipoFiltroPregunta tipoFiltroPreg = null;
			ArrayList<TipoFiltroPregunta> filUsados = new ArrayList<TipoFiltroPregunta>();
			for (TipoFiltroPregunta tfp: preguntadas) { //recorro las reglas que ya fueron preguntadas
				if (tfp.equals(TipoFiltroPregunta.PASAJE) || 
					tfp.equals(TipoFiltroPregunta.HOTEL) || 
					tfp.equals(TipoFiltroPregunta.PAQUETETURISTICO)
					) {
					tipoFiltroPreg = tfp;
				} else {
					filUsados.add(tfp);
				}
			}
			
			printArchivo.println(" -- PRIMERO SE BUSCA UNA RESPUESTA PARA DARLE AL USUARIO -- ");
			printArchivo.println(" ");
			printArchivo.println("BASE DE CONOCIMIENTO:");
			printArchivo.println("Palabras ingresadas por el usuario: " + palabrasIngresadasUsuario);
			printArchivo.println("Tipo de pregunta actual realizada por el bot: " + ultimaPreguntaRealizada);
			printArchivo.println("Tipos de preguntas que ya fueron realizadas: " + preguntadas);
			printArchivo.println(eleccionUsuario);
			printArchivo.println(" ");
			printArchivo.println("POSIBLES REGLAS DE RESPUESTAS A EJECUTARSE:");
			int contador = 1;  
			for (Regla r: reglasResPosiblesAEjecutar) { //recorro todas las posibles reglas a ejecutar y las imprimo
				printArchivo.println(
					contador + "- " + ((ReglaRespuesta) r).getCondicion() + " ^ TipoPreguntaActual[" + ((ReglaRespuesta) r).getFiltroPregunta() + 
					"] -> '" + ((ReglaRespuesta) r).getSalida() + "' ^ TipoPreguntaRespondida[" + ((ReglaRespuesta) r).getFiltroPregunta() + 
					"] ^ RespuestaUsuario[" + ((ReglaRespuesta) r).getFiltroRespuesta() + "] "
				);
				contador++;
			}
			printArchivo.println(" ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//finally para asegurarnos que se cierra el archivo ya se que tire error o se escriba bien el archivo (por eso va en el finally)
				if (archivo != null) {
					archivo.close();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	// Metodo que escribe en el archivo la regla que se ejecutó (fase de resolucion)
	//cuando ya el bot encuentra una regla y la ejecuta
	public void escribirReglaSeleccionada(String res, Regla regla) {
		try {
			nombre = "log.txt";
			archivo = new FileWriter(nombre, true); //True para que vaya escribiendo al final del archivo
			printArchivo = new PrintWriter(archivo);
			printArchivo.println("SELECCION DE REGLA: ");
			printArchivo.println("Se ejecuta la regla: "+regla.getId()+" utilizando:"+res);
			printArchivo.println(" ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //me aseguro que se cierre el fichero
			try {
				if (archivo != null) archivo.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	//Metodo que escribe en el archivo el resultado de ejecutar la regla de respuestas seleccionada
	public void escribirResultadoRespuestas(ArrayList<TipoFiltroPregunta> preguntadas, Regla reglaAEjecutar) {
		try {
			nombre = "log.txt";
			archivo = new FileWriter(nombre, true); //True para que vaya escribiendo al final del archivo
			printArchivo = new PrintWriter(archivo);
			
			TipoFiltroPregunta filtroPreg = null;
			ArrayList<TipoFiltroPregunta> tipoFiltroPreg = new ArrayList<TipoFiltroPregunta>();
			for (TipoFiltroPregunta tfp: preguntadas) {
				if (tfp.equals(TipoFiltroPregunta.PASAJE) || 
					tfp.equals(TipoFiltroPregunta.HOTEL) || 
					tfp.equals(TipoFiltroPregunta.PAQUETETURISTICO)
					)
				{
					filtroPreg = tfp;
				} else {
					tipoFiltroPreg.add(tfp);
				}
			}
			
			printArchivo.println("RESULTADOS DE EJECUTAR LA REGLA: ");
			printArchivo.println("Se muestra por pantalla: " + ((ReglaRespuesta) reglaAEjecutar).getSalida());
			printArchivo.println("Se infiere: TipoPreguntaRespondida[" + ((ReglaRespuesta) reglaAEjecutar).getFiltroPregunta() + 
			                     "] ^ RespuestaUsuario[" + ((ReglaRespuesta) reglaAEjecutar).getFiltroRespuesta() + "] ");
			printArchivo.println("");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) archivo.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	//Metodo que imprime en el txt la fase de cotejo, es decir q imprime la busqueda que hace
	//el bot entre todas las posibles preguntas (entre todas las preguntas que creamos)
	public void escribirBusquedaPreguntas(ArrayList<String> palabras, 
											ArrayList<Regla> reglasPregPosiblesAEjecutar, 
											TipoFiltroPregunta tipoPregActual, 
											ArrayList<TipoFiltroPregunta> preguntadas, 
											ArrayList<Regla> reglasRespuestasUsadas) {
		try {
			nombre = "log.txt";
			archivo = new FileWriter(nombre, true);
			printArchivo = new PrintWriter(archivo);
			
			TipoFiltroPregunta tipoFiltroServicio = null;
			ArrayList<TipoFiltroPregunta> filUsados = new ArrayList<TipoFiltroPregunta>();
			
			//Ahora recorro todas las reglas que ya fueron preguntadas
			for (TipoFiltroPregunta tfp: preguntadas) {
				if (tfp.equals(TipoFiltroPregunta.PASAJE) || 
					tfp.equals(TipoFiltroPregunta.HOTEL) || 
					tfp.equals(TipoFiltroPregunta.PAQUETETURISTICO)
					) {
						tipoFiltroServicio = tfp;
					} else {
						filUsados.add(tfp);
					}
			}
			
			String eleccionUsuario = "";
			//for que recorre todas las reglas de respuestas que el bot ya utilizo
			for (Regla r: reglasRespuestasUsadas) {
				eleccionUsuario += "Respuesta/eleccion del usuario: [" + ((ReglaRespuesta) r).getFiltroRespuesta() + "] ";
				//eleccionUsuario guarda las distintas respuestas que el usuario va dando (por ej: hotel si escribe querer hotel)
			}
			
			printArchivo.println(" -- LUEGO SE BUSCA UNA PREGUNTA PARA PREGUNTARLE AL USUARIO -- ");
			printArchivo.println(" ");
			printArchivo.println("BASE DE CONOCIMIENTO:");
			printArchivo.println("Palabras ingresadas por el usuario: " + palabras);
			printArchivo.println("Tipo de pregunta actual realizada por el bot: " + tipoPregActual);
			printArchivo.println("Tipos de preguntas que ya fueron realizadas: " + filUsados);
			printArchivo.println(eleccionUsuario);
			printArchivo.println(" ");
			printArchivo.println("POSIBLES REGLAS DE PREGUNTAS A EJECUTARSE:");
			int contador = 1;  
			String tipoPregHechas = "";
			String filtroInternacional = "";
			for (Regla r: reglasPregPosiblesAEjecutar) { //recorro todas las posibles reglas a ejecutar y las imprimo
				tipoPregHechas = contador + "- TipoPreguntaRespondida[ ";
				for (TipoFiltroPregunta fp: ((ReglaPregunta) r).getCondicion()) { //recorro todas las palabras de la izquierda (toda la condicion de la regla)
					//separo los tipos de preguntas de los filtros (pasaje, hotel, paquete e internacional son filtros que uso en las reglas de preguntas pero no son tipos de preguntas)
					if (!
						(fp == TipoFiltroPregunta.PASAJE) ||
						(fp == TipoFiltroPregunta.HOTEL) ||
						(fp == TipoFiltroPregunta.PAQUETETURISTICO) ||
						(fp == TipoFiltroPregunta.INTERNACIONAL)
					) {
						tipoPregHechas+= fp + ", "; 
					} else if (fp == TipoFiltroPregunta.INTERNACIONAL) {
						filtroInternacional += " - " + fp; //agrego la palabra "internacional" para luego mostrarla en los filtros que se fueron usando
					}
				}
				printArchivo.println(
					tipoPregHechas + "] ^ FiltrosUsados[" + tipoFiltroServicio + filtroInternacional +
					"] -> " + ((ReglaPregunta) r).getSalida() + " ^ TipoPreguntaActual[" + ((ReglaPregunta) r).getFiltroPregunta() + "]"
				);
				contador++;
			}
			printArchivo.println(" ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) archivo.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	//Metodo que escribe en el archivo el resultado de ejecutar la regla de preguntas seleccionada
	public void escribirResultadoPreguntas(Regla reglaAEjecutar) {
		try {
			nombre = "log.txt";
			archivo = new FileWriter(nombre, true); //True para que vaya escribiendo al final del archivo
			printArchivo = new PrintWriter(archivo);
			
			printArchivo.println("RESULTADOS DE EJECUTAR LA REGLA: ");
			printArchivo.println("Se muestra por pantalla: " + ((ReglaPregunta) reglaAEjecutar).getSalida());
			printArchivo.println("Se infiere: TipoPreguntaActual[" + ((ReglaPregunta) reglaAEjecutar).getFiltroPregunta() + "]");
			printArchivo.println(" ");
			printArchivo.println(" ");
			printArchivo.println(" ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) archivo.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
}
