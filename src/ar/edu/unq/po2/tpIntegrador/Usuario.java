package ar.edu.unq.po2.tpIntegrador;

public abstract class Usuario {
	
	protected AplicacionWeb app;
	protected String username;
	
	
	public Usuario(AplicacionWeb app, String username) {
		this.app = app;
		this.username = username;
	}
	public abstract void publicarMuestra(Muestra muestra);
	protected abstract String getNivel();
	protected abstract Inivel nivel();
	
	public String getUsername() {
		return this.username;
	}
	public AplicacionWeb getApp() {
		return this.app;
	}
	protected abstract void verificarMuestra(Muestra muestra, Voto voto) throws VotacionCerradaException;
	protected abstract void setNivel(Inivel nivel);
	protected abstract void setCalculador(CalculadorDeNivel calculador);
	protected abstract boolean esMismoUsuario(Usuario usuario);

}
