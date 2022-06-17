package chatbot;

import java.util.ArrayList;
import java.util.Arrays;

import reglas.ReglaPregunta;
import reglas.ReglaRespuesta;
import reglas.TipoFiltroPregunta;
import reglas.TipoRespuestaUsuario;

public class BaseDeDatosDeReglas {
	
	ArrayList<ReglaPregunta> reglasPreg;
	ArrayList<ReglaRespuesta> reglasRes;
	
	private static BaseDeDatosDeReglas instance = new BaseDeDatosDeReglas();
	public static BaseDeDatosDeReglas getInstance() {
		return instance;
	}
	
	private BaseDeDatosDeReglas() {
		this.reglasPreg = new ArrayList<ReglaPregunta>();
		this.reglasRes = new ArrayList<ReglaRespuesta>();
		agregarReglasPreguntas();
		agregarReglasRespuestas();
	}

	//Getters and setters
	public ArrayList<ReglaPregunta> getReglasPreg() {
		return reglasPreg;
	}

	public void setReglasPreg(ArrayList<ReglaPregunta> reglasPreg) {
		this.reglasPreg = reglasPreg;
	}

	public ArrayList<ReglaRespuesta> getReglasRes() {
		return reglasRes;
	}

	public void setReglasRes(ArrayList<ReglaRespuesta> reglasRes) {
		this.reglasRes = reglasRes;
	}
	
