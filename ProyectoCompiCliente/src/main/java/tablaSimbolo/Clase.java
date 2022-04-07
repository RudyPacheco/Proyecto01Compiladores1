package tablaSimbolo;



import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class Clase implements Serializable{

    private String nombre;
    private ArrayList<String> funciones = new ArrayList<>();

    public Clase() {
    }

    public Clase(String nombre) {
        this.nombre = nombre;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<String> funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        return "Clase{" + "nombre=" + nombre + ", funciones=" + funciones() + '}';
    }

   public String funciones(){
       String funtion = "";
       funtion = funciones.stream().map(funcione -> " "+funcione+" ").reduce(funtion, String::concat);
       return funtion;
   }

   

}
