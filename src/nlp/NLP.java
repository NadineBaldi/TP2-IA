package nlp;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;

public class NLP {
	
	public NLP() {
	}

	public ArrayList<String> aplicarNLP(String oracion){
		ArrayList<String> rtdo = new ArrayList<String>();
		//separo el string en palabras (las separo por el espacio entre ellas)
		ArrayList<String> palabras = new ArrayList<String>(Arrays.asList(oracion.split(" ")));
		
		//itero cada palabra y la voy modificando
		for(String palabra : palabras) {
			String palabraModificada;
			//paso a minuscula
			palabraModificada = this.pasarAMinuscula(palabra);
			//elimino signos puntuacion
			palabraModificada = this.eliminarSimbolosPuntuacion(palabraModificada);
			//elimino acentos
			palabraModificada = this.eliminarAcentos(palabraModificada);
			//la paso a singular
			palabraModificada = this.convertirASingular(palabraModificada);
			//paso a infinitivo los verbos
			palabraModificada = this.pasarAInfinitivo(palabraModificada);
			//busco si puedo encontrar algun sinonimo
			palabraModificada = this.buscarSinonimo(palabraModificada);
			
			//por ultimo la agrego a array que devuelvo
			rtdo.add(palabraModificada);
		}
		
		return rtdo;
	}
	
	private String pasarAMinuscula(String palabra) {
		return palabra.toLowerCase();
	}
	
	private String eliminarSimbolosPuntuacion(String palabra) {
		return palabra.replaceAll("\\p{Punct}", "");
	}
	
	private String eliminarAcentos(String palabra) {
		String cadenaNormalize = Normalizer.normalize(palabra, Normalizer.Form.NFD);   
		String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		return cadenaSinAcentos;
	}
	
	private String convertirASingular(String palabra) {
		String singular = palabra;
		
		//Si termina con is lo paso a y
		if(palabra.endsWith("is")) {
			singular = palabra.substring(0, palabra.length()-2); 
			singular += "y";
		}else {
			//Si termina en ces lo paso a z
			if(palabra.endsWith("ces")) {
				singular = palabra.substring(0, palabra.length()-3); 
				singular += "z";
			}else {
				//Si termina en es se lo saco
				if(palabra.endsWith("es") && palabra != "grandes") {
					singular = palabra.substring(0, palabra.length()-2);
				}else {
					//Si termina en s se lo saco
					if(palabra.endsWith("s")) {
						singular = palabra.substring(0, palabra.length()-1);
					}
				}
			}
		}
		
		return singular;
	}
	
	private String pasarAInfinitivo(String palabra) {
		String infinitivo = palabra;
		if (palabra.startsWith("necesit")) {
			infinitivo = "necesitar";
		}else if (palabra.startsWith("busc")) {
				infinitivo = "buscar";
		}else if (palabra.startsWith("quer") || palabra.startsWith("quier")) {
			infinitivo = "querer";
		}else if (palabra.startsWith("pregunt")) {
			infinitivo = "preguntar";
		}else if (palabra.startsWith("gast")) {
			infinitivo = "gastar";
		}else if (palabra.startsWith("acept")) {
			infinitivo = "aceptar";
		}else if (palabra.startsWith("pedi")) {
			infinitivo = "pedir";
		}else if (palabra.startsWith("precisa")) {
			infinitivo = "precisar";
		}else if (palabra.startsWith("requer")) {
			infinitivo = "requerir";
		}else if (palabra.startsWith("averigua")) {
			infinitivo = "averiguar";
		}else if (palabra.startsWith("investig")) {
			infinitivo = "investigar";
		}else if (palabra.startsWith("indag")) {
			infinitivo = "indagar";
		}else if (palabra.startsWith("consult")) {
			infinitivo = "consultar";
		}
		
		return infinitivo;
	}
	
	private String buscarSinonimo(String palabra) {
		//sinonimos de verbos
		String[] sinonimosNecesitar = {"pedir", "requerir", "precisar" };
		String[] sinonimosBuscar = {"averiguar", "investigar", "indagar" };
		String[] sinonimosPreguntar = {"averiguar", "consultar"};
		if(Arrays.stream(sinonimosNecesitar).anyMatch(palabra::equals)) {
			return "necesitar";
		}else if(Arrays.stream(sinonimosBuscar).anyMatch(palabra::equals)) {
			return "buscar";
		}else if(Arrays.stream(sinonimosPreguntar).anyMatch(palabra::equals)) {
			return "preguntar";
		}
		//sinonimos de sustantivos
		String[] sinonimosPasaje = {"vuelo", "viaje"};
		String[] sinonimosHotel = {"alojamiento", "albergue", "hostal",};
		if(Arrays.stream(sinonimosPasaje).anyMatch(palabra::equals)) {
			return "pasaje";
		}else if(Arrays.stream(sinonimosHotel).anyMatch(palabra::equals)) {
			return "hotel";
		}
		
		return palabra;
	}
	
}
