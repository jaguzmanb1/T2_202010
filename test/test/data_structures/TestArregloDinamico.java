package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico<Integer> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico<Integer>(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		// TODO
		setUp1();
		assertTrue(arreglo != null);
		assertEquals(0, arreglo.darTamano());
	}

	@Test
	public void testDarElemento() {
		setUp2();
		assertEquals((Integer)25, arreglo.darElemento(25));
		// TODO
	}

}
