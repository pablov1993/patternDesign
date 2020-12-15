package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionesTest {
	
	private Organizacion organizacion;
	private IfuncionalidadExterna funcionalidadParaMuestra;
	private IfuncionalidadExterna funcionalidadParaVerificacion;
	private Ubicacion ubicacion;
	private Muestra muestra;
	private ZonaDeCobertura zona;
	
	
	@BeforeEach
	public void setUp() {
		
		this.zona = mock(ZonaDeCobertura.class);		
		this.funcionalidadParaMuestra = mock(IfuncionalidadExterna.class);
		this.funcionalidadParaVerificacion = mock(IfuncionalidadExterna.class);
		this.ubicacion = mock(Ubicacion.class);		
		this.organizacion = new Organizacion(ubicacion,"Salud",100,funcionalidadParaMuestra,funcionalidadParaVerificacion);
		this.muestra = mock(Muestra.class);
	}
	

	@Test
	void testOrganizacionRecibeNuevaMuestraYActivaFuncionalidadExterna() {

		organizacion.setFuncionalidadMuestra(funcionalidadParaMuestra);
		organizacion.registrarNuevaPublicacion(muestra, zona);
		
		verify(funcionalidadParaMuestra).nuevoEvento(organizacion,zona,muestra);
		
	}
	
	@Test
	void testOrganizacionRecibeNuevaVeroficacionYActivaFuncionalidadExterna() {
		
		organizacion.setFuncionalidadVerificacion(funcionalidadParaVerificacion);
		organizacion.registrarNuevaVerificacion(muestra, zona);
		
		verify(funcionalidadParaVerificacion).nuevoEvento(organizacion,zona,muestra);
		
	}

}
