package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SequentialSearchST <Key, Value> implements Iterable<Key> {

	private Node first; // first node in the linked list
	private int lenght;



	private class Node  { // linked-list node

		Key key;

		ListaEncadenada<Value> val;

		Node next;



		/**
		 * Constructor
		 */

		public Node(Key key, Value val, Node next) {

			this.key = key;

			this.val = new ListaEncadenada<Value> ();
			this.val.addLast(val);

			this.next = next;


		} 

	}

	public SequentialSearchST () {
		first = null;
		lenght = 0;
	}


	/**
	 * Retorna el valor asociado a la llave
	 * @param key
	 * @return
	 */

	public ListaEncadenada<Value> get(Key key)

	{ // Search for key, return associated value.

		for (Node x = first; x != null; x = x.next)

			if (key.equals(x.key))

				return x.val; // search hit

		return null; // search miss

	}

	/**
	 * Busca por llave y si lo esncuentra lo ingresa a la tabla
	 * @param key
	 * @param val
	 */
	public boolean put(Key key, Value val)

	{ 

		for (Node x = first; x != null; x = x.next)

			if (key.equals(x.key))

			{ x.val.addLast(val); return false ; } // Search hit: update val.

		first = new Node(key, val, first); // Search miss: add new node.
		lenght++;
		return true; 
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	
	public void updateNode(Key key, ListaEncadenada<Value> value) {
		for(Node x = first; x != null; x = x.next)

				if (key.equals(x.key)){
					x.val= value;
					return;
		}
	}
	
	
	/**
	 * 
	 * @param key
	 */
	
	public void deleteNode(Key key) {
		if(first.key.equals(key)) {
			first= first.next;
			lenght--;
		}
		else {
			Node nodeAnterior = first;
			
			for(Node x = first; x != null; x = x.next) {
				if (key.equals(x.key)) {
					nodeAnterior.next = x.next;
					lenght--;
					break;
				}
			}
		}
			
	}
	
	
	public boolean contains(Key key){
		return get(key)!= null;
	}
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	
	public int size() {
		return lenght;
	}


	@Override
	public Iterator<Key> iterator() {
		
		return new KeyIterator();
	}
	
	private class KeyIterator implements Iterator <Key>{
		
		private Node actual;
		
		private Node anterior;
		
		public KeyIterator () {
			
			actual = new Node(null,null,first);
			anterior = null;
		}
		
		
		@Override
		public boolean hasNext() {
			return actual.next!= null;
		}

		@Override
		public Key next() {
			anterior = actual; 
			actual = actual.next;
			
			if(actual == null) {
				throw new NoSuchElementException();
			}
			return actual.key;
		}
		
		/**
		 * 
		 */
		
		public void delete() {
			if(actual == first) {
				first = first.next;
			}
			else {
				anterior.next= actual.next;
			}
		}
		
	}
}
