
package run;

import funcionUi.Analizar;
import funcionUi.llenarTabla;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import objetosAnalisis.errorE;
import objetosAnalisis.listaProyectos;
import tablaSimbolo.*;

/**
 *
 * @author andaryus7
 */
public class servidor {

    JTextArea area;
    Socket actual;
    ServerSocket servidor = null;
    Socket sc = null;
    DataInputStream input;
    DataOutputStream ouput;


    public void IniciarServer() {
        final int PUERTO = 5000;
        try {
            servidor = new ServerSocket(PUERTO);
           
            area.append("\n" + "Servidor Iniciado");

            //siempre escucha peticiones 
            while (true) {

                sc = servidor.accept();
               
                area.append("\n" + "Cliente Conectado");
                actual = sc;
                input = new DataInputStream(sc.getInputStream());
                // String mensaje = input.readUTF();
                Opciones aux = Opciones.valueOf(input.readUTF());
                recibirPeticion(aux);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void recibirPeticion(Opciones options) throws IOException {
        // DataOutputStream ouput = new DataOutputStream(actual.getOutputStream());
        switch (options) {
            case PROYECTOS:
               
                area.append("\n" + "Recibiendo Proyectos");
                //ouput.writeUTF("Proyectos recibidos");
                recibirProyectos();
                break;
            case PETICION:
               
                break;
            default:
                break;

        }
    }

    public void recibirProyectos() {
        ObjectInputStream inputO;
        try {
            inputO = new ObjectInputStream(actual.getInputStream());
            listaProyectos archivos = (listaProyectos) inputO.readObject();
            // ArrayList<File> archivos = (ArrayList<File>) inputO.readObject();
            enviarAnalisis(archivos);
        } catch (Exception ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void enviarAnalisis(listaProyectos archivos) {

        area.append("\n" + "Analizando Proyectos");
        Analizar analisis = new Analizar();
        analisis.analizarProyecto(archivos);
        enviarResultado(analisis.getJson(), analisis.getErroresGenerales());

    }

    public void enviarResultado(String json, ArrayList<errorE> errores) {
        try {

            DataOutputStream ouput = new DataOutputStream(actual.getOutputStream());
            if (!errores.isEmpty()) {
                area.append("\n" + "Errores en los proyectos");
                llenarTabla llenarTabla = new llenarTabla();
                llenarTabla.imprimirErrores(area, errores);
                ouput.writeUTF(Opciones.ERRORES.toString());
//                ObjectOutputStream oss = new ObjectOutputStream(actual.getOutputStream());
//                oss.writeObject(errores);
            } else {
                area.append("\n" + "Json generado");
                ouput.writeUTF(Opciones.TABLASIMBOLOS.toString());
                ouput.writeUTF(json);
//                ObjectOutputStream oss = new ObjectOutputStream(actual.getOutputStream());
//                oss.writeObject(tabla);
            }
        } catch (Exception ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    public void setTextArea(JTextArea texta) {
        this.area = texta;
    }
}
