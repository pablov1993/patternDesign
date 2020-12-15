package ar.edu.unq.po2.tpIntegrador;

public abstract class EstadoDeMuestra {
	
	protected Muestra muestra;
	protected String mensajeError;
	public EstadoDeMuestra(Muestra muestra) {
		
		this.muestra = muestra;
		this.mensajeError = "";
	}

	protected abstract String getEstado();
	
	protected abstract boolean getEsVerificable();
	
	protected abstract void verificarModificacionDeEstado(Voto voto);
	
	protected abstract void concretarVotacion(Voto voto);
	
	protected abstract boolean cumpleConNivel(Inivel nivel);
	
	public boolean noVotoAntes(Voto voto) {
		
		if(!this.muestra.noRegistraVotoDe(voto.getUsuario())){
			this.setMensajeError("Ya voto esta muestra");
		}
		return(this.muestra.noRegistraVotoDe(voto.getUsuario()));
	}
	
	public void setMensajeError(String mensaje) {
		this.mensajeError = mensaje;
	}
	

	public void agregarVoto(Voto voto) throws VotacionCerradaException{
		
		if(this.getEsVerificable() && this.noVotoAntes(voto) && this.cumpleConNivel(voto.getNivelUsuario())){
			this.verificarModificacionDeEstado(voto);			
			this.concretarVotacion(voto);		
		}else {
			throw new VotacionCerradaException(this.mensajeError);
		}
		
	}

}
