package fr.lecteurbd.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ZoneDessin extends JPanel{

	Image acceuil;
	JButton ouvrir;
	
	public ZoneDessin() {
		setPreferredSize(new Dimension(400,500));

		try {
			System.out.println("try to read acceuil");
			acceuil = ImageIO.read(new File("img/acceuil.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		setLayout(null);
		ouvrir = new JButton("Ouvrir une BD");
		ouvrir.setBounds(120,230,150,40);
		
		add(ouvrir);
		
	}	
	
	public void paint(Graphics g){
		g.drawImage(acceuil, 0, 0, this);
		
		Font font = new Font("Arial", Font.BOLD, 12);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Format de fichier autorisé: *.cbz, *.cbr", 85, 285);
		
	}
	
}
