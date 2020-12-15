package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class TipoTest {
	
	
	private Tipo vinchuca;

	@BeforeEach
	public void setUp() {	
		
	this.vinchuca = new Tipo("Sordida");
		
		
	}
	
	
	@Test
	void test() {
		
		Tipo tipo = mock(Tipo.class);
		Tipo otroTipo = mock(Tipo.class);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(otroTipo.getTipo()).thenReturn("Imagen poco clara");
		
		assertTrue(vinchuca.mismoTipo(tipo));
		assertFalse(vinchuca.mismoTipo(otroTipo));
				
	}

}
