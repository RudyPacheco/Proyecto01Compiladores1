
package reporteHtml;

import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class EtiquetaTabla extends Etiqueta{
    
    private ArrayList<EtiquetaTexto>  contenidoHijo = new ArrayList<>();

    public EtiquetaTabla(){
        
    }
    
    public EtiquetaTabla(ArrayList<EtiquetaTexto> contenidohijo) {
        this.contenidoHijo = contenidohijo;
    }

    public EtiquetaTabla(ArrayList<EtiquetaTexto> contenidoHijo, String contenido, TipoEtiqueta tipo) {
        super(contenido, tipo);
        this.contenidoHijo = contenidoHijo;
    }

    public ArrayList<EtiquetaTexto> getContenidoHijo() {
        return contenidoHijo;
    }

    public void setContenidoHijo(ArrayList<EtiquetaTexto> contenidoHijo) {
        this.contenidoHijo = contenidoHijo;
    }

    
    
    
    
    
}
