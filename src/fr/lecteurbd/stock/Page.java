package fr.lecteurbd.stock;

/**
 * Classe permettant le stockage des données des pages de la BD
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class Page {

	/**
	 * Variable du numéro de la page
	 */
	private int numpage;
	/**
	 * Variable du nom de la page
	 */
	private String name;
	/**
	 * Variable du chemin d'accès de la page
	 */
	private String path;
	
	/**
	 * Constructeur de la page
	 * @param num
	 * @param name
	 * @param path
	 */
	public Page(int num, String name, String path) {
		this.numpage=num;
		this.name=name;
		this.path=path;
	}

	/**
	 * Getter du numéro de la page
	 * @return le num de la page
	 */
	public int getNumpage() {
		return numpage;
	}

	/**
	 * Getter du nom de la page
	 * @return nom de la page
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter du chemin de la page
	 * @return chemin de la page
	 */
	public String getPath() {
		return path;
	}
	
}
