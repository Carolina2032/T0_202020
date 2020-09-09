package model.logic;

/**
 * Representa un editor
 */

public class Editor implements Comparable <Editor> {

	/**
	 * atributos
	 * 
	 */
	private String name;


	/**
	 * Arroja un  editor 
	 * @param editor
	 */

	public Editor (String editor) {
		this.setEditor(editor);

	}  

	/**
	 * compara el editor con uno dado
	 */
	@Override
	public int compareTo(Editor editor) {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * da el nombre del editor
	 */

	public String getEditor() {
		return name;
	}

	/**
	 * Representa un editor con uno dado
	 * @param editor
	 */

	public void setEditor(String editor) {
		this.name = editor;
	}
}
