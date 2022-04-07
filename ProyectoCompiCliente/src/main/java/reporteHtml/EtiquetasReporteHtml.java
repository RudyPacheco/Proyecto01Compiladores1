package reporteHtml;

import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class EtiquetasReporteHtml {

    private ArrayList<Etiqueta> etiquetas = new ArrayList<>();
    private String contenidoTem = "";
    private EtiquetaTabla tem = new EtiquetaTabla();

    public EtiquetasReporteHtml() {

    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getContenidoTem() {
        return contenidoTem;
    }

    public void setContenidoTem(String contenidoTem) {
        this.contenidoTem += contenidoTem;
    }

    public void limpiarContenido() {
        this.contenidoTem = "";
    }

    public void capturaH1() {
        this.etiquetas.add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.H1));
        limpiarContenido();
    }

    public void capturaH2() {
        this.etiquetas.add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.H2));
        limpiarContenido();
    }

    public void capturaBr() {
        this.etiquetas.add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.BR));
        limpiarContenido();
    }

    public void capturarTH() {
        this.tem.getContenidoHijo().add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.TH));
        limpiarContenido();
    }

    public void capturarTD() {
        this.tem.getContenidoHijo().add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.TD));
        limpiarContenido();
    }
    public void capturarTR() {
        this.tem.getContenidoHijo().add(new EtiquetaTexto(contenidoTem, TipoEtiqueta.TR));
        limpiarContenido();
    }
    
    public void caputararTable(){
        this.etiquetas.add(new EtiquetaTabla((ArrayList<EtiquetaTexto>) tem.getContenidoHijo().clone(), contenidoTem, TipoEtiqueta.TABLE));
        tem.getContenidoHijo().clear();
        limpiarContenido();
    }
    
    
    public void tostring(){
        for (Etiqueta etiqueta : etiquetas) {
            System.out.println("---------------------");
            if (etiqueta instanceof EtiquetaTexto) {
                EtiquetaTexto etiq = (EtiquetaTexto) etiqueta;
                System.out.println(etiq.toString());
            }else{
                EtiquetaTabla aux = (EtiquetaTabla) etiqueta;
                for (EtiquetaTexto etiquetaSimple : aux.getContenidoHijo()) {
                    EtiquetaTexto etiq = (EtiquetaTexto) etiquetaSimple;
                    System.out.println(etiq.toString());
                }
            }
        }
    }

    
    
    
}
