package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelExpertoTest {
	
	
	private AplicacionWeb app;
	private Usuario usuarioBasico;
	private Muestra muestra;
	private Inivel nivel;
	private Voto voto;
	
	
	@BeforeEach
	public void setUp() {		
		
		this.app = mock(AplicacionWeb.class);
		this.usuarioBasico = mock(Usuario.class);		
		this.muestra = mock(Muestra.class);
		this.nivel = new Experto();
		this.voto = mock(Voto.class);
		
	}
	

	@Test
	void testSeSolicitaAlNivelPublicarMuestra() {
		
		nivel.publicarMuestraPara(app, usuarioBasico, muestra);
		verify(app).registrarMuestra(muestra);
	}
	
	@Test 
	void testSeSolicitaAlNivelVerificarMuestraYModificoEstadoDeMuestra() throws VotacionCerradaException{
		
		this.nivel.verificarMuestraPara(muestra, voto);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		
		verify(voto).setNivel(nivel);
		verify(muestra).registrarVerificacion(voto);
		
		assertTrue(voto.getNivelUsuario().isExperto());
		
		nivel.setEstadoMuestra(muestra);
		verify(muestra).setEstado(any(EstadoDeMuestra.class));
		verify(muestra).setCalculador(any(Icalculador.class));
		
	}

}
