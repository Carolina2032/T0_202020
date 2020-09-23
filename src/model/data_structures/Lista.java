package model.data_structures;

public interface Lista <T> {

	/**
	 * Agrega un elemento al inicio de la lista
	 * @param element elemento que se va a agregar al inicio de la lista
	 */
	void addFirst(T element);
	
	/**
	 * Agrega un elemento al final de la lista
	 * @param element elemento que se va a agregar al final de la lista
	 */
	void addLast(T element);
	
	/**
	 * Agrega un elemento en la posición pos si la posición es una posición válida. 
	 * @param element elemento que se va a agregar
	 * @param pos posicion a la cual se agrega el elemento 
	 */
	void insertElement(T element, int pos);
	
	/**
	 * Elimina el primer elemento. 
	 */
	T removeFirst( );
	
	/**
	 * Elimina el último elemento.
	 */
	T removeLast( );
	
	/**
	 * Elimina el elemento de una posición válida
	 * @param pos posicion que quiero eliminar
	 */
	T deleteElement( int pos);

	/**
	 * Retorna el primer elemento
	 */
	T firstElement( );
	
	/**
	 * Retorna el ultimo elemento
	 */
	T lastElement();
	
	/**
	 * Retorna el elemento en una posición válida
	 * @param pos posicion que quiero recuperar
	 */
	T getElement( int pos);
	
	/**
	 * Retorna el número de datos en el arreglo
	 */
	int size( );
	
	/**
	 * Retorna true si el arreglo No tiene datos. false en caso contrario.
	 */
	boolean isEmpty( );
	
	/**
	 * Retorna la posición válida de un elemento. Si no se encuentra el elemento, el valor retornado es -1.
	 *@param element elemento a ser verificado
	 */
	int isPresent (T element);
	
	/**
	 * Intercambia la información de los elementos en dos posiciones válidas.
	 *@param pos1 primera posiciona  ser intercambiada
	 *@param pos2 segunda posicion a ser intercambiada
	 */
	void exchange (int pos1, int pos2);
	
	/**
	 * Actualiza el elemento en una posición válida.
	 *@param pos Posicion que en la que se desea agregar
	 *@param elem elemnto a ser agregado
	 */
	void changeInfo (int pos, T elem);
}
