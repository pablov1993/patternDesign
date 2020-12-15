package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroTipoDeMuestra implements Ifiltro {
	
	private AplicacionWeb app;
	private String tipo;
	
	
	public FiltroTipoDeMuestra(AplicacionWeb app, String tipo) {
		
		this.setApp(app);
		this.setTipo(tipo);
	}

	public AplicacionWeb getApp() {
		return app;
	}

	public void setApp(AplicacionWeb app) {
		this.app = app;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Muestra> filtrar(){
		
		return app.getMuestras().stream()
				.filter(m -> m.getEspecie().getTipo() == this.getTipo())
				.collect(Collectors.toList());
	}

}
