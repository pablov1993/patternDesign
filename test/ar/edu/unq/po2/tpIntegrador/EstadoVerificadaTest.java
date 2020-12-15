package ar.edu.unq.po2.tpIntegrador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class EstadoVerificadaTest {
	
	private EstadoDeMuestra estado;
	private Muestra muestra;
	private Voto voto;
	private Usuario usuario;
	@BeforeEach
	public void setUp() {
		this.muestra = mock(Muestra.class);
		this.estado = new EstadoVerificada(muestra);
		this.voto = mock(Voto.class);
		this.usuario = mock(Usuario.class);
	}
	@Test
	void testMuestraYaNoPuedeVerificarse() throws VotacionCerradaException {
		
		
		when(muestra.noRegistraVotoDe(usuario)).thenReturn(true);
		String mensajeEsperado = "Votacion cerrada";
		Exception exception = assertThrows(VotacionCerradaException.class,() -> estado.agregarVoto(voto));
		
		assertEquals(mensajeEsperado,exception.getMessage());
	}

}
