package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

public class CalculadorDeNivel {
	
	public CalculadorDeNivel() {
		
	}

	public Inivel calcularNivelDe(Usuario usuario, AplicacionWeb app) {
		
		Inivel nivel = new Basico();
		
		if(this.cumpleConPublicaciones(usuario,app) && this.cumpleConVotos(usuario, app)) {
			nivel = new Experto();
		}
		return nivel;
		
	}
	
	public boolean cumpleConPublicaciones(Usuario usuario, AplicacionWeb app) {
		
		return app.muestrasPublicadasDe(usuario).stream()
												.filter(m -> this.dentroDePlazo(m,30))
												.collect(Collectors.toList())
												.size() >= 10;
	}
	
	
	
	public boolean cumpleConVotos(Usuario usuario, AplicacionWeb app) {
		
		return app.muestrasVotadasPor(usuario).stream()
												.filter(m -> this.dentroDePlazo(m, 30))
												.collect(Collectors.toList())
												.size() >= 20;
	}
	
	public boolean dentroDePlazo(Muestra muestra,Integer plazo) {
		
		return Period.between(muestra.getFecha(), LocalDate.now()).getDays() <= plazo;
	}
	

}
