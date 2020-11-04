package fr.lecteurbd.windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.lecteurbd.Main;

public class LoadPage extends JPanel implements ActionListener {

	private JButton before;
	private JButton after;
	
	public LoadPage() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 800));
		
		before = new JButton("Précédent");
		after = new JButton("Suivant");
		
		before.addActionListener(this);
		before.setActionCommand("button_before");
		
		after.addActionListener(this);
		after.setActionCommand("button_after");
		
		add(before);
		add(after);
	}	
	
	@Override
	public void paint(Graphics g) {
		try {
			BufferedImage page = ImageIO.read(new File(Main.bd.getListe_page().get(Main.bd.getCurrent_page()).getPath()));
			
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.drawImage(page, 0, 0, getWidth(), getHeight()-50, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		before.setBounds(20,getHeight()-45,150,40);
		after.setBounds(getWidth()-170,getHeight()-45,150,40);
		
	
		if(Main.bd.getCurrent_page()+1 == 1) {
			before.setEnabled(false);
		}else{
			before.setEnabled(true);
		}
		
		if(Main.bd.getCurrent_page()+1 == Main.bd.getListe_page().size()) {
			after.setEnabled(false);
		}else{
			after.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("button_after")) {
			Main.bd.setCurrent_page(Main.bd.getCurrent_page()+1);
			repaint();
		}
		if(e.getActionCommand().equals("button_before")) {
			Main.bd.setCurrent_page(Main.bd.getCurrent_page()-1);
			repaint();
		}
	}
	
}
