package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(500000);
	}
		
	
	
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer dato = 0;
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			Scanner entradaEscaner = new Scanner (System.in);
			switch(option){
			
			
				case 0:
					view.printMessage("---------\nCargando...");
					long startTime =System.currentTimeMillis();
					view.printMessage(modelo.cargaDatos());
					long endTime = System.currentTimeMillis();
					long delta = endTime-startTime;
					view.printMessage("---------\nArchivo Cargado tiempo de carga: " + delta + " milisegundo");
					break;
					
				case 1: 
					view.printMessage("\nPor favor ingrese el nombre de la compañia de produccion ");
					String name = entradaEscaner.nextLine();
					view.printMessage("\n Por favor ingrese la fecha de estreno (DD/MM/AA)" );
					String fecha = entradaEscaner.nextLine();
					long startTime1 = System.currentTimeMillis();
					modelo.requerimiento1Reto2(name, fecha);
					long endTime1 = System.currentTimeMillis();
					long delta1 = endTime1 - startTime1; 
					view.printMessage("--------------------\n");
					view.printMessage("Requerimiento 1 terminado. Tiempo de ejecucion: " + delta1 + " milisegundos");
					break;
					
				case 2: 
					view.printMessage("\nPor favor ingrese el nombre de la compañia de produccion ");
					String name2 = entradaEscaner.nextLine();
					view.printMessage("\n Por favor ingrese la fecha de estreno (DD/MM/AA)" );
					String fecha2 = entradaEscaner.nextLine();
					long startTime2 = System.currentTimeMillis();
					modelo.requerimiento2Reto2(name2, fecha2);
					long endTime2 = System.currentTimeMillis();
					long delta2 = endTime2 - startTime2; 
					view.printMessage("--------------------\n");
					view.printMessage("Requerimiento 1 terminado. Tiempo de ejecucion: " + delta2 + " milisegundos");
					break;
					
				case 3: 
					
					
					long startTime3 = System.currentTimeMillis();
					modelo.requerimiento3Reto2();
					long endTime3 = System.currentTimeMillis();
					long delta3 = endTime3 - startTime3; 
					view.printMessage("Requerimiento 3 terminado. Tiempo de ejecucion: " + delta3 + " milisegundos" + "\n-------------------------");
					break;
											
			}
		}
		
	}	
}
