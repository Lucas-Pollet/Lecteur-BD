package fr.lecteurbd.windows;

import javax.swing.JFrame;

public class LectureWindow extends JFrame{

	public LectureWindow(String nom) {
		super(nom);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);
		//setAlwaysOnTop(true);
		//setSize(400, 500);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		LoadPage load = new LoadPage();
		getContentPane().add(load);
		
		pack();
		
		setVisible(true);
		
	}
	
	
}
