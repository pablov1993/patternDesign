package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;


public class FechaDeCreacionMayorA extends FiltroSimplePorFecha {

	
public FechaDeCreacionMayorA(AplicacionWeb app, LocalDate fecha) {
		super(app, fecha);
		
	}


@Override
public Boolean criterioDeFiltro(Muestra m) {
	
	return m.getFecha().isAfter(this.getFecha());
	
}
	
}
