package model.logic;

/**
 * Representa un Screen player
 */

public class ScreenPlay implements Comparable <ScreenPlay> {
	
	/**
	 * Atributos
	 */

	private String name;
	

	/**
	 * Cosntructor
	 */

	
	public ScreenPlay (String escritor) {
		this.setEscritor(escritor);
	
	}  
	
	
	/**
	 * comapra dos elementos
	 */
	
	@Override
	public int compareTo(ScreenPlay screenPlay) {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getEscritor() {
		return name;
	}



	public void setEscritor(String escritor) {
		this.name = escritor;
	}
}
