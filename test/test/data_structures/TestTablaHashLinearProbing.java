package test.data_structures;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.TablaHashLinearProbing;

public class TestTablaHashLinearProbing {

	private TablaHashLinearProbing <Integer,Integer>HT;
	
	@Before
	public void setUp1() {
		HT = new TablaHashLinearProbing<Integer,Integer>(4);
	}
	
	
	@Before
	public void setUp2() {
		HT = new TablaHashLinearProbing<Integer,Integer>(10);
		for (int i = 0; i<10;i++)
		{
			HT.put(i, i+1);
		}
	}
	
	@Test
	public void tablaHashLinearProbingtest() {
		setUp1();
		assertTrue("No se inicializó correctamente", HT!= null);
			
	}
	
	@Test
	public void testPut() {
		setUp1();
		HT.put(1, 2);
		assertTrue("La llave no se encontró", HT.get(1).size()!=0);
		assertTrue("El valor esperado no fue el correcto", HT.get(1).getElement(0)== 2);
	}
	
	@Test
	public void testGet() {
		setUp1();		
		assertTrue("El valor retornado debio ser nulo", HT.get(1)==null);
		
		setUp2();
		assertTrue("El valor esperado no fue el correcto", HT.get(3).getElement(0)== 4);
	}
	
	@Test
	public void test() {
		setUp1();
		HT.put(1, 2);
		assertTrue("La llave no se encontró", HT.get(1)!=null);
		assertTrue("El valor esperado no fue el correcto", HT.get(1).getElement(0)== 2);
	}
	
	@Test
	public void testRemove() {
		setUp2();
		HT.remove(1);
		assertTrue("El valor no se borro correctamente", HT.get(1)==null);
	
	}
	
	@Test
	public void testContains() {
		setUp1();
		assertTrue("La llave no deberia estar contenida", !HT.contains(1));
		setUp2();
		assertTrue("La llave deberia estar contenida", HT.contains(1));
	}
	
	
	@Test
	public void testIsEmpty() {
		setUp1();
		assertTrue("La tabla deberia estar vacia", HT.isEmpty());
		setUp2();
		assertTrue("La tabla no deberia estar vacia", !HT.isEmpty());
	}
	
	
	
	@Test
	public void testSize() {
		setUp1();
		assertTrue("El tamaño deberia ser cero", HT.size()==0);
		setUp2();
		assertTrue("El tamaño deberia ser 10", HT.size()==10);
	}
	

	@Test
	public void testKeySet() {
		setUp1();
		assertTrue("El keySet deberia ser vacio", HT.keySet().size()==0);
		setUp2();
		assertTrue("El keySet no deberia ser vacio", HT.keySet().size()!=0);
		assertTrue("El keySet deberia contener la llave 1", HT.keySet().getElement(1)==1);
	}
	
	@Test
	public void testValueSet() {
		setUp1();
		assertTrue("El valueSet deberia ser vacio", HT.valueSet().size()==0);
		setUp2();
		assertTrue("El valueSet no deberia ser vacio", HT.valueSet().size()!=0);
		assertTrue("El valueSet deberia contener el valor 1", HT.valueSet().getElement(0)==1);
	}
	
	
	@Test
	public void testIterator() {
		setUp1();
		assertTrue("El iterador no fue inicializado", HT.iterator()!=null);
		Iterator<Integer> iter = HT.iterator();
		assertTrue("El iterador no deberia tener siguiente", !iter.hasNext());
		
		setUp2();
		iter = HT.iterator();
		assertTrue("El iterador deberia tener siguiente", iter.hasNext());
		int i =0; 
		while (iter.hasNext()) {
			if (iter.next()!= i ) {
				break;
			}
			i++;
		}
		
		assertTrue("Uno de los elementos que fue retornado no tenia el valor esperado",i ==10);
	}
		
	@Test
	public void testRehash() {
		setUp1();
		for(int i =0;i<5; i++){
			HT.put(i, i+1);
		}
		assertTrue("Se debio efectuar un rehash: " + HT.M,HT.M == 8);
		
	}
}

