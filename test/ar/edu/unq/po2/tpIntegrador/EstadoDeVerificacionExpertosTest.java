package ar.edu.unq.po2.tpIntegrador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeVerificacionExpertosTest {
	
	private EstadoVerificacionExpertos estado;
	private Usuario experto;
	private Usuario otroExperto;
	private Muestra muestra;
	private Voto voto;
	private Voto otroVoto;
	private Tipo tipo;
	private Inivel nivel;
	private List<Voto> votos;
	
	
	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.experto = mock(UsuarioVariable.class);
		when(experto.getNivel()).thenReturn("Experto");
		this.otroExperto = mock(UsuarioVariable.class);
		when(otroExperto.getNivel()).thenReturn("Experto");
		this.voto = mock(Voto.class);
		this.otroVoto = mock(Voto.class);
		this.tipo = mock(Tipo.class);
		this.estado = new EstadoVerificacionExpertos(this.muestra);
		this.votos = new ArrayList<Voto>();
		this.nivel = mock(Inivel.class);
	}
	
	
	@Test
	void testMuestraTieneEstadoVerificable() {
		assertTrue(estado.getEsVerificable());
	}
	
	@Test
	void testVerificadorRegistraVotoDeUsuarioExperto() throws VotacionCerradaException {
		
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(nivel.isExperto()).thenReturn(true);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		estado.agregarVoto(voto);
		
		verify(muestra).agregarVoto(voto);
		verify(muestra, times(0)).setEstado(any(EstadoDeMuestra.class));
	}
	
	
	@Test
	void testVerificadorNoRegistraVotoDeUsuarioBasico() throws VotacionCerradaException {
		
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(nivel.isExperto()).thenReturn(false);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		
		
		String mensajeEsperado = "No puede votar un basico";
		Exception exception = assertThrows(VotacionCerradaException.class,() -> estado.agregarVoto(voto));
		
		assertEquals(mensajeEsperado,exception.getMessage());
	}
	
	@Test
	void hayCoincidenciaEntreExpertos() {
		
		when(nivel.getNivel()).thenReturn("Experto");
		when(voto.getNivelUsuario()).thenReturn(nivel);
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(otroVoto.getNivelUsuario()).thenReturn(nivel);
		when(otroVoto.getTipo()).thenReturn(tipo);
		when(otroVoto.getUsuario()).thenReturn(otroExperto);
		when(muestra.noRegistraVotoDe(otroExperto)).thenReturn(true);
		votos.add(voto);
		votos.add(otroVoto);
		
		when(muestra.getVotacion()).thenReturn(votos);
		when(muestra.cantidadVotosDeTipo(tipo)).thenReturn(2);
		
		estado.verificarModificacionDeEstado(otroVoto);
		
		
		verify(muestra,times(1)).setEstado(any(EstadoDeMuestra.class));
		verify(muestra,times(1)).setCalculador(any(Icalculador.class));
		
	}
	
	
	

}
