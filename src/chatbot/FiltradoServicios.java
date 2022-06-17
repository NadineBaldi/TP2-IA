package chatbot;

import java.util.ArrayList;

import reglas.TipoFiltroPregunta;
import reglas.TipoRespuestaUsuario;
import servicios.Hotel;
import servicios.PaqueteTuristico;
import servicios.Pasaje;

public class FiltradoServicios {
	
	private ArrayList<Hotel> hotelesFiltrados;
	private ArrayList<PaqueteTuristico> paquetesFiltrados;
	private ArrayList<Pasaje> pasajesFiltrados;
	private TipoRespuestaUsuario tipoRes; 
	private boolean mostrarDocumentacion;
	
	public FiltradoServicios() {
		this.inicializar();
	}
	
	public ArrayList<Hotel> getHotelesFiltrados() {
		return hotelesFiltrados;
	}
	public void setHotelesFiltrados(ArrayList<Hotel> hotelesFiltrados) {
		this.hotelesFiltrados = hotelesFiltrados;
	}
	public ArrayList<PaqueteTuristico> getPaquetesFiltrados() {
		return paquetesFiltrados;
	}
	public void setPaquetesFiltrados(ArrayList<PaqueteTuristico> paquetesFiltrados) {
		this.paquetesFiltrados = paquetesFiltrados;
	}
	public ArrayList<Pasaje> getPasajesFiltrados() {
		return pasajesFiltrados;
	}
	public void setPasajesFiltrados(ArrayList<Pasaje> pasajesFiltrados) {
		this.pasajesFiltrados = pasajesFiltrados;
	}
	public TipoRespuestaUsuario getTipoRes() {
		return tipoRes;
	}
	public void setTipoRes(TipoRespuestaUsuario tipoRes) {
		this.tipoRes = tipoRes;
	}
	
	// Defino un metodo que inicializa los ArrayList declarados
	public void inicializar() {
		BaseDeDatos BD = BaseDeDatos.getInstance(); //obtengo una instancia de la base de datos
		this.hotelesFiltrados = new ArrayList<Hotel>();
		this.paquetesFiltrados = new ArrayList<PaqueteTuristico>();
		this.pasajesFiltrados = new ArrayList<Pasaje>();
		this.hotelesFiltrados.addAll(BD.getHoteles());
		this.paquetesFiltrados.addAll(BD.getPaquetesTuristicos());
		this.pasajesFiltrados.addAll(BD.getPasajes());
		this.tipoRes = null;
		this.mostrarDocumentacion = false;
	}
	
	// Defino un metodo que crea el string que se va a imprimir por pantalla con todas las recomendaciones que el chatbot le dara al usuario
	public String recomendacion() {
		String recomendacion = "";
		
		if (tipoRes == TipoRespuestaUsuario.PASAJE) {
			for (Pasaje p: pasajesFiltrados) {
				recomendacion += p.toString(mostrarDocumentacion) + "\n";
			}
		} else if (tipoRes == TipoRespuestaUsuario.HOTEL) {
			for (Hotel h: hotelesFiltrados) {
				recomendacion += h.toString(mostrarDocumentacion) + "\n";
			}
		} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) {
			for (PaqueteTuristico pt: paquetesFiltrados) {
				recomendacion += pt.toString(mostrarDocumentacion) + "\n";
			}
		}
		
