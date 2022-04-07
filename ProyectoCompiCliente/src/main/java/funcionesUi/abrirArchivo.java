/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionesUi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author andaryus7
 */
public class abrirArchivo {

    String json = "";
    String def = "";
    File directorio;
    boolean correcto = false;

    public void abir() {
        JFileChooser abrir = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("copy", "copy");
        abrir.setFileFilter(fi);
        if (abrir.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            File archivo = abrir.getSelectedFile();
            this.directorio = abrir.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("copy")) {
                    //abrirIndividual(archivo);
                    leerFichero(archivo);
                    correcto = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo incompatible");
                    correcto = false;

                }
            }

        } else {
            
        }

    }

    public void abrirIndividual(File archivo) {
        String docuemento = "";
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            int asc;
            while ((asc = entrada.read()) != -1) {
                char caracter = (char) asc;
                docuemento += caracter;

            }
            System.out.println(docuemento);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leerFichero(File archivo) {
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
                File nuevo = new File(linea);
                if (nuevo.getName().endsWith("json")) {
                    this.json = abrirFiles(nuevo);
                } else if (nuevo.getName().endsWith("def")) {
                    this.def = abrirFiles(nuevo);
                }

                //abrirIndividual(nuevo);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
            correcto = false;
        } catch (IOException ex) {
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
            correcto = false;
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String abrirFiles(File archivo) {
        String docuemento = "";
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            int asc;
            while ((asc = entrada.read()) != -1) {
                char caracter = (char) asc;
                docuemento += caracter;

            }
            System.out.println(docuemento);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            correcto = false;
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        } catch (IOException ex) {
            correcto = false;
            Logger.getLogger(abrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        }
        return docuemento;
    }

    public String getJson() {
        return json;
    }

    public String getDef() {
        return def;
    }

    public File getDirectorio() {
        return directorio;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

}
