package fr.lecteurbd.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.lecteurbd.utils.UnzipFile;

public class ZoneDessin extends JPanel implements ActionListener{

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
		ouvrir.addActionListener(this);
		ouvrir.setActionCommand("bouton_ouvrir");
		
		add(ouvrir);
		
	}	
	
	public void paintComponent(Graphics g){
		g.drawImage(acceuil, 0, 0, this);
		
		Font font = new Font("Arial", Font.BOLD, 12);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Format de fichier autorisé: *.cbz, *.zip", 85, 285);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("bouton_ouvrir")) {
			JFileChooser selec = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers archive comics (.cbz)", "cbz");
			selec.addChoosableFileFilter(filter);
			selec.addChoosableFileFilter(new FileNameExtensionFilter("Fichiers zip (.zip)", "zip"));
			selec.setFileFilter(filter);
			
			int resultat = selec.showOpenDialog(null);
			
			if(resultat == JFileChooser.APPROVE_OPTION) {
				String file = selec.getSelectedFile().getAbsolutePath();
				
				UnzipFile.extract(file);
				
			}
		}
		
	}
	
}
