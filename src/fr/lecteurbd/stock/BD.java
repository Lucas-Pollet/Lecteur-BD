package fr.lecteurbd.stock;

import java.util.Vector;

public class BD {
	
	private Vector<Page> liste_page;
	private int current_page;
	private String name_bd;
	
	public BD(String name) {
		liste_page = new Vector<Page>();
		current_page = 0;
		this.name_bd=name;
	}

	public Vector<Page> getListe_page() {
		return liste_page;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	
	public String getNameBD() {
		return name_bd;
	}
	
}
