package ar.edu.unq.po2.tpIntegrador;

public class Basico implements Inivel {
	
	private String nivel;
	
	public Basico() {
		
		this.nivel = "Basico";
	}

	@Override
	public String getNivel() {
		
		return this.nivel;
	}

	@Override
	public void publicarMuestraPara(AplicacionWeb app, Usuario usuario, Muestra muestra) {
		
		muestra.getVotacion().add(new Voto(usuario,this,muestra.getEspecie()));
		app.registrarMuestra(muestra);		
		
	}

	@Override
	public void verificarMuestraPara(Muestra muestra, Voto voto) throws VotacionCerradaException {
		voto.setNivel(this);
		muestra.registrarVerificacion(voto);
		
	}

	@Override
	public void setEstadoMuestra(Muestra muestra) {
	}

	@Override
	public boolean isExperto() {
		
		return false;
	}

	@Override
	public boolean esDeMismoNivel(String nivel) {
		
		return this.nivel == nivel;
	}

}
