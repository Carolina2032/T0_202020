package model.data_structures;

/** Representa un arreglo dinamico genérico
 * 
 */
public interface IArregloDinamico<T extends Comparable<T>> {

	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return
	 */
	int darCapacidad( );

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int darTamano( );

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T darElemento( int i );

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	void agregar(T dato );

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	T buscar(T dato);

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	T eliminar(T dato );

	/**
	 * Inserta un elemento dado el elemento y la posicion
	 * @param element elemento 
	 * @param pos posicion
	 */
	void insertElement(T element, int pos);
	

	/**
	 * Remueve el primer elemento 
	 * @return
	 */
	T removeFirst( );


	/**
	 * Remueve el último elemento
	 * @return
	 */
	 T removeLast( ) ;

	/**
	 * Remueve un elemento dada la posicion
	 * @return
	 * @param  posicion
	 */
	T deleteElement( int pos);

	/**
	 * Arroja el primer elemento
	 * @return
	 */
	T firstElement( );

	/**
	 * Arroja el último elemento
	 * @return
	 */
	T lastElement();
	
	
	/**
	 * Intercambia dos elementos dada las posiciones
	 * @param pos1 posicion1
	 * @param pos 2 posicion2
	 */
	void exchange (int pos1, int pos2);
	

	/**
	 * Contruir un arreglo de datos
	 * @param  arreglo arreglo
	 */
	void setDatos(Comparable [] arreglo );
	
	
	/**
	 * Introduce un elemento en una posicion dada 
	 * @param pos posicion1
	 * @param elem posicion2
	 */
	void changeInfo (int pos, T elem);


	/**
	 * Borra todos los datos del arreglo
	 */
	void eliminartodo() ;


	/**
	 * Agrega en primer puesto un dato 
	 * @param element dato a ser agregado
	 */
	void addFirst(T element); 

	/**
	 * Agrega en ultimo puesto un dato 
	 * @param element elemento a ser agregado
	 */
	void addLast(T element) ;

	/**
	 * Da el elemento en la posicion ingresada
	 * @param pos posicion 
	 */
	T getElement(int pos) ;

	/**
	 * Da el tamaño del arreglo
	 * @return
	 */
	int size();
	

	/**
	 * verifica si esta vacio el arreglo 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Verifica si existe un elemento en el arreglo
	 * @return
	 */
	int isPresent(T element);


}