	public void agregarReglasPreguntas() {
		
		reglasPreg.add(new ReglaPregunta(
			1,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE)),
			"¿Deseas viajar al interior o exterior del pais?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			2,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE)),
			"¿Deseas realizar un viaje nacional o internacional?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			3,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO)),
			"¿Deseas viajar por via terrestre o via aerea?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			4,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO)),
			"¿Quieres viajar en colectivo o avion?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			5,
			3,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Deseas viajar en clase economica o en primera clase?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			6,
			3,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Cuanto piensas gastar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			7,
			3,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Deseas un pasaje solo de ida o ida y vuelta?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			8,
			3,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Quieres un pasaje solo de ida o ida y vuelta?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			9,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Buscas pasajes para una sola persona o mas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			10,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Te interesan pasajes para una sola persona o mas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			11,
			4,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Tienes alguna preferencia en especial? ¿Playa o montaña?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			12,
			4,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Te gustaria viajar a un lugar de playa o montaña?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			13,
			4,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Alguna preferencia en especial? ¿Grandes ciudades o lugares mas tranquilos?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			14,
			4,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Te gustaria viajar a una ciudad grande o algun lugar tranquilo?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			15,
			4,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Te interesa mas un lugar de frio o de calor?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			16,
			4,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.TRANSPORTE)),
			"¿Te gustaria viajar a un lugar de frio o de calor?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			17,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL)),
			"¿Deseas viajar al interior o exterior del pais?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			18,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL)),
			"¿Deseas realizar un viaje nacional o internacional?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			19,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO)),
			"¿Cuanto deseas gastar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			20,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO)),
			"¿Cual es tu presupuesto?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			21,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Buscas hotel para una sola persona o mas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			22,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te interesa una habitacion para una persona o varias?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			23,
			4,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Tienes alguna preferencia en especial? ¿Con pileta o sin pileta?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			24,
			4,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un hotel con pileta o sin?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			25,
			4,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Queres el hotel con o sin desayuno?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			26,
			4,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un hotel con desayuno o sin?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			27,
			4,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Alguna preferencia en especial con las mascotas? ¿Que acepte o no acepte mascotas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			28,
			4,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un hotel que acepte o no acepte mascotas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			29,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO)),
			"¿Deseas viajar al interior o exterior del pais?"
		));
			
		reglasPreg.add(new ReglaPregunta(
			30,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO)),
			"¿Deseas realizar un viaje nacional o internacional?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			31,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO)),
			"¿Cuanto deseas gastar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			32,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO)),
			"¿Cual es tu presupuesto?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			33,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Buscas paquetes para una sola persona o mas?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			34,
			3,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te interesan paquetes para una persona o varias?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			35,
			4,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Alguna preferencia en especial con respecto a las excursiones? ¿Con excursiones o sin excursiones?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			36,
			4,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un paquete que cuente con excursiones o prefieres sin excursiones?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			37,
			4,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te interesa que el paquete cuente con asistencia al viajero o sin asistencia al viajero?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			38,
			4,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un paquete que cuente con asistencia al viajero o prefieres sin asistencia al viajero?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			39,
			4,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te interesa que el paquete cuente con traslados o sin traslados?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			40,
			4,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.PRESUPUESTO)),
			"¿Te gustaria un paquete que cuente con traslados o prefieres sin traslados?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			41,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿A que continente deseas viajar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			42,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿Que continente deseas visitar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			43,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿A que continente deseas viajar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			44,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿Que continente deseas visitar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			45,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿A que continente deseas viajar?"
		));
			
		reglasPreg.add(new ReglaPregunta(
			46,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.INTERNACIONAL)),
			"¿Que continente deseas visitar?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			47,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.TRANSPORTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.TIPOPASAJE, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.NATURALEZA, TipoFiltroPregunta.PREFERENCIALUGAR, TipoFiltroPregunta.PREFERENCIACLIMA)),
			"¿Necesitas asistencia con los documentos requeridos para el viaje?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			48,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PASAJE, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.TRANSPORTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.TIPOPASAJE, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.NATURALEZA, TipoFiltroPregunta.PREFERENCIALUGAR, TipoFiltroPregunta.PREFERENCIACLIMA)),
			"¿Necesitas ayuda para saber que documentos son necesarios para el viaje?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			49,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.PREFERENCIAPILETA, TipoFiltroPregunta.PREFERENCIADESAYUNO, TipoFiltroPregunta.PREFERENCIAMASCOTAS)),
			"¿Necesitas asistencia con los documentos requeridos para el viaje?"
		));
			
		reglasPreg.add(new ReglaPregunta(
			50,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.HOTEL, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.PREFERENCIAPILETA, TipoFiltroPregunta.PREFERENCIADESAYUNO, TipoFiltroPregunta.PREFERENCIAMASCOTAS)),
			"¿Necesitas ayuda para saber que documentos son necesarios para el viaje?"
		));
		
		reglasPreg.add(new ReglaPregunta(
			51,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.EXCURSION, TipoFiltroPregunta.ASISTENCIAVIAJERO, TipoFiltroPregunta.TRASLADOS)),
			"¿Necesitas asistencia con los documentos requeridos para el viaje?"
		));
				
		reglasPreg.add(new ReglaPregunta(
			52,
			5,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<TipoFiltroPregunta>(Arrays.asList(TipoFiltroPregunta.TIPOSERVICIO, TipoFiltroPregunta.PAQUETETURISTICO, TipoFiltroPregunta.DESTINO, TipoFiltroPregunta.CONTINENTE, TipoFiltroPregunta.PRESUPUESTO, TipoFiltroPregunta.CANTPERSONAS, TipoFiltroPregunta.EXCURSION, TipoFiltroPregunta.ASISTENCIAVIAJERO, TipoFiltroPregunta.TRASLADOS)),
			"¿Necesitas ayuda para saber que documentos son necesarios para el viaje?"
		));
	}
	
	public void agregarReglasRespuestas() {
		
		reglasRes.add(new ReglaRespuesta(
			1,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("necesitar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Ok, puedo ayudarte con tu busqueda de pasajes!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			2,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("necesitar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Perfecto! Puedo ofrecerte pasajes"
		));
		
		reglasRes.add(new ReglaRespuesta(
			3,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Ok, puedo ayudarte con tu busqueda de pasajes!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			4,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Perfecto! Puedo ofrecerte pasajes"
		));
		
		reglasRes.add(new ReglaRespuesta(
			5,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Ok, puedo ayudarte con tu busqueda de pasajes!"
		));
			
		reglasRes.add(new ReglaRespuesta(
			6,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Perfecto! Puedo ofrecerte pasajes"
		));
		
		reglasRes.add(new ReglaRespuesta(
			7,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Ok, puedo ayudarte con tu busqueda de pasajes!"
		));
				
		reglasRes.add(new ReglaRespuesta(
			8,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "pasaje")),
			TipoRespuestaUsuario.PASAJE,
			"Perfecto! Puedo ofrecerte pasajes"
		));
		
		reglasRes.add(new ReglaRespuesta(
			9,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("necesitar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Ok, puedo ayudarte con tu busqueda de hoteles!"
		));
			
		reglasRes.add(new ReglaRespuesta(
			10,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("necesitar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Perfecto! Puedo ofrecerte hoteles"
		));
			
		reglasRes.add(new ReglaRespuesta(
			11,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Ok, puedo ayudarte con tu busqueda de hoteles!"
		));
			
		reglasRes.add(new ReglaRespuesta(
			12,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Perfecto! Puedo ofrecerte hoteles"
		));
			
		reglasRes.add(new ReglaRespuesta(
			13,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Ok, puedo ayudarte con tu busqueda de hoteles!"
		));
				
		reglasRes.add(new ReglaRespuesta(
			14,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Perfecto! Puedo ofrecerte hoteles"
		));
			
		reglasRes.add(new ReglaRespuesta(
			15,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Ok, puedo ayudarte con tu busqueda de hoteles!"
		));
					
		reglasRes.add(new ReglaRespuesta(
			16,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "hotel")),
			TipoRespuestaUsuario.HOTEL,
			"Perfecto! Puedo ofrecerte hoteles"
		));
	
		reglasRes.add(new ReglaRespuesta(
			17,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Ok, puedo ayudarte con tu busqueda de paquetes de turismo!"
		));
				
		reglasRes.add(new ReglaRespuesta(
			18,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("querer", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Perfecto! Puedo ofrecerte paquetes de turismo"
		));
				
		reglasRes.add(new ReglaRespuesta(
			19,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Ok, puedo ayudarte con tu busqueda de paquetes de turismo!"
		));
					
		reglasRes.add(new ReglaRespuesta(
			20,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("buscar", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Perfecto! Puedo ofrecerte paquetes de turismo!"
		));
				
		reglasRes.add(new ReglaRespuesta(
			21,
			1,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Ok, puedo ayudarte con tu busqueda de paquetes de turismo!"
		));
						
		reglasRes.add(new ReglaRespuesta(
			22,
			2,
			TipoFiltroPregunta.TIPOSERVICIO,
			new ArrayList<String>(Arrays.asList("preguntar", "paquete", "turismo")),
			TipoRespuestaUsuario.PAQUETETURISTICO,
			"Perfecto! Puedo ofrecerte paquetes de turismo"
		));
		
		reglasRes.add(new ReglaRespuesta(
			23,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("interior")),
			TipoRespuestaUsuario.NACIONAL,
			"Tengo algunos dentro del pais para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			24,
			2,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("interior")),
			TipoRespuestaUsuario.NACIONAL,
			"Te puedo recomendar algunos dentro del pais"
		));
		
		reglasRes.add(new ReglaRespuesta(
			25,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("nacional")),
			TipoRespuestaUsuario.NACIONAL,
			"Tengo algunos dentro del pais para recomendarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			26,
			2,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("nacional")),
			TipoRespuestaUsuario.NACIONAL,
			"Te puedo recomendar algunos dentro del pais"
		));
		
		reglasRes.add(new ReglaRespuesta(
			27,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("exterior")),
			TipoRespuestaUsuario.INTERNACIONAL,
			"Tengo algunos fuera del pais para recomendarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			28,
			2,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("exterior")),
			TipoRespuestaUsuario.INTERNACIONAL,
			"Te puedo recomendar algunos fuera del pais"
		));
			
		reglasRes.add(new ReglaRespuesta(
			29,
			1,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("internacional")),
			TipoRespuestaUsuario.INTERNACIONAL,
			"Tengo algunos fuera del pais para recomendarte"
		));
				
		reglasRes.add(new ReglaRespuesta(
			30,
			2,
			TipoFiltroPregunta.DESTINO,
			new ArrayList<String>(Arrays.asList("internacional")),
			TipoRespuestaUsuario.INTERNACIONAL,
			"Te puedo recomendar algunos fuera del pais"
		));
		
		reglasRes.add(new ReglaRespuesta(
			31,
			1,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("terrestre")),
			TipoRespuestaUsuario.COLECTIVO,
			"Perfecto!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			32,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("terrestre")),
			TipoRespuestaUsuario.COLECTIVO,
			"Buenisimo!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			33,
			1,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("colectivo")),
			TipoRespuestaUsuario.COLECTIVO,
			"Perfecto!"
		));
			
		reglasRes.add(new ReglaRespuesta(
			34,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("colectivo")),
			TipoRespuestaUsuario.COLECTIVO,
			"Buenisimo!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			35,
			1,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("aerea")),
			TipoRespuestaUsuario.AVION,
			"Perfecto!"
		));
			
		reglasRes.add(new ReglaRespuesta(
			36,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("aerea")),
			TipoRespuestaUsuario.AVION,
			"Buenisimo!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			37,
			1,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("avion")),
			TipoRespuestaUsuario.AVION,
			"Perfecto!"
		));
				
		reglasRes.add(new ReglaRespuesta(
			38,
			2,
			TipoFiltroPregunta.TRANSPORTE,
			new ArrayList<String>(Arrays.asList("avion")),
			TipoRespuestaUsuario.AVION,
			"Buenisimo!"
		));
		
		reglasRes.add(new ReglaRespuesta(
			39,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("clase", "economica")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos economicos que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			40,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("clase", "economica")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos baratos que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			41,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("gastar", "poco")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos economicos que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			42,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("gastar", "poco")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos baratos que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			43,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("presupuesto", "bajo")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos baratos que podrian interesarte"
		));
				
		reglasRes.add(new ReglaRespuesta(
			44,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("presupuesto", "bajo")),
			TipoRespuestaUsuario.GASTARPOCO,
			"Ok, tengo algunos economicos que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			45,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("primera", "clase")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos premium que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			46,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("primera", "clase")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos costosos que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			47,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("gastar", "mucho")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos premium que podrian interesarte"
		));
				
		reglasRes.add(new ReglaRespuesta(
			48,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("gastar", "mucho")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos costosos que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			49,
			1,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("presupuesto", "alto")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos de lujo que podrian interesarte"
		));
					
		reglasRes.add(new ReglaRespuesta(
			50,
			2,
			TipoFiltroPregunta.PRESUPUESTO,
			new ArrayList<String>(Arrays.asList("presupuesto", "alto")),
			TipoRespuestaUsuario.GASTARMUCHO,
			"Ok, tengo algunos costosos que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			51,
			1,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<String>(Arrays.asList("ida")),
			TipoRespuestaUsuario.IDA,
			"Entiendo"
		));
						
		reglasRes.add(new ReglaRespuesta(
			52,
			2,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<String>(Arrays.asList("ida")),
			TipoRespuestaUsuario.IDA,
			"Perfecto"
		));
		
		reglasRes.add(new ReglaRespuesta(
			53,
			1,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<String>(Arrays.asList("ida", "vuelta")),
			TipoRespuestaUsuario.IDAYVUELTA,
			"Entiendo"
		));
							
		reglasRes.add(new ReglaRespuesta(
			54,
			2,
			TipoFiltroPregunta.TIPOPASAJE,
			new ArrayList<String>(Arrays.asList("ida", "vuelta")),
			TipoRespuestaUsuario.IDAYVUELTA,
			"Perfecto"
		));
		
		reglasRes.add(new ReglaRespuesta(
			55,
			1,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<String>(Arrays.asList("una", "persona")),
			TipoRespuestaUsuario.UNAPERSONA,
			"Perfecto. Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			56,
			2,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<String>(Arrays.asList("una", "persona")),
			TipoRespuestaUsuario.UNAPERSONA,
			"Excelente eleccion. Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			57,
			1,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<String>(Arrays.asList("varias", "persona")),
			TipoRespuestaUsuario.VARIASPERSONAS,
			"Perfecto. Tengo algunos para recomendarles"
		));
			
		reglasRes.add(new ReglaRespuesta(
			58,
			2,
			TipoFiltroPregunta.CANTPERSONAS,
			new ArrayList<String>(Arrays.asList("varias", "persona")),
			TipoRespuestaUsuario.VARIASPERSONAS,
			"Excelente eleccion. Tengo algunos para recomendarles"
		));
		
		reglasRes.add(new ReglaRespuesta(
			59,
			1,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<String>(Arrays.asList("playa")),
			TipoRespuestaUsuario.PLAYA,
			"Bien, en ese caso tengo algunos para que disfrutes de la playa"
		));
			
		reglasRes.add(new ReglaRespuesta(
			60,
			2,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<String>(Arrays.asList("playa")),
			TipoRespuestaUsuario.PLAYA,
			"Excelente eleccion. Puedo recomendarte algunos para que disfrutes de la playa"
		));
		
		reglasRes.add(new ReglaRespuesta(
			61,
			1,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<String>(Arrays.asList("montania")),
			TipoRespuestaUsuario.MONTANIA,
			"Bien, en ese caso tengo algunos para que disfrutes de las montanias"
		));
				
		reglasRes.add(new ReglaRespuesta(
			62,
			2,
			TipoFiltroPregunta.NATURALEZA,
			new ArrayList<String>(Arrays.asList("montania")),
			TipoRespuestaUsuario.MONTANIA,
			"Excelente eleccion. Puedo recomendarte algunos para que disfrutes de las montanias"
		));
		
		reglasRes.add(new ReglaRespuesta(
			63,
			1,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<String>(Arrays.asList("ciudad", "grande")),
			TipoRespuestaUsuario.CIUDADGRANDE,
			"Entiendo. Te puedo recomendar algunas ciudades grandes que podrias visitar"
		));
		
		reglasRes.add(new ReglaRespuesta(
			64,
			2,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<String>(Arrays.asList("ciudad", "grande")),
			TipoRespuestaUsuario.CIUDADGRANDE,
			"Buenisimo! Tengo algunas ciudades grandes para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			65,
			1,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<String>(Arrays.asList("lugar", "tranquilo")),
			TipoRespuestaUsuario.LUGARTRANQUILO,
			"Entiendo. Te puedo recomendar algunos lugares tranquilos que podrias visitar"
		));
			
		reglasRes.add(new ReglaRespuesta(
			66,
			2,
			TipoFiltroPregunta.PREFERENCIALUGAR,
			new ArrayList<String>(Arrays.asList("lugar", "tranquilo")),
			TipoRespuestaUsuario.LUGARTRANQUILO,
			"Buenisimo! Tengo algunos lugares tranquilos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			67,
			1,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<String>(Arrays.asList("frio")),
			TipoRespuestaUsuario.FRIO,
			"Ok, tengo algunos para disfrutar del frio que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			68,
			2,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<String>(Arrays.asList("frio")),
			TipoRespuestaUsuario.FRIO,
			"Perfecto. Puedo recomendarte algunos para disfrutar del frio"
		));
			
		reglasRes.add(new ReglaRespuesta(
			69,
			1,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<String>(Arrays.asList("calor")),
			TipoRespuestaUsuario.CALOR,
			"Ok, tengo algunos para disfrutar del calor que podrian interesarte"
		));
				
		reglasRes.add(new ReglaRespuesta(
			70,
			2,
			TipoFiltroPregunta.PREFERENCIACLIMA,
			new ArrayList<String>(Arrays.asList("calor")),
			TipoRespuestaUsuario.CALOR,
			"Perfecto. Puedo recomendarte algunos para disfrutar del calor"
		));
		
		reglasRes.add(new ReglaRespuesta(
			71,
			1,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<String>(Arrays.asList("con", "pileta")),
			TipoRespuestaUsuario.CONPILETA,
			"Ok, tengo algunos hoteles con pileta que podrian interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			72,
			2,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<String>(Arrays.asList("con", "pileta")),
			TipoRespuestaUsuario.CONPILETA,
			"Buenisimo! Tengo algunos hoteles con pileta para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			73,
			1,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<String>(Arrays.asList("sin", "pileta")),
			TipoRespuestaUsuario.SINPILETA,
			"Ok, tengo algunos hoteles sin pileta que podrian interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			74,
			2,
			TipoFiltroPregunta.PREFERENCIAPILETA,
			new ArrayList<String>(Arrays.asList("sin", "pileta")),
			TipoRespuestaUsuario.SINPILETA,
			"Buenisimo! Tengo algunos hoteles sin pileta para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			75,
			1,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<String>(Arrays.asList("con", "desayuno")),
			TipoRespuestaUsuario.CONDESAYUNO,
			"Entiendo"
		));
				
		reglasRes.add(new ReglaRespuesta(
			76,
			2,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<String>(Arrays.asList("con", "desayuno")),
			TipoRespuestaUsuario.CONDESAYUNO,
			"Ok, entiendo"
		));
		
		reglasRes.add(new ReglaRespuesta(
			77,
			1,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<String>(Arrays.asList("sin", "desayuno")),
			TipoRespuestaUsuario.SINDESAYUNO,
			"Entiendo"
		));
					
		reglasRes.add(new ReglaRespuesta(
			78,
			2,
			TipoFiltroPregunta.PREFERENCIADESAYUNO,
			new ArrayList<String>(Arrays.asList("sin", "desayuno")),
			TipoRespuestaUsuario.SINDESAYUNO,
			"Ok, entiendo"
		));
		
		reglasRes.add(new ReglaRespuesta(
			79,
			1,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<String>(Arrays.asList("aceptar", "mascota")),
			TipoRespuestaUsuario.ACEPTARMASCOTAS,
			"Perfecto! Tengo unos hoteles pet friendly que podrian interesarte"
		));
					
		reglasRes.add(new ReglaRespuesta(
			80,
			2,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<String>(Arrays.asList("aceptar", "mascota")),
			TipoRespuestaUsuario.ACEPTARMASCOTAS,
			"Excelente eleccion! Puedo recomendarte algunos hoteles pet friendly"
		));
			
		reglasRes.add(new ReglaRespuesta(
			81,
			1,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<String>(Arrays.asList("no", "aceptar", "mascota")),
			TipoRespuestaUsuario.NOACEPTARMASCOTAS,
			"Perfecto! Tengo unos hoteles que no aceptan mascotas que podrian interesarte"
		));
						
		reglasRes.add(new ReglaRespuesta(
			82,
			2,
			TipoFiltroPregunta.PREFERENCIAMASCOTAS,
			new ArrayList<String>(Arrays.asList("no", "aceptar", "mascota")),
			TipoRespuestaUsuario.NOACEPTARMASCOTAS,
			"Excelente eleccion! Puedo recomendarte algunos hoteles que no aceptan mascotas"
		));
		
		reglasRes.add(new ReglaRespuesta(
			83,
			1,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<String>(Arrays.asList("con", "excursion")),
			TipoRespuestaUsuario.CONEXCURSION,
			"Ok, tengo algunos paquetes con excursiones incluidas que podrian interesarte"
		));
							
		reglasRes.add(new ReglaRespuesta(
			84,
			2,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<String>(Arrays.asList("con", "excursion")),
			TipoRespuestaUsuario.CONEXCURSION,
			"Bien. Tengo algunos paquetes con excursiones incluidas para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			85,
			1,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<String>(Arrays.asList("sin", "excursion")),
			TipoRespuestaUsuario.SINEXCURSION,
			"Ok, tengo algunos paquetes sin excursiones incluidas que podrian interesarte"
		));
								
		reglasRes.add(new ReglaRespuesta(
			86,
			2,
			TipoFiltroPregunta.EXCURSION,
			new ArrayList<String>(Arrays.asList("sin", "excursion")),
			TipoRespuestaUsuario.SINEXCURSION,
			"Bien. Tengo algunos paquetes sin excursiones incluidas para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			87,
			1,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<String>(Arrays.asList("con", "asistencia", "viajero")),
			TipoRespuestaUsuario.CONASISTENCIAVIAJERO,
			"Entiendo"
		));
								
		reglasRes.add(new ReglaRespuesta(
			88,
			2,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<String>(Arrays.asList("con", "asistencia", "viajero")),
			TipoRespuestaUsuario.CONASISTENCIAVIAJERO,
			"Perfecto"
		));
			
		reglasRes.add(new ReglaRespuesta(
			89,
			1,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<String>(Arrays.asList("sin", "asistencia", "viajero")),
			TipoRespuestaUsuario.SINASISTENCIAVIAJERO,
			"Entiendo"
		));
									
		reglasRes.add(new ReglaRespuesta(
			90,
			2,
			TipoFiltroPregunta.ASISTENCIAVIAJERO,
			new ArrayList<String>(Arrays.asList("sin", "asistencia", "viajero")),
			TipoRespuestaUsuario.SINASISTENCIAVIAJERO,
			"Perfecto"
		));
		
		reglasRes.add(new ReglaRespuesta(
			91,
			1,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<String>(Arrays.asList("con", "traslados")),
			TipoRespuestaUsuario.CONTRASLADOS,
			"Entiendo"
		));
									
		reglasRes.add(new ReglaRespuesta(
			92,
			2,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<String>(Arrays.asList("con", "traslados")),
			TipoRespuestaUsuario.CONTRASLADOS,
			"Perfecto"
		));
				
		reglasRes.add(new ReglaRespuesta(
			93,
			1,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<String>(Arrays.asList("sin", "traslados")),
			TipoRespuestaUsuario.SINTRASLADOS,
			"Entiendo"
		));
										
		reglasRes.add(new ReglaRespuesta(
			94,
			2,
			TipoFiltroPregunta.TRASLADOS,
			new ArrayList<String>(Arrays.asList("sin", "traslados")),
			TipoRespuestaUsuario.SINTRASLADOS,
			"Perfecto"
		));
		
		reglasRes.add(new ReglaRespuesta(
			95,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("america", "sur")),
			TipoRespuestaUsuario.AMERICASUR,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			96,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("america", "sur")),
			TipoRespuestaUsuario.AMERICASUR,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			97,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("america", "norte")),
			TipoRespuestaUsuario.AMERICANORTE,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
			
		reglasRes.add(new ReglaRespuesta(
			98,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("america", "norte")),
			TipoRespuestaUsuario.AMERICANORTE,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			99,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("centroamerica")),
			TipoRespuestaUsuario.CENTROAMERICA,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
				
		reglasRes.add(new ReglaRespuesta(
			100,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("centroamerica")),
			TipoRespuestaUsuario.CENTROAMERICA,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			101,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("europa")),
			TipoRespuestaUsuario.EUROPA,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
					
		reglasRes.add(new ReglaRespuesta(
			102,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("europa")),
			TipoRespuestaUsuario.EUROPA,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			103,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("africa")),
			TipoRespuestaUsuario.AFRICA,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
						
		reglasRes.add(new ReglaRespuesta(
			104,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("africa")),
			TipoRespuestaUsuario.AFRICA,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			105,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("asia")),
			TipoRespuestaUsuario.ASIA,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
							
		reglasRes.add(new ReglaRespuesta(
			106,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("asia")),
			TipoRespuestaUsuario.ASIA,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			107,
			1,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("oceania")),
			TipoRespuestaUsuario.OCEANIA,
			"Excelente elección! Tengo algunos que pueden interesarte"
		));
								
		reglasRes.add(new ReglaRespuesta(
			108,
			2,
			TipoFiltroPregunta.CONTINENTE,
			new ArrayList<String>(Arrays.asList("oceania")),
			TipoRespuestaUsuario.OCEANIA,
			"Perfecto! Tengo algunos para recomendarte"
		));
		
		reglasRes.add(new ReglaRespuesta(
			109,
			1,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("necesitar", "asistencia")),
			TipoRespuestaUsuario.NECESITARAYUDA,
			"Perfecto, puedo ayudarte con eso"
		));
		
		reglasRes.add(new ReglaRespuesta(
			110,
			2,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("necesitar", "asistencia")),
			TipoRespuestaUsuario.NECESITARAYUDA,
			"Dale! Puedo ayudarte con eso"
		));
		
		reglasRes.add(new ReglaRespuesta(
			111,
			1,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("necesitar", "ayuda")),
			TipoRespuestaUsuario.NECESITARAYUDA,
			"Perfecto, puedo ayudarte con eso"
		));
			
		reglasRes.add(new ReglaRespuesta(
			112,
			2,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("necesitar", "ayuda")),
			TipoRespuestaUsuario.NECESITARAYUDA,
			"Dale! Puedo ayudarte con eso"
		));
		
		reglasRes.add(new ReglaRespuesta(
			113,
			1,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("no", "necesitar", "asistencia")),
			TipoRespuestaUsuario.NONECESITARAYUDA,
			"Entiendo"
		));
				
		reglasRes.add(new ReglaRespuesta(
			114,
			2,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("no", "necesitar", "asistencia")),
			TipoRespuestaUsuario.NONECESITARAYUDA,
			"Comprendo"
		));
		
		reglasRes.add(new ReglaRespuesta(
			115,
			1,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("no", "necesitar", "ayuda")),
			TipoRespuestaUsuario.NONECESITARAYUDA,
			"Entiendo"
		));
					
		reglasRes.add(new ReglaRespuesta(
			116,
			2,
			TipoFiltroPregunta.AYUDADOCS,
			new ArrayList<String>(Arrays.asList("no", "necesitar", "ayuda")),
			TipoRespuestaUsuario.NONECESITARAYUDA,
			"Comprendo"
		));
	}
	
	

}
