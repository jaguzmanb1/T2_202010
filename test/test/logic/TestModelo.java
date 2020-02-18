package test.logic;

import static org.junit.Assert.*;
import model.logic.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() {
		modelo= new Modelo();
	}

	public void setUp2() {
		modelo.cargarDatos();;

	}

	@Test
	public void testModelo() {
		setUp1();
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darCantidadQueue());  // Modelo con 0 elementos presentes.
		assertEquals(0, modelo.darCantidadStack());  // Modelo con 0 elementos presentes.

	}

}


