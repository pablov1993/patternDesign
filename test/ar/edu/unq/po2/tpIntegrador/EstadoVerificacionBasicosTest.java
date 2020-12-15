package ar.edu.unq.po2.tpIntegrador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EstadoVerificacionBasicosTest {
	
	private Muestra muestra;
	private Usuario basico;
	private Voto voto;
	private EstadoDeMuestra estado;
	private Usuario experto;
	private Inivel nivelBasico;

	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.basico = mock(UsuarioVariable.class);
		this.voto = mock(Voto.class);
		this.estado = new EstadoVerificacionBasico(muestra);
		this.experto = mock(UsuarioVariable.class);
		this.nivelBasico = mock(Inivel.class);
	}
	
	@Test
	void testMuestraTieneUnEstadoVerificable() {
		assertTrue(estado.getEsVerificable());
	}
	@Test
	void testMuestraRegistraVotoDeUsuarioBasico() throws VotacionCerradaException {	
				
		when(nivelBasico.getNivel()).thenReturn("Basico");
		when(muestra.noRegistraVotoDe(basico)).thenReturn(true);
		when(voto.getUsuario()).thenReturn(basico);
		when(voto.getNivelUsuario()).thenReturn(nivelBasico);
		estado.agregarVoto(voto);
		
		
		verify(muestra).agregarVoto(voto);
	}
	
	@Test
	void testMuestraNoRegistraVotoDeUsuarioBasicoQueYaVoto() throws VotacionCerradaException {
		
		
		
		when(nivelBasico.getNivel()).thenReturn("Experto");
		when(muestra.noRegistraVotoDe(basico)).thenReturn(false);
		when(voto.getUsuario()).thenReturn(basico);
		
		String mensajeEsperado = "Ya voto esta muestra";
		Exception exception = assertThrows(VotacionCerradaException.class,() -> estado.agregarVoto(voto));
		
		assertEquals(mensajeEsperado,exception.getMessage());
	}
	
	@Test
	void testUnUsuarioExpertoVotaPorPrimeraVezUnaMuestraEnVerificacionBasica() throws VotacionCerradaException {
		
		
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getNivelUsuario()).thenReturn(nivelBasico);
		when(nivelBasico.isExperto()).thenReturn(true);
		estado.agregarVoto(voto);		
		
		verify(nivelBasico).setEstadoMuestra(muestra);
		verify(muestra, times(1)).agregarVoto(voto);
		
	}


}
