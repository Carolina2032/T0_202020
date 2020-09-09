package test.data_structures;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Nodo;

public class TestNodo {
	
	private Nodo<Integer> nodo;
	
	
	@Before
	public void setUp1(){
		nodo = new Nodo<Integer>() ;
	}
	
	
	@Before
	public void setUp2() {
		setUp1(); 
		nodo.setDato(0);
	}
	
	@Before
	public void setUp3() {
		setUp1(); 
		nodo.setSiguiente(new Nodo <Integer> (2));
	}
	
	@Before
	public void setUp4() {
		
		nodo = new Nodo<Integer>(0) ;
	}
		
	
	@Before
	public void setUp5() {
		
		nodo = new Nodo<Integer>(0, new Nodo <Integer> ()) ;
	}
	
	@Test 
	public void testNodo() {
		setUp1();
		assertTrue("El nodo no se inicializó correctamente", nodo != null );

		setUp4();
		assertTrue("El nodo no se inicializó correctamente", nodo != null );
		
		setUp5();
		assertTrue("El nodo no se inicializó correctamente", nodo != null );
	}
	
	@Test 
	public void testGetDato() {
		setUp2();
		assertTrue("El valor guardado debio ser 0", nodo.getDato()==0);
	}
	
	@Test
	public void testSetDato() {
		setUp2();
		nodo.setDato(1);
		assertTrue("El valor guardado debio ser 1", nodo.getDato()==1);
	}
	
	@Test 
	public void testGetSiguiente() {
		setUp1();
		assertTrue("El nodo siguiente debio ser nulo", nodo.getSiguiente()==null);
		setUp3();
		assertTrue("El nodo siguiente no debio ser nulo", nodo.getSiguiente()!=null);
	}
	
	@Test
	public void testSetSiguiente() {
		setUp3();
		nodo.setSiguiente(new Nodo <Integer>(0));
		assertTrue("El valor guardado del nodo siguiente debio ser 0", nodo.getSiguiente().getDato()==0);
	}
	
}
