package fr.lecteurbd.windows;

import javax.swing.*;

/**
 * Classe de lancement de la fenetre principale
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class HomeWindow extends JFrame{

	/**
	 * Constructeur de la fenetre d'acceuil
	 * @param nom de fenetre
	 */
	public HomeWindow(String nom) {
		super(nom);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		Home_Panel zone = new Home_Panel();
		getContentPane().add(zone);
		
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}
