package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.List;	

public class ZonaDeCobertura{

	private String nombre;
	private Ubicacion epicentro;
	private Double radio;
	private List<Muestra> muestrasReportadas;
	private List<Iorganizacion> organizaciones;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double radio) {
		
		this.setNombre(nombre);
		this.setEpicentro(epicentro);
		this.setRadio(radio);
		this.muestrasReportadas = new ArrayList<Muestra>();
		this.organizaciones = new ArrayList<Iorganizacion>();

}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}
	
	
	public Boolean muestraDentroDeEstaZona(Muestra muestra){
		
		return muestra.getUbicacion().distanciaCon(this.getEpicentro()) <= this.getRadio();
		
	}
	
	public Boolean seSolapaCon(ZonaDeCobertura zona) {
		
		return (this.getEpicentro().distanciaCon(zona.getEpicentro()) <= this.getRadio() ||
				this.getEpicentro().distanciaCon(zona.getEpicentro()) <= zona.getRadio()); 
		
	}

	
	public void registrarMuestra(Muestra muestra) {
		
		if(this.muestraDentroDeEstaZona(muestra)) {

			this.muestrasReportadas.add(muestra);
			this.notificarNuevaPublicacion(muestra);
		}
	}

	
	public void suscribir(Iorganizacion organizacion) {
		this.organizaciones.add(organizacion);
		
	}

	
	public void desuscribir(Iorganizacion organizacion) {
		// TODO Auto-generated method stub
		
	}

	
	public void notificarNuevaPublicacion(Muestra muestra) {

		for(Iorganizacion orga : organizaciones) {
			
			orga.registrarNuevaPublicacion(muestra, this);
		}
		
	}
	
	
	public void registrarNuevaVerificacion(Muestra muestra) {
		
		this.notificarNuevaVerificacion(muestra);
	}


	
	public void notificarNuevaVerificacion(Muestra muestra) {
		
		for(Iorganizacion orga : organizaciones) {
			
			orga.registrarNuevaVerificacion(muestra, this);
		}
		
	}


	
	
}
