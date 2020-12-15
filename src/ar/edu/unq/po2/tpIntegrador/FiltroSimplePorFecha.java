package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FiltroSimplePorFecha extends FiltroSimple {

	private LocalDate fecha;
	private AplicacionWeb app;
	
public FiltroSimplePorFecha(AplicacionWeb app, LocalDate fecha) {
		
		this.setApp(app);
		this.setFecha(fecha);
	}
	
	public LocalDate getFecha() {
	
		return this.fecha;
		
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
		
	}
	
	public AplicacionWeb getApp() {
		return this.app;
	}

	public void setApp(AplicacionWeb app) {
		this.app = app;
	}
	
	public List<Muestra> getLista(){
		
		return this.getApp().getMuestras();
		
	}
	
	
	public abstract Boolean criterioDeFiltro(Muestra m);
	
	
	
public final List<Muestra> filtrar(){
	
	return this.getLista().stream().filter(m -> this.criterioDeFiltro(m))
			.collect(Collectors.toList());
	
	

	}

}