		return recomendacion;
	}
	
	// Defino los metodos que van a ir filtrando
	public void filtrar(TipoFiltroPregunta tipoPreg, TipoRespuestaUsuario tipoRespuesta) {
		switch(tipoPreg) {
		case TIPOSERVICIO:
			//se setea a tipoRes (se setea a tipoRes con el servicio que el usuario esta buscando)
			this.tipoRes = tipoRespuesta;
			break;
		case DESTINO:
			//metodo que filtra el destino (nacional o internacional)
			this.filtrarDestino(tipoRespuesta);
			break;
		case CONTINENTE:
			//metodo que filtra el continente
			this.filtrarContinente(tipoRespuesta);
			break;
		case PRESUPUESTO:
			//metodo que filtra si un precio es caro o barato
			this.filtrarPresupuesto(tipoRespuesta);
			break;
		case CANTPERSONAS:
			//metodo que filtra la cantidad de personas
			this.filtrarCantPersonas(tipoRespuesta);
			break;
		case TRANSPORTE:
			//metodo que filtra el tipo de transporte para los pasajes (avion o colectivo)
			this.filtrarTransporte(tipoRespuesta);
			break;
		case TIPOPASAJE:
			//metodo que filtra si el pasaje es solo de ida o ida y vuelta
			this.filtrarTipoPasaje(tipoRespuesta);
			break;
		case NATURALEZA:
			//metodo que filtra el tipo de naturaleza para el pasaje buscado (si el lugar es de playa o montania)
			this.filtrarTipoNaturaleza(tipoRespuesta);
			break;
		case PREFERENCIALUGAR:
			//metodo que filtra la preferencia del lugar para el pasaje buscado (ciudad grande o lugar tranquilo)
			this.filtrarPreferenciaLugar(tipoRespuesta);
			break;
		case PREFERENCIACLIMA:
			//metodo que filtra la preferencia del clima para el pasaje buscado (calor o frio)
			this.filtrarPreferenciaClima(tipoRespuesta);
			break;
		case PREFERENCIAPILETA:
			//metodo que filtra si se prefiere hotel con pileta o sin
			this.filtrarPreferenciaPileta(tipoRespuesta);
			break;
		case PREFERENCIADESAYUNO:
			//metodo que filtra si se prefiere hotel con desayuno incluido o sin
			this.filtrarPreferenciaDesayuno(tipoRespuesta);
			break;
		case PREFERENCIAMASCOTAS:
			//metodo que filtra si se prefiere hotel pet-friendly o no
			this.filtrarPreferenciaMascotas(tipoRespuesta);
			break;
		case EXCURSION:
			//metodo que filtra si se prefiere paquete con excursiones incluidas o no
			this.filtrarPreferenciaExcursion(tipoRespuesta);
			break;
		case ASISTENCIAVIAJERO:
			//metodo que filtra si se prefiere paquete que incluya asistencia al viajero o no
			this.filtrarPreferenciaAsistenciaViajero(tipoRespuesta);
			break;
		case TRASLADOS:
			//metodo que filtra si se prefiere paquete que incluya traslados o no
			this.filtrarPreferenciaTraslados(tipoRespuesta);
			break;
		case AYUDADOCS:
			//metodo que filtra si se prefiere recibir una referencia de los docs necesarios para ingresar a un pais o no
			if (tipoRespuesta == TipoRespuestaUsuario.NECESITARAYUDA) this.mostrarDocumentacion = true;
			else if (tipoRespuesta == TipoRespuestaUsuario.NONECESITARAYUDA) this.mostrarDocumentacion = false;
			break;
		default: 
			break;
		}
	}
	
	private void filtrarDestino(TipoRespuestaUsuario tipoRespuesta) {
		if (tipoRespuesta == TipoRespuestaUsuario.NACIONAL) { //si es nacional
			if (tipoRes == TipoRespuestaUsuario.PASAJE) { //veo si es un pasaje, para recorrer los pasajes
				ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
				for (Pasaje p: pasajesFiltrados) {
					if (p.isDestinoNacional()) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean nacionales (es decir que destinoNacional sea true)
				}
				pasajesFiltrados = aux;
			} else if (tipoRes == TipoRespuestaUsuario.HOTEL) { //veo si es un hotel, para recorrer todos los hoteles
				ArrayList<Hotel> aux = new ArrayList<Hotel>();
				for (Hotel h: hotelesFiltrados) {
					if (h.isDestinoNacional()) aux.add(h); //agrego en el arreglo aux los hoteles que sean nacionales
				}
				hotelesFiltrados = aux;
			} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) {
				ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
				for (PaqueteTuristico pt: paquetesFiltrados) {
					if (pt.isDestinoNacional()) aux.add(pt); //agrego en el arreglo aux los paquetes que sean nacionales
				}
				paquetesFiltrados = aux;
			}
		} else {
			if (tipoRes == TipoRespuestaUsuario.PASAJE) { //veo si es un pasaje, para recorrer los pasajes
				ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
				for (Pasaje p: pasajesFiltrados) {
					if (!p.isDestinoNacional()) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean nacionales (es decir que destinoNacional sea true)
				}
				pasajesFiltrados = aux;
			} else if (tipoRes == TipoRespuestaUsuario.HOTEL) { //veo si es un hotel, para recorrer todos los hoteles
				ArrayList<Hotel> aux = new ArrayList<Hotel>();
				for (Hotel h: hotelesFiltrados) {
					if (!h.isDestinoNacional()) aux.add(h); //agrego en el arreglo aux los hoteles que sean nacionales
				}
				hotelesFiltrados = aux;
			} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) {
				ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
				for (PaqueteTuristico pt: paquetesFiltrados) {
					if (!pt.isDestinoNacional()) aux.add(pt); //agrego en el arreglo aux los paquetes que sean nacionales
				}
				paquetesFiltrados = aux;
			}
		}
	}
	
	private void filtrarContinente(TipoRespuestaUsuario tipoRespuesta) {
		if (tipoRes == TipoRespuestaUsuario.PASAJE) { //veo si es un pasaje, para recorrer los pasajes
			ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
			for (Pasaje p: pasajesFiltrados) {
				if((tipoRespuesta == TipoRespuestaUsuario.AMERICASUR && p.getContinente().equals("America del Sur")) ||
					(tipoRespuesta == TipoRespuestaUsuario.CENTROAMERICA && p.getContinente().equals("Centroamerica")) ||	
					(tipoRespuesta == TipoRespuestaUsuario.AMERICANORTE && p.getContinente().equals("America del Norte")) ||
					(tipoRespuesta == TipoRespuestaUsuario.EUROPA && p.getContinente().equals("Europa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.AFRICA && p.getContinente().equals("Africa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.ASIA && p.getContinente().equals("Asia")) ||
					(tipoRespuesta == TipoRespuestaUsuario.OCEANIA && p.getContinente().equals("Oceania"))
				) {
					aux.add(p); //agrego en el arreglo aux todos los pasajes que sean del continente que el usuario ingresa
				}	
			}
			pasajesFiltrados = aux;
		} else if (tipoRes == TipoRespuestaUsuario.HOTEL) { //veo si es un hotel, para recorrer todos los hoteles
			ArrayList<Hotel> aux = new ArrayList<Hotel>();
			for (Hotel h: hotelesFiltrados) {
				if((tipoRespuesta == TipoRespuestaUsuario.AMERICASUR && h.getContinente().equals("America del Sur")) ||
					(tipoRespuesta == TipoRespuestaUsuario.CENTROAMERICA && h.getContinente().equals("Centroamerica")) ||	
					(tipoRespuesta == TipoRespuestaUsuario.AMERICANORTE && h.getContinente().equals("America del Norte")) ||
					(tipoRespuesta == TipoRespuestaUsuario.EUROPA && h.getContinente().equals("Europa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.AFRICA && h.getContinente().equals("Africa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.ASIA && h.getContinente().equals("Asia")) ||
					(tipoRespuesta == TipoRespuestaUsuario.OCEANIA && h.getContinente().equals("Oceania"))
				) {
					aux.add(h); //agrego en el arreglo aux todos los hoteles que sean del continente que el usuario ingresa
				}	
			}
			hotelesFiltrados = aux;
		} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) {
			ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if((tipoRespuesta == TipoRespuestaUsuario.AMERICASUR && pt.getContinente().equals("America del Sur")) ||
					(tipoRespuesta == TipoRespuestaUsuario.CENTROAMERICA && pt.getContinente().equals("Centroamerica")) ||	
					(tipoRespuesta == TipoRespuestaUsuario.AMERICANORTE && pt.getContinente().equals("America del Norte")) ||
					(tipoRespuesta == TipoRespuestaUsuario.EUROPA && pt.getContinente().equals("Europa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.AFRICA && pt.getContinente().equals("Africa")) ||
					(tipoRespuesta == TipoRespuestaUsuario.ASIA && pt.getContinente().equals("Asia")) ||
					(tipoRespuesta == TipoRespuestaUsuario.OCEANIA && pt.getContinente().equals("Oceania"))
				) {
					aux.add(pt); //agrego en el arreglo aux todos los paquetes que sean del continente que el usuario ingresa
				}	
			}
			paquetesFiltrados = aux;
		}
	}
	
	private void filtrarPresupuesto(TipoRespuestaUsuario tipoRespuesta) {
		if (tipoRes == TipoRespuestaUsuario.PASAJE) { //veo si es un pasaje, para recorrer los pasajes
			ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
			for (Pasaje p: pasajesFiltrados) {
				if(tipoRespuesta == TipoRespuestaUsuario.GASTARPOCO && (p.getCantPersonas() == 1 && p.getPrecio() < 80000.0) || (p.getCantPersonas() > 1 && p.getPrecio() < 160000.0)) {
					//Si el usuario quiere gastar poco y el pasaje es para una persona, pasaje economico es con un precio maximo de 79.999
					//si el pasaje es para mas de una persona, pasaje economico es con un precio menor a 160.000
					aux.add(p); //agrego en el arreglo aux todos los pasajes que sean economicos
				} else if(tipoRespuesta == TipoRespuestaUsuario.GASTARMUCHO && (p.getCantPersonas() == 1 && p.getPrecio() >= 80000.0) || (p.getCantPersonas() > 1 && p.getPrecio() >= 160000.0)) {
					//Si el usuario quiere gastar mucho y el pasaje es para una persona, pasaje caro es con un precio mayor de 80.000
					//si el pasaje es para mas de una persona, pasaje caro es con un precio mayor a 160.000
					aux.add(p); //agrego en el arreglo aux todos los pasajes que sean caros/clase alta
				}
			}
			pasajesFiltrados = aux;
		} else if (tipoRes == TipoRespuestaUsuario.HOTEL) { //veo si es un hotel, para recorrer todos los hoteles
			ArrayList<Hotel> aux = new ArrayList<Hotel>();
			for (Hotel h: hotelesFiltrados) {
				if(tipoRespuesta == TipoRespuestaUsuario.GASTARPOCO && (h.getPrecio()/h.getCantDias()/h.getCantPersonas() < 3000.0)) {
					//Si el usuario quiere gastar poco y el hotel tiene precio por dia y por persona menor a 3000
					aux.add(h); //agrego en el arreglo aux todos los hoteles que sean economicos
				} else if(tipoRespuesta == TipoRespuestaUsuario.GASTARMUCHO && (h.getPrecio()/h.getCantDias()/h.getCantPersonas() >= 3000.0)) {
					//Si el usuario quiere gastar mucho y el hotel tiene precio por dia y por persona mayor o igual a 3000
					aux.add(h); //agrego en el arreglo aux todos los hoteles que sean caros/lujosos
				}
			}
			hotelesFiltrados = aux; 
		} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) { //veo si es un paquete turistico, para recorrer todos los paquetes
			ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if(tipoRespuesta == TipoRespuestaUsuario.GASTARPOCO && (pt.getPrecio()/pt.getCantDias()/pt.getCantPersonas() < 25000.0)) {
					//Si el usuario quiere gastar poco y el paquete tiene precio por dia y por persona menor a 25.000
					aux.add(pt); //agrego en el arreglo aux todos los paquetes que sean economicos
				} else if (tipoRespuesta == TipoRespuestaUsuario.GASTARPOCO && (pt.getPrecio()/pt.getCantDias()/pt.getCantPersonas() >= 25000.0)) {
					//Si el usuario quiere gastar mucho y el paquete tiene precio por dia y por persona mayor o igual a 25.000
					aux.add(pt); //agrego en el arreglo aux todos los paquetes que sean caros/de lujo
				}
			}
			paquetesFiltrados = aux;
		}
	}
	
	private void filtrarCantPersonas(TipoRespuestaUsuario tipoRespuesta) {
		if (tipoRes == TipoRespuestaUsuario.PASAJE) { //veo si es un pasaje, para recorrer los pasajes
			ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
			for (Pasaje p: pasajesFiltrados) {
				if(p.getCantPersonas() == 1 && tipoRespuesta == TipoRespuestaUsuario.UNAPERSONA) {
					aux.add(p); //agrego en el arreglo aux todos los pasajes que sean para una sola persona
				} else if(p.getCantPersonas() > 1 && tipoRespuesta == TipoRespuestaUsuario.VARIASPERSONAS) {
					aux.add(p); //agrego en el arreglo aux todos los pasajes que sean para mas de una persona
				}
			}
			pasajesFiltrados = aux;
		} else if (tipoRes == TipoRespuestaUsuario.HOTEL) { //veo si es un hotel, para recorrer todos los hoteles
			ArrayList<Hotel> aux = new ArrayList<Hotel>();
			for (Hotel h: hotelesFiltrados) {
				if(h.getCantPersonas() == 1 && tipoRespuesta == TipoRespuestaUsuario.UNAPERSONA) {
					aux.add(h); //agrego en el arreglo aux todos los hoteles que sean para una sola persona
				} else if (h.getCantPersonas() > 1 && tipoRespuesta == TipoRespuestaUsuario.VARIASPERSONAS) {
					aux.add(h); //agrego en el arreglo aux todos los hoteles que sean para mas de una persona
				}
			}
			hotelesFiltrados = aux;
		} else if (tipoRes == TipoRespuestaUsuario.PAQUETETURISTICO) { //veo si es un paquete turistico, para recorrer todos los paquetes
			ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if(pt.getCantPersonas() == 1 && tipoRespuesta == TipoRespuestaUsuario.UNAPERSONA) {
					aux.add(pt); //agrego en el arreglo aux todos los paquetes que sean para una sola persona
				} else if (pt.getCantPersonas() > 1 && tipoRespuesta == TipoRespuestaUsuario.VARIASPERSONAS) {
					aux.add(pt); //agrego en el arreglo aux todos los paquetes que sean para mas de una persona
				}
			}
			paquetesFiltrados = aux;
		}
	}
	
	private void filtrarTransporte(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
		if (tipoRespuesta == TipoRespuestaUsuario.AVION) { //si el pasaje es en avion
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoTransporte().equals("avion")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean de avion
			}
			pasajesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.COLECTIVO) { //si el pasaje es en colectivo
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoTransporte().equals("colectivo")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean de colectivo
			}
			pasajesFiltrados = aux;
		}
	}
	
	private void filtrarTipoPasaje(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
		if (tipoRespuesta == TipoRespuestaUsuario.IDA) { //si el pasaje es solo de ida
			for (Pasaje p: pasajesFiltrados) {
				if (!p.isIdaYVuelta()) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean solo de ida
			}
			pasajesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.IDAYVUELTA) { //si el pasaje es de ida y vuelta
			for (Pasaje p: pasajesFiltrados) {
				if (p.isIdaYVuelta()) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean de ida y vuelta
			}
			pasajesFiltrados = aux;
		}
	}
	
	private void filtrarTipoNaturaleza(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
		if (tipoRespuesta == TipoRespuestaUsuario.PLAYA) { //si el usuario elige playa
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoNaturaleza().equals("Playa")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean en lugares de playa
			}
			pasajesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.MONTANIA) { //si el usuario elige montania
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoNaturaleza().equals("Montania")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean en lugares de montania
			}
			pasajesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaLugar(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
		if (tipoRespuesta == TipoRespuestaUsuario.CIUDADGRANDE) { //si el usuario elige ciudad grande
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoLugar().equals("Ciudad grande")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean en ciudades grandes
			}
			pasajesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.LUGARTRANQUILO) { //si el usuario elige un lugar tranquilo
			for (Pasaje p: pasajesFiltrados) {
				if (p.getTipoLugar().equals("Lugar tranquilo")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean en lugares tranquilos
			}
			pasajesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaClima(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Pasaje> aux = new ArrayList<Pasaje>();
		if (tipoRespuesta == TipoRespuestaUsuario.FRIO) { //si el usuario elige un lugar de frio
			for (Pasaje p: pasajesFiltrados) {
				if (p.getClima().equals("frio")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean a lugares frios
			}
			pasajesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.CALOR) { //si el usuario elige un lugar de calor
			for (Pasaje p: pasajesFiltrados) {
				if (p.getClima().equals("calor")) aux.add(p); //agrego en el arreglo aux todos los pasajes que sean a lugares de calor
			}
			pasajesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaPileta(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Hotel> aux = new ArrayList<Hotel>();
		if (tipoRespuesta == TipoRespuestaUsuario.CONPILETA) { //si el usuario elige un hotel con pileta
			for (Hotel h: hotelesFiltrados) {
				if (h.isTienePileta()) aux.add(h); //agrego en el arreglo aux todos los hoteles que incluyan pileta
			}
			hotelesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.SINPILETA) { //si el usuario elige un hotel sin pileta
			for (Hotel h: hotelesFiltrados) {
				if (!h.isTienePileta()) aux.add(h); //agrego en el arreglo aux todos los hoteles que no incluyan pileta
			}
			hotelesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaDesayuno(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Hotel> aux = new ArrayList<Hotel>();
		if (tipoRespuesta == TipoRespuestaUsuario.CONDESAYUNO) { //si el usuario elige un hotel con desayuno incluido
			for (Hotel h: hotelesFiltrados) {
				if (h.isIncluyeDesayuno()) aux.add(h); //agrego en el arreglo aux todos los hoteles que incluyan desayuno
			}
			hotelesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.SINDESAYUNO) { //si el usuario elige un hotel sin desayuno incluido
			for (Hotel h: hotelesFiltrados) {
				if (!h.isIncluyeDesayuno()) aux.add(h); //agrego en el arreglo aux todos los hoteles que no incluyan desayuno
			}
			hotelesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaMascotas(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<Hotel> aux = new ArrayList<Hotel>();
		if (tipoRespuesta == TipoRespuestaUsuario.ACEPTARMASCOTAS) { //si el usuario elige un hotel pet friendly
			for (Hotel h: hotelesFiltrados) {
				if (h.isAceptaMascotas()) aux.add(h); //agrego en el arreglo aux todos los hoteles que acepten mascotas
			}
			hotelesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.NOACEPTARMASCOTAS) { //si el usuario elige un hotel que no acepte mascotas
			for (Hotel h: hotelesFiltrados) {
				if (!h.isAceptaMascotas()) aux.add(h); //agrego en el arreglo aux todos los hoteles que no acepten mascotas
			}
			hotelesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaExcursion(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
		if (tipoRespuesta == TipoRespuestaUsuario.CONEXCURSION) { //si el usuario elige un paquete que incluya excursiones
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (pt.isIncluyeExcursion()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que incluyen excursiones
			}
			paquetesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.SINEXCURSION) { //si el usuario elige un paquete que no incluye excursiones
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (!pt.isIncluyeExcursion()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que no incluyen excursiones
			}
			paquetesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaAsistenciaViajero(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
		if (tipoRespuesta == TipoRespuestaUsuario.CONASISTENCIAVIAJERO) { //si el usuario elige un paquete que incluya asistencia al viajero
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (pt.isIncluyeAsistenciaViajero()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que incluyen asistencia al viajero
			}
			paquetesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.SINASISTENCIAVIAJERO) { //si el usuario elige un paquete que no incluye asistencia al viajero
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (!pt.isIncluyeAsistenciaViajero()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que no incluyen asistencia al viajero
			}
			paquetesFiltrados = aux;
		}
	}
	
	private void filtrarPreferenciaTraslados(TipoRespuestaUsuario tipoRespuesta) {
		ArrayList<PaqueteTuristico> aux = new ArrayList<PaqueteTuristico>();
		if (tipoRespuesta == TipoRespuestaUsuario.CONTRASLADOS) { //si el usuario elige un paquete que incluya traslados
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (pt.isIncluyeTraslados()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que incluyen traslados
			}
			paquetesFiltrados = aux;
		} else if (tipoRespuesta == TipoRespuestaUsuario.SINTRASLADOS) { //si el usuario elige un paquete que no incluye traslados
			for (PaqueteTuristico pt: paquetesFiltrados) {
				if (!pt.isIncluyeTraslados()) aux.add(pt); //agrego en el arreglo aux todos los paquetes que no incluyen traslados
			}
			paquetesFiltrados = aux;
		}
	}
	
}
