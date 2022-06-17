package criteriosSistemaProduccion;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;
import utils.EscribirTxt;

public class Estrategia {
	
	private List<Regla> reglasActivas;
	private List<Regla> reglasUsadas;
	private String logFaseResolucion;
	
	public Estrategia() {
	}

	//Getters and setters
	public List<Regla> getReglasActivas() {
		return reglasActivas;
	}

	public void setReglasActivas(List<Regla> reglasActivas) {
		this.reglasActivas = reglasActivas;
	}

	public List<Regla> getReglasUsadas() {
		return reglasUsadas;
	}

	public void setReglasUsadas(List<Regla> reglasUsadas) {
		this.reglasUsadas = reglasUsadas;
	}

	public String getLogEjecucion() {
		return logFaseResolucion;
	}

	public void setLogEjecucion(String logFaseResolucion) {
		this.logFaseResolucion = logFaseResolucion;
	}
	
	
	public Regla buscarRegla() {
		Regla r = new Regla();
		ArrayList<Regla> aux = new ArrayList<Regla>();
		EscribirTxt escLog = new EscribirTxt();
		this.logFaseResolucion = "";
		
		// Criterios: especificidad, no-duplicación, prioridad, novedad, aleatorio
		
		// Probar con la estrategia de Especificidad
		aux = this.especificidad();
		if (aux.size() == 1) {
			r = aux.get(0);
		} else {
			// Probar con la estrategia de NoDuplicacion
			this.reglasActivas = aux;
			aux = this.noDuplicacion();
			if (aux.size() == 1) {
				r = aux.get(0);
			} else {
				// Probar con la estrategia de prioridad
				this.reglasActivas = aux;
				aux = this.prioridad();
				if (aux.size() == 1) {
					r = aux.get(0);
				} else {
					// Probar con la estrategia de novedad
					this.reglasActivas = aux;
					aux = this.novedad();
					if (aux.size() == 1) {
						r = aux.get(0);
					} else {
						// Probar con la estrategia aleatorio
						this.reglasActivas = aux;
						r = this.aleatorio();
					}
				}
			}
		}
		
		// Ahora escribo el archivo de texto con la regla que se selecciono
		escLog.escribirReglaSeleccionada(logFaseResolucion, r);
		
		return r;
		
	}
	
	public ArrayList<Regla> especificidad() {
		ArrayList<Regla> reglaRes = new ArrayList<Regla>();
		Especificidad e = new Especificidad();
		reglaRes = e.especificidad(this.reglasActivas);
		if (reglaRes.size() != reglasActivas.size()) {
			this.logFaseResolucion += " Especificidad ";
		}
		if (reglaRes.size() > 1) {
			return reglaRes;
		} else if (reglaRes.size()== 0) {
			return (ArrayList<Regla>) this.reglasActivas;
		} else {
			return reglaRes;
		}
	}
	
	public ArrayList<Regla> noDuplicacion() {
		ArrayList<Regla> reglaRes = new ArrayList<Regla>();
		NoDuplicacion np = new NoDuplicacion();
		reglaRes = np.noDuplicacion(reglasActivas, reglasUsadas);
		if (reglaRes.size() != reglasActivas.size()) {
			this.logFaseResolucion += " No duplicacion ";
		}
		if (reglaRes.size() > 1) {
			return reglaRes;
		} else if (reglaRes.size() == 0) {
			return (ArrayList<Regla>) this.reglasActivas;
		} else {
			return reglaRes;
		}
	}
	
	public ArrayList<Regla> prioridad() {
		ArrayList<Regla> reglaRes = new ArrayList<Regla>();
		Prioridad p = new Prioridad();
		reglaRes = p.prioridad(this.reglasActivas);
		if (reglaRes.size() != reglasActivas.size()) {
			this.logFaseResolucion += " Prioridad ";
		}
		if (reglaRes.size() > 1) {
			return reglaRes;
		} else if (reglaRes.size() == 0) {
			return (ArrayList<Regla>) this.reglasActivas;
		} else {
			return reglaRes;
		}
	}
	
	public ArrayList<Regla> novedad() {
		ArrayList<Regla> reglaRes = new ArrayList<Regla>();
		Novedad n = new Novedad();
		reglaRes = n.novedad(this.reglasActivas);
		if (reglaRes.size() != reglasActivas.size()) {
			this.logFaseResolucion += " Novedad ";
		}
		if (reglaRes.size() > 1) {
			return reglaRes;
		} else if (reglaRes.size() == 0) {
			return (ArrayList<Regla>) this.reglasActivas;
		} else {
			return reglaRes;
		}
	}
	
	public Regla aleatorio() {
		Regla r = new Regla();
		Aleatorio a = new Aleatorio();
		r = a.randomReglas(this.reglasActivas);
		this.logFaseResolucion += " Aleatorio ";
		return r;
	}
	

}
