package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.data_structures.ShellSort;
import model.data_structures.TablaHashLinearProbing;
import model.data_structures.TablaHashSeparateChaining;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */

	private ArregloDinamico <Integer> datos;

	public static String ARCHIVO = "/Users/anabulla/reto2/T3_202020/data/AllMoviesFull.csv";

	public TablaHashLinearProbing <String, Movie> LP;
	
	public TablaHashSeparateChaining<String, Movie> SC;

	private Catalog catalogo;

	private ShellSort sort; 

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico <Integer> (7);
		catalogo = new Catalog();
		sort = new ShellSort();
		LP = new TablaHashLinearProbing<String, Movie>(1);
		SC = new TablaHashSeparateChaining<String, Movie>(1);
		
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico <Integer> (capacidad);
		catalogo = new Catalog(capacidad);
		sort = new ShellSort();
		LP = new TablaHashLinearProbing<String, Movie>(1);
		SC = new TablaHashSeparateChaining<String, Movie>(1);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Integer dato)
	{	
		datos.addLast(dato);;
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return datos.eliminar(dato);
	}


	/**
	 * Carga los datos
	 */
	public String cargaDatos() {

		int MLP = LP.M;
		int MSC	= SC.M;
				
		Integer idPeliculaAct = -1; 

		FileReader fr1 = null;
		FileReader fr2 = null;

		try {


			File archivo2 = new File(ARCHIVO);
			archivo2.createNewFile();



			fr2 = new FileReader (archivo2);


			BufferedReader br2 = new BufferedReader (fr2);

			String lineaActual = br2.readLine();

			Integer contador = 0;

			while ((lineaActual=br2.readLine())!=null) {

				String[] atributos = lineaActual.split(";") ;
				Movie peliculaAct = new Movie (Integer.parseInt(atributos[0])) ;
				idPeliculaAct = Integer.parseInt(atributos[0]);
				
				peliculaAct.setBudget(Double.parseDouble(atributos [1]));
				
				String [] generos = atributos[2].split(",");
				ArregloDinamico<String> arregloGeneros = new ArregloDinamico <String>() ;
				
				for (String genero: generos ) {
					arregloGeneros.addLast(genero );
				}
				peliculaAct.setGenre(arregloGeneros);

				peliculaAct.setImbdID(atributos[3]);
				peliculaAct.setLanguage(atributos[4]);
				peliculaAct.setoriginalTitle(atributos[5]);
				peliculaAct.setOverview(atributos[6]);
				peliculaAct.setPopularity(atributos[7]);
				peliculaAct.setProductionCompany(atributos[8]);
				peliculaAct.setProductionCountry(atributos[9]);
				peliculaAct.setReleaseDate(atributos[10]);
				peliculaAct.setRevenue(Integer.parseInt(atributos[11]));
				peliculaAct.setRunTime(Integer.parseInt(atributos[12]));
				peliculaAct.setSpokenLanguage(atributos[13]);
				peliculaAct.setStatus(atributos[14]);
				peliculaAct.setTagLine(atributos[15]);
				peliculaAct.setTitle(atributos[16]);
				
				peliculaAct.setVoteAverage(Double.parseDouble(atributos[17]));	
				
				peliculaAct.setCount(Integer.parseInt(atributos [18]));
				peliculaAct.setProductionCompanies(Integer.parseInt(atributos[19]));
				peliculaAct.setProductionCountries(Integer.parseInt(atributos[20]));
				peliculaAct.setSpokenLanguages(Integer.parseInt(atributos[21]));
				
				
				
				ArregloDinamico<Actor> actores = peliculaAct.getActores();

				for (int j = 22; j < 31; j++) {
					Actor actorAct = new Actor(atributos [j],Integer.parseInt(atributos [j+1])); 
					j++;
					actores.addLast(actorAct);;

				}

				peliculaAct.setActores(actores);

				peliculaAct.setNumberActors(Integer.parseInt(atributos[32]));
				Director director = new Director (atributos[33],Integer.parseInt(atributos [34])) ;

				peliculaAct.setDirectores(director);
				peliculaAct.setNumberDirectors(Integer.parseInt(atributos[35]));

				Producer productor = new Producer (atributos [36]);
				peliculaAct.setProductor(productor);

				peliculaAct.setNumberProducers(Integer.parseInt(atributos [37]));

				ScreenPlay screenplay = new ScreenPlay (atributos[38]);
				peliculaAct.setScreenplay(screenplay);

				Editor editor= new Editor (atributos[39]);
				peliculaAct.setEditor(editor);


				catalogo.peliculas.addLast(peliculaAct);
				
				String key = peliculaAct.getProductionCompany()+ peliculaAct.getReleaseDate();
				
				LP.put(key, peliculaAct);
				
				SC.put(key, peliculaAct);
			}

			System.out.println("Total de películas encontradas: "+ catalogo.peliculas.size()+ "\n" + "\nPrimera película: "  + "\n" + catalogo.peliculas.firstElement().darInformacionReq1() + "\nUltima pelicula: "+ "\n" + catalogo.peliculas.lastElement().darInformacionReq1());

			return "\n El numero de tuplas para la tabla LinearProbing fue: " + LP.size() + "\n El numero de tuplas para la tabla SeparateChaining fue: " + SC.size() + "\n El tamaño inicial en LinearProbing fue: " + MLP + "\n El tamaño inicial en SeparateChaining fue: " + MSC +  "\n El tamaño final en LinearProbing fue: " + LP.M + "\n El tamaño final en SeparateChaining fue: " + SC.M + "\n El factor de carga en LinearProbing fue: " + (LP.size()/LP.M) + "\n El factor de carga en SeparateChaining fue: " + (SC.size()/SC.M) + "\n El numero de rehashes en LinearProbing fue: " + LP.rehashes + "\n El numero de rehashes en SeparateChaining fue: " + SC.rehash ;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error fatal: en pelicula " + idPeliculaAct + " descripción error: " + e.getMessage() );
		}
		finally {
			try {

				if (null!= fr2) {
					fr2.close();
				}
			}
			
			catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return "se presento un error";
	}


	/**
	 * Da el catalogo
	 * @return 
	 */

	public Catalog getCatalogo() {
		return catalogo;
	}


	/**
	 * Da el catalogo
	 * @param catalogo
	 */

	public void setCatalogo(Catalog catalogo) {
		this.catalogo = catalogo;
	}


	/**
	 * Requerimiento uno
	 * @param nombreDirector nombre del director a buscar
	 * @return 
	 */
	public String requerimiento1Reto1(String nombreDirector) {

		int contador=0;
		Double sumatoriaVotos=0.0;
		ArregloDinamico<Movie> peliculas = new ArregloDinamico<Movie>(); 

		for (int i = 0; i < catalogo.peliculas.size() ; i++) {

			Movie peliculaAct = catalogo.peliculas.getElement(i);


			String nombreDirectorActual = peliculaAct.getDirectores().getDirectorName();

			if (nombreDirectorActual.equalsIgnoreCase(nombreDirector) && peliculaAct.getVoteAverage()>= 6.0 ) {

				contador++;
				sumatoriaVotos+=catalogo.peliculas.getElement(i).getVoteAverage();	
				peliculas.addLast(peliculaAct);
			}

		}
		if (contador == 0) {
			return "No se han encontrado peliculas del director especificado";
		}
		else {

			double resultado= sumatoriaVotos/contador;
			String respuesta = "---------------\n" + "Director buscado: "+ nombreDirector+ "\n# Películas buenas (promedio >=6): "+contador+" \nPromedio de votación: "+ resultado + " \n";

			for (int i =0; i< peliculas.size();i++) {

				respuesta = respuesta + "\nPelicula Número " + (i+1);
				respuesta =respuesta + peliculas.getElement(i).darInformacionReq1();
			}

			return respuesta; 

		}	

	}

	/**
	 * Requerimiento dos
	 * @param tipoComparacion tipod e comapracion
	 * @param ascendente ascendente o descendente
	 * @param numeroDatos numero de datos que se quieren arrojar
	 * @return 
	 */

	public String requerimiento2Reto1 (int tipoComparacion, boolean ascendente, int numeroDatos ) {

		String respuesta = "\nEl ranking de las " + numeroDatos + " películas son:" + " \n " ;

		for (int i = 0 ; i< catalogo.peliculas.size(); i++) {
			Movie peliculaAct = catalogo.peliculas.getElement(i);
			peliculaAct.setTipoComparacion(tipoComparacion);
			peliculaAct.setAscendente(ascendente);
			catalogo.peliculas.changeInfo(i, peliculaAct);		

		}
		Comparable  [] peliculas = catalogo.peliculas.darDatos();
		sort.sort(peliculas);

		for (int i= 0 ;i < numeroDatos; i++ ) {
			Movie peliculaAct = (Movie) peliculas[i];
			respuesta = respuesta + "\nPelícula en posición # " + (i+1) + peliculaAct.darInformacionReq2();	
		}
		return respuesta;

	}


	/**
	 * Requerimiento tres
	 * @param nombreDirector nombre del director a buscar
	 * @return 
	 */

	public String requerimiento3Reto1(String nombreDirector ){

		String respuesta = "\nLas peliculas del director(a) " + nombreDirector + " son: " + "\n" ;
		Integer contador = 0 ;
		Double promedio = 0.0 ;   



		for (int i = 0 ; i<catalogo.peliculas.size();i++) {
			Movie peliculaAct = catalogo.peliculas.getElement(i);

			if (peliculaAct.getDirectores().getDirectorName().equals(nombreDirector) ) {
				contador++;
				promedio += peliculaAct.getVoteAverage();
				respuesta = respuesta + "\nPelicula # "  + contador +  "\n" + peliculaAct.darInformacionBasica();
			}
		}

		if ( contador ==0) {
			respuesta =  "\nEl director especificado no tiene películas registradas" + "\n" ;
		}
		else {
			promedio = promedio/contador;  
			respuesta = respuesta + "\nEl número de películas encontradas: " + contador +  "\nEl promedio de calificación de sus películas es de: " + promedio + "\n" ;
		}

		return respuesta; 
	}



	/**
	 * Requerimiento cuatro
	 * @param nombreActor nombre del actor a buscar
	 * @return
	 */
	public String requerimiento4Reto1(String nombreActor){

		String respuesta = "\nLas películas del actor " + nombreActor + " son: " + "\n";
		Integer contador = 0 ;
		Double promedio = 0.0 ;   
		ArregloDinamico <String> directores = new ArregloDinamico <String >();
		int numeroMaxApariciones = 0;
		String directorMasApariciones = "";

		for (int i = 0 ; i<catalogo.peliculas.size();i++) {

			Movie peliculaAct = catalogo.peliculas.getElement(i);
			for ( int j= 0 ;j< peliculaAct.getActores().size(); j++ ) {

				if (peliculaAct.getActores().getElement(j).getActorOne().equals(nombreActor))  {
					directores.addLast(peliculaAct.getDirectores().getDirectorName());
					contador++;
					promedio += peliculaAct.getVoteAverage();
					respuesta = respuesta + "\nPelicula # " + contador + peliculaAct.darInformacionBasica();

				}
			}
		}

		for (int i =0;i< directores.size();i++) {
			int numeroApariciones =0;
			String nombreDirector = directores.getElement(i);
			for (int j=0; j<directores.size();j++) {
				if(directores.getElement(j).equals(nombreDirector)) {
					numeroApariciones++;

				}
			}
			if (numeroApariciones > numeroMaxApariciones ) {
				numeroMaxApariciones = numeroApariciones ;
				directorMasApariciones = nombreDirector;
			}
		}


		if ( contador ==0) {
			respuesta =  "\nEl actor especificado no tiene películas registradas"  + "\n";
		}
		else {

			promedio = promedio/contador;  
			respuesta = respuesta + "\nEl número de películas en las que participó: " + contador + "\nPromedio de calificación de sus películas: " + promedio + " \nEl director con más colaboraciones fue: " + directorMasApariciones + " \n";

		}

		return respuesta; 
	}


	/**
	 * Requerimiento cinco
	 * @param nombreGenero nombre del  genero a buscar
	 * @return
	 */

	public String requerimiento5Reto1(String nombreGenero ){

		String respuesta = "\nLas películas asociadas al género " + nombreGenero + " son: "  + "\n";
		Integer contador = 0 ;
		Double promedio = 0.0 ;   


		for (int i = 0 ; i<catalogo.peliculas.size();i++) {

			Movie peliculaAct = catalogo.peliculas.getElement(i);
			for ( int j= 0 ;j< peliculaAct.getGenre().size(); j++ ) {

				if (peliculaAct.getGenre().getElement(j).contains(nombreGenero))  {

					contador++;
					promedio += peliculaAct.getCount();
					respuesta = respuesta + "\nPelicula # " + contador + peliculaAct.darInformacionBasica();
					break;
				}
			}
		}

		if ( contador ==0) {
			respuesta =  "\nEl genero especificado no tiene películas registradas" + "\n";
		}
		else {

			promedio = promedio/contador;  
			respuesta = respuesta + "\nEl número de películas fue: " + contador + " \nPromedio de votos del género: " + promedio + "\n" ;

		}

		return respuesta; 
	}

	/**
	 * Requerimiento seis
	 * @param tipoComparacion tipod e comparacion
	 * @param ascendente ascendente o descendente
	 * @param numeroDatos numero de datos que se quieren arrojar
	 * @param genero genero que se desea bsucar
	 * @return 
	 */


	public String requerimiento6Reto1 (int tipoComparacion, boolean ascendente, int numeroDatos, String genero  ) {

		String respuesta = "\nEl ranking solicitado de las " + numeroDatos + " películas del género " + genero +  " son:" + " \n " ;
		ArregloDinamico<Movie> peliculasGenero = new ArregloDinamico<Movie>();
		int contador = 0;
		Double promedio = 0.0;

		for (int i = 0 ; i< catalogo.peliculas.size(); i++) {
			Movie peliculaAct = catalogo.peliculas.getElement(i);
			for (int j=0;j< peliculaAct.getGenre().size();j++) {
				if(peliculaAct.getGenre().getElement(j).contains(genero)){


					peliculaAct.setTipoComparacion(tipoComparacion);
					peliculaAct.setAscendente(ascendente);
					peliculasGenero.addLast(peliculaAct); 
					contador++;
				}
			}
		}
		Comparable  [] peliculas = peliculasGenero.darDatos();
		sort.sort(peliculas);

		if(peliculas.length==0) {
			respuesta = "El género especificado no tiene películas registradas en la base de datos";
		}
		else {
			for (int i= 0 ;i < numeroDatos; i++ ) {


				Movie peliculaAct = (Movie) peliculas[i];

				if (tipoComparacion==1 ) {

					promedio+= peliculaAct.getVoteAverage();


				}else {
					promedio += peliculaAct.getCount();



				}			
				respuesta = respuesta + "\nPelícula en posición # " + (i+1) + peliculaAct.darInformacionReq2();
			}
			promedio = promedio/numeroDatos;

			respuesta= respuesta + "\nEl número de películas total del género fue: " +  contador + "\n" +  " \nPromedio del ranking solicitado " + promedio + "\n";	
		}


		return respuesta  ;

	}
	
	
	public void requerimiento1Reto2 (String productionCompany, String releaseDate) {
		Integer contador =0;
		String key = productionCompany + releaseDate;
		ListaEncadenada <Movie> peliculas = LP.get(key);
		 if (peliculas==null) {
			 System.out.println("No se ha encontrado ninguna pelicula con compañia de produccion y fecha especificadas");
		 }
		 else {
			 for(int i = 0; i<peliculas.size();i++) {
				System.out.println("\nPelicula #: " + (i+1) + "\nInformacion pelicula: " + peliculas.getElement(i).darInformacionReq1()  );
				contador++;
				
			 }
			 System.out.println("\nEl número de películas encontradas: " + contador);
		 }
	}

	public void requerimiento2Reto2 (String productionCompany, String releaseDate) {
		Integer contador =0;
		String key = productionCompany + releaseDate;
		ListaEncadenada <Movie> peliculas = SC.get(key);
		 if (peliculas==null) {
			 System.out.println("No se ha encontrado ninguna pelicula con compañia de produccion y fecha especificadas");
		 }
		 else {
			 for(int i = 0; i<peliculas.size();i++) {
				System.out.println("\nPelicula #: " + (i+1) + "\nInformacion pelicula: " + peliculas.getElement(i).darInformacionReq1()  );
				contador++;
			 }
			 System.out.println("\nEl número de películas encontradas: " + contador);
		 }
	}
	
	public void requerimiento3Reto2 () {
		ListaEncadenada <String> keySetLP = (ListaEncadenada <String>)LP.keySet() ;
		ListaEncadenada <String> keySetSC =  (ListaEncadenada <String>)SC.keySet() ;
		Long inicio = System.currentTimeMillis();
		
		for (int i=0; i< 800;i++) {
			String key = keySetLP.getElement((int)Math.random()*LP.size());
			ListaEncadenada<Movie> consulta = LP.get(key);
			
		}
		for (int i=0; i< 200;i++) {
			byte[] array = new byte[7]; // length is bounded by 7
			new Random().nextBytes(array);
			String key = new String(array, Charset.forName("UTF-8"));
			ListaEncadenada<Movie> consulta = LP.get(key);			
		}
		Long fin = System.currentTimeMillis();
		Long tiempoConsultaLP = (fin-inicio)/1000;
		inicio = System.currentTimeMillis();
		
		for (int i=0; i< 800;i++) {
			String key = keySetSC.getElement((int)Math.random()*SC.size());
			ListaEncadenada<Movie> consulta = SC.get(key);
		}
		
		for (int i=0; i< 200;i++) {
			byte[] array = new byte[7]; // length is bounded by 7
			new Random().nextBytes(array);
			String key = new String(array, Charset.forName("UTF-8"));
			ListaEncadenada<Movie> consulta = SC.get(key);
			
		}
		fin = System.currentTimeMillis();
		Long tiempoConsultaSC = (fin-inicio)/1000;
		
		System.out.println("\nTiempo de consulta promedio de Linear Probing: " + tiempoConsultaLP + "\nTiempo de consulta promedio de Separate Chaining: " + tiempoConsultaSC );
		
	}
}
