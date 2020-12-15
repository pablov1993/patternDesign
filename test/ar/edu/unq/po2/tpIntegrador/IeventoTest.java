package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class IeventoTest {
	
	private Muestra muestra;
	private Muestra muestraVotada;
	private Usuario usuario;
	private ZonaDeCobertura zona;
	private Ubicacion ubicacion;
	private Tipo tipo;
	
	@BeforeEach
	public void setUp() {
	
	this.muestra = mock(Muestra.class);
	this.usuario = mock(Usuario.class);
	this.tipo = mock(Tipo.class);
	this.zona = mock(ZonaDeCobertura.class);
	this.ubicacion = mock(Ubicacion.class);
	this.muestra = new Muestra(usuario,ubicacion,"foto",tipo);
	}
	

	@Test
	void testSeNotificaAZonaUnaNuevaMuestra() {

		muestra.agregarZona(zona);
		muestra.notificarNuevaVerificacion(muestraVotada);
		verify(zona).registrarNuevaVerificacion(muestraVotada);
	}

}
