package ar.edu.unq.po2.tpIntegrador;

public class Tipo {

	private String especie;
	public Tipo(String tipo) {
		
		this.especie = tipo;
	}
	

	public String getTipo() {
		return this.especie;
	}


	public boolean mismoTipo(Tipo tipo) {
		
		return this.getTipo() == tipo.getTipo();
	}
}
