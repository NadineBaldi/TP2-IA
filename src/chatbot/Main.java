package chatbot;

public class Main {
	
	public static FiltradoReglas sistemaDeProduccion;
	
	public static void main(String[] args) {
		
		sistemaDeProduccion = new FiltradoReglas();
		sistemaDeProduccion.nuevoCicloDeRespuesta(null);
	}

}
