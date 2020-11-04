package fr.lecteurbd;

import fr.lecteurbd.stock.BD;
import fr.lecteurbd.windows.HomeWindow;

public class Main {
	
	public static BD bd;
	
	public static void main(String[] args) {
		new HomeWindow("Lecteur de BD");
	}
}
