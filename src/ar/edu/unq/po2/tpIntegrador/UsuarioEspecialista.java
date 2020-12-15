package ar.edu.unq.po2.tpIntegrador;

public class UsuarioEspecialista extends Usuario {
	
	private Inivel nivel;
	
	public UsuarioEspecialista(AplicacionWeb app, String username) {
		
		super(app,username);
		this.nivel = new Experto();
	}

	@Override
	public String getNivel() {
		return this.nivel.getNivel();
	}
	
	public Inivel nivel() {
		return this.nivel;
	}

	@Override
	public void verificarMuestra(Muestra muestra, Voto voto) throws VotacionCerradaException {
		this.nivel.verificarMuestraPara(muestra,voto);
	}

	@Override
	protected void setNivel(Inivel nivel) {
	}

	@Override
	public void publicarMuestra(Muestra muestra) {
		this.nivel.publicarMuestraPara(this.getApp(),this, muestra);		
	}

	@Override
	protected void setCalculador(CalculadorDeNivel calculador) {
		
		
	}

	@Override
	protected boolean esMismoUsuario(Usuario usuario) {
		
		return this.username == usuario.getUsername();
	}
}
