package ar.edu.unq.po2.tpIntegrador;


import java.util.List;
import java.util.stream.Collectors;

public class FiltroEstadoDeMuestra implements Ifiltro {
	
	private String estado;
	private AplicacionWeb app;
	
public FiltroEstadoDeMuestra(AplicacionWeb app, String estado) {
		
		this.setApp(app);
		this.setEstado(estado);
	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public AplicacionWeb getApp() {
		return app;
	}

	public void setApp(AplicacionWeb app) {
		this.app = app;
	}

	
	
	public List<Muestra> filtrar(){
		
		return getApp().getMuestras().stream()
				.filter(m -> m.tipoDeVerificacion().equals(this.getEstado()))
				.collect(Collectors.toList());
	}

}
