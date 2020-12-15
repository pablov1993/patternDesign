package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ZonaDeCoberturaTest {
	
	private ZonaDeCobertura zona;
	private Ubicacion epicentro;
	private Iorganizacion organizacion;
	private Muestra muestra;
	private ZonaDeCobertura otraZona;
	private Ubicacion otroEpicentro;
	
	@BeforeEach
	public void setUp() {		
		
		this.epicentro = mock(Ubicacion.class);
		this.zona = new ZonaDeCobertura("Zona A",epicentro,30d);
		this.otraZona = mock(ZonaDeCobertura.class);
		this.organizacion = mock(Iorganizacion.class);
		this.muestra = mock(Muestra.class);
		this.otroEpicentro = mock(Ubicacion.class);
		
	}
	

	@Test
	void testUnaZonaDeCoberturaA() {		
		assertTrue(zona.getNombre() == "Zona A");
	}
	
	@Test
	void testUbicacionEpicentroDeLaZona(){
		
		zona.getEpicentro().getLatitud();
		zona.getEpicentro().getLongitud();
		verify(epicentro).getLatitud();
		verify(epicentro).getLongitud();
	}
	
	@Test
	void testZonaDeCoberturaAvisaAOrganizacionDeNuevaMuestraPublicada() {
		
		this.zona.suscribir(organizacion);
		
		when(muestra.getUbicacion()).thenReturn(otroEpicentro);
		
		when(otroEpicentro.distanciaCon(epicentro)).thenReturn(10d);
		
		this.zona.registrarMuestra(muestra);
		
		verify(organizacion).registrarNuevaPublicacion(muestra,zona);
		
		
	}
	
	@Test
	void testZonaDeCoberturaRecibeEventoDeVerificacionYAvisaAOraganizaciones() {
		
		this.zona.suscribir(organizacion);
		zona.registrarNuevaVerificacion(muestra);
		verify(organizacion).registrarNuevaVerificacion(muestra,zona);
	}
	
	@Test
	void testMuestraSeEncuentraDentroDeZon() {
		
		when(muestra.getUbicacion()).thenReturn(epicentro);
		when(epicentro.distanciaCon(epicentro)).thenReturn(10d);
		
		assertTrue(zona.muestraDentroDeEstaZona(muestra));
		
	}
	
	@Test
	void testZonaSeSolapaConOtra() {
		
		
		when(otraZona.getEpicentro()).thenReturn(otroEpicentro);
		when(otraZona.getRadio()).thenReturn(30d);
		
		when(epicentro.distanciaCon(otroEpicentro)).thenReturn(20d);
		
		assertTrue(zona.seSolapaCon(otraZona));
	}
	
	@Test
	void testZonaNoSeSolapaConOtra() {
		
		
		when(otraZona.getEpicentro()).thenReturn(otroEpicentro);
		when(otraZona.getRadio()).thenReturn(30d);
		
		when(epicentro.distanciaCon(otroEpicentro)).thenReturn(31d);
		
		assertFalse(zona.seSolapaCon(otraZona));
	}

}
