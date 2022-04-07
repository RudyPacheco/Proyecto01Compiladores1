
package objetosAnalisis;

import java.io.Serializable;

/**
 *
 * @author andaryus7
 */
public class errorE implements Serializable{
    
    private static final long serializableUID = 1l;
 
    private String lexeman;
    private int fila;
    private int columna;
    private String descripcion;
    private String tipo;
    private String nomClase;
    private String Proyecto;
    private boolean proyecto1;

    public errorE() {
    }

    public errorE(String lexeman, int fila, int columna, String descripcion, String tipo) {
        this.lexeman = lexeman;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public errorE(String lexeman, int fila, int columna, String descripcion, String tipo, boolean proyecto1) {
        this.lexeman = lexeman;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.proyecto1 = proyecto1;
    }

    public errorE(String lexeman, int fila, int columna, String descripcion, String tipo, String nomClase, boolean proyecto1) {
        this.lexeman = lexeman;
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nomClase = nomClase;
        this.proyecto1 = proyecto1;
    }
    
    
    

    public String getLexeman() {
        return lexeman;
    }

    public void setLexeman(String lexeman) {
        this.lexeman = lexeman;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(boolean proyecto1) {
        this.proyecto1 = proyecto1;
    }

    public String getNomClase() {
        return nomClase;
    }

    public void setNomClase(String nomClase) {
        this.nomClase = nomClase;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
    }
    
    
    
    
}
