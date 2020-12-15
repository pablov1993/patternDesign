package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FiltroOrTest {

private Muestra muestra;
private Muestra muestra2;
private Muestra muestra3;
private Muestra muestra4;
private Muestra muestra5;
private Muestra muestra6;
private Ifiltro filtro1;
private Ifiltro filtro2;
private Ifiltro filtroOR;

private List<Muestra> subListaDeMuestras1;
private List<Muestra> subListaDeMuestras2;

@BeforeEach
public void setUp() {
	this.muestra = mock(Muestra.class);
	this.muestra2 = mock(Muestra.class);
	this.muestra3 = mock(Muestra.class);
	this.muestra4 = mock(Muestra.class);
	this.muestra5 = mock(Muestra.class);
	this.muestra6 = mock(Muestra.class);
	this.filtroOR = mock(Ifiltro.class);
	this.filtro1 = mock(Ifiltro.class);
	this.filtro2 = mock(Ifiltro.class);
	
	
	
	filtroOR = new FiltroCompuestoOR(filtro1 ,filtro2);
	this.subListaDeMuestras1 = new ArrayList<Muestra>();
	this.subListaDeMuestras2 = new ArrayList<Muestra>();
	
}

@Test
void testAplicoFiltroORConVariosEnComún() {
	
	subListaDeMuestras1.add(muestra);
	subListaDeMuestras1.add(muestra2);
	subListaDeMuestras1.add(muestra3);
	subListaDeMuestras1.add(muestra6);
	
	subListaDeMuestras2.add(muestra);
	subListaDeMuestras2.add(muestra4);
	subListaDeMuestras2.add(muestra5);
	subListaDeMuestras2.add(muestra6);
	
	
	when(filtro1.filtrar()).thenReturn(subListaDeMuestras1);
	when(filtro2.filtrar()).thenReturn(subListaDeMuestras2);
		
	assertEquals(6,filtroOR.filtrar().size());

	
}
@Test
void testAplicoFiltroORSinElementosEnComún() {
	
	subListaDeMuestras1.add(muestra);
	subListaDeMuestras1.add(muestra2);
	subListaDeMuestras1.add(muestra3);
	subListaDeMuestras1.add(muestra6);
	
	
	subListaDeMuestras2.add(muestra4);
	subListaDeMuestras2.add(muestra5);
	
	
	
	when(filtro1.filtrar()).thenReturn(subListaDeMuestras1);
	when(filtro2.filtrar()).thenReturn(subListaDeMuestras2);
		
	assertEquals(6,filtroOR.filtrar().size());
	
}

@Test
void testAplicoFiltroORConListasVacías() {
	
		
	when(filtro1.filtrar()).thenReturn(subListaDeMuestras1);
	when(filtro2.filtrar()).thenReturn(subListaDeMuestras2);
		
	assertEquals(0,filtroOR.filtrar().size());
	
}

@Test
void testAplicoFiltroORSoloConElementosEnComún() {
	
	subListaDeMuestras1.add(muestra);
	subListaDeMuestras2.add(muestra);
	
	when(filtro1.filtrar()).thenReturn(subListaDeMuestras1);
	when(filtro2.filtrar()).thenReturn(subListaDeMuestras2);
		
	assertEquals(1,filtroOR.filtrar().size());
	
}


}

