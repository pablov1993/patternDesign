package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorBasicoTest {
	
	private Muestra muestra;
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	private Tipo sordida;
	private Tipo chinche;
	private Tipo otraSordida;
	private CalculadorBasico verificador;
	private ArrayList<Voto> votacion;
	
	
	
	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.verificador = new CalculadorBasico();
		this.votacion = new ArrayList<Voto>();
		this.voto = mock(Voto.class);
		this.voto2 = mock(Voto.class);
		this.voto3= mock(Voto.class);
		this.sordida = mock(Tipo.class);
		this.chinche = mock(Tipo.class);
		this.otraSordida = mock(Tipo.class);
		
		
		
	}
	
	@Test
	void testVerificacionTipoDeMuestraSordida() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		this.votacion.add(voto3);
		
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(otraSordida.getTipo()).thenReturn("Sordida");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		when(voto3.getTipo()).thenReturn(otraSordida);
		when(muestra.cantidadVotosDeTipo(sordida)).thenReturn(2);
		when(muestra.cantidadVotosDeTipo(chinche)).thenReturn(1);
		
		assertEquals("Sordida",	verificador.calcularTipo(muestra).getTipo());
		
		
	}
	
	@Test
	void testVerificacionDeUnEmpateEnLaVotacion() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		
		
		assertEquals("Indefinido",	verificador.calcularTipo(muestra).getTipo());
		
	}
	
	@Test
	void testVerificacionDeUnEmpateEnLaVotacion2() {
	
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(otraSordida.getTipo()).thenReturn("Sordida");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		when(voto3.getTipo()).thenReturn(otraSordida);
		when(muestra.cantidadVotosDeTipo(sordida)).thenReturn(3);
		when(muestra.cantidadVotosDeTipo(chinche)).thenReturn(1);
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		this.votacion.add(voto3);
		
		assertEquals(sordida.getTipo(),verificador.calcularTipo(muestra).getTipo());
		
	}
	
	@Test 
	void testHayEmpate() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		when(muestra.cantidadVotosDeTipo(sordida)).thenReturn(1);
		when(muestra.cantidadVotosDeTipo(chinche)).thenReturn(1);
		
		
		assertTrue(verificador.hayEmpate(muestra, 1));
		
	}
}
