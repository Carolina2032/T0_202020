package model.logic;

/** Representa un Actor
 * 
 */
public class Actor  implements Comparable <Actor> {


	/**
	 * Atributos
	 */
	private String name;


	/**
	 * Genero del actor
	 */
	public enum Gender { 
		NONE,
		MALE,
		FEMALE
	}

	private Gender gender;

	/**
	 * Constructor de actor
	 * @param actorOne actor
	 * @param gender genero
	 */


	public Actor (String actorOne, int gender) {
		this.setActorOne(actorOne);

		if (gender == 0 ) {
			setActorOneGender(Gender.NONE);
		}
		else if ( gender ==1) {
			setActorOneGender(Gender.FEMALE);
		}
		else  {
			setActorOneGender(Gender.MALE);
		}
	}  

	/**
	 * Compara actor
	 */
	@Override
	public int compareTo(Actor actor) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Da el genero del actor
	 */
	public Gender getActorOneGender() {
		return gender;
	}


	/**
	 * Da el genero del actor
	 * @ param actorOneGender  
	 */
	public void setActorOneGender(Gender actorOneGender) {
		this.gender = actorOneGender;
	}

	/**
	 * Da el nombre del actor
	 */

	public String getActorOne() {
		return name;
	}


	/**
	 * Constructor actor
	 */
	public void setActorOne(String actorOne) {
		this.name = actorOne;
	}
}

