package fr.lecteurbd.windows;

import javax.swing.*;

public class HomeWindow extends JFrame{
	

	public HomeWindow(String nom) {
		super(nom);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setAlwaysOnTop(true);
		//setSize(400, 500);
		
		ZoneDessin zone = new ZoneDessin();
		getContentPane().add(zone);
		
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}
