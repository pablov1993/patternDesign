package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;


public class FechaDeCreacionIgualA extends FiltroSimplePorFecha {

	
public FechaDeCreacionIgualA(AplicacionWeb app, LocalDate fecha) {
		super(app, fecha);
		
	}


@Override
public Boolean criterioDeFiltro(Muestra m) {
	
	return m.getFecha().isEqual(this.getFecha());
	
}
	
}
