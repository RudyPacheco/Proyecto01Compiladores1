
package reporteHtml;

/**
 *
 * @author andaryus7
 */
public class EtiquetaTexto extends Etiqueta {

    public EtiquetaTexto() {
    }

    public EtiquetaTexto(String contenido, TipoEtiqueta tipo) {
        super(contenido, tipo);
    }

   @Override
    public String toString() {
        return "Etiqueta{" + "contenido=" + contenido + ", tipo=" + tipo + '}';
    }
    
    
}
