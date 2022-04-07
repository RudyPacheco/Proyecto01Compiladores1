
package objetosAnalisis;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class listaProyectos implements Serializable{
    private ArrayList<File> proyecto1;
    private ArrayList<File> proyecto2;

    public listaProyectos() {
    }

    public listaProyectos(ArrayList<File> proyecto1, ArrayList<File> proyecto2) {
        this.proyecto1 = proyecto1;
        this.proyecto2 = proyecto2;
    }

    public ArrayList<File> getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(ArrayList<File> proyecto1) {
        this.proyecto1 = proyecto1;
    }

    public ArrayList<File> getProyecto2() {
        return proyecto2;
    }

    public void setProyecto2(ArrayList<File> proyecto2) {
        this.proyecto2 = proyecto2;
    }
    
    
}
