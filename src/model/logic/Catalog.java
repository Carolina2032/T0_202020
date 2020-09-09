package model.logic;

import model.data_structures.ArregloDinamico;

/**
 * Representa un catalogo de pelicuals
 */

public class Catalog {

	/**
	 * atributos
	 */


	public ArregloDinamico<Movie> peliculas;

	/**
	 * constructor
	 */


	public Catalog () {
		peliculas = new ArregloDinamico<Movie>();
	}

	/**
	 * Genera Arreglo dinamico de peliculas con una capidad dada
	 * @param capacidad tamaño
	 */

	public Catalog (int capacidad) {
		peliculas = new ArregloDinamico<Movie>(capacidad);
	}


}
