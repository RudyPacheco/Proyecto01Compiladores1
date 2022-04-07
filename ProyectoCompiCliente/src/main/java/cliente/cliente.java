
package cliente;

import funcionesUi.guardarArchivos;
import interfazUI.ventanaResultados;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tablaSimbolo.TablaSimbolo;

import objetosAnalisis.errorE;
import objetosAnalisis.listaProyectos;

/**
 *
 * @author andaryus7
 */
public class cliente {

    Socket actual;
    Boolean error = false;



    public void iniciar() {
        final String HOST = "localhost";  
        final int PUERTO = 5000;
        DataInputStream input;
        DataOutputStream ouput;

        try {

            Socket sc = new Socket(HOST, PUERTO);
            actual = sc;

        } catch (Exception ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void enviarArchivo(ArrayList archivos1, ArrayList archivos2) {
        try {
            if (archivos1 != null && archivos2 != null) {
                listaProyectos listaProyectos = new listaProyectos();
                listaProyectos.setProyecto1(archivos1);
                listaProyectos.setProyecto2(archivos2);
                this.iniciar();
                String msj = "";
                DataOutputStream ouput2 = new DataOutputStream(actual.getOutputStream());
                DataInputStream input = new DataInputStream(actual.getInputStream());

                ouput2.writeUTF(Opciones.PROYECTOS.toString());
                ObjectOutputStream oss = new ObjectOutputStream(actual.getOutputStream());
                oss.writeObject(listaProyectos);
                Opciones aux = Opciones.valueOf(input.readUTF());
                recibirPeticion(aux);
       
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar 2 proyectos");
            }

        } catch (Exception ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void enviarPeticion(ArrayList archivos) {
        try {
            DataOutputStream ouput2 = new DataOutputStream(actual.getOutputStream());
            ouput2.writeUTF(Opciones.PETICION.toString());

        } catch (Exception ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void recibirPeticion(Opciones xd) {
        switch (xd) {
            case ERRORES:

                recibirErrores();

                break;
            case TABLASIMBOLOS:

                recibirTabla();

                break;
            default:
                throw new AssertionError();
        }
    }

    public void recibirErrores() {
        try {

            JOptionPane.showMessageDialog(null, "Los proyectos contienen errores");
            error=true;

        } catch (Exception ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public void recibirTabla() {
        try {

            error=false;
            DataInputStream input = new DataInputStream(actual.getInputStream());
            String mensaje = input.readUTF();

            guardarArchivos guardar = new guardarArchivos();
            guardar.ventanaGuardar(mensaje, "");
            ventanaResultados ventanaResultados1 = new ventanaResultados();
            ventanaResultados1.getAreaJson().setText(mensaje);
            ventanaResultados1.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }


    
    public boolean existeError(){
        return error;
    }
}
