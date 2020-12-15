package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorExpertoTest {
	
	private Icalculador calculadorExperto;
	private Muestra muestra;
	private Voto voto;
	private Voto otroVoto;
	private Usuario usuario;
	private Usuario otroUsuario;
	private Tipo tipo;
	private Tipo otroTipo;
	private ArrayList<Voto> votacion;

	
	@BeforeEach
	public void setUp(){
		
		this.usuario = mock(Usuario.class);
		this.otroUsuario = mock(Usuario.class);
		this.voto = mock(Voto.class);
		this.otroVoto = mock(Voto.class);
		this.tipo = mock(Tipo.class);
		this.otroTipo = mock(Tipo.class);
		this.muestra = mock(Muestra.class);
		this.votacion = new ArrayList<Voto>();
		this.calculadorExperto = new CalculadorExperto();
		
	}
	@Test
	void testPidoElTipoAunaMuestraConUnSoloVoto() {
		
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(voto.getUsuario()).thenReturn(usuario);
		votacion.add(voto);
		when(muestra.getVotosDeExpertos()).thenReturn(votacion);
		
		Tipo tipoEsperado = mock(Tipo.class);
		when(tipoEsperado.getTipo()).thenReturn("Sordida");

		assertEquals(tipoEsperado.getTipo() , calculadorExperto.calcularTipo(muestra).getTipo());
		
	}
	
	@Test
	void testPidoElTipoAunaMuestraConDistintosVotos() {
		
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(voto.getUsuario()).thenReturn(usuario);
		when(otroVoto.getTipo()).thenReturn(otroTipo);
		when(otroTipo.getTipo()).thenReturn("Chinche");
		when(otroVoto.getUsuario()).thenReturn(otroUsuario);
		votacion.add(voto);
		votacion.add(otroVoto);
		when(muestra.getVotosDeExpertos()).thenReturn(votacion);
		
		Tipo tipoEsperado = mock(Tipo.class);
		when(tipoEsperado.getTipo()).thenReturn("Indefinido");
		
		assertTrue(calculadorExperto.calcularTipo(muestra).mismoTipo(tipoEsperado));
		assertFalse(calculadorExperto.hayEmpate(muestra, 2));
	}

}
