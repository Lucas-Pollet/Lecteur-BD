package fr.lecteurbd.windows;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import fr.lecteurbd.Main;


public class LectureWindow extends JFrame {

	public LectureWindow(String nom) {
		super(nom);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		//setSize(400, 500);

		setBackground(Color.GRAY);

		LoadPage load = new LoadPage();
		load.setFocusable(true);
		
		this.add(load);

		pack();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		setVisible(true);

		
		// Sauvegarde de la page en cours
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				try {
					DataOutputStream fW  = new DataOutputStream(new FileOutputStream("src/tmp/"+Main.bd.getNameBD()+"/page.dat"));
					try {
						fW.writeInt(Main.bd.getCurrent_page());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
}
