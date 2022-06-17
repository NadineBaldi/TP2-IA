package servicios;

public class Hotel {
	
	private String nombre;
	private Double precio;
	private boolean destinoNacional; //true si el hotel es dentro del pais, false si es internacional
	private String destino;
	private String continente;
	private Integer cantPersonas;
	private String fechaCheckIn;
	private String fechaCheckOut;
	private int cantDias;
	private boolean tienePileta; //true si el hotel tiene pileta, false sino
	private boolean incluyeDesayuno; //true si el hotel tiene el desayuno incluido, false sino
	private boolean aceptaMascotas; //true si el hotel acepta mascotas, false sino
	private String documentacion;
	
	public Hotel(String nombre, Double precio, boolean destinoN, String destino, String continente, Integer cantidadPersonas, String fechaCI, String fechaCO, int cantDias, boolean tienePileta, boolean incluyeDesayuno, boolean aceptaMascotas, String doc) {
		this.nombre = nombre;
		this.precio = precio;
		this.destinoNacional = destinoN;
		this.destino = destino;
		this.continente = continente;
		this.cantPersonas = cantidadPersonas;
		this.fechaCheckIn = fechaCI;
		this.fechaCheckOut = fechaCO;
		this.cantDias = cantDias;
		this.tienePileta = tienePileta;
		this.incluyeDesayuno = incluyeDesayuno;
		this.aceptaMascotas = aceptaMascotas;
		this.documentacion = doc;
	}

	//Getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
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
	public Integer getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(Integer cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public String getFechaCheckIn() {
		return fechaCheckIn;
	}
	public void setFechaCheckIn(String fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}
	public String getFechaCheckOut() {
		return fechaCheckOut;
	}
	public void setFechaCheckOut(String fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}
	public boolean isTienePileta() {
		return tienePileta;
	}
	public void setTienePileta(boolean tienePileta) {
		this.tienePileta = tienePileta;
	}
	public boolean isIncluyeDesayuno() {
		return incluyeDesayuno;
	}
	public void setIncluyeDesayuno(boolean incluyeDesayuno) {
		this.incluyeDesayuno = incluyeDesayuno;
	}
	public boolean isAceptaMascotas() {
		return aceptaMascotas;
	}
	public void setAceptaMascotas(boolean aceptaMascotas) {
		this.aceptaMascotas = aceptaMascotas;
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
				"Hotel " + this.nombre + " en " + this.destino + 
				". Precio: $" + this.precio + ". Fecha check-in: " + this.fechaCheckIn + 
				" - Fecha check-out: " + this.fechaCheckOut + ". ";
		
		if (this.incluyeDesayuno) {
			aux += "El hotel cuenta con desayuno incluido. ";
		}
		
		if (this.tienePileta) {
			aux += "El hotel tiene pileta. ";
		}
		
		if (this.aceptaMascotas) {
			aux += "El hotel acepta mascotas. ";
		}
		
		if (mostrarDoc) {
			aux += this.documentacion;
		}
		
		return aux;
	}
}
