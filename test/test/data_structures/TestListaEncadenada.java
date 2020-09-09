package test.data_structures;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ListaEncadenada;

public class TestListaEncadenada {
	private ListaEncadenada <Integer> listaEncadenada;
	
	
	@Before
	public void setUp1() {
		listaEncadenada= new ListaEncadenada <Integer>();
	}

	
	@Before
	public void setUp2() {
		listaEncadenada= new ListaEncadenada <Integer>();
		for(int i = 0; i<200;i++) {
			listaEncadenada.addLast(i);
		}
	}
	
	@Test
	public void testListaEncadenada() {
		setUp1();
		assertTrue("la lista no se inicio correctamente", listaEncadenada!= null);
	}

	
	
	@Test
	public void testGetElement() {
		setUp1();
		assertTrue("se debio retornar null",listaEncadenada.getElement(0)==null);
		setUp2();
		assertTrue("se debio retornar 0",listaEncadenada.getElement(0)==0);
	}
	
	@Test
	public void testRemoveFirst() {
		setUp1(); 
		assertTrue("se debio retornar null", listaEncadenada.removeFirst()==null);
		setUp2();
		assertTrue("se debio retornar 0", listaEncadenada.removeFirst()==0);
	}
	

	@Test
	public void testRemoveLast() {
		setUp1(); 
		assertTrue("se debio retornar null", listaEncadenada.removeLast()==null);
		setUp2();
		assertTrue("se debio retornar 199", listaEncadenada.removeLast()==199);
	}

	@Test
	public void testDeleteElement() {
		setUp1(); 
		assertTrue("se debio retornar null", listaEncadenada.deleteElement(0)==null);
		setUp2();
		assertTrue("se debio retornar null", listaEncadenada.deleteElement(201)==null);
		assertTrue("se debio retornar 199", listaEncadenada.deleteElement(199)==199);
	}
	
	@Test
	public void testFirtElement() {
		setUp1(); 
		assertTrue("se debio retornar null", listaEncadenada.firstElement()==null);
		setUp2();		
		assertTrue("se debio retornar 0", listaEncadenada.firstElement()==0);
	}
	
	@Test
	public void testLastElement() {
		setUp1(); 
		assertTrue("se debio retornar null", listaEncadenada.lastElement()==null);
		setUp2();		
		assertTrue("se debio retornar 199", listaEncadenada.lastElement()==199);
	}
	
	
	@Test
	public void testSize() {
		setUp1();
		assertTrue("se debio retornar 0",listaEncadenada.size()==0);
		setUp2();
		assertTrue("se debio retornar 200" ,listaEncadenada.size()==200);
	}
	
	@Test
	public void testIsEmpty() {
		setUp1();
		assertTrue("se debio retornar true",listaEncadenada.isEmpty());
		setUp2();
		assertTrue("se debio retornar false",!listaEncadenada.isEmpty());
	}
	
	@Test
	public void testIsPresent() {
		setUp1();
		assertTrue("se debio retornar -1",listaEncadenada.isPresent(0)==-1);
		setUp2();
		assertTrue("se debio retornar 0",listaEncadenada.isPresent(0)==0);
	}
	
	
	@Test
	public void testAddFirst() {
		setUp1(); 
		listaEncadenada.addFirst(5);
		assertTrue("se debio retornar 5", listaEncadenada.getElement(0)==5);
		setUp2();
		listaEncadenada.addFirst(5);
		assertTrue("se debio retornar 5", listaEncadenada.getElement(0)==5);
	}
	
	@Test
	public void testAddLast() {
		setUp1(); 
		listaEncadenada.addLast(5);
		assertTrue("se debio retornar 5", listaEncadenada.getElement(0)==5);
		setUp2();
		listaEncadenada.addLast(5);
		assertTrue("se debio retornar 5", listaEncadenada.getElement(200)==5);
	}
		
	
	@Test
	public void testInsertarElemento() {
		setUp2(); 
		listaEncadenada.insertElement(1, 50);
		assertTrue("El valor es incorrecto", listaEncadenada.getElement(50)==1);
	}

	
	
	@Test
	public void testExchange() {
		setUp2(); 
		listaEncadenada.exchange(0, 1);
		assertTrue("se debio retornar 0", listaEncadenada.getElement(1)==0);
		assertTrue("se debio retornar 1", listaEncadenada.getElement(0)==1);
	
	}
	@Test
	public void testChangeInfo() {
		setUp2(); 
		listaEncadenada.changeInfo(0, 1);
		assertTrue("se debio retornar 1", listaEncadenada.getElement(0)==1);
	}	
	
}
