package fr.lecteurbd.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import fr.lecteurbd.utils.OpenSelector;

/**
 * Classe du panel de la fenetre d'acceuil
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class Home_Panel extends JPanel implements ActionListener{

	/**
	 * Variable de stockage de l'image d'acceuil
	 */
	Image acceuil;
	/**
	 * Bouton ouvrir
	 */
	JButton ouvrir;
	
	/**
	 * Constructeur du panel
	 */
	public Home_Panel() {
		setPreferredSize(new Dimension(400,500));

		try {
			System.out.println("try to read acceuil");
			acceuil = ImageIO.read(getClass().getResourceAsStream("/img/acceuil.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		setLayout(null);
		ouvrir = new JButton("Ouvrir une BD");
		ouvrir.setBounds(120,230,150,40);
		ouvrir.addActionListener(this);
		ouvrir.setActionCommand("bouton_ouvrir");
		
		add(ouvrir);
		
	}	
	
	/**
	 * Fonction qui dessine les composants
	 */
	public void paintComponent(Graphics g){
		g.drawImage(acceuil, 0, 0, this);
		
		Font font = new Font("Arial", Font.BOLD, 12);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Format de fichier autorisé: *.cbz, *.zip", 85, 285);
		
	}

	/**
	 * Listener des actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("bouton_ouvrir")) {
			new OpenSelector().open();
		}
		
	}
	
}
