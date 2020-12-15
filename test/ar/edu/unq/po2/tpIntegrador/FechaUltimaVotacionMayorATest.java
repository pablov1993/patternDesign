package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FechaUltimaVotacionMayorATest {
	

	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	private List<Voto> votacion;
	private List<Voto> votacion2;
	private List<Voto> votacion3;
	
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Ifiltro filtro;
	private AplicacionWeb app;
	private List<Muestra> muestras;
	
	private LocalDate fecha;
	private LocalDate fecha2;
	private LocalDate fecha3;
	
	
	
	@BeforeEach
	public void setUp() {
		
		this.fecha = LocalDate.parse("15/05/2020",fmt);
		this.fecha2 = LocalDate.parse("14/05/2020",fmt);
		this.fecha3 = LocalDate.parse("16/05/2020",fmt);
		
		this.votacion = new ArrayList<Voto>();
		this.votacion2 = new ArrayList<Voto>();
		this.votacion3 = new ArrayList<Voto>();
		
		this.muestra = mock(Muestra.class);
		this.muestra2 = mock(Muestra.class);
		this.muestra3 = mock(Muestra.class);
		
		this.voto = mock(Voto.class);
		this.voto2 = mock(Voto.class);
		this.voto3 = mock(Voto.class);
		
						
						
		this.app = mock(AplicacionWeb.class);
		this.filtro = new FechaUltimaVotacionMayorA(app,fecha);
		this.muestras = new ArrayList<Muestra>();
	}
	
	
	
	@Test
	void testAplicoFechaUltimaVotacionIgual() {
		
		when(voto.getFecha()).thenReturn(fecha);
		when(voto2.getFecha()).thenReturn(fecha2);
		when(voto3.getFecha()).thenReturn(fecha3);
		
		when(app.getMuestras()).thenReturn(muestras);
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(muestra2.getVotacion()).thenReturn(votacion2);
		when(muestra3.getVotacion()).thenReturn(votacion3);
		
		votacion.add(voto);
		votacion2.add(voto2);
		votacion3.add(voto3);
		
		muestras.add(muestra);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		
		assertEquals(1,filtro.filtrar().size());
	}

}
	



