package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTest {
	
	private Ubicacion ubicacion;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private List<Ubicacion> ubicaciones;
	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	private List<Muestra> muestras;
	@BeforeEach
	public void setUp() {
		
		this.ubicacion2 = mock(Ubicacion.class);
		this.ubicacion3 = mock(Ubicacion.class);
		this.ubicacion = new Ubicacion(34.7d,58.28d);
		this.ubicaciones = new ArrayList<Ubicacion>();
		this.muestra = mock(Muestra.class);
		this.muestra2 = mock(Muestra.class);
		this.muestra3= mock(Muestra.class);
		this.muestras= new ArrayList<Muestra>();
		
	}

	@Test
	void testDistanciaEntreDosUbicaciones() {
		
		when(ubicacion2.getLatitud()).thenReturn(34.7d);
		when(ubicacion2.getLongitud()).thenReturn(58.28d);
		
		Double distancia = ubicacion.distanciaCon(ubicacion2);
		
		assertEquals(0,distancia);
	}
	
	@Test
	void testDevuelvoListaDeUbicacionesCercanasAmi() {
		
		when(ubicacion2.getLatitud()).thenReturn(34.6d);
		when(ubicacion2.getLongitud()).thenReturn(58.28d);
		when(ubicacion3.getLatitud()).thenReturn(20.7d);
		when(ubicacion3.getLongitud()).thenReturn(58.28d);
		this.ubicaciones.add(ubicacion2);
		this.ubicaciones.add(ubicacion3);
		
		assertEquals(1,ubicacion.listaDeUbicacionesCercanas(ubicaciones, 20d).size());
	}
	
	@Test
	void testDevuelvoMuestrasCercaDeUbicacion() {
		when(ubicacion2.getLatitud()).thenReturn(34.6d);
		when(ubicacion2.getLongitud()).thenReturn(58.28d);
		when(ubicacion3.getLatitud()).thenReturn(20.7d);
		when(ubicacion3.getLongitud()).thenReturn(58.28d);
		when(muestra.getUbicacion()).thenReturn(ubicacion);
		when(muestra2.getUbicacion()).thenReturn(ubicacion2);
		when(muestra3.getUbicacion()).thenReturn(ubicacion3);
		
		muestras.add(muestra);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		assertEquals(2,ubicacion.listaDeMuestrasCercanas(muestras, 20d).size());
	}

}
