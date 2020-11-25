package fr.lecteurbd.stock;

import java.util.Vector;

/**
 * Classe permettant le stockage des données de la BD
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class BD {
	
	/**
	 * Variable de la liste des pages 
	 */
	private Vector<Page> liste_page;
	/**
	 * Variable de la page actuelle
	 */
	private int current_page;
	/**
	 * Varible du nom de la bd
	 */
	private String name_bd;
	
	/**
	 * Constructeur de la BD
	 * @param name
	 */
	public BD(String name) {
		liste_page = new Vector<Page>();
		current_page = 0;
		this.name_bd=name;
	}

	/**
	 * Getter de la liste des pages
	 * @return La liste des pages
	 */
	public Vector<Page> getListe_page() {
		return liste_page;
	}

	/**
	 * Getter de la page actuelle
	 * @return Le int de la page actuelle
	 */
	public int getCurrent_page() {
		return current_page;
	}

	/**
	 * Setter de la page actuelle
	 * @param current_page
	 */
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	
	/**
	 * Getter du nom de la BD
	 * @return Le nom de la BD
	 */
	public String getNameBD() {
		return name_bd;
	}
	
}
