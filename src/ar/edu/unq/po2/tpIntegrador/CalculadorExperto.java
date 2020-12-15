package ar.edu.unq.po2.tpIntegrador;



public class CalculadorExperto implements Icalculador {

	@Override
	public Tipo calcularTipo(Muestra muestra) {
		
		Tipo tipo = new Tipo("Indefinido");
		if(muestra.getVotosDeExpertos().size() == 1) {
			tipo = muestra.getVotosDeExpertos().get(0).getTipo();
		}
		
		return tipo;
	}

	@Override
	public boolean hayEmpate(Muestra muestra, Integer score) {
		
		return false;
	}

}
