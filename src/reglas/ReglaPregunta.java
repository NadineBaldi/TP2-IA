package reglas;

import java.util.ArrayList;

public class ReglaPregunta extends Regla {
	
	private TipoFiltroPregunta filtroPregunta;
	private ArrayList<TipoFiltroPregunta> condicion; //(parte izquierda del if)
	private String salida;
	
	public ReglaPregunta() {
	}

	public ReglaPregunta(int id, int prioridad,
			TipoFiltroPregunta filtroPregunta, 
			ArrayList<TipoFiltroPregunta> condicion,
			String salida) {
		super();
		this.setId(id);
		this.setPrioridad(prioridad);
		this.filtroPregunta = filtroPregunta;
		this.condicion = condicion;
		this.setCantEspecificaciones(condicion.size());
		this.salida = salida;
	}

	// Getters and setters
	public TipoFiltroPregunta getFiltroPregunta() {
		return filtroPregunta;
	}

	public void setFiltroPregunta(TipoFiltroPregunta filtroPregunta) {
		this.filtroPregunta = filtroPregunta;
	}

	public ArrayList<TipoFiltroPregunta> getCondicion() {
		return condicion;
	}

	public void setCondicion(ArrayList<TipoFiltroPregunta> condicion) {
		this.condicion = condicion;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}
	
	public boolean verificarCondicion(ArrayList<TipoFiltroPregunta> preguntadas) {
		int contador = 0;
		for (TipoFiltroPregunta p: preguntadas) { //recorro los tipos de preguntas que ya fueron preguntadas
			for (TipoFiltroPregunta c: this.condicion) { //recorror la condicion de la regla (parte izquierda de la regla - tipos de pregunta de la izquierda)
				if (p.equals(c)) { //si tienen las mismas palabras
					contador++;
				}
			}
		}
		if (contador == this.condicion.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setearNovedad(TipoFiltroPregunta ultimoTipoInferido) {
		boolean encontrado = false;
		for (TipoFiltroPregunta fp: this.condicion) {
			if (fp.equals(ultimoTipoInferido)) {
				encontrado=true;
			}
		}
		this.setNovedad(encontrado);
	}

}
