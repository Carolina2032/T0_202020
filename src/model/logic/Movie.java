package model.logic;

import model.data_structures.ArregloDinamico;
/**
 * Representa una pelicula
 */

public class Movie implements Comparable <Movie> {


	/**
	 * Atributos
	 */

	private Integer id;
	private double budget;
	private String language;
	private String originalTitle;
	private String overview;
	private String popularity;
	private String productionCompany;
	private String imbdID;
	private String productionCountry;
	private ArregloDinamico<Actor> actores;
	private Director director;
	private Producer productor;
	private ScreenPlay screenplay;
	private Editor editor;
	private ArregloDinamico <String> genre;
	private String releaseDate;
	private Integer revenue;
	private Integer runTime;
	private String spokenLanguage;
	private String status;
	private String tagLine;
	private String title;
	private Double voteAverage;
	private Integer count;
	private Integer productionCompanies;
	private Integer productionCountries;
	private Integer spokenLanguages;
	private Integer numberActors;
	private Integer numberDirectors;
	private Integer numberProducers;
	private Integer tipoComparacion; 
	private Boolean ascendente;

	/**
	 * Constructor de pelicula
	 */


	public Movie (int id) {
		this.id = id;
		actores = new ArregloDinamico<Actor>();
		genre = new ArregloDinamico<String> ();
	}


	/**
	 * Arroja la informacion basica de la pelicula
	 * @return 
	 */

	public String darInformacionBasica() {

		String respuesta = "\nID: " + id + "\nTitle: " + title + "\nRelease Date: " + releaseDate + "\nGenre: ";

		for(int i = 0; i< genre.size(); i++){
			respuesta = respuesta  + genre.getElement(i) ;

		}



		return respuesta + "\n";

	}



	/**
	 * Arroja la informacion basica de la pelicula para el requ 1
	 * @return 
	 */
	public String darInformacionReq1() {

		String respuesta = "\nID: " + id + "\nTitle: " + title + "\nRelease Date: " + releaseDate + "\nGenre: " ;


		for(int i = 0; i< genre.size(); i++){
			respuesta = respuesta  + genre.getElement(i) ;
		}

		respuesta =respuesta + "\nActores: " ;

		for(int i = 0; i< actores.size(); i++){	
			respuesta = respuesta +  "\nActor " + (i+1) + ": " + actores.getElement(i).getActorOne();	
		}		

		return respuesta + "\n";
	}


	/**
	 * Arroja la informacion basica de la pelicula para el req 2
	 * @return 
	 */


	public String darInformacionReq2() {

		String respuesta = "\nID: " + id + "\nTitle: " + title + "\nRelease Date: " + releaseDate + "\nGenre: " ;



		for(int i = 0; i< genre.size(); i++){
			respuesta = respuesta  + genre.getElement(i) ;
		}
		if (getTipoComparacion()==1) {
			respuesta = respuesta +"\nAverage:" +voteAverage;

		}
		else {
			respuesta = respuesta +"\nCount:" +count;
		}


		respuesta =respuesta + "\nActores: " ;

		for(int i = 0; i< actores.size(); i++){	
			respuesta = respuesta +  "\nActor " + (i+1) + ": " + actores.getElement(i).getActorOne();	
		}		

		return respuesta + "\n";
	}



	/**
	 * Arroja el presupuesto
	 * @return 
	 */
	public double getBudget() {
		return budget;
	}


	/**
	 * Da el Budget
	 */

	public void setBudget(double budget) {
		this.budget = budget;
	}


	/**
	 * Arroja el lenguaje
	 * @return 
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Da el lenguaje
	 */


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getoriginalTitle() {
		return originalTitle;
	}

	public void setoriginalTitle(String title) {
		this.originalTitle = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getProductionCompany() {
		return productionCompany;
	}

	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}

	public String getImbdID() {
		return imbdID;
	}

	public void setImbdID(String imbdID) {
		this.imbdID = imbdID;
	}

	public ArregloDinamico <String> getGenre() {
		return genre;
	}

	public void setGenre(ArregloDinamico <String> genre) {
		this.genre = genre;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int compareTo(Movie movie) {

		int respuesta = 0 ;

		switch(tipoComparacion){



		case -1://Exclusivo para la carga de datos
			respuesta = id.compareTo(movie.getId());


			break;


		case 0: //Comparacion por votos 
			if (ascendente) { 

				respuesta =  count.compareTo(movie.getCount());			
			}
			else {

				respuesta = - count.compareTo(movie.getCount());	

			}
			break;

		case 1: //Comparacion por promedio
			if (ascendente) { 

				respuesta =  voteAverage.compareTo(movie.getVoteAverage());
			}
			else {

				respuesta = - voteAverage.compareTo(movie.getVoteAverage());	

			}
			break;



		}			

		return respuesta;
	}

	public String getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(String productionCountry) {
		this.productionCountry = productionCountry;
	}

	public ArregloDinamico<Actor> getActores() {
		return actores;
	}

	public void setActores(ArregloDinamico<Actor> actores) {
		this.actores = actores;
	}


	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public Integer getRevenue() {
		return revenue;
	}



	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}



	public String getSpokenLanguage() {
		return spokenLanguage;
	}



	public void setSpokenLanguage(String spokenLanguage) {
		this.spokenLanguage = spokenLanguage;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Integer getRunTime() {
		return runTime;
	}



	public void setRunTime(Integer runTime) {
		this.runTime = runTime;
	}



	public String getTagLine() {
		return tagLine;
	}



	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}



	public double getVoteAverage() {
		return voteAverage;
	}



	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}



	public Integer getProductionCompanies() {
		return productionCompanies;
	}



	public void setProductionCompanies(Integer productionCompanies) {
		this.productionCompanies = productionCompanies;
	}



	public Integer getProductionCountries() {
		return productionCountries;
	}



	public void setProductionCountries(Integer productionCountries) {
		this.productionCountries = productionCountries;
	}



	public Integer getSpokenLanguages() {
		return spokenLanguages;
	}



	public void setSpokenLanguages(Integer spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getNumberActors() {
		return numberActors;
	}



	public void setNumberActors(Integer numberActors) {
		this.numberActors = numberActors;
	}



	public Director getDirectores() {
		return director;
	}



	public void setDirectores(Director directores) {
		this.director = directores;
	}



	public Producer getProductor() {
		return productor;
	}



	public void setProductor(Producer productor) {
		this.productor = productor;
	}



	public Editor getEditor() {
		return editor;
	}



	public void setEditor(Editor editor) {
		this.editor = editor;
	}



	public ScreenPlay getScreenplay() {
		return screenplay;
	}



	public void setScreenplay(ScreenPlay screenplay) {
		this.screenplay = screenplay;
	}



	public Integer getNumberDirectors() {
		return numberDirectors;
	}



	public void setNumberDirectors(Integer numberDirectors) {
		this.numberDirectors = numberDirectors;
	}



	public Integer getNumberProducers() {
		return numberProducers;
	}



	public void setNumberProducers(Integer numberProducers) {
		this.numberProducers = numberProducers;
	}

	public Integer getTipoComparacion() {
		return tipoComparacion;
	}

	public void setTipoComparacion(Integer tipoComparacion) {
		this.tipoComparacion = tipoComparacion;
	}

	public Boolean getAscendente() {
		return ascendente;
	}

	public void setAscendente(Boolean ascendente) {
		this.ascendente = ascendente;
	}

}
