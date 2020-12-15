package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class VotoTest {
	
	private Voto voto;
	private Muestra muestra;
	private AplicacionWeb appWeb;
	private Usuario usuario;
	private Tipo sordida;
	private EstadoDeMuestra verificada;
	private Inivel nivel;
	
	@BeforeEach
	public void setUp() {
		
		this.usuario = mock(UsuarioVariable.class);
		when(usuario.getNivel()).thenReturn("Basico");		
		this.sordida = mock(Tipo.class);
		when(sordida.getTipo()).thenReturn("Sordida");
		this.nivel = mock(Inivel.class);
		this.voto = new Voto(usuario,nivel, sordida);		
		
	}
	@Test
	void testSolicitoElNivelDelUsuarioQueVotoYRegistroEnVoto() {
		
		voto.setNivel(nivel);
		when(nivel.getNivel()).thenReturn("Basico");
		assertEquals(voto.getNivelUsuario().getNivel(),"Basico");
	
	}
	
	@Test
	void testPidoElUsuarioAlVoto() {
		
		assertEquals(usuario, voto.getUsuario());		
	}
	
	@Test
	void testSolicitoElTipoDetalladoEnLaVotacion() {
	
		voto.getTipo().getTipo();
		verify(sordida).getTipo();
	}
	
	@Test
	void testVotoTieneMismoUsuarioYesExperto() {
		
		
		Usuario usuarioEsperado = mock(Usuario.class);
		when(usuario.esMismoUsuario(usuarioEsperado)).thenReturn(true);
		when(nivel.isExperto()).thenReturn(true);
		
		
		assertTrue(voto.mismoUsuario(usuarioEsperado) && voto.esDeExperto());
	}

}
