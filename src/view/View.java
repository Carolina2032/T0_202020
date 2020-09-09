package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("0. Realizar la carga de las fuentes de datos de las peliculas");
			System.out.println("1. Encontrar buenas películas");
			System.out.println("2. Crear Ranking de películas");
			System.out.println("3. Conocer a un director");
			System.out.println("4. Conocer a un actor");
			System.out.println("5. Entender un género cinematográfico");
			System.out.println("6. Crear Ranking del género");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
			
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
