package criteriosSistemaProduccion;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;

public class Novedad {
	
	public Novedad() {
	}
	
	public ArrayList<Regla> novedad(List<Regla> listaReg) {
		ArrayList<Regla> reglas = new ArrayList<Regla>();
		for (Regla r : listaReg) {
			if (r.getNovedad()) {
				reglas.add(r);
			}
		}
		if (reglas.isEmpty()) {
			return (ArrayList<Regla>) listaReg;
		} else {
			return reglas;
		}
	}
	
	public String toString() {
		return "Novedad";
	}

}
