package criteriosSistemaProduccion;

import java.util.List;

import reglas.Regla;

public class Aleatorio {
	
	public Aleatorio() {
		
	}
	
	public Regla randomReglas(List<Regla> listaReg) {
		java.util.Random r = new java.util.Random(System.currentTimeMillis());
		int valor = r.nextInt(listaReg.size());
		return listaReg.get(valor);
	}
	
	public String toString() {
		return "Aleatorio";
	}

}
