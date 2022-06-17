package chatbot;

import java.util.ArrayList;
import java.util.List;

import servicios.Hotel;
import servicios.PaqueteTuristico;
import servicios.Pasaje;

public class BaseDeDatos {
	
	private List<Pasaje> pasajes;
	private List<Hotel> hoteles;
	private List<PaqueteTuristico> paquetesTuristicos;
	
	private static BaseDeDatos instance = new BaseDeDatos();
	public static BaseDeDatos getInstance() {
		return instance;
	}
	
	private BaseDeDatos(){
		pasajes = agregarPasajes();
        hoteles = agregarHoteles();
        paquetesTuristicos = agregarPaquetesTuristicos();
    }

	// Getters and setters
	public List<Pasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<Pasaje> pasajes) {
		this.pasajes = pasajes;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public List<PaqueteTuristico> getPaquetesTuristicos() {
		return paquetesTuristicos;
	}

	public void setPaquetesTuristicos(List<PaqueteTuristico> paquetesTuristicos) {
		this.paquetesTuristicos = paquetesTuristicos;
	}
	
	private ArrayList<Pasaje> agregarPasajes() {
		ArrayList<Pasaje> pasajes = new ArrayList<>();
		
		pasajes.add(new Pasaje(43438.0, true, "Buenos Aires", "Bariloche", "America del Sur", "25/10/22", "31/10/22", "avion", true, 2, "Montania", "Lugar tranquilo", "frio", ""));
		pasajes.add(new Pasaje(121134.0, false, "Buenos Aires", "Miami", "America del Norte", "12/09/22", "22/09/22", "avion", true, 1, "Playa", "Ciudad grande", "calor", "Los documentos para viajar a Estados Unidos en 2022 son: pasaporte vigente - visa vigente - certificado de vacunacion"));
		pasajes.add(new Pasaje(90514.0, false, "Rosario", "San Andres", "America del Sur", "10/07/22", "", "avion", false, 1, "Playa", "Lugar tranquilo", "calor", "Para ingresar a Colombia podes hacerlo solamente con el DNI o Pasaporte vigente"));
		pasajes.add(new Pasaje(25304.0, true, "Rosario", "Mendoza", "America del Sur", "24/08/22", "30/08/22", "avion", true, 1, "Montania", "Lugar tranquilo", "calor", ""));
		pasajes.add(new Pasaje(40500.0, true, "Rosario", "Puerto Iguazu", "America del Sur", "14/10/22", "", "avion", false, 2, "Montania", "Lugar tranquilo", "calor", ""));
		pasajes.add(new Pasaje(6297.0, true, "Buenos Aires", "Salta", "America del Sur", "15/08/22", "", "avion", false, 1, "Montania", "Lugar tranquilo", "calor", ""));
		pasajes.add(new Pasaje(175890.0, false, "Buenos Aires", "Ibiza", "Europa", "30/09/22", "20/10/22", "avion", true, 1, "Playa", "Ciudad grande", "calor", "Para viajar a España necesitaras un pasaporte en vigor y una justificacion del motivo del viaje"));
		pasajes.add(new Pasaje(209140.0, false, "Buenos Aires", "Zurich", "Europa", "01/12/22", "21/12/22", "avion", true, 1, "Montania", "Ciudad grande", "frio", "Para ingresar a Zurich debes contar con un pasaporte con validez minima de tres meses"));
		pasajes.add(new Pasaje(500120.0, false, "Rosario", "Berlin", "Europa", "18/11/22", "", "avion", false, 2, "Montania", "Ciudad grande", "frio", "Para ingresar a Alemania se requiere tener un pasaporte vigente, boleto de avion (ida y vuelta), constancia de alojamiento y comprobante de ingresos financieros"));
		pasajes.add(new Pasaje(256000.0, false, "Buenos Aires", "Rio de Janeiro", "America del Sur", "25/07/22", "09/08/22", "avion", true, 2, "Playa", "Ciudad grande", "calor", "Para ingresar a Rio de Janeiro podes hacerlo solamente con el DNI o Pasaporte vigente, y certificado de vacunacion"));
		pasajes.add(new Pasaje(16000.0, false, "Santa Fe", "Montevideo", "America del Sur", "10/08/22", "17/08/22", "colectivo", true, 1, "Playa", "Ciudad grande", "calor", "Para ingresar a Uruguay podes hacerlo solamente con el DNI o Pasaporte vigente"));
		pasajes.add(new Pasaje(45100.0, true, "Santa Fe", "Bariloche", "America del Sur", "10/07/22", "", "colectivo", false, 2, "Montania", "Lugar tranquilo", "frio", ""));
		pasajes.add(new Pasaje(32162.0, true, "Parana", "Mendoza", "America del Sur", "31/10/22", "17/11/22", "colectivo", true, 2, "Montania", "Lugar tranquilo", "calor", ""));
		pasajes.add(new Pasaje(45000.0, false, "Buenos Aires", "Florianopolis", "America del Sur", "15/01/23", "28/01/23", "colectivo", true, 1, "Playa", "Ciudad grande", "calor", "Para ingresar a Brasil podes hacerlo solamente con el DNI o Pasaporte vigente, y certificado de vacunacion"));
		pasajes.add(new Pasaje(23150.0, true, "Rosario", "Bahia Blanca", "America del Sur", "25/11/22", "07/12/22", "colectivo", true, 1, "Montania", "Lugar tranquilo", "frio", ""));
		pasajes.add(new Pasaje(42500.0, false, "Buenos Aires", "Santiago de Chile", "America del Sur", "01/07/22", "", "colectivo", false, 2, "Montania", "Ciudad grande", "calor", "Para ingresar a Chile podes hacerlo solamente con el DNI o Pasaporte vigente"));
		pasajes.add(new Pasaje(6420.0, true, "Santa Fe", "Cordoba", "America del Sur", "10/10/22", "19/10/22", "colectivo", true, 1, "Montania", "Ciudad grande", "calor", ""));
		pasajes.add(new Pasaje(8900.0, true, "Parana", "Mar del Plata", "America del Sur", "02/01/23", "12/01/23", "colectivo", true, 1, "Playa", "Ciudad grande", "calor", ""));
		pasajes.add(new Pasaje(35600.0, false, "Buenos Aires", "Santa Marta", "America del Sur", "15/12/22", "", "colectivo", false, 2, "Playa", "Lugar tranquilo", "calor", "Para ingresar a Colombia podes hacerlo solamente con el DNI o Pasaporte vigente"));
		pasajes.add(new Pasaje(28000.0, false, "Buenos Aires", "Punta Arena", "America del Sur", "18/07/22", "29/07/22", "colectivo", true, 1, "Montania", "Ciudad grande", "frio", "Para ingresar a Punta Arena podes hacerlo solamente con el DNI o Pasaporte vigente"));
		pasajes.add(new Pasaje(265556.0, false, "Buenos Aires", "Auckland", "Oceania", "29/12/22", "08/01/23", "avion", true, 1, "Playa", "Ciudad grande", "calor", "Para viajar a Nueva Zelanda se necesita ser titular de un pasaporte valido al menos por 3 meses despues de la fecha de regreso a su pais, poseer pasajes aereos y tener dinero suficiente para vivir en Nueva Zelanda por el tiempo que desees estar"));
		pasajes.add(new Pasaje(425354.0, false, "Buenos Aires", "Johannesburgo", "Africa", "04/02/23", "11/02/23", "avion", true, 1, "Montania", "Ciudad grande", "calor", "Para entrar a Sudafrica necesitas contar con un pasaporte vigente con al menos 6 meses de validez, el pasaporte ademas debe contar con al menos 3 paginas libres para sellos. Tambien debes contar con una tarjeta de fiebre amarilla, vuelo de regreso y acreditacion de alojamiento."));
		pasajes.add(new Pasaje(464437.0, false, "Buenos Aires", "Tokio", "Asia", "03/04/23", "28/04/23", "avion", true, 2, "Montania", "Ciudad grande", "frio", "Para ingresar a Tokio necesitas un pasaporte en vigor con una validez que cubra todo el periodo de la estancia en Japon, una prueba de billete de vuelta y un formulario completo que se te entregara en el avion y que necesitaras dar al oficial de inmigracion"));
		pasajes.add(new Pasaje(566540.0, false, "Buenos Aires", "Sidney", "Oceania", "18/08/22", "30/08/22", "avion", true, 2, "Playa", "Ciudad grande", "calor", "Para ingresar a Australia deberas contar con un pasaporte vigente"));
		pasajes.add(new Pasaje(223006.0, false, "Buenos Aires", "El Cairo", "Africa", "08/03/23", "22/03/23", "avion", true, 1, "Playa", "Ciudad grande", "calor", "Para viajar a Egipto desde Argentina necesitaras un pasaporte valido, un correo electronico valido y contar con algun medio de pago (tarjeta de credito o debito)"));
		pasajes.add(new Pasaje(680474.0, false, "Buenos Aires", "Hong Kong", "Asia", "05/03/23", "18/03/23", "avion", true, 2, "Montania", "Ciudad grande", "calor", "Para viajar a Hong Kong solo necesitas un pasaporte vigente. Luego, al llegar al pais te concederan 90 dias de visa"));
		pasajes.add(new Pasaje(175000.0, false, "Buenos Aires", "Toronto", "America del Norte", "28/06/22", "08/07/22", "avion", true, 1, "Montania", "Ciudad grande", "frio", "Para ingresar a Canada es obligatorio contar con un pasaporte vigente. Ademas se debera mostrar solvencia economica para costear la estadia en Canada."));
		pasajes.add(new Pasaje(300000.0, false, "Buenos Aires", "La Habana", "Centroamerica", "31/03/23", "07/04/23", "avion", true, 2, "Playa", "Ciudad grande", "calor", "Para viajar a Cuba necesitaras un pasaporte en vigor, una tarjeta turistica, seguro para viajeros con cobertura COVID, declaracion de sanidad del viajero y un billete de avion de ida y vuelta"));
		pasajes.add(new Pasaje(181408.0, false, "Buenos Aires", "San Juan - Puerto Rico", "Centroamerica", "04/11/22", "30/11/22", "avion", true, 1, "Playa", "Ciudad grande", "calor", "Para viajar a Puerto Rico necesitas: pasaporte vigente - visa turistica - acreditar fondos suficientes para cubrir tu estadia"));
		
		return pasajes;
	}
	
	private ArrayList<Hotel> agregarHoteles() {
		ArrayList<Hotel> hoteles = new ArrayList<>();
		
		hoteles.add(new Hotel("Aldea Andina", 70500.0, true, "Bariloche", "America del Sur", 3, "20/11/22", "27/11/22", 7, true, false, false, ""));
		hoteles.add(new Hotel("Hilton", 49000.0, true, "Buenos Aires", "America del Sur", 2, "15/10/22", "22/10/22", 7, true, true, false, ""));
		hoteles.add(new Hotel("Pinar del Lago", 50000.0, true, "Carlos Paz", "America del Sur", 2, "25/01/23", "05/02/23", 12, true, false, true, ""));
		hoteles.add(new Hotel("Raices Aconcagua Hotel", 24000.0, true, "Mendoza", "America del Sur", 1, "18/09/22", "23/09/22", 5, true, true, true, ""));
		hoteles.add(new Hotel("Plaza Hotel", 42000.0, true, "Salta", "America del Sur", 2, "24/11/22", "30/11/22", 7, false, true, true, ""));
		hoteles.add(new Hotel("Argos", 71000.0, true, "Bahia Blanca", "America del Sur", 2, "10/09/22", "20/09/22", 20, false, false, true, ""));
		hoteles.add(new Hotel("Riogrande", 16500.0, true, "Santa Fe", "America del Sur", 2, "21/07/22", "24/07/22", 3, false, true, false, ""));
		hoteles.add(new Hotel("Merit", 13000.0, true, "Puerto Iguazu", "America del Sur", 1, "05/08/22", "07/08/22", 2, false, false, false, ""));
		hoteles.add(new Hotel("Ibis", 18900.0, false, "Montevideo", "America del Sur", 1, "17/08/22", "20/08/22", 3, true, false, false, "Para ingresar a Uruguay podes hacerlo solamente con el DNI o Pasaporte vigente"));
		hoteles.add(new Hotel("Hilton", 55000.0, false, "Rio de Janeiro", "America del Sur", 1, "24/12/22", "30/12/22", 6, true, true, false, "Para ingresar a Brasil podes hacerlo solamente con el DNI o Pasaporte vigente, y el certificado de vacunacion"));
		hoteles.add(new Hotel("Santa Lucia", 64080.0, false, "Santiago de Chile", "America del Sur", 2, "18/10/22", "28/10/22", 10, true, false, true, "Para ingresar a Chile podes hacerlo solamente con el DNI o Pasaporte vigente"));
		hoteles.add(new Hotel("Castelmar", 50430.0, false, "Florianopolis", "America del Sur", 2, "18/02/23", "24/02/23", 6, true, true, true, "Para ingresar a Brasil podes hacerlo solamente con el DNI o Pasaporte vigente, y el certificado de vacunacion"));	
		hoteles.add(new Hotel("Sagrada Familia", 70500.0, false, "Barcelona", "Europa", 1, "17/07/22", "25/07/22", 8, false, true, true, "Para viajar a España necesitaras un pasaporte en vigor y una justificacion del motivo del viaje"));
		hoteles.add(new Hotel("Downtown", 85100.0, false, "Miami", "America del Norte", 2, "10/12/22", "16/12/22", 6, false, false, true, "Los documentos para viajar a Estados Unidos en 2022 son: pasaporte vigente - visa vigente - certificado de vacunacion"));
		hoteles.add(new Hotel("Manhattan", 100500.0, false, "Nueva York", "America del Norte", 2, "14/10/22", "22/10/22", 8, false, true, false, "Los documentos para viajar a Estados Unidos en 2022 son: pasaporte vigente - visa vigente - certificado de vacunacion"));
		hoteles.add(new Hotel("Smart Hyde", 120400.0, false, "Londres", "Europa", 2, "29/07/22", "10/08/22", 12, false, false, false, "Para ingresar a Londres solo necesitas un pasaporte en vigor (el cual no debe caducar antes de los seis meses de tu marcha del pais)"));
		hoteles.add(new Hotel("Crowne Plaza Johannesburg - The Rosebank", 98500.0, false, "Johannesburg", "Africa", 1, "29/08/22", "10/09/22", 12, false, false, false, "Para entrar a Sudafrica necesitas contar con un pasaporte vigente con al menos 6 meses de validez, el pasaporte ademas debe contar con al menos 3 paginas libres para sellos. Tambien debes contar con una tarjeta de fiebre amarilla, vuelo de regreso y acreditacion de alojamiento."));
		hoteles.add(new Hotel("Ramses Hilton", 180460.0, false, "El Cairo", "Africa", 2, "01/09/22", "06/09/22", 5, true, true, false, "Para viajar a Egipto desde Argentina necesitaras un pasaporte valido, un correo electronico valido y contar con algun medio de pago (tarjeta de credito o debito)"));
		hoteles.add(new Hotel("The Grand Hotel", 21600.0, false, "Sidney", "Oceania", 1, "11/10/22", "13/10/22", 2, false, true, false, "Para ingresar a Australia deberas contar con un pasaporte vigente"));
		hoteles.add(new Hotel("Grand Millennium", 136000.0, false, "Auckland", "Oceania", 2, "15/11/22", "19/11/22", 4, false, true, true, "Para ingresar a Australia deberas contar con un pasaporte vigente"));
		hoteles.add(new Hotel("Hilton Tokyo", 48416.0, false, "Tokio", "Asia", 1, "21/10/22", "23/10/22", 2, true, true, true, "Para ingresar a Tokio necesitas un pasaporte en vigor con una validez que cubra todo el periodo de la estancia en Japon, una prueba de billete de vuelta y un formulario completo que se te entregara en el avion y que necesitaras dar al oficial de inmigracion"));
		hoteles.add(new Hotel("The Harbourview", 66890.0, false, "Hong Kong", "Asia", 2, "13/12/22", "18/12/22", 5, true, true, false, "Para viajar a Hong Kong solo necesitas un pasaporte vigente. Luego, al llegar al pais te concederan 90 dias de visa"));
		hoteles.add(new Hotel("Hotel Nacional de Cuba", 25800.0, false, "La Habana", "Centroamerica", 1, "13/08/22", "17/08/22", 4, false, true, false, "Para viajar a Cuba necesitaras un pasaporte en vigor, una tarjeta turistica, seguro para viajeros con cobertura COVID, declaracion de sanidad del viajero y un billete de avion de ida y vuelta"));
		hoteles.add(new Hotel("Occidental Caribe", 120526.0, false, "Punta Cana", "Centroamerica", 2, "09/11/22", "12/11/22", 3, true, true, true, "Para viajar a Punta Cana solo debes llevar el pasaporte vigente"));

		return hoteles;
	}
	
	private ArrayList<PaqueteTuristico> agregarPaquetesTuristicos() {
		ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
		
		paquetes.add(new PaqueteTuristico(53262.0, true, "Salta", "America del Sur", "06/08/22", "09/08/22", 3, 1, "Salta 3 noches ¡Con dia en Humahuaca!", true, false, false, ""));
		paquetes.add(new PaqueteTuristico(264308.0, true, "Bariloche y San Martin de los Andes", "America del Sur", "23/07/22", "30/07/22", 7, 2, "Bariloche y San Martin de los Andes ¡Incluye excursion a Cerro Tronador!", true, true, false, ""));
		paquetes.add(new PaqueteTuristico(61542.0, true, "Calafate", "America del Sur", "28/07/22", "01/08/22", 4, 1, "Calafate ¡Con excursion al glaciar y traslados de regalo!", true, false, true, ""));
		paquetes.add(new PaqueteTuristico(71592.0, true, "Puerto Madryn", "America del Sur", "23/09/22", "26/09/22", 3, 1, "Puerto Madryn ¡con excursion a Puerto Piramides!", true, true, true, ""));
		paquetes.add(new PaqueteTuristico(140578.0, true, "San Miguel de Tucuman, Cafayate y Salta", "America del Sur", "20/11/22", "26/11/22", 6, 1, "Vuelta al norte tradicional ¡Con traslados!", false, true, true, ""));
		paquetes.add(new PaqueteTuristico(109827.0, true, "Puerto Iguazu", "America del Sur", "10/07/22", "14/07/22", 4, 2, "Iguazu 4 noches ¡Con Cataratas y Ruinas!", false, false, true, ""));
		paquetes.add(new PaqueteTuristico(48910.0, true, "Mendoza", "America del Sur", "23/10/22", "27/10/22", 4, 1, "4 noches en Mendoza ¡con asistencia al viajero incluida!", false, true, false, ""));
		paquetes.add(new PaqueteTuristico(168847.0, true, "Mendoza y San Rafael", "America del Sur", "09/09/22", "15/09/22", 6, 2, "Mendoza y San Rafael 6 noches", false, false, false, ""));
		paquetes.add(new PaqueteTuristico(247625.0, false, "Punta Cana", "Centroamerica", "29/08/22", "06/09/22", 7, 1, "Punta Cana - 7 noches (Vuelo + hotel Riu Naiboa All Inclusive)", true, false, false, "Para viajar a Punta Cana solo debes llevar el pasaporte vigente"));
		paquetes.add(new PaqueteTuristico(573433.0, false, "Cancun", "Centroamerica", "01/09/22", "09/09/22", 8, 2, "Rivera Maya 7 noches - Vuelo + Hotel Bahia Principe Grand Coba", true, true, false, "Para ingresar a Cancun necesitas un pasaporte con una validez minima de 6 meses, el boleto de avion y una tarjeta de credito/debito"));
		paquetes.add(new PaqueteTuristico(120386.0, false, "Buzios", "America del Sur", "18/08/22", "25/08/22", 7, 1, "Buzios ¡con media pension Buzios Gastronomico!", true, false, true, "Para ingresar a Brasil podes hacerlo solamente con el DNI o Pasaporte vigente, y el certificado de vacunacion covid"));
		paquetes.add(new PaqueteTuristico(346212.0, false, "Salvador", "America del Sur", "16/10/22", "23/10/22", 7, 2, "Salvador de Bahia ¡Con city tour y tour de playas!", true, true, true, "Para ingresar a Brasil podes hacerlo solamente con el DNI o Pasaporte vigente, y el certificado de vacunacion"));
		paquetes.add(new PaqueteTuristico(545805.0, false, "Amsterdam", "Europa", "19/11/22", "02/12/22", 13, 1, "Amsterdam 13 noches - incluye vuelos + asistencia al viajero + equipaje + hotel Citiez", false, true, true, "Para ingresar a Amsterdam debes contar con un pasaporte con validez minima de tres meses"));
		paquetes.add(new PaqueteTuristico(652369.0, false, "Berlin", "Europa", "03/02/23", "18/02/23", 13, 2, "13 noches en Berlin - incluye vuelos + hotel + traslados", false, false, true, "Para ingresar a Alemania se requiere tener un pasaporte vigente, boleto de avion (ida y vuelta), constancia de alojamiento y comprobante de ingresos financieros"));
		paquetes.add(new PaqueteTuristico(357200.0, false, "Paris", "Europa", "10/11/22", "17/11/22", 7, 1, "Paris ¡Vuelvo + Hotel! - 7 noches", false, true, false, "Para ingresar a Francia se requiere tener un pasaporte vigente y certificado de vacunacion covid"));
		paquetes.add(new PaqueteTuristico(320154.0, false, "El Cairo, Luxor y Edfu", "Africa", "26/07/22", "02/07/22", 7, 2, "Egipto Faraonico - alojamiento incluido", false, false, false, "Para viajar a Egipto desde Argentina necesitaras un pasaporte valido, un correo electronico valido y contar con algun medio de pago (tarjeta de credito o debito)"));
		paquetes.add(new PaqueteTuristico(233838.0, false, "El Cairo, Luxor y Abu Simbel", "Africa", "10/08/22", "19/08/22", 9, 1, "Egipto y Abu Simbel - incluye alojamiento y traslados con guia turistica", false, false, true, "Para viajar a Egipto desde Argentina necesitaras un pasaporte valido, un correo electronico valido y contar con algun medio de pago (tarjeta de credito o debito)"));
		paquetes.add(new PaqueteTuristico(308401.0, false, "Tokio", "Asia", "20/01/23", "04/02/23", 20, 1, "Tokio en 20 dias", true, true, false, "Para ingresar a Tokio necesitas un pasaporte en vigor con una validez que cubra todo el periodo de la estancia en Japon, una prueba de billete de vuelta y un formulario completo que se te entregara en el avion y que necesitaras dar al oficial de inmigracion"));
		paquetes.add(new PaqueteTuristico(540200.0, false, "Hong Kong", "Asia", "10/02/23", "25/02/23", 5, 2, "Tus mejores vacaciones en Hong Kong", false, true, true, "Para viajar a Hong Kong solo necesitas un pasaporte vigente. Luego, al llegar al pais te concederan 90 dias de visa"));
		paquetes.add(new PaqueteTuristico(289009.0, false, "Orlando", "America del Norte", "18/07/22", "26/07/23", 8, 1, "Dejate cautivar por Orlando", false, true, false, "Los documentos para viajar a Estados Unidos en 2022 son: pasaporte vigente - visa vigente - certificado de vacunacion"));
		paquetes.add(new PaqueteTuristico(468000.0, false, "Vancouver", "America del Norte", "11/09/22", "18/09/22", 7, 2, "Visita Canada - con estadia en EXChange Hotel Vancouver incluida", false, false, false, "Para ingresar a Canada es obligatorio contar con un pasaporte vigente. Ademas se debera mostrar solvencia economica para costear la estadia en Canada."));
		paquetes.add(new PaqueteTuristico(248500.0, false, "Sidney", "Oceania", "12/10/22", "20/10/22", 8, 1, "Conoce Sidney - con estadia en hotel Hilton Sidney incluida", false, true, false, "Para ingresar a Australia deberas contar con un pasaporte vigente"));
		paquetes.add(new PaqueteTuristico(426000.0, false, "Auckland, Rotorua, Lake Tekapo, Wanaka y Queenstown", "Oceania", "01/12/22", "09/12/22", 8, 2, "Nueva Zelanda Aotearoa - 9 días", false, true, true, "Para ingresar a Nueva Zelanda deberas contar con un pasaporte valido para solicitar la Autoridad de Viajes Electronica de Nueva Zelanda (NZeTA)"));
		
		return paquetes;
	}

}
