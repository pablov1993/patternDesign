package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class Ubicacion {

	private Double latitud; 
	private Double longitud; 
	
	public Ubicacion(Double latitud, Double longitud) {
		
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}
	
	
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	
	public Double distanciaCon(Ubicacion ubi) {		
				
		Double radioTierra = 6371d; 
		Double distanciaLatitudes = Math.toRadians(this.getLatitud() - ubi.getLatitud());  
		Double distanciaLongitudes = Math.toRadians(this.getLongitud() - ubi.getLongitud());  
		Double senoDistanciaLatitudes = Math.sin(distanciaLatitudes / 2);  
		Double senoDistanciaLongitudes = Math.sin(distanciaLongitudes / 2);  
		Double va1 = Math.pow(senoDistanciaLatitudes, 2) + Math.pow(senoDistanciaLongitudes, 2)  
                * Math.cos(Math.toRadians(ubi.getLatitud())) * Math.cos(Math.toRadians(this.getLatitud()));  
		Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		Double distancia = radioTierra * va2;  
   
        return distancia;  
    }  
		
	
	
	public List<Ubicacion> listaDeUbicacionesCercanas(List<Ubicacion> ubicaciones, Double distancia){
		
		return  ubicaciones.stream()
				.filter(u -> this.distanciaCon(u) <= distancia)
				.collect(Collectors.toList());
	}
	
	
	
	
	public List<Muestra> listaDeMuestrasCercanas(List<Muestra> muestras, Double distancia){
		
		return  muestras.stream()
				.filter(m -> this.distanciaCon(m.getUbicacion())<= distancia)
						.collect(Collectors.toList());
	
	}
	
}









