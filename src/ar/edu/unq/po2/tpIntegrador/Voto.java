package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Voto {
	
	private Usuario usuario;
	private Tipo votable;
	private Inivel nivelUsuario;
	private LocalDate fechaVoto;


	public Voto(Usuario usuario, Inivel nivel, Tipo votable) {
		
		this.usuario = usuario;
		this.nivelUsuario = nivel;
		this.votable = votable;
		this.fechaVoto = LocalDate.now();
		
	}


	public Inivel getNivelUsuario() {
		
		return this.nivelUsuario;
	}


	public Tipo getTipo() {
		return this.votable;		
	}


	public Usuario getUsuario() {
		
		return this.usuario;
	}
	
	public void setNivel(Inivel nivel) {
		this.nivelUsuario = nivel;
	}
	
	public LocalDate getFecha(){
		
		return this.fechaVoto;
	}


	public boolean mismoUsuario(Usuario otroUsuario) {
		
		return this.usuario.esMismoUsuario(otroUsuario);
	}


	public boolean esDeExperto() {
		
		return this.getNivelUsuario().isExperto();
	}

}
