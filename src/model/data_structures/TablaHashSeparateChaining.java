package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;


/** 
 * Representa una TablaHashSeparateChaining
 */
public class TablaHashSeparateChaining <K extends Comparable<K>, V> implements TablaSimbolos <K, V> , Iterable<K>{
	
	/**
	 * Atributos
	 */

	public int M;
	
	private int N;
	
	private SequentialSearchST <K,V>[] st;
	
	public int rehash;
	
	
	public final static double FACTOR_DE_CARGA =5.0;
	
	
	/**
	 * Constructor
	 */
	public TablaHashSeparateChaining(int max) {
		
		M = max;
		N = 0;
		st = (SequentialSearchST<K,V>[]) new SequentialSearchST[max]; 
		rehash =0;
		
		for ( int i=0; i<max; i++) {
			st[i] = new SequentialSearchST <K,V> ();
		}	
	}
	
	/**
	 * 
	 * @Param capacidad maxima
	 */
	private int hash (K key) {
		return (key.hashCode()& 0x7fffffff) % M;
	}
	
	/**
	 * Redimensiona la tabla
	 * @Param capacidad maxima
	 */	
	private void resize(int max) {
		
		TablaHashSeparateChaining <K,V> t= new TablaHashSeparateChaining <K,V> (max);
		Iterator <K> iter = this.iterator();
		while (iter.hasNext()) {
			K key = iter.next();
			ListaEncadenada<V> value = get(key);
			t.st[hash(key)].updateNode(key, value);  
		}
		st = t.st;
		N = t.N;
		M = t.M;
		rehash++;
	}
	
	
	@Override
	public Iterator<K> iterator() {
		return new KeyIterator();
	}
	
	/**
	 * Agregar una dupla (K, V) a la tabla. Si la llave K existe, se reemplaza su valor V asociado. V no puede ser null.
	 * @Param K key 
	 * @ParamV value
	 */
	@Override
	public void put(K key, V value) {
		
		if (N/M> FACTOR_DE_CARGA) {
			resize(2*M);
		}
		if (st[hash(key)].put(key, value)) {
			N++;
		}
	}


	/**
	 * Obtener el valor V asociado a la llave K. Se obtiene null solo si la llave K no existe. Se usa el comparador sobre las llaves para saber si existe.
	 * @Param K key 
	 */
	@Override
	public ListaEncadenada<V> get(K key) {
		
		return st[hash(key)].get(key);
	}

	/**
	 * Borrar la dupla asociada a la llave K. Se obtiene el valor V asociado a la llave K. Se obtiene null solo si la llave K no existe.
	 * @Param K key
	 */
	@Override
	public ListaEncadenada<V> remove(K key) {
		ListaEncadenada<V> value = get(key);
		st[hash(key)].deleteNode(key);
		return value;
	}

	/**
	 * Retorna true en el caso que la llave K se encuentre almacenada en la Tabla, o false en el caso contrario
	 * @Param K key
	 */
	@Override
	public boolean contains(K key) {
		Iterator <K> iter = this.iterator();
		while (iter.hasNext()) {
			K actualKey = (K) iter.next();
			if(actualKey.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna true si la Tabla NO tiene datos, o false en caso contrario.
	 * @Return 
	 */
	@Override
	public boolean isEmpty() {
		
		return N==0;
	}

	/**
	 * Retorna el número de duplas en la Tabla de Símbolos
	 * @Return 
	 */
	@Override
	public int size() {
	
		return N;
	}

	/**
	 * Retorna todas las llaves almacenadas en la Tabla.
	 * @Return 
	 */
	@Override
	public Lista<K> keySet() {
		Iterator<K> iter = this.iterator();
		ListaEncadenada<K> listaEncadenada = new ListaEncadenada <K>();	
		while (iter.hasNext()) {
			listaEncadenada.addLast(iter.next());
		}
		return listaEncadenada;
	}

	/**
	 * Retorna todos los valores almacenados en la Tabla.
	 * @Return 
	 */
	@Override
	public Lista<V> valueSet() {
		Iterator<K> iter = this.iterator();
		ListaEncadenada<V> listaEncadenada = new ListaEncadenada <V>();	
		while (iter.hasNext()) {
			K actualKey = iter.next(); 
			for (int i =0; i< get(actualKey).size();i++) {
				listaEncadenada.addLast(get(actualKey).getElement(i));
			}
		}
		return listaEncadenada;
		
	}
	
	
	private class KeyIterator implements Iterator <K>{

		
		private int index ;
		
		private Iterator <K> iterActual;
		
		
		
		public KeyIterator() {
			
			index = 0;
			iterActual = st[index].iterator();
		}
		
		
		@Override
		public boolean hasNext() {
			return iterActual.hasNext()|| (index+1)<M;
		}

		@Override
		public K next() {
			if (iterActual.hasNext()) {
				return iterActual.next();
			}
			else {
				while (!iterActual.hasNext()) {
					iterActual= (index+1)<M?st [++index].iterator():null;
					if (iterActual ==null) {
						throw new NoSuchElementException();
					}
				}
				return iterActual.next();
			}
		}
		
	}
}
