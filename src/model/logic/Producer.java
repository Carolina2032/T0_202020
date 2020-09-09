package model.logic;

/**
 * Representa un productor
 */

public class Producer implements Comparable <Producer> {
	
	
	/**
	 * atributos
	 */

	private String name;
	
	
	/**
	 * constructor
	 */

	public Producer (String producer) {
		this.setProducer(producer);
	
	}  
	
	
	/**
	 * compara dos productores con el dado como parametro
	 */

	@Override
	public int compareTo(Producer producer) {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getProducer() {
		return name;
	}



	public void setProducer(String producer) {
		this.name = producer;
	}
}
