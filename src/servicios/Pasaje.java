package servicios;

public class Pasaje {
	
	private Double precio;
	private boolean destinoNacional; //true si el pasaje es dentro del pais, false si es internacional
	private String origen;
	private String destino;
	private String continente;
	private String fechaIda;
	private String fechaVuelta;
	private String tipoTransporte;
	private boolean idaYVuelta; //true si el pasaje incluye fecha de ida y vuelta, false si no incluye la vuelta
	private Integer cantPersonas;
	private String tipoNaturaleza;
	private String tipoLugar;
	private String clima;
	private String documentacion;
	
	public Pasaje(Double precio, boolean destinoNacional, String origen, String destino, String continente, String fechaI, String fechaV, String tipoTransporte, boolean idaYVuelta, Integer cantPersonas, String tipoNaturaleza, String tipoLugar, String clima, String documentacion) {
		this.precio = precio;
		this.destinoNacional = destinoNacional;
		this.origen = origen;
		this.destino = destino;
		this.continente = continente;
		this.fechaIda = fechaI;
		this.fechaVuelta = fechaV;
		this.tipoTransporte = tipoTransporte;
		this.idaYVuelta = idaYVuelta;
		this.cantPersonas = cantPersonas;
		this.tipoNaturaleza = tipoNaturaleza;
		this.tipoLugar = tipoLugar;
		this.clima = clima;
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
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public boolean isIdaYVuelta() {
		return idaYVuelta;
	}
	public void setIdaYVuelta(boolean idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}
	public Integer getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(Integer cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public String getTipoNaturaleza() {
		return tipoNaturaleza;
	}
	public void setTipoNaturaleza(String tipoNaturaleza) {
		this.tipoNaturaleza = tipoNaturaleza;
	}
	public String getTipoLugar() {
		return tipoLugar;
	}
	public void setTipoLugar(String tipoLugar) {
		this.tipoLugar = tipoLugar;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
	
	public String toString(boolean mostrarDoc) {
		String aux = 
			"Origen: " + this.origen + " - Destino: " + this.destino + 
			". \n Medio de transporte: " + this.tipoTransporte +
			". \n Precio: $" + this.precio + ". \n Fecha ida: " + this.fechaIda + 
			" - Fecha vuelta: " + this.fechaVuelta + ". ";
		
		if (mostrarDoc) {
			aux += this.documentacion;
		}
		
		return aux;
	}
}
