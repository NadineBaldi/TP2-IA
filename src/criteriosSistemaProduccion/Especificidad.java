package criteriosSistemaProduccion;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;

public class Especificidad {

	public Especificidad() {
	}
	
	public ArrayList<Regla> especificidad(List<Regla> listaReg) {
		int max = 0;
		ArrayList<Regla> reglas = new ArrayList<Regla>();
		for (Regla r : listaReg) {
			max = r.getCantEspecificaciones();
		}
		for (Regla r : listaReg) {
			if(r.getCantEspecificaciones() == max) {
				reglas.add(r);
			}
		}
		return reglas;
	}
	
	public String toString() {
		return "Especificidad";
	}
}
