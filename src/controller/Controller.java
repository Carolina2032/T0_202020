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
					modelo.cargaDatos();
					long endTime = System.currentTimeMillis();
					long delta = endTime-startTime;
					view.printMessage("---------\nArchivo Cargado tiempo de carga: " + delta + " milisegundo");
					break;
					
				case 1: 
					view.printMessage("\nPor favor ingrese el nombre del director ");
					String name = entradaEscaner.nextLine();
					long startTime1 = System.currentTimeMillis();
					view.printMessage(modelo.requerimiento1(name));
					long endTime1 = System.currentTimeMillis();
					long delta1 = endTime1 - startTime1; 
					view.printMessage("--------------------\n");
					view.printMessage("Requerimiento 1 terminado. Tiempo de ejecucion: " + delta1 + " milisegundos");
					break;
					
				case 2: 
					view.printMessage("RANKING DE PELICULAS " );
					view.printMessage("");
					view.printMessage("0. Por Votación" );
					view.printMessage("1. Por Promedio " );
					view.printMessage("");
					view.printMessage("Por favor ingrese el número correspondiente al tipo de comparación");
					int tipoComparacion = entradaEscaner.nextInt();		
					
					
					if (tipoComparacion == 0) {
						view.printMessage("0. Las menos votadas"); 
						view.printMessage("1. Las más votadas");
						view.printMessage("");
					}
					else {
						view.printMessage("0. Las peor calificadas"); 
						view.printMessage("1. Las mejor calificadas");
						view.printMessage("");
					}
					
					view.printMessage("Por favor ingrese el número correspondiente al tipo de ordenamiento");
					int tipoOrdenamiento = entradaEscaner.nextInt();
					view.printMessage("Por favor ingrese el número de datos que desea que se muestren (min) 10 ");
					int numeroDatos = entradaEscaner.nextInt(); 
					
					
					
					if ((tipoComparacion==0 || tipoComparacion ==1) && (tipoOrdenamiento ==0 || tipoOrdenamiento ==1) && numeroDatos > 9) {
						long startTime2 = System.currentTimeMillis();
						view.printMessage(modelo.requerimiento2(tipoComparacion, tipoOrdenamiento ==0, numeroDatos));
						long endTime2 = System.currentTimeMillis();
						long delta2 = endTime2 - startTime2; 
						view.printMessage("--------------------\n");
						view.printMessage("Requerimiento 2 terminado. Tiempo de ejecucion: " + delta2 + " milisegundos");
					}
					else {
						view.printMessage("Alguno de los datos ingresados es invalido, por favor intente de nuevo ");
						view.printMessage("");
					}
					break;
				
				case 3: 
					
					view.printMessage(" Por favor ingrese el nombre del director(a) ");
					String nombreDirector = entradaEscaner.nextLine();
					long startTime3 = System.currentTimeMillis();
					view.printMessage(modelo.requerimiento3(nombreDirector));
					long endTime3 = System.currentTimeMillis();
					long delta3 = endTime3 - startTime3; 
					view.printMessage("Requerimiento 3 terminado. Tiempo de ejecucion: " + delta3 + " milisegundos" + "\n-------------------------");
					break;
					
				case 4: 
					view.printMessage(" Por favor ingrese el nombre del actor ");
					String nombreActor = entradaEscaner.nextLine();
					long startTime4 = System.currentTimeMillis();
					view.printMessage(modelo.requerimiento4(nombreActor));
					long endTime4 = System.currentTimeMillis();
					long delta4 = endTime4 - startTime4; 
					view.printMessage("Requerimiento 4 terminado. Tiempo de ejecucion: " + delta4 + " milisegundos"  + "\n-------------------------");
					break;
					
					
				case 5: 
					view.printMessage(" Por favor ingrese el nombre del genero");
					String nombreGenero = entradaEscaner.nextLine();
					long startTime5 = System.currentTimeMillis();
					view.printMessage(modelo.requerimiento5(nombreGenero));
					long endTime5 = System.currentTimeMillis();
					long delta5 = endTime5 - startTime5; 
					view.printMessage("Requerimiento 5 terminado. Tiempo de ejecucion: " + delta5 + " milisegundos"  + "\n-------------------------");
					break;
					
					
				case 6: 
				
					
					view.printMessage("Ingrese el nombre del genero");
					String genero = entradaEscaner.nextLine();
					view.printMessage("RANKING DE PELICULAS " );
					view.printMessage("");
					view.printMessage("0. Por Votación" );
					view.printMessage("1. Por Promedio " );
					view.printMessage("");
					view.printMessage("Por favor ingrese el número correspondiente al tipo de comparación");
					
					int tipoComparacion6 = entradaEscaner.nextInt();		
					
					
					if (tipoComparacion6 == 0) {
						view.printMessage("0. Las menos votadas"); 
						view.printMessage("1. Las más votadas");
						view.printMessage("");
					}
					else {
						view.printMessage("0. Las peor calificadas"); 
						view.printMessage("1. Las mejor calificadas");
						view.printMessage("");
					}
					
					view.printMessage("Por favor ingrese el número correspondiente al tipo de ordenamiento");
					int tipoOrdenamiento6 = entradaEscaner.nextInt();
					view.printMessage("Por favor ingrese el número de datos que desea que se muestren (min) 10 ");
					int numeroDatos6 = entradaEscaner.nextInt(); 
					
					if ((tipoComparacion6==0 || tipoComparacion6 ==1) && (tipoOrdenamiento6 ==0 || tipoOrdenamiento6 ==1) && numeroDatos6 > 9) {
						long startTime6 = System.currentTimeMillis();
						view.printMessage(modelo.requerimiento6(tipoComparacion6, tipoOrdenamiento6 ==0, numeroDatos6, genero));
						long endTime6 = System.currentTimeMillis();
						long delta6 = endTime6 - startTime6; 
						view.printMessage("--------------------\n");
						view.printMessage("Requerimiento 6 terminado. Tiempo de ejecucion: " + delta6 + " milisegundos"  + "\n-------------------------");
					}
					else {
						view.printMessage("Alguno de los datos ingresados es invalido, por favor intente de nuevo ");
						view.printMessage("");
					}
					break;
				

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
