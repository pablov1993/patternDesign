package ar.edu.unq.po2.tpIntegrador;


import java.util.List;
import java.util.stream.Collectors;

public class FiltroCompuestoAND extends FiltroCompuesto implements Ifiltro {

		
		
	public FiltroCompuestoAND(Ifiltro filtro1, Ifiltro filtro2) {
		super(filtro1, filtro2);
			
	}


	public List<Muestra> filtrar() {
		
		
	return this.getFiltro1().filtrar().stream()
				.filter(this.getFiltro2().filtrar()::contains)
				.collect(Collectors.toList());
			
}
}




