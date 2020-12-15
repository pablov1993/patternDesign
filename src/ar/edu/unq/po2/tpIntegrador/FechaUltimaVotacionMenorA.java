package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class FechaUltimaVotacionMenorA extends FiltroSimplePorFecha {


public FechaUltimaVotacionMenorA(AplicacionWeb app, LocalDate fecha) {
		super(app, fecha);
		
	}


@Override
public Boolean criterioDeFiltro(Muestra m) {
	
	return m.getVotacion().get(m.getVotacion().size() -1).getFecha().isBefore(this.getFecha());
	
}
	
}
