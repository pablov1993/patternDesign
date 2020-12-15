package ar.edu.unq.po2.tpIntegrador;

public interface Inivel {

	public String getNivel();

	public void publicarMuestraPara(AplicacionWeb app, Usuario usuario, Muestra muestra);

	public void verificarMuestraPara(Muestra muestra, Voto voto) throws VotacionCerradaException;

	public void setEstadoMuestra(Muestra muestra);

	public boolean isExperto();

	public boolean esDeMismoNivel(String nivel2);
}
