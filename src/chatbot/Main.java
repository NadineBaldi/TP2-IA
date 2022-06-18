package chatbot;

import interfaz.interfazChatbot;

public class Main {
	
	public static FiltradoReglas sistemaDeProduccion;
	
	public static void main(String[] args) {
		
		sistemaDeProduccion = new FiltradoReglas();
		
		//Interfaz
		interfazChatbot interfaz = new interfazChatbot(sistemaDeProduccion);
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);
		//sistemaDeProduccion.nuevoCicloDeRespuesta(null);
	}

}
