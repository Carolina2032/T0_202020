package model.data_structures;


/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements Lista<T>  {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Tamaño de arreglo por defecto
	 */

	private static final int DEFAULT_SIZE = 7;

	/**
	 * Construir un arreglo con la capacidad maxima por defecto.
	 */

	public ArregloDinamico()
	{

		elementos = (T[]) new Comparable [DEFAULT_SIZE];
		tamanoMax = DEFAULT_SIZE;
		tamanoAct = 0;
	}

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */

	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable [max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	/**
	 * Construir un arreglo con los datos .
	 */


	public Comparable[] darDatos() {

		int tamano=tamanoAct==0?0:tamanoAct-1;

		T[] datos = (T[]) new Comparable [tamano] ;

		for (int i = 0 ; i<tamanoAct -1; i++)	{
			datos [i] = elementos [i]; 

		}
		return datos;
	}


	/**
	 * Inserta un elemento dado el elemento y la posicion
	 * @param element elemento 
	 * @param pos posicion
	 */

	public void insertElement(T element, int pos) {
		elementos [pos] = element; 

	}


	/**
	 * Remueve el primer elemento 
	 */

	public T removeFirst( ) {
		if ( tamanoAct==0) {
			return null;
		}
		else {
			T elemento = elementos [0];

			for (int i=0;i<tamanoAct-1;i++) {
				elementos [i] = elementos [i+1];
			}
			tamanoAct--;
			return elemento;
		}		 		
	}


	/**
	 * Remueve el último elemento
	 */

	public T removeLast( ) {
		if ( tamanoAct==0) {
			return null;
		}
		else {
			T elemento = elementos [tamanoAct-1];
			elementos [tamanoAct-1] = null;
			tamanoAct--;
			return elemento;
		}		 		
	}

	/**
	 * Remueve un elemento dada la posicion
	 * @param  posicion
	 */

	public T deleteElement( int pos) {
		if ( tamanoAct==0) {
			return null;
		}
		else {
			if(pos>=0 && pos<= tamanoAct-1){

				T elemento = elementos [pos];

				for (int i=pos;i<tamanoAct-1;i++) {
					elementos [i] = elementos [i+1];
				}
				tamanoAct--;
				return elemento;
			}
			else {
				System.out.println("posicion invalida");
				return null;
			}

		}		 	
	}

	/**
	 * Arroja el primer elemento
	 */

	public T firstElement( ) {
		return tamanoAct==0 ? null:elementos [0] ;
	}


	/**
	 * Arroja el último elemento
	 */

	public T lastElement() {
		return tamanoAct==0 ? null:elementos [tamanoAct-1];
	}

	/**
	 * Intercambia dos elementos dada las posiciones
	 * @param pos1 posicion1
	 * @param pos 2 posicion2
	 */

	public void exchange (int pos1, int pos2) {
		if (pos1 == pos2) {
			return ;	
		}
		if(pos1>=0 && pos1 <= tamanoAct-1 && pos2>=0 && pos2 <= tamanoAct-1) {
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
	 * Contruir un arreglo de datos
	 * @param  arreglo arreglo
	 */

	public void setDatos(Comparable [] arreglo ) {
		elementos = (T[]) arreglo;  
		tamanoMax = arreglo.length; 
		tamanoAct = tamanoMax;
	}


	/**
	 * Introduce un elemento en una posicion dada 
	 * @param pos posicion1
	 * @param elem posicion2
	 */


	public void changeInfo (int pos, T elem) {
		elementos [pos] =elem;

	}


	/**
	 * Da el tamaño o capacidad del arreglo
	 */
	public int darCapacidad() {
		return tamanoMax;
	}


	/**
	 * Busca un dato que es ingresado
	 * @param dato dato a ser buscado
	 */

	public T buscar(T dato) {

		for (int i =0; i< tamanoAct; i++) {
			T datoact = elementos [i];
			if (datoact.compareTo(dato) == 0) {
				return datoact; 
			}

		}
		return null;	 
	}



	/**
	 * Borra todos los datos del arreglo
	 */


	public void eliminartodo() {
		if (isEmpty())
			return;
		for ( int i = 0; i < tamanoAct; i++)
		{
			elementos[i] = null;
		} 
		tamanoAct =0;
	}


	/**
	 * Borra un dato dado del arreglo
	 * @param dato dato a ser eliminado
	 */


	public T eliminar(T dato) {
		for (int i =0; i< tamanoAct; i++) {
			T datoact = elementos [i];
			if (datoact.compareTo(dato) == 0) {
				if(i == tamanoAct-1) {
					elementos [i] =null;
				}
				else { while (i<tamanoAct-1 ) {
					elementos [i] = elementos [i+1];
					i++;
				}
				}
				tamanoAct--; 

				return datoact; 
			}
		}
		return null;

	}

	/**
	 * Agrega en primer puesto un dato 
	 * @param element dato a ser agregado
	 */


	@Override
	public void addFirst(T element) {

		if ( tamanoAct == tamanoMax) 
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = (tamanoMax * 3) / 2 + 1; // Asegura capacidad (Formula ideal)
		}
		T [ ] copia = elementos;
		elementos = (T[]) new Comparable[tamanoMax];

		// Copia el arreglo de los elementos 
		for ( int i = 0; i < copia.length-1; i++)
		{
			elementos[i+1] = copia[i];                 	 
		}    	 
		// Adiciona el elemento al arreglo
		elementos[0] = element;

		// Incrementa el tamaño de la lista 
		tamanoAct++;

	}


	/**
	 * Agrega en ultimo puesto un dato 
	 * @param element elemento a ser agregado
	 */

	@Override
	public void addLast(T element) {
		if ( tamanoAct == tamanoMax) 
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = (tamanoMax * 3) / 2 + 1; // Asegura capacidad (Formula ideal)
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];

			// Copia el arreglo de los elementos 
			for ( int i = 0; i < copia.length; i++)
			{
				elementos[i] = copia[i];

			} 

		}	
		// Adiciona el elemento al arreglo
		elementos[tamanoAct] = element;

		// Incrementa el tamaño de la lista 
		tamanoAct++;

	}

	/**
	 * Da el elemento en la posicion ingresada
	 * @param pos posicion 
	 */

	@Override
	public T getElement(int pos) {
		if ( tamanoAct <= tamanoMax) {
			return elementos[pos];
		}
		return null;
	}


	/**
	 * Da el tamaño del arreglo
	 */

	@Override
	public int size() {
		return tamanoAct;
	}

	/**
	 * verifica si esta vacio el arreglo 
	 */

	@Override
	public boolean isEmpty() {
		return tamanoAct==0;
	}


	/**
	 * Verifica si existe un elemento en el arreglo
	 */

	@Override
	public int isPresent(T element) {
		for (int i =0; i< tamanoAct; i++) {
			T datoact = elementos [i];
			if (datoact.compareTo(element) == 0) {
				return i; 
			}
		}
		return -1;	 
	}
}






