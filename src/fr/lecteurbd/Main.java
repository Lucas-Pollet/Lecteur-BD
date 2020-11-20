package fr.lecteurbd;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.lecteurbd.stock.BD;
import fr.lecteurbd.windows.HomeWindow;

public class Main {
	
	public static BD bd;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new HomeWindow("Lecteur de BD");
	}
}
