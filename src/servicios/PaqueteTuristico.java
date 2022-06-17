package servicios;

public class PaqueteTuristico {
	
	private Double precio;
	private boolean destinoNacional; //true si el paquete es dentro del pais, false si es internacional
	private String destino;
	private String continente;
	private String fechaIda;
	private String fechaVuelta;
	private int cantDias;
	private Integer cantPersonas;
	private String descripcion;
	private boolean incluyeExcursion; //true si el paquete incluye excursiones, false sino 
	private boolean incluyeAsistenciaViajero; //true si el paquete incluye asistencia al viajero, false sino
	private boolean incluyeTraslados; //true si el paquete incluye los traslados, false sino
	private String documentacion;
	
	public PaqueteTuristico(Double precio, boolean destinoN, String destino, String continente, String fechaIda, String fechaVuelta, int cantDias, Integer cantidadPersonas, String descripcion, boolean incluyeExcursion, boolean incluyeAV, boolean incluyeTraslados, String documentacion) {
		this.precio = precio;
		this.destinoNacional = destinoN;
		this.destino = destino;
		this.continente = continente;
		this.fechaIda = fechaIda;
		this.fechaVuelta = fechaVuelta;
		this.cantDias = cantDias;
		this.cantPersonas = cantidadPersonas;
		this.descripcion = descripcion;
		this.incluyeExcursion = incluyeExcursion;
		this.incluyeAsistenciaViajero = incluyeAV;
		this.incluyeTraslados = incluyeTraslados;
		this.documentacion = documentacion;
	}

	//Getters and setters
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public boolean isDestinoNacional() {
		return destinoNacional;
	}
	public void setDestinoNacional(boolean destinoNacional) {
		this.destinoNacional = destinoNacional;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}

	public Integer getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(Integer cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public boolean isIncluyeExcursion() {
		return incluyeExcursion;
	}
	public void setIncluyeExcursion(boolean incluyeExcursion) {
		this.incluyeExcursion = incluyeExcursion;
	}
	public boolean isIncluyeAsistenciaViajero() {
		return incluyeAsistenciaViajero;
	}
	public void setIncluyeAsistenciaViajero(boolean incluyeAsistenciaViajero) {
		this.incluyeAsistenciaViajero = incluyeAsistenciaViajero;
	}
	public boolean isIncluyeTraslados() {
		return incluyeTraslados;
	}
	public void setIncluyeTraslados(boolean incluyeTraslados) {
		this.incluyeTraslados = incluyeTraslados;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}
	public String getFechaVuelta() {
		return fechaVuelta;
	}
	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	
	public String toString(boolean mostrarDoc) {
		String aux = 
				this.descripcion + ". Precio: $" + this.precio + 
				". Fecha inicio: " + this.fechaIda + 
				" - Fecha fin: " + this.fechaVuelta + ". ";
		
		if (this.incluyeExcursion) {
			aux += "El paquete incluye excursiones. ";
		}
		
		if (this.incluyeAsistenciaViajero) {
			aux += "El paquete incluye asistencia al viajero. ";
		}
		
		if (this.incluyeTraslados) {
			aux += "El paquete incluye los traslados. ";
		}
		
		if (mostrarDoc) {
			aux += this.documentacion;
		}
		
		return aux;
	}
	
}
