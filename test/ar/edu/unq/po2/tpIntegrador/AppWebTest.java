package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
class AppWebTest {
	
	private AplicacionWeb aplicacion;
	private Usuario usuario;
	private Muestra muestra;
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private ZonaDeCobertura zona;

	@BeforeEach
	public void setUp() {
		
		this.aplicacion = new AplicacionWeb();
		this.usuario = mock(Usuario.class);
		this.muestra = mock(Muestra.class);
		this.zona = mock(ZonaDeCobertura.class);

	}

	
	
	@Test
	void testRegistrarMuestra() {	
		
		
		aplicacion.registrarMuestra(muestra);
		assertEquals(aplicacion.cantidadDeMuestras(),1);		
	}
	
	@Test
	void testPidoMuestrasDeUnUsuario(){
		
		when(muestra.getUsuario()).thenReturn(usuario);
		when(usuario.esMismoUsuario(usuario)).thenReturn(true);
		aplicacion.registrarMuestra(muestra);
		
		assertTrue(aplicacion.muestrasPublicadasDe(usuario).size() == 1);
	}
	
	@Test
	void testPidoMuestrasVotadasPorUnUsuario() {
		
		when(muestra.registraVotoDeUsuario(usuario)).thenReturn(true);		
		aplicacion.registrarMuestra(muestra);
		assertTrue(aplicacion.muestrasVotadasPor(usuario).size() == 1);
		
	}
	
	@Test
	void testTrueSiLaFechaDeMuestraEstaDentroDeUnPlazo() {
		
		LocalDate fecha = LocalDate.parse("26/06/2020",fmt);
		when(muestra.getFecha()).thenReturn(fecha);
		
		assertTrue(aplicacion.dentroDePlazo(muestra, 30));
		assertFalse(aplicacion.dentroDePlazo(muestra, 3));
	}
	
	@Test
	void testAppRegistraZonaYLuegoAgregaMuestrasDentroDeElla() {
		
		aplicacion.registrarZona(zona);
		aplicacion.registrarMuestra(muestra);
		
		
		assertTrue(aplicacion.getZonas().size() == 1);
		verify(zona).registrarMuestra(muestra);
		verify(muestra).agregarZona(any(ZonaDeCobertura.class));	
	}	
	

}
