package model.logic;

/**
 * Representa un director
 */

public class Director implements Comparable <Director> {
	
	
	/**
	 * Atributos 
	 */
	
	private String name;

	
	public enum Gender { 
		NONE,
		MALE,
		FEMALE
	}
	
	private Gender gender;
	
	/**
	 * Constructor de director
	 * @param actorOne director
	 * @param gender genero del director
	 */
	
	public Director(String nombreDirector, int gender) {
		this.setDirectorName(nombreDirector);
		
	if (gender == 0 ) {
		setDirectorGender(Gender.NONE);
		}
	else if ( gender ==1) {
		setDirectorGender(Gender.FEMALE);
		}
	else  {
		setDirectorGender(Gender.MALE);
		}
	}  
	
	
	/**
	 * Compara contra un director dado
	 * @param director
	 */
	
	@Override
	public int compareTo(Director director) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	/**
	 * Da el genero del director
	 */

	public Gender getDirectorGender() {
		return gender;
	}


	/**
	 * Constructor genero de director
	 */
	public void setDirectorGender(Gender directorGender) {
		this.gender = directorGender;
	}
	
	/**
	 * Da el nombre del director
	 */

	public String getDirectorName() {
		return name;
	}



	/**
	 * Constructor nombre de director
	 */
	public void setDirectorName(String directorName) {
		this.name = directorName;
	}
}
