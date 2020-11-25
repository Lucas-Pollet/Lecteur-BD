package fr.lecteurbd;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.lecteurbd.stock.BD;
import fr.lecteurbd.windows.HomeWindow;

/**
 * Classe de démarrage du programme
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class Main {
	
	/**
	 * Variable d'instance de la BD
	 */
	public static BD bd;
	
	/**
	 * Fonction principale
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new HomeWindow("Lecteur de BD");
	}
}
