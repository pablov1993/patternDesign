package ar.edu.unq.po2.tpIntegrador;


import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;


public class FiltroTipoDeMuestraTest {
	
	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	private Ifiltro filtro;
	private AplicacionWeb app;
	private List<Muestra> muestras;
	private Tipo vinchuca;
	private Tipo chinche;
	
	
	@BeforeEach
	public void setUp() {
		this.vinchuca = mock(Tipo.class);
		this.chinche = mock(Tipo.class);
		this.muestra = mock(Muestra.class);
		this.muestra2 = mock(Muestra.class);
		this.muestra3 = mock(Muestra.class);
		this.app = mock(AplicacionWeb.class);
		this.filtro = new FiltroTipoDeMuestra(app,"Vinchuca");
		this.muestras = new ArrayList<Muestra>();
	}
	
	@Test
	void testAplicoFiltroPorTipoDeMuestra() {
		when(muestra.getEspecie()).thenReturn(vinchuca);
		when(muestra2.getEspecie()).thenReturn(vinchuca);
		when(muestra3.getEspecie()).thenReturn(chinche);
		
		when(vinchuca.getTipo()).thenReturn("Vinchuca");
		when(chinche.getTipo()).thenReturn("Chinche");
		
		muestras.add(muestra);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		
		when(app.getMuestras()).thenReturn(muestras);
		
				
		assertEquals(2,filtro.filtrar().size());
		
	}

}
