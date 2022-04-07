package tablaSimbolo;




import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class Metodo implements Serializable{
    private String nombre;
    private String tipo;
    private int numParametros;
    private ArrayList<Variable> variables = new ArrayList<>();;

    public Metodo() {
    }

    public Metodo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    
    public Metodo(String nombre, String tipo, int numParametros, ArrayList<Variable> variables) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numParametros = numParametros;
        this.variables = variables;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumParametros() {
        return numParametros;
    }

    public void setNumParametros(int numParametros) {
        this.numParametros = numParametros;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> graficas) {
        this.variables = graficas;
    }

    @Override
    public String toString() {
        return "Metodo{" + "nombre=" + nombre + ", tipo=" + tipo + ", numParametros=" + numParametros + ", variables=" + parametros() + '}';
    }

    public String parametros(){
        String parametros = "";
        parametros = variables.stream().map(variable -> " "+variable.toString()+" ").reduce(parametros, String::concat);
        return parametros;
    }

}
