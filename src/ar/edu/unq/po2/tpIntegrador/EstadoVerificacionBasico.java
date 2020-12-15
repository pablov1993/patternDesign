package ar.edu.unq.po2.tpIntegrador;

public class EstadoVerificacionBasico extends EstadoDeMuestra {
	
	private boolean esVerificable;
	private String estado;
	
	public EstadoVerificacionBasico(Muestra muestra) {
		super(muestra);
		this.esVerificable = true;	
		this.estado = "Votada";
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public boolean getEsVerificable() {
		return this.esVerificable;
	}



	public void concretarVotacion(Voto voto) {
		
		this.muestra.agregarVoto(voto);
		
	}

	public void verificarModificacionDeEstado(Voto voto) {			
		
				voto.getNivelUsuario().setEstadoMuestra(this.muestra);

		}

	@Override
	protected boolean cumpleConNivel(Inivel nivel) {
		return true;
	}


}
