package ar.edu.unq.po2.tpIntegrador;

public class Experto implements Inivel {
	
	private String nivel;
	
	public Experto() {
		
		this.nivel = "Experto";
		
	}

	@Override
	public String getNivel() {
		
		return this.nivel;
	}

	@Override
	public void publicarMuestraPara(AplicacionWeb app, Usuario usuario, Muestra muestra) {
		
		muestra.getVotacion().add(new Voto(usuario,this,muestra.getEspecie()));
		app.registrarMuestra(muestra);	
		muestra.setEstado(new EstadoVerificacionExpertos(muestra));
		
	}

	@Override
	public void verificarMuestraPara(Muestra muestra, Voto voto) throws VotacionCerradaException {
		
		voto.setNivel(this);
		muestra.registrarVerificacion(voto);
	}

	@Override
	public void setEstadoMuestra(Muestra muestra) {
		muestra.setEstado(new EstadoVerificacionExpertos(muestra));
		muestra.setCalculador(new CalculadorExperto());
	}

	@Override
	public boolean isExperto() {
		
		return true;
	}

	@Override
	public boolean esDeMismoNivel(String nivel) {
		return this.nivel == nivel;
	}

}
