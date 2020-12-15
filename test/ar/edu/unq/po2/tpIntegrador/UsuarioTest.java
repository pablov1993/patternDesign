package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

class UsuarioTest {
	
	private Usuario usuario;
	private AplicacionWeb app;
	private Muestra muestra;
	private Voto voto;
	private CalculadorDeNivel calculador;
	private EstadoDeMuestra estadoExpertos;
	private Inivel nivel;
	
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuario = new UsuarioVariable(app,"Pablov");
		this.voto = mock(Voto.class);
		this.nivel = mock(Inivel.class);
		this.calculador = mock(CalculadorDeNivel.class);
		this.estadoExpertos = mock(EstadoVerificacionExpertos.class);
	}
	
	
	@Test
	void testUsuarioBasicoPublicaMuestra() {	
		
		usuario.setCalculador(calculador);
		when(calculador.calcularNivelDe(usuario, app)).thenReturn(nivel);
		usuario.publicarMuestra(muestra);
		when(muestra.getUsuario()).thenReturn(usuario);
		verify(nivel).publicarMuestraPara(app,usuario,muestra);	
		
		Usuario usuarioEsperado = mock(Usuario.class);
		when(usuarioEsperado.getUsername()).thenReturn("Pablov");
		assertTrue(muestra.getUsuario().esMismoUsuario(usuarioEsperado));
	}
	
	
	
	
	@Test
	void testUsuarioBasicoVerificaMuestra() throws VotacionCerradaException {
		
		
		
		usuario.setCalculador(calculador);
		when(calculador.calcularNivelDe(usuario, app)).thenReturn(nivel);
		usuario.verificarMuestra(muestra,voto);
		when(voto.getUsuario()).thenReturn(usuario);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		verify(nivel).verificarMuestraPara(muestra, voto);

	}
	
	@Test
	void testUsuarioPideSuNivel() {
		
		usuario.setCalculador(calculador);
		when(calculador.calcularNivelDe(usuario, app)).thenReturn(nivel);
		when(nivel.getNivel()).thenReturn("Basico");
		
		assertFalse(usuario.nivel().isExperto());
		assertEquals("Basico",usuario.getNivel());
	}
}
