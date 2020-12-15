package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroPorEstadoTest {
	
	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	private Ifiltro filtro;
	private AplicacionWeb app;
	private List<Muestra> muestras;
	
	@BeforeEach
	public void setUp() {
		this.muestra = mock(Muestra.class);
		this.muestra2 = mock(Muestra.class);
		this.muestra3 = mock(Muestra.class);
		this.app = mock(AplicacionWeb.class);
		this.filtro = new FiltroEstadoDeMuestra(app,"Votada");
		this.muestras = new ArrayList<Muestra>();
	}
	
	@Test
	void testAplicoFiltroPorEstado() {
		when(muestra.tipoDeVerificacion()).thenReturn("Votada");
		when(muestra2.tipoDeVerificacion()).thenReturn("Votada");
		when(muestra3.tipoDeVerificacion()).thenReturn("Verificada");
		
		muestras.add(muestra);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		when(app.getMuestras()).thenReturn(muestras);
		
		
		
		assertEquals(2,filtro.filtrar().size());
	}

}
