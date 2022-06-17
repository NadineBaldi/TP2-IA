package reglas;

import java.util.ArrayList;

public class ReglaRespuesta extends Regla {
	
	private TipoFiltroPregunta filtroPregunta;
	private ArrayList<String> condicion; //(parte izquierda de la regla)
	private TipoRespuestaUsuario filtroRespuesta;
	private String salida;
	
	public ReglaRespuesta() {
	}

	public ReglaRespuesta(int id, 
		int prioridad,
		TipoFiltroPregunta filtroPregunta, 
		ArrayList<String> condicion, 
		TipoRespuestaUsuario filtroRespuesta,
		String salida) {
		super();
		this.setId(id);
		this.setPrioridad(prioridad);
		this.filtroPregunta = filtroPregunta;
		this.condicion = condicion;
		this.setCantEspecificaciones(condicion.size());
		this.filtroRespuesta = filtroRespuesta;
		this.salida = salida;
	}

	// Getters and setters
	public TipoFiltroPregunta getFiltroPregunta() {
		return filtroPregunta;
	}

	public void setFiltroPregunta(TipoFiltroPregunta filtroPregunta) {
		this.filtroPregunta = filtroPregunta;
	}

	public ArrayList<String> getCondicion() {
		return condicion;
	}

	public void setCondicion(ArrayList<String> condicion) {
		this.condicion = condicion;
	}

	public TipoRespuestaUsuario getFiltroRespuesta() {
		return filtroRespuesta;
	}

	public void setFiltroRespuesta(TipoRespuestaUsuario filtroRespuesta) {
		this.filtroRespuesta = filtroRespuesta;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}
	
	public boolean verificarCondicion(ArrayList<String> palabras, TipoFiltroPregunta tipoPreg) {
		int contador = 0;
		for (String p: palabras) { //recorro las palabras que ingresa el usuario
			for (String c: this.condicion) { //recorro la condicion de la regla (parte izquierda de la regla)
				if (p.equals(c)) { //si tienen las mismas palabras
					contador++;
				}
			}
		}
		if (contador == this.condicion.size() && tipoPreg.equals(this.filtroPregunta)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setearNovedad(TipoFiltroPregunta tipoPreg) {
		if (tipoPreg.equals(this.filtroPregunta)) {
			this.setNovedad(true);
		} else {
			this.setNovedad(false);
		}
	}
	
}
