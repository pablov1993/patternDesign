package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class CalculadorBasico implements Icalculador {
	
	public CalculadorBasico() {
		
	}
	
	
	public Tipo calcularTipo(Muestra muestra) {
		
		int contador = 0;
		Tipo ganador = new Tipo("Vinchuca");
		List<Voto> votacion = muestra.getVotacion();  
		for(Voto voto : votacion) {
			if(muestra.cantidadVotosDeTipo(voto.getTipo()) > contador) {
				contador = muestra.cantidadVotosDeTipo(voto.getTipo());
				ganador = voto.getTipo();
			}
			
		}
		
		if(hayEmpate(muestra, contador)) {
			ganador = new Tipo("Indefinido");
		}
		
		return ganador;
		
	}

	public boolean hayEmpate(Muestra muestra, Integer contador) {
			
		return muestra.getVotacion().stream()
				.filter(v -> muestra.cantidadVotosDeTipo(v.getTipo()) == contador)
				.collect(Collectors.toList())
				.size()>1;
	}



}
