package ar.edu.unq.po2.tpIntegrador;



public class EstadoVerificacionExpertos extends EstadoDeMuestra {
	
	private String estado;
	private boolean esVerificable;
	
	public EstadoVerificacionExpertos(Muestra muestra) {
		super(muestra);
		this.estado = "Votada";
		this.esVerificable = true;
		
	}

	@Override
	protected String getEstado() {
		
		return this.estado;
	}
	
	public boolean getEsVerificable() {
		return this.esVerificable;
	}


	@Override
	public void verificarModificacionDeEstado(Voto voto) {
		
		if(this.muestra.cantidadVotosDeTipo(voto.getTipo()) > 1) {
			
			this.muestra.setEstado(new EstadoVerificada(this.muestra));
			this.muestra.setCalculador(new CalculadorVerificado(voto));
		}
		
	}


	@Override
	protected void concretarVotacion(Voto voto) {
		
		this.muestra.agregarVoto(voto);
	}

	@Override
	protected boolean cumpleConNivel(Inivel nivel) {
		if(! nivel.isExperto()) {
			super.setMensajeError("No puede votar un basico");
		}
		return nivel.isExperto();
	}

}
