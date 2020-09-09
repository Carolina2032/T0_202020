package model.data_structures;

import java.util.Iterator;

/** Representa una lista encadenada
 * 
 */

public class ListaEncadenada <T extends Comparable<T>> implements Iterable<T>,Lista<T> {

	private Nodo<T> head;
    private Nodo<T> tail;
    private int size;
	
    
    
    /**
     * Constructor
     */
    
    public ListaEncadenada() {
        head = null;
        tail = null;
        size = 0;
    }
  
	
    /**
     * Devuelve el nodo completo de una posicion concreta
     *
     * @param pos
     * @return
     */
    
    private Nodo<T> getNode(int pos) {
 
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (pos < 0 || pos >= size())) {
            return null;
        } else if (pos == 0) {
            return head; 
        } else if (pos == size() - 1) {
            return tail;
        } else {
 
            Nodo<T> buscado = head;
 
            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < pos) {
                contador++;
                buscado = buscado.getSiguiente();
            }
 
       
            return buscado;
 
        }
 
    }
    
    /**
     * Devuelve el elemento en la posicion indicada
     * @param pos
     * @return
     */
  
	public T getElement( int pos) 
	{
		//si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (pos < 0 || pos >= size())) {
            return null;
        } else if (pos == 0) {
            return firstElement();
        } else if (pos == size() - 1) {
            return lastElement(); 
        } else {
 
            Nodo<T> buscado = getNode(pos);
 
            return buscado.getDato();
        }
	}
	
	
	/**
     * Elimina el primer elemento de la lista
     * @return 
     */
	
	public T removeFirst(){

        if (isEmpty()) {
            return null;
        } else {
 
            //Guardo el elemento antes
            T elemento = head.getDato();
 
            //Cojo el segundo
            Nodo<T> aux = head.getSiguiente();
            head = null; //Lo marco como null para el recolector
            head = aux; //Este es mi nuevo primero
 
            //En caso de que borremos el ultimo elemento,el ultimo también
            if (size() == 1) {
                tail = null;
            }
 
            size--;
            return elemento;
 
        }
	}
	
	/**
     * Elimina el ultimo elemento de la lista
     * @return
     */
	public T removeLast( ) {
		
		 if (isEmpty()) {
	            return null;
	        } else {
	 
	            //Coge el elemento antes de borrar
	            T elemento = tail.getDato();
	 
	            //Cojo el penultimo
	            Nodo<T> aux = getNode(size() - 2);
	 
	            //En caso de que sea null
	            //Hay 1 o dos elementos
	            if (aux == null) {
	 
	                //marco el ultimo como nulo
	                tail = null;
	                //Si hay dos, el primero y el ultimo seran el mismo
	                //Si hay 1 elemento, significa que borramos la lista
	                if (size() == 2) {
	                    tail = head;
	                } else {
	                    head = null;
	                }
	 
	            } else {
	                //el penultimo es el nuevo ultimo 
	                //y le ponemos como siguiente nulo
	                tail = null;
	                tail = aux;
	                tail.setSiguiente(null);
	            }
	 
	            size--;
	 
	            return elemento;
	 
	        }
	 
	}
	
	
	/**
     * Elimina el nodo de la lista en una posicion concreta
     *
     * @param pos
     * @return
     */
	
	public T deleteElement( int pos) {
		
		 //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (pos < 0 || pos >= size())) {
            return null;
        } else if (pos == 0) {
            return removeFirst();
        } else if (pos == size() - 1) {
            return removeLast();
        } else {
 
            //Cojo el nodo anterior al que quiero borrar
            Nodo<T> nodo_anterior = getNode(pos - 1);
 
            //Cojo el nodo que quiero borrar
            Nodo<T> nodo_actual = getNode(pos);
 
            //Cojo el elemento antes de borrar
            T elemento = nodo_actual.getDato();
 
            //Cojo el nodo siguiente al que quiero borrar
            Nodo<T> nodo_siguiente = nodo_actual.getSiguiente();
 
            //Lo marco para borrar para el recolector
            nodo_actual = null;
 
            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);
 
            size--;
 
            return elemento;
 
        }
	}
	

	/**
     * Devuelve el primer elemento, null si esta vacia la lista
     *
     * @return
     */
	
	public T firstElement() {
		
		if (isEmpty()) {
            return null;
        } else {
            return head.getDato();
        }
	}
	
	
	  
    /**
     * Devuelve el ultimo elemento, null si esta vacia la lista
     *
     * @return
     */
	
	public T lastElement() {
		 //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return tail.getDato();
        }
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	/**
     * Indica si existe el elemento indicado
     *
     * @param element
     * @return 
     */
	
	public int isPresent (T element) {
		
		  //Si esta vacio, devuelve 0
        if (isEmpty()) {
            return -1;
        } else {
 
            Nodo<T> aux = head;
            int contador =0;
 
            //Recorremos la lista
            while (aux != null) {
                if (element.equals(aux.getDato())) { 
                    return contador; //Existe
                }
                contador++;
                aux = aux.getSiguiente();
            }
 
            //Si no lo encuentra devuelve false
            return -1;
 
        }
	}
	
	/**
	 * Agrega un elemento al inicio de la lista
	 * @param element elemento que se va a agregar al inicio de la lista
	 */
	
	@Override
	public void addFirst(T element) {
		
		 Nodo<T> aux;
			
	        if (isEmpty()) {
	            aux = new Nodo<>(element, null);
	            head = aux;
	            tail = aux;
	        } else {
	          
	            Nodo<T> primeroActual = head;
	            aux = new Nodo<>(element, primeroActual);
	            head = aux;
	        }
	        size++;
	}


	
	/**
	 * Agrega un elemento al final de la lista
	 * @param element elemento que se va a agregar al final de la lista
	 */
	
	@Override
	public void addLast(T element) {
		
		Nodo<T> aux;
		       
        if (isEmpty()) {
          addFirst(element);
        } else {
 
            aux = new Nodo<>(element, null);
            tail.setSiguiente(aux);
            tail = aux;
            size++;	
        }
      	
	}


	/**
	 * Agrega un elemento en la posición pos si la posición es una posición válida. 
	 * @param element elemento que se va a agregar
	 * @param pos posicion a la cual se agrega el elemento 
	 */
	

	@Override
	public void insertElement(T element, int pos) {
	
		if (pos == 0) {
            addFirst(element); 
        } else if (pos == size()) {
            addLast(element); 
        } else if ((pos < 0 || pos >= size())) {
           
        } else {
 
            //Cojo el anterior nodo al que estoy buscando
            Nodo<T> buscado_anterior = getNode(pos - 1);
 
            //Cojo el nodo de la posicion indicada
            Nodo<T> buscado_actual = getNode(pos);
 
            //Creo el nuevo novo, este apuntara al de la posicion actual
            Nodo<T> aux = new Nodo<>(element, buscado_actual);
 
            //el nodo anterior apunta a nuestro nuevo nodo
            buscado_anterior.setSiguiente(aux);

            size++;
          
        }
		
	}
	
	
	/**
	 * Intercambia la información de los elementos en dos posiciones válidas.
	 *@param pos1 primera posiciona  ser intercambiada
	 *@param pos2 segunda posicion a ser intercambiada
	 */


	@Override
	public void exchange(int pos1, int pos2) {
		
		if (pos1 == pos2) {
			return ;	
		}
		if(pos1>=0 && pos1 <= size-1 && pos2>=0 && pos2 <= size-1) {
			T elemento1 = getElement(pos1);
			T elemento2 = getElement(pos2);
			changeInfo(pos1, elemento2);
			changeInfo(pos2, elemento1);
		}
		else {
			System.out.println("posiciones invalidas");
		}
		
	}

	
	/**
	 * Actualiza el elemento en una posición válida.
	 *@param pos Posicion que en la que se desea agregar
	 *@param elem elemnto a ser agregado
	 */
	

	@Override
	public void changeInfo(int pos, T elem) {
		
		//si esta vacio o el indice no es correcto
        if (isEmpty() || (pos < 0 || pos >= size())) {
          
        } else {
 
            //Nodo actual
            Nodo<T> aux = getNode(pos);
 
            //modifico
            aux.setDato(elem);;
            aux.getDato();
 
        }
		
	}
	
	
	
	
	public Iterator<T> iterator() {
        return new MyIterator<T>();
    }
 
    //Creo la clase interna MyIterator, que implementa la interfaz Iterator
    private class MyIterator<ListaDinamica> implements Iterator<T>{
 
        //Indica el siguiente elemento que se va a devolver 
        private int actual;
        
        
        //constructor
        
        public MyIterator(){ 
        	actual = size == 0? -1:0 ;	
        }
        
         
        //Indica si hay un elemento
        @Override
        public boolean hasNext() {
            
        	return getNode(actual).getSiguiente()!=null;            
        }
 
        
        //Devuelve el elemento actual e incrementa al siguiente
        @Override
        public T next() {
            T elemento = getNode(actual).getDato();
            actual++;
            return elemento;
        }
         
    }
	
	
}
