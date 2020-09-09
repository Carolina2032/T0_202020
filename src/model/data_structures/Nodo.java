package model.data_structures;


/** Representa un nodo
 * 
 */
public class Nodo<T> {
	
	private T dato;
    private Nodo<T> next;
 
    /**
     * Constructor por defecto
     */
    public Nodo(){
        next=null;
     }
 
    /**
     * Le pasamos un dato al nodo
     * @param p 
     */
    public Nodo(T p){
        next=null;
        dato = p;
    }
 
    /**
     * Le pasamos un dato y su siguiente nodo al nodo
     * @param t Dato a insertar
     * @param siguiente Su siguiente nodo
     */
    public Nodo(T t, Nodo<T> siguiente){
        this.next=siguiente;
        dato = t;
    }
     

    /**
     * Arroja un  dato 
     */
    
    public T getDato() {
        return dato;
    }
 

    /**
     * Obtiene el  dato del nodo
     * @param T Dato solicitado
     */
    
    public void setDato(T dato) {
        this.dato = dato;
    }
 

    /**
     * Obtiene el siguiente nodo
     */
    public Nodo<T> getSiguiente() {
        return next;
    }
 

    /**
     * Arroja el siguiente Nodo
     * @param siguiente nodo a buscar el siguiente
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.next = siguiente;
    }
}
