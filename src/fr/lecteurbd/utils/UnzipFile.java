package fr.lecteurbd.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;

import fr.lecteurbd.Main;
import fr.lecteurbd.stock.BD;
import fr.lecteurbd.stock.Page;
import fr.lecteurbd.windows.LectureWindow;

public class UnzipFile {

    public static void extract(String fileZip) {
    	System.out.println("extract "+fileZip);
        
    	File file = new File(fileZip);
    	File destDir = new File("src/tmp/"+file.getName());
        if(!destDir.exists()) destDir.mkdirs();

        Main.bd = new BD(file.getName());
        
        int page=1;
        
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(fileZip);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            
           
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                //System.out.println("Unzipping to "+newFile.getAbsolutePath());
  
                Main.bd.getListe_page().add(new Page(page, fileName, newFile.getAbsolutePath()));
                
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                	fos.write(buffer, 0, len);
                }
                fos.close();
                zis.closeEntry();
                ze = zis.getNextEntry();
                
                page++;
            }
            
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File fpage = new File("src/tmp/"+file.getName()+"/page.dat"); 
        String options[] = {"Oui", "Non"};
					   int retour = JOptionPane.showOptionDialog(null,
								"Reprendre la lecture où vous vous êtes arrêté ?", "Reprendre",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
					   
		
					   
        if(fpage.exists() && (retour == 0)) {
        	try {
        		DataInputStream fR  = new DataInputStream(new FileInputStream("src/tmp/"+file.getName()+"/page.dat"));
        		try {
					int actualPage = fR.readInt();
					Main.bd.setCurrent_page(actualPage);
					
					new LectureWindow("Lecture : " + file.getName());		
				} catch (IOException e) {
					e.printStackTrace();
				}

        	} catch (FileNotFoundException e) {
        		e.printStackTrace();
        	}

        }else{	
        	new LectureWindow("Lecture : " + file.getName());
        }
             
    }
}