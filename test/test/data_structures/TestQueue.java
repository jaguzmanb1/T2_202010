package test.data_structures;

import model.data_structures.Queue;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestQueue{

	private Queue<String> test;
	
	@Before
	public void setUp() {
		test = new Queue<String>();
		test.enqueue("Item1");
		test.enqueue("Item2");
		test.enqueue("Item3");
		test.enqueue("Item4");
		test.enqueue("Item5");
	}
	
	public void setUp2() {
		test.dequeue();
	}
	
	@Test
	public void testEnqueue() {
		
		setUp();
		assertEquals(5, test.size());
		assertEquals("Item1",test.darPrimerElemento().darElemento());
		assertEquals("Item5",test.darUltimoElemento().darElemento());
		setUp2();
		assertEquals(4, test.size());
		assertEquals("Item2",test.darPrimerElemento().darElemento());
		assertEquals("Item5",test.darUltimoElemento().darElemento());
	}

}