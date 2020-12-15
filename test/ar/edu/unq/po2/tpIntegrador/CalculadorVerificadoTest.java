package ar.edu.unq.po2.tpIntegrador;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorVerificadoTest {
	
	private Icalculador calculador;
	private Muestra muestra;
	private Voto voto;
	private Tipo tipo;
	
	@BeforeEach
	public void setUp() {
		
		this.voto = mock(Voto.class);
		this.tipo = mock(Tipo.class);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(voto.getTipo()).thenReturn(tipo);
		this.calculador = new CalculadorVerificado(voto);
		
	}

	@Test
	void testMuestraVerificadaDevuelveSuTipo() {
		
		assertEquals("Sordida" , calculador.calcularTipo(muestra).getTipo() );
		assertFalse(calculador.hayEmpate(muestra, 2));
	}

}
