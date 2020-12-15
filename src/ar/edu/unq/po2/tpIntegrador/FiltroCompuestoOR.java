package ar.edu.unq.po2.tpIntegrador;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FiltroCompuestoOR extends FiltroCompuesto implements Ifiltro {

	
	
		
	public FiltroCompuestoOR(Ifiltro filtro1, Ifiltro filtro2) {
		super(filtro1, filtro2);
		
	}



	public List<Muestra> filtrar() {
		
				
		Set<Muestra> set = new HashSet<Muestra>(this.getFiltro1().filtrar());
		
		set.addAll(this.getFiltro2().filtrar());
		
		List<Muestra> listaResultado = new ArrayList<Muestra>(set);
		
		return listaResultado;
	}
}





