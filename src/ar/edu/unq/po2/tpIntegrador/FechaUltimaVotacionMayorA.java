package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;


public class FechaUltimaVotacionMayorA extends FiltroSimplePorFecha {

	
public FechaUltimaVotacionMayorA(AplicacionWeb app, LocalDate fecha) {
		super(app, fecha);
		
	}


@Override
public Boolean criterioDeFiltro(Muestra m) {
	
	return m.getVotacion().get(m.getVotacion().size() -1).getFecha().isAfter(this.getFecha());
	
}
	
}