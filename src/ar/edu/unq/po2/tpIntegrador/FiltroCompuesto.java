package ar.edu.unq.po2.tpIntegrador;

import java.util.List;

public abstract class FiltroCompuesto implements Ifiltro {

	private Ifiltro filtro1;
	private Ifiltro filtro2;

	
		
	public FiltroCompuesto(Ifiltro filtro1, Ifiltro filtro2) {
		
		this.setFiltro1(filtro1);
		this.setFiltro2(filtro2); 
	}



	public Ifiltro getFiltro1() {
		return filtro1;
	}



	public void setFiltro1(Ifiltro filtro1) {
		this.filtro1 = filtro1;
	}



	public Ifiltro getFiltro2() {
		return filtro2;
	}



	public void setFiltro2(Ifiltro filtro2) {
		this.filtro2 = filtro2;
	}


	public abstract List<Muestra> filtrar();

}
