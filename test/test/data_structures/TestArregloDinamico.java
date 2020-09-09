package test.data_structures;
import static org.junit.Assert.*;


import model.data_structures.ArregloDinamico;


import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico <Integer> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico <Integer>(TAMANO);
	}

	public void setUp2() {
		setUp1(); 
		for(Integer i =0; i< TAMANO*2; i++){
			arreglo.addLast(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		setUp1();
	}

	@Test
	public void testDarElemento() {
		setUp2();
		Integer x = arreglo.getElement(34);
		assertTrue("El valor es incorrecto",x==34);
		
	}
	
	@Test
	public void testInsertarElemento() {
		setUp2(); 
		arreglo.insertElement(1, 50);
		assertTrue("El valor es incorrecto", arreglo.getElement(50)==1);
	}

	@Test
	public void testRemoveFirst() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.removeFirst()==null);
		setUp2();
		assertTrue("se debio retornar 0", arreglo.removeFirst()==0);
	}
	
	@Test
	public void testRemoveLast() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.removeLast()==null);
		setUp2();
		assertTrue("se debio retornar 199", arreglo.removeLast()==199);
	}

	@Test
	public void testDeleteElement() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.deleteElement(0)==null);
		setUp2();
		assertTrue("se debio retornar null", arreglo.deleteElement(201)==null);
		assertTrue("se debio retornar 199", arreglo.deleteElement(199)==199);
	}
	
	@Test
	public void testFirtElement() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.firstElement()==null);
		setUp2();		
		assertTrue("se debio retornar 0", arreglo.firstElement()==0);
	}
	
	@Test
	public void testLastElement() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.lastElement()==null);
		setUp2();		
		assertTrue("se debio retornar 199", arreglo.lastElement()==199);
	}
	
	@Test
	public void testExchange() {
		setUp2(); 
		arreglo.exchange(0, 1);
		assertTrue("se debio retornar 0", arreglo.getElement(1)==0);
		assertTrue("se debio retornar 1", arreglo.getElement(0)==1);
	
	}
	@Test
	public void testChangeInfo() {
		setUp2(); 
		arreglo.changeInfo(0, 1);
		assertTrue("se debio retornar 1", arreglo.getElement(0)==1);
	}
	
	@Test
	public void testdarCapacidad() {
		setUp1(); 
		assertTrue("se debio retornar 100", arreglo.darCapacidad()==100);
		setUp2();
		assertTrue("se debio retornar 227", arreglo.darCapacidad()==227);
	}
	
	@Test
	public void testBuscar() {
		setUp1(); 
		assertTrue("se debio retornar null", arreglo.buscar(0)==null);
		setUp2();
		assertTrue("se debio retornar 0", arreglo.buscar(0)==0);
	}
	
	@Test
	public void testEliminarTodo() {
		setUp1(); 
		arreglo.eliminartodo();
		assertTrue("se debio retornar null", arreglo.buscar(0)==null);
		setUp2();
		arreglo.eliminartodo();
		assertTrue("se debio retornar null", arreglo.buscar(0)==null);
	}
	
	@Test
	public void testEliminar() {
		setUp1(); 
		arreglo.eliminar(0);
		assertTrue("se debio retornar null", arreglo.buscar(0)==null);
		setUp2();
		arreglo.eliminar(0);
		assertTrue("se debio retornar 1", arreglo.buscar(1)==1);
	}
	
	@Test
	public void testAddFirst() {
		setUp1(); 
		arreglo.addFirst(5);
		assertTrue("se debio retornar 5", arreglo.buscar(5)==5);
		setUp2();
		arreglo.addFirst(5);
		assertTrue("se debio retornar 5", arreglo.buscar(5)==5);
	}
	
	@Test
	public void testAddLast() {
		setUp1(); 
		arreglo.addLast(5);
		assertTrue("se debio retornar 5", arreglo.buscar(5)==5);
		setUp2();
		arreglo.addLast(5);
		assertTrue("se debio retornar 5", arreglo.buscar(5)==5);
	}
	
	@Test
	public void testGetElemento() {
		setUp2();
		Integer x = arreglo.getElement(34);
		assertTrue("El valor es incorrecto",x==34);
	
	}
	
	@Test
	public void testSize() {
		setUp1();
		assertTrue("se debio retornar 0",arreglo.size()==0);
		setUp2();
		assertTrue("se debio retornar 200",arreglo.size()==200);
	}
	
	@Test
	public void testIsEmpty() {
		setUp1();
		assertTrue("se debio retornar true",arreglo.isEmpty());
		setUp2();
		assertTrue("se debio retornar false",!arreglo.isEmpty());
	}
	
	@Test
	public void testIsPresent() {
		setUp1();
		assertTrue("se debio retornar -1",arreglo.isPresent(0)==-1);
		setUp2();
		assertTrue("se debio retornar 0",arreglo.isPresent(0)==0);
	}
	

}
