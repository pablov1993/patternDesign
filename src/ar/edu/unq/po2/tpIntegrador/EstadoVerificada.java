package ar.edu.unq.po2.tpIntegrador;

public class EstadoVerificada extends EstadoDeMuestra {
	
	private Boolean esVerificable;
	private String estado;
	
	
	public EstadoVerificada(Muestra muestra) {
		super(muestra);
		this.esVerificable = false;
		this.estado = "Verificada";
	}

	@Override
	protected String getEstado() {
		return this.estado;
	}
	
	public boolean getEsVerificable() {
		
		this.setMensajeError("Votacion cerrada");
		return this.esVerificable;
	}



	@Override
	public void verificarModificacionDeEstado(Voto voto) {
		
		
	}



	@Override
	protected void concretarVotacion(Voto voto) {
		
		
	}

	@Override
	protected boolean cumpleConNivel(Inivel nivel) {
		
		return false;
	}
	
	
	


}
