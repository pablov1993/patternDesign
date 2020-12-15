package ar.edu.unq.po2.tpIntegrador;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class MuestraTest {
	
	private Muestra muestra;
	private Usuario usuario;
	private Usuario usuario2;
	private Ubicacion ubicacion;
	private Tipo vinchuca;
	private Tipo chinche;
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	private EstadoDeMuestra verificada;
	private Icalculador calculador;
	private Inivel basico;
	private Inivel experto;
	private ZonaDeCobertura zona;
	
	@BeforeEach
	public void setUp() {		
		this.ubicacion = mock(Ubicacion.class);
		this.usuario = mock(UsuarioVariable.class);
		this.usuario2 = mock(UsuarioVariable.class);
		this.vinchuca = mock(Tipo.class);
		this.muestra = new Muestra(usuario,ubicacion,"foto",vinchuca);
		this.voto = mock(Voto.class);
		this.voto2 = mock(Voto.class);
		this.voto3 = mock(Voto.class);
		this.verificada = mock(EstadoVerificada.class);
		this.chinche = mock(Tipo.class);
		this.calculador = mock(Icalculador.class);
		this.basico = mock(Inivel.class);
		this.experto = mock(Inivel.class);
		this.zona = mock(ZonaDeCobertura.class);
		
	}
	
	@Test
	void testUnaMuestraSePublicaConUnaVotacion() {
		assertTrue(muestra.getVotacion().isEmpty());
	}
	
	@Test
	void testUnaMuestraSeIniciaConUnEstadoEnVerificacion() {
		assertEquals(muestra.esVerificable(), true);
	}
	
	@Test
	void testSeCierraLaVotacionDeUnaMuestra() {
		
		muestra.setEstado(verificada);
		
		when(verificada.getEsVerificable()).thenReturn(false);		
		
		assertEquals(muestra.esVerificable(),false);
	}
	
	@Test
	void testUsuarioVotaMuestra() throws VotacionCerradaException{
		
		muestra.setEstado(verificada);
		muestra.registrarVerificacion(voto);
		
		verify(verificada,times(1)).agregarVoto(voto);
	}
	

	
	@Test
	void testUsuarioQueGeneroMuestraNoPuedeVotar() throws VotacionCerradaException {
		
		when(basico.getNivel()).thenReturn("Basico");
		when(usuario2.getUsername()).thenReturn("ro");
		when(voto.getNivelUsuario()).thenReturn(basico);
		when(voto.getUsuario()).thenReturn(usuario2);
		
		when(voto.mismoUsuario(usuario2)).thenReturn(true);
		
		muestra.agregarVoto(voto);
		String mensajeEsperado = "Ya voto esta muestra";
		Exception exception = assertThrows(VotacionCerradaException.class,() -> muestra.registrarVerificacion(voto));
		
		assertEquals(mensajeEsperado,exception.getMessage());
	}
	
	@Test
	void testUnaMuestraDevuelveLosVotosDeUnUsuario() throws VotacionCerradaException {
	
		when(voto.mismoUsuario(usuario)).thenReturn(true);
		
		muestra.getVotacion().add(voto);
		
		
		assertEquals(1,muestra.getVotosDe(usuario).size());
		
	}
	
	@Test
	void testUnaMuestraDevuelveLosVotosDeNivelExperto() {
		
		when(voto.esDeExperto()).thenReturn(true);
		when(voto2.esDeExperto()).thenReturn(true);
		when(voto3.esDeExperto()).thenReturn(false);

		muestra.getVotacion().add(voto);
		muestra.getVotacion().add(voto2);
		muestra.getVotacion().add(voto3);	
		
		
		assertEquals(2, muestra.getVotosDeExpertos().size());
		
	}
	
	
	
	@Test 
	void testUnMuestraDevuelveCantidadDeVotosDeUnTipo(){
		
		when(voto.getTipo()).thenReturn(vinchuca);
		when(voto2.getTipo()).thenReturn(chinche);
		when(chinche.mismoTipo(vinchuca)).thenReturn(true);
		
		muestra.getVotacion().add(voto);
		muestra.getVotacion().add(voto2);
		
		assertEquals(1,muestra.cantidadVotosDeTipo(vinchuca));	
		
	}
	
	@Test
	void testPidoTipoALaMuestra() {
		
		
		muestra.setCalculador(calculador);
		muestra.getEspecie();
		verify(calculador,times(1)).calcularTipo(muestra);
		
	}
	
	@Test
	void testConsultoSiLaMuestraTieneVotosDeUnUsuario() {
		
		when(voto.getUsuario()).thenReturn(usuario2);
		when(usuario2.getUsername()).thenReturn("pablov");
		when(voto.mismoUsuario(usuario2)).thenReturn(true);
		
		
		muestra.getVotacion().add(voto);
		
		assertTrue(muestra.registraVotoDeUsuario(usuario2));
		
	}
	
	
	@Test
	void muestraAgregaSuscriptorYNotificaUnaVerificacionLuegoEliminaYNoNotifica() {
		
		muestra.agregarZona(zona);
		muestra.agregarVoto(voto);
		
		verify(zona).registrarNuevaVerificacion(muestra);
		
		muestra.eliminarZona(zona);
		verify(zona,times(0)).registrarMuestra(muestra);
		
	}



	
}
