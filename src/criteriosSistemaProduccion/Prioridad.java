package criteriosSistemaProduccion;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;

public class Prioridad {
	
	public Prioridad() {
		
	}
	
	public ArrayList<Regla> prioridad(List<Regla> listaReg) {
		int max = 100;
		ArrayList<Regla> reglas = new ArrayList<Regla>();
		for (Regla r : listaReg) {
			if (r.getPrioridad() < max) {
				max = r.getPrioridad();
			}
		}
		for (Regla r : listaReg) {
			if (r.getPrioridad() == max) {
				reglas.add(r);
			}
		}
		
		return reglas;
	}
	
	public String toString() {
		return "Priority";
	}

}
