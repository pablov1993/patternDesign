package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelBasicoTest {
	
	
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
		this.nivel = new Basico();
		this.voto = mock(Voto.class);
		
	}
	

	@Test
	void testSeSolicitaAlNivelPublicarMuestra() {
		
		nivel.publicarMuestraPara(app, usuarioBasico, muestra);
		verify(app).registrarMuestra(muestra);
	}
	
	@Test 
	void testSeSolicitaAlNivelVerificarMuestra() throws VotacionCerradaException{
		
		this.nivel.verificarMuestraPara(muestra, voto);
		when(voto.getNivelUsuario()).thenReturn(nivel);
		
		verify(voto).setNivel(nivel);
		verify(muestra).registrarVerificacion(voto);
		assertFalse(voto.getNivelUsuario().isExperto());
	}

}
