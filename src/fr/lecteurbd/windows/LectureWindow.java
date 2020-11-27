package fr.lecteurbd.windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fr.lecteurbd.Main;
import fr.lecteurbd.utils.OpenSelector;

/**
 * Classe de la fenetre de lecture de la BD
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class LectureWindow extends JFrame implements ActionListener {

	/**
	 * Constructeur de la fenetre de lecture
	 * @param nom
	 */
	public LectureWindow(String nom) {
		super(nom);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,800);
		setLocationRelativeTo(null);

		setBackground(Color.GRAY);

		Page_Panel load = new Page_Panel();
		load.setFocusable(true);

		this.add(load);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		JMenu help = new JMenu("Aide");
		menuBar.add(help);
		
		JMenuItem ouvrir =new JMenuItem("Ouvrir");
		menu.add(ouvrir);
		JMenuItem quitter =new JMenuItem("Quitter");
		menu.add(quitter);
		
		JMenuItem morehelp =new JMenuItem("Cliquez pour avoir de l'aide");
		help.add(morehelp);
		
		quitter.setActionCommand("menu_quitter");
		quitter.addActionListener(this);

		ouvrir.setActionCommand("menu_ouvrir");
		ouvrir.addActionListener(this);
		
		morehelp.setActionCommand("menu_aide");
		morehelp.addActionListener(this);
		
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
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Listener des actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		{
			if (e.getActionCommand().equals("menu_quitter")) {	
					String options[] = {"Oui", "Non"};
					int retour = JOptionPane.showOptionDialog(null,
							"Voulez-vous quitter l'application ?", "Quitter",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
					if(retour == 0)  
						System.exit(0);			
				}
			
			if (e.getActionCommand().equals("menu_ouvrir"))
				new OpenSelector().open();
			if (e.getActionCommand().equals("menu_aide")) 
				JOptionPane.showMessageDialog(null,
						 "Touches utiles : \nTouches Z-Q-S-D: Déplacement de la page\nTouches flèches gauche ou droite: Déplacement entre les pages\n"
						 + "Touche R: Reset de la page\nMolette de la souris: Réglage du zoom\nTouche F: Aller à une page",
						 "Aide",
						 JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

}
