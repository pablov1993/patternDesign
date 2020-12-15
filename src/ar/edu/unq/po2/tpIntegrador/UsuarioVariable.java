package ar.edu.unq.po2.tpIntegrador;

public class UsuarioVariable extends Usuario {
	
	private Inivel nivel;
	private CalculadorDeNivel calculador;
	
	public UsuarioVariable(AplicacionWeb app, String username) {
		
		super(app,username);
		this.calculador = new CalculadorDeNivel();
		this.nivel = new Basico();
	}

	@Override
	public String getNivel() {
		this.setNivel(calculador.calcularNivelDe(this, super.app));
		return this.nivel.getNivel();
	}
	


	@Override
	protected void setNivel(Inivel nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public void verificarMuestra(Muestra muestra, Voto voto) throws VotacionCerradaException {
		this.nivel().verificarMuestraPara(muestra,voto);
	}

	@Override
	public void publicarMuestra(Muestra muestra) {
		this.nivel().publicarMuestraPara(this.getApp(),this, muestra);		
	}

	@Override
	protected Inivel nivel() {
		this.setNivel(calculador.calcularNivelDe(this, super.app));
		return this.nivel;		
	}

	@Override
	public void setCalculador(CalculadorDeNivel calculador) {
		this.calculador = calculador;
		
	}

	@Override
	protected boolean esMismoUsuario(Usuario usuario) {
		return this.username == usuario.getUsername();
	}
}
