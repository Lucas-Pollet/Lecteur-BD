package fr.lecteurbd.utils;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe selection de la BD
 * @author Lucas POLLET - Jean PERRUT
 *
 */
public class OpenSelector {

	/**
	 * Fonction d'ouverture du selecteur d'une BD
	 */
	public void open() {
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
