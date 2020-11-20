package fr.lecteurbd.windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.lecteurbd.Main;

public class LoadPage extends JPanel implements ActionListener, MouseWheelListener, KeyListener {

	private JButton before;
	private JButton after;
	
    public float zoom = 0.75f;
	
    private BufferedImage page;
    private BufferedImage fond;
    
    private int x_loc = 0;
    private int y_loc = 0;
    
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
		
		addMouseWheelListener(this);
		addKeyListener(this);
		
	}	

	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		try {
			fond = ImageIO.read(new File("img/fondapp.jpg"));
			page = ImageIO.read(new File(Main.bd.getListe_page().get(Main.bd.getCurrent_page()).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2d.drawImage(fond, 0, 0, getWidth(), getHeight(), null);
		
		float z = zoom*zoom;
		AffineTransform t = new AffineTransform();
		float currentImgWidth = page.getWidth()*z, currentImgHeight = page.getHeight()*z;
		t.translate((getWidth()/2-currentImgWidth/2) + x_loc, (getHeight()/2-currentImgHeight/2) + y_loc);
		t.scale(z, z);

		g2d.drawImage(page, t, null);

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

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		zoom = Math.max(0, zoom - 0.03f * e.getWheelRotation());
		repaint();		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		requestFocus();
		
		// Deplacement de la page;
		if(e.getKeyCode() == KeyEvent.VK_D) {
			x_loc=x_loc+10;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			x_loc=x_loc-10;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			y_loc=y_loc-10;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			y_loc=y_loc+10;
			repaint();
		}
		
		// Reset de la position et du zoom
		if(e.getKeyCode() == KeyEvent.VK_R) {
			x_loc=0;
			y_loc=0;
			zoom=0.75f;
			repaint();
		}
		
		// Deplacement de pages en pages
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(!(Main.bd.getCurrent_page()+1 == Main.bd.getListe_page().size())) {
				Main.bd.setCurrent_page(Main.bd.getCurrent_page()+1);
				repaint();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(!(Main.bd.getCurrent_page()+1 == 1)) {
				Main.bd.setCurrent_page(Main.bd.getCurrent_page()-1);
				repaint();
			}
		}
		
		// Changer de pages avec recherche
		if(e.getKeyCode() == KeyEvent.VK_F) {
			String setpage = JOptionPane.showInputDialog(this,
                    "Quelle page voulez vous ?", null);
			
			int selected_page = Integer.valueOf(setpage);
			
			if((selected_page >= 1) && (selected_page <= Main.bd.getListe_page().size())){
				Main.bd.setCurrent_page(selected_page+1);
				repaint();
			}else{
				JOptionPane.showMessageDialog(null,"Valeur hors champ !","Erreur", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {}


	@Override
	public void keyTyped(KeyEvent e) {}


	
}
