/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionesUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andaryus7
 */


public class guardarArchivos {

    File directorio;
    
    public void guardarArchivosAnalisis(String json, String def) {
        String xd = "";
        JFileChooser selectorCarpeta = new JFileChooser();
        selectorCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorCarpeta.setAcceptAllFileFilterUsed(false);
        if (selectorCarpeta.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File carpetaSelec = selectorCarpeta.getSelectedFile();
            System.out.println(carpetaSelec);
            guardarArchivoIndividual(carpetaSelec, def, ".def");
            guardarArchivoIndividual(carpetaSelec, json, ".json");
            xd += carpetaSelec + ".def";
            xd += "\n" + carpetaSelec + ".json";
            guardarArchivoIndividual(carpetaSelec, xd, ".copy");
//              String[] lista = carpetaSelec.list();

//            ArrayList<File> archivosP1 = new ArrayList<>();
//            for (int i = 0; i < lista.length; i++) {
//                System.out.println(lista[i]);
//                File nuevo = new File(carpetaSelec, lista[i]);
//                archivosP1.add(nuevo);
//
//            }
        }
    }

    public void ventanaGuardar(String json, String def) {
        String xd = "";
        JFileChooser choser = new JFileChooser();
        if (choser.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            File carpetaSelec = choser.getSelectedFile();
            directorio=carpetaSelec;
            guardarArchivoIndividual(carpetaSelec, def, ".def");
            guardarArchivoIndividual(carpetaSelec, json, ".json");
            System.out.println(carpetaSelec.getAbsolutePath());
            xd += carpetaSelec + ".def";
            xd += "\n" + carpetaSelec + ".json";
            guardarArchivoIndividual(carpetaSelec, xd, ".copy");
        }
    }

    public void guardarArchivoIndividual(File directorio, String contenido, String extension) {
        try {
            FileOutputStream salida = new FileOutputStream(directorio + extension);
            System.out.println(salida);
            byte[] byts = contenido.getBytes();
            salida.write(byts);
            JOptionPane.showMessageDialog(null, "Archivo"+extension+"Guardado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(guardarArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(guardarArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sobreEscribir(File directorio, String json, String def) {
        guardarArchivoIndividual(directorio, def, ".def");
        guardarArchivoIndividual(directorio, json, ".json");
    }

    public File getDirectorio() {
        return directorio;
    }

    public void setDirectorio(File directorio) {
        this.directorio = directorio;
    }
    
    

}
