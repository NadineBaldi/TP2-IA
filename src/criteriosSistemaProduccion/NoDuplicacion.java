package criteriosSistemaProduccion;

import java.util.ArrayList;
import java.util.List;

import reglas.Regla;

public class NoDuplicacion {
	
	public NoDuplicacion() {
	}
	
	public ArrayList<Regla> noDuplicacion(List<Regla> reglasActivas, List<Regla> reglasUsadas) {
		ArrayList<Regla> aux = new ArrayList<Regla>();
		boolean encontrado = false;
		
		if (!reglasUsadas.isEmpty()) {
			for (Regla ra : reglasActivas) {
				for (Regla ru : reglasUsadas) {
					if (ra.getId() == ru.getId()) {
						encontrado=true;
					}
				}
				if (!encontrado) {
					aux.add(ra);
				}
				encontrado=false;
			}
		} else {
			aux =(ArrayList<Regla>) reglasActivas;
		}
		
		return aux;
	}
	
	public String toString() {
		return "No duplicacion";
	}

}
