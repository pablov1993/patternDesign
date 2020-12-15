package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


public class Muestra {
	
	private Usuario usuario;
	private Ubicacion ubicacion;
	private String foto;
	private Tipo vinchuca;
	private EstadoDeMuestra estado;
	private List<Voto> votacion;
	private Icalculador calculador;
	private LocalDate fecha;
	private List<ZonaDeCobertura> zonas;

	public Muestra(Usuario usuario, Ubicacion ubicacion, String foto, Tipo vinchuca) {
		
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.foto = foto;
		this.vinchuca = vinchuca;
		this.estado = new EstadoVerificacionBasico(this);
		this.votacion = new ArrayList<Voto>();
		this.calculador = new CalculadorBasico();
		this.fecha = LocalDate.now();
		this.zonas = new ArrayList<ZonaDeCobertura>();
	
	}

	
	public String tipoDeVerificacion() {
		return this.getEstado().getEstado();
	}
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void registrarVerificacion(Voto voto) throws VotacionCerradaException {
			
			this.getEstado().agregarVoto(voto);	
	}
	

	public boolean esVerificable() {
		
		return this.estado.getEsVerificable();
	}

	public void setEstado(EstadoDeMuestra estado) {
		this.estado = estado;		
	}
	
	public EstadoDeMuestra getEstado() {
		return this.estado;
	}

	public List<Voto> getVotacion() {
		return this.votacion;
	}

	public Tipo getEspecie() {
		return this.calculador.calcularTipo(this);
	}
	

	public boolean noRegistraVotoDe(Usuario username) {
		
		return this.getVotosDe(username).isEmpty();
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}



	public void agregarVoto(Voto voto) {
		this.getVotacion().add(voto);
		this.notificarNuevaVerificacion(this);
	}

	
	
	public List<Voto> getVotosDe(Usuario usuario) {
	

		return  this.getVotacion()
									.stream()
									.filter(v -> v.mismoUsuario(usuario))
									.collect(Collectors.toList());
		}


	public Integer cantidadVotosDeTipo(Tipo tipo) {
		
		
		return this.getVotacion().stream()
										.filter(v -> esMismoTipo(v.getTipo(),tipo))
										.collect(Collectors.toList())
										.size();
	}
	
	public boolean esMismoTipo(Tipo tipo, Tipo tipo2) {
		
		return tipo.mismoTipo(tipo2);
	}



	public void setCalculador(Icalculador calculador) {
		this.calculador = calculador;
		
	}



	public boolean registraVotoDeUsuario(Usuario usuario) {
		
		return this.getVotacion().stream()
								.filter(v -> v.mismoUsuario(usuario))
								.collect(Collectors.toList())
								.size()>0 && noEsUsuarioCreador(usuario);
	}
	
	public boolean noEsUsuarioCreador(Usuario usuario) {
		
		return !usuario.esMismoUsuario(this.getUsuario());
	}

	
	public void agregarZona(ZonaDeCobertura zona) {
		
		this.zonas.add(zona);
		
	}


	
	public void notificarNuevaVerificacion(Muestra muestra) {
		
		for(ZonaDeCobertura zona : zonas) {
			zona.registrarNuevaVerificacion(muestra);
		}		
	}

	
	public void eliminarZona(ZonaDeCobertura suscriptor) {
		this.zonas.remove(suscriptor);		
	}


	public List<Voto> getVotosDeExpertos() {
		return  this.getVotacion()
				.stream()
				.filter(v -> v.esDeExperto())
				.collect(Collectors.toList());
	}



	
	
}
