package ar.edu.unq.po2.tpIntegrador;

public class CalculadorVerificado implements Icalculador {
	
	private Tipo tipo;
	public CalculadorVerificado(Voto voto) {
		
		this.tipo = voto.getTipo();
	}

	@Override
	public Tipo calcularTipo(Muestra muestra) {
	
		return this.tipo;
	}

	@Override
	public boolean hayEmpate(Muestra muestra, Integer score) {
		
		return false;
	}

}
