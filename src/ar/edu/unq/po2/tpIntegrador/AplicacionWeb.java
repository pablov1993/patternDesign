package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AplicacionWeb{
	
	
	private List<Muestra> muestras;
	private List<ZonaDeCobertura> zonas;
	
	public AplicacionWeb() {
		
		
		this.muestras = new ArrayList<Muestra>();
		this.zonas = new ArrayList<ZonaDeCobertura>();
	}
	
	public List<Muestra> getMuestras(){
		return this.muestras;
	}

	
	public void registrarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
		this.agregarMuestraEnZona(muestra);
	}

	public Integer cantidadDeMuestras() {
		return this.getMuestras().size();
	}

	public List<Muestra> muestrasPublicadasDe(Usuario usuario) {

		return  this.muestras.stream().filter(m -> muestraDeUsuario(m.getUsuario(),usuario)).collect(Collectors.toList());
	}

	public boolean muestraDeUsuario(Usuario usuario, Usuario usuario2) {
		
		return usuario.esMismoUsuario(usuario2);
	}

	public List<Muestra> muestrasVotadasPor(Usuario usuario) {
		
		return  this.muestras.stream()
				.filter(m -> m.registraVotoDeUsuario(usuario))
				.collect(Collectors.toList());
	}
	
	public boolean dentroDePlazo(Muestra muestra,Integer plazo) {
		
		return Period.between(muestra.getFecha(), LocalDate.now()).getDays() <= plazo;
	}

	

	public void registrarZona(ZonaDeCobertura zona) {
		
		this.zonas.add(zona);
		
	}

	public void agregarMuestraEnZona(Muestra muestra) {
		
		for(ZonaDeCobertura zona : zonas) {
			
				zona.registrarMuestra(muestra);
				muestra.agregarZona(zona);
		}
		
	}

	public List<ZonaDeCobertura> getZonas() {
		return this.zonas;
	}
	
	
	

}
