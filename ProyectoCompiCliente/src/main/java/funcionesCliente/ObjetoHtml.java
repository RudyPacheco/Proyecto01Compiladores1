/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionesCliente;

/**
 *
 * @author andaryus7
 */
public class ObjetoHtml {
    private String Tipo;
    private String contenido;
    
     public ObjetoHtml() {
    }


    public ObjetoHtml(String Tipo, String contenido) {
        this.Tipo = Tipo;
        this.contenido = contenido;
    }

   
    
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
    
    
    
    
    
}
