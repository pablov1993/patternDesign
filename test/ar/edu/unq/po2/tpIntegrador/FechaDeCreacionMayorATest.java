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

public class FechaDeCreacionMayorATest {
	

	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	
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
		
			
		this.muestra = mock(Muestra.class);
		this.muestra2 = mock(Muestra.class);
		this.muestra3 = mock(Muestra.class);
		
									
						
		this.app = mock(AplicacionWeb.class);
		this.filtro = new FechaDeCreacionMayorA(app,fecha);
		this.muestras = new ArrayList<Muestra>();
	}
		
	
	@Test
	void testAplicoFechaUltimaVotacionIgual() {
		
			
		when(app.getMuestras()).thenReturn(muestras);
		when(muestra.getFecha()).thenReturn(fecha);
		when(muestra2.getFecha()).thenReturn(fecha2);
		when(muestra3.getFecha()).thenReturn(fecha3);
		
				
		muestras.add(muestra);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		
		assertEquals(1,filtro.filtrar().size());
	}

}
	



