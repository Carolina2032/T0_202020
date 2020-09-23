package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;


/** 
 * Representa una TablaHashLinearProbing
 */

public class TablaHashLinearProbing <K extends Comparable<K>, V> implements TablaSimbolos <K, V> , Iterable<K>{

	/**
	 * Atributos
	 */

	public int N;
	public int M;
	private K[] keys;
	private ListaEncadenada <V>[] values;
	public final static double FACTOR_DE_CARGA = 0.75; 
	public int rehashes ;

	/**
	 * Constructor
	 */

	public TablaHashLinearProbing( int max) {

		M = max;
		keys = (K[]) new Comparable[M];
		values = new ListaEncadenada[M];
		rehashes = 0;

		for (int i=0;i<values.length;i++) {
			values [i]= new ListaEncadenada <V>();
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
		TablaHashLinearProbing<K,V> t = new TablaHashLinearProbing<K,V> (max);

		for (int i= 0; i< M-1;i++) {
			if(keys [i]!= null) {

				for (int j=0;j< get(keys[i]).size();j++) {
					t.put(keys[i], values[i].getElement(j));
				}
			}
		}
		keys = t.keys;
		values = t.values;
		M = t.M;
		rehashes++;
	}

	/**
	 * Agregar una dupla (K, V) a la tabla. Si la llave K existe, se reemplaza su valor V asociado. V no puede ser null.
	 * @Param K key 
	 * @ParamV value
	 */
	@Override
	public void put(K key, V value) {
		if (N/M > FACTOR_DE_CARGA) {
			resize (2*M); 
		}
		int i; 
		for(i=hash(key);keys[i]!= null;i=(i+1)%M) {
			if(keys [i].equals(key)) {
				values[i].addLast(value);
				return;
			}
		}
		keys[i] = key;
		values[i].addLast(value);
		N++;

	}

	/**
	 * Obtener el valor V asociado a la llave K. Se obtiene null solo si la llave K no existe. Se usa el comparador sobre las llaves para saber si existe.
	 * @Param K key 
	 */

	@Override
	public ListaEncadenada <V> get(K key) {
		for (int i= hash(key); keys [i]!= null; i=(i+1)%M) {
			if(keys [i].equals(key)){
				return values[i];
			}
		}
		return null;
	}


	/**
	 * Borrar la dupla asociada a la llave K. Se obtiene el valor V asociado a la llave K. Se obtiene null solo si la llave K no existe.
	 * @Param K key
	 */

	@Override
	public ListaEncadenada<V>  remove(K key) {
		for (int i= hash(key); keys [i]!= null; i=(i+1)%M) {
			if(keys [i].equals(key)){
				ListaEncadenada<V> value = values[i];
				keys[i]= null;
				values[i]= null;
				N--;
				return value;
			}
		}
		return null;

	}

	/**
	 * Retorna true en el caso que la llave K se encuentre almacenada en la Tabla, o false en el caso contrario
	 * @Param K key
	 */

	@Override
	public boolean contains(K key) {

		return get(key)!=null;
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
		Iterator iter=  this.iterator();
		ListaEncadenada<K> keySet = new ListaEncadenada <K>() ;
		while (iter.hasNext()){
			K actualKey = (K) iter.next();
			keySet.addLast(actualKey);

		}
		return keySet;
	}



	/**
	 * Retorna todos los valores almacenados en la Tabla.
	 * @Return 
	 */

	@Override
	public Lista<V> valueSet() {
		Iterator iter=  this.iterator();
		ListaEncadenada<V> keySet = new ListaEncadenada <V>() ;

		while (iter.hasNext()){
			K actualKey = (K) iter.next();
			for (int i = 0;i<get(actualKey).size();i++) {
				keySet.addLast(get(actualKey).getElement(i));
			}
		}
		return keySet;
	}

	@Override
	public Iterator<K> iterator() {
		return new KeyIterator();
	}

	private class KeyIterator implements Iterator<K>{

		private int indice;

		public KeyIterator () {
			indice =-1;
		}

		@Override
		public boolean hasNext() {
			if (indice< keys.length) {
				int i = indice ;
				try {
					while(keys[i+1]== null) {
						i++;
					}
					return true;
				}
				catch (Exception e) {
					return false;	
				}
			}
			else {
				return false;
			}
		}

		@Override
		public K next() {
			try {
				while(keys[indice+1]== null) {
					indice++;
				}
				return keys[++indice];
			}
			catch (Exception e){
				throw new NoSuchElementException();
			}
		}
	}
}
