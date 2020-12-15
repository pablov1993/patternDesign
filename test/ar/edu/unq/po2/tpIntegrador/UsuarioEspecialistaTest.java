package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class UsuarioEspecialistaTest {
	
	private Usuario usuario;
	private AplicacionWeb app;
	private Muestra muestra;
	private Voto voto;
	private Inivel nivel;
	
	
	
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuario = new UsuarioEspecialista(app,"pablov");
		this.voto = mock(Voto.class);		
	}
	
	
	@Test
	void testUsuarioBasicoPublicaMuestra() {	
		usuario.publicarMuestra(muestra);		
		when(muestra.getUsuario()).thenReturn(usuario);
		verify(app).registrarMuestra(muestra);	
		
		Usuario pablov = mock(Usuario.class);
		when(pablov.getUsername()).thenReturn("pablov");
		
		assertTrue(muestra.getUsuario().esMismoUsuario(pablov));
	}
	
	@Test
	void testUsuarioBasicoVerificaMuestra() throws VotacionCerradaException {
		
		usuario.verificarMuestra(muestra,voto);
		when(voto.getUsuario()).thenReturn(usuario);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		verify(voto).setNivel(usuario.nivel());
		verify(muestra).registrarVerificacion(voto);
	}
	
	@Test
	void testUsuarioPideSuNivel() {		
		
		assertTrue(usuario.nivel().isExperto());
	}
}
