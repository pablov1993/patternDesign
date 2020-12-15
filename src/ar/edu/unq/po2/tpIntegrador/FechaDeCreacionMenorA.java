package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;


public class FechaDeCreacionMenorA extends FiltroSimplePorFecha {

	
public FechaDeCreacionMenorA(AplicacionWeb app, LocalDate fecha) {
		super(app, fecha);
		
	}


@Override
public Boolean criterioDeFiltro(Muestra m) {
	
	return m.getFecha().isBefore(this.getFecha());
	
}
	
}
