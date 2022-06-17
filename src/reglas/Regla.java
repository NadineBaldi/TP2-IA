package reglas;

public class Regla {

	private int id; //asigno id para que no se dupliquen (no duplicacion)
	private boolean novedad; //novedad indica el orden en que se definieron las reglas
	private int prioridad; //prioridad que le pusimos nosotras
	private int cantEspecificaciones; //(especificidad) indica la cantidad de especificaciones que tiene el if
	
	public Regla() {
		novedad = false;
		prioridad = 0;
		cantEspecificaciones = 0;
	}

	public Regla(int id, boolean novedad, int prioridad, int cantEspecificaciones) {
		super();
		this.id = id;
		this.novedad = novedad;
		this.prioridad = prioridad;
		this.cantEspecificaciones = cantEspecificaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getNovedad() {
		return novedad;
	}

	public void setNovedad(boolean novedad) {
		this.novedad = novedad;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getCantEspecificaciones() {
		return cantEspecificaciones;
	}

	public void setCantEspecificaciones(int cantEspecificaciones) {
		this.cantEspecificaciones = cantEspecificaciones;
	}
	
	
}
