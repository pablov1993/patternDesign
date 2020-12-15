package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorDeNivelTest {
	
	private CalculadorDeNivel calculador;
	private Muestra muestra;
	private AplicacionWeb app;
	private Usuario usuarioBasico;
	private Usuario usuarioExperto;
	private List<Muestra> publicadas;
	private List<Muestra> votadas;
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuarioBasico = mock(Usuario.class);
		this.usuarioExperto = mock(Usuario.class);
		this.calculador = new CalculadorDeNivel();
		this.publicadas = new ArrayList<Muestra>();
		this.votadas  = new ArrayList<Muestra>();
		
	}

	@Test
	void testCalcularNivelDeUsuarioBasico() {
		
		when(muestra.getUsuario()).thenReturn(usuarioBasico);
		when(app.muestrasPublicadasDe(usuarioBasico)).thenReturn(publicadas);
		when(app.muestrasVotadasPor(usuarioBasico)).thenReturn(publicadas);
		when(muestra.getFecha()).thenReturn(LocalDate.now());
		
		this.publicadas.add(muestra);
		
		calculador.calcularNivelDe(usuarioBasico, app);
		
		assertFalse(calculador.calcularNivelDe(usuarioBasico, app).isExperto());
		
	}
	
	@Test
	void testCalcularNivelDeUsuarioExperto() {
		
		when(muestra.getUsuario()).thenReturn(usuarioBasico);
		when(app.muestrasPublicadasDe(usuarioBasico)).thenReturn(publicadas);
		when(app.muestrasVotadasPor(usuarioBasico)).thenReturn(publicadas);
		when(muestra.getFecha()).thenReturn(LocalDate.now());
		
		assertFalse(calculador.calcularNivelDe(usuarioBasico, app).isExperto());
		
		for(int i = 0; i<31;i++) {
			this.publicadas.add(muestra);
		}
		
		calculador.calcularNivelDe(usuarioBasico, app);
		
		assertTrue(calculador.calcularNivelDe(usuarioBasico, app).isExperto());
		
	}

}
