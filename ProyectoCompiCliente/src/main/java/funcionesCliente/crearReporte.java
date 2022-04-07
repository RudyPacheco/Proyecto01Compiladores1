/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionesCliente;

import reporteHtml.Etiqueta;
import reporteHtml.EtiquetaTabla;
import reporteHtml.TipoEtiqueta;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andaryus7
 */
public class crearReporte {

    JFrame ventana;
    JScrollPane scroll;
    JPanel panel;

    public void setJframe(JFrame v) {
        this.ventana = v;
    }

    public void setScroll(JScrollPane j) {
        this.scroll = j;
    }
    
    public void setPanel(JPanel panele){
        this.panel=panele;
    }

//    public void generarReporte(ArrayList<ObjetoHtml> html) {
//        for (ObjetoHtml objetoHtml : html) {
//            if (objetoHtml.getTipo().equals("h1")) {
//                System.out.println("encontrado h1");
//                agregarH1(objetoHtml.getContenido());
//            }
//            if (objetoHtml.getTipo().equals("h2")) {
//                System.out.println("encontrado h2");
//                agregarH2(objetoHtml.getContenido());
//            }
//            if (objetoHtml.getTipo().equals("br")) {
//                System.out.println("se encontro salto");
//                agregarSalto();
//            }
//            if (objetoHtml.getTipo().equals("table")) {
//                System.out.println("se encontro una tabla");
//                agregarTabla();
//            }
//        }
//    }

    public void generarReporteLu(ArrayList<Etiqueta> etiqueas) {
//        ventanPruebaReporte ventanaS = new ventanPruebaReporte();

        //ventanaS.setVisible(true);

        for (Etiqueta etiquea : etiqueas) {
            System.out.println(etiquea.getTipo());
            if (etiquea.getTipo() == TipoEtiqueta.H1) {
//                JLabel h1 = new JLabel(etiquea.getContenido());
//                h1.setFont(new Font("Dialog", Font.PLAIN, 20));
//                h1.setBounds(20, 20, 100, 75);
//                ventanaS.add(h1);
                  agregarH1(etiquea.getContenido());
            }
            if (etiquea.getTipo()==TipoEtiqueta.H2) {
                agregarH2(etiquea.getContenido());
            }
            if (etiquea.getTipo()==TipoEtiqueta.BR) {
                agregarSalto();
            }
            if (etiquea.getTipo()==TipoEtiqueta.TABLE) {
                agregarTabla(etiquea);
            }

        }

    }

    private void agregarH1(String contenido) {
        JLabel h1 = new JLabel(contenido);
        h1.setFont(new Font("Dialog", Font.PLAIN, 20));
        h1.setBounds(20, 20, 100, 75);
        //ventana.add(h1);
        // scroll.add(h1);
        panel.add(h1);
    }

    private void agregarH2(String contenido) {
        JLabel h2 = new JLabel(contenido);
        h2.setFont(new Font("Dialog", Font.PLAIN, 14));
        h2.setBounds(20, 20, 100, 75);
        //ventana.add(h2);
        // scroll.add(h2);
        panel.add(h2);
    }

    private void agregarSalto() {
        JLabel br = new JLabel("         ");
        br.setBounds(20, 20, 100, 75);
        //ventana.add(br);
        panel.add(br);
        //scroll.add(br);
    }

    private void agregarTabla(Etiqueta eTabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable();
        tabla.setModel(modelo);
        ArrayList<String> datosFila = new ArrayList<>();
//        modelo.addColumn("Numero");
//        modelo.addColumn("Variable");
//        modelo.addColumn("Tipo");
//        modelo.addColumn("Funcion");
//        String[] pq = {"1", "val1", "int", "miclase"};
//        modelo.addRow(pq);
//          
        EtiquetaTabla table = (EtiquetaTabla) eTabla;
        for (int i = 0; i <table.getContenidoHijo().size() ; i++) {
            if (table.getContenidoHijo().get(i).getTipo()==TipoEtiqueta.TH) {
                modelo.addColumn(table.getContenidoHijo().get(i).getContenido());
            }
            if (table.getContenidoHijo().get(i).getTipo()==TipoEtiqueta.TD) {
                datosFila.add(table.getContenidoHijo().get(i).getContenido());
            }
            if (table.getContenidoHijo().get(i).getTipo()==TipoEtiqueta.TR) {
                if (!datosFila.isEmpty()) {
                    String[] datos = new String[datosFila.size()];
                    for (int j = 0; j < datosFila.size(); j++) {
                        datos[j]=datosFila.get(j);
                    }
                    
                    modelo.addRow(datos);
                    datosFila.clear();
                }
            }
            
            
            
        }
        JScrollPane sc = new JScrollPane(tabla);
        // tabla.setSize(454, 546);
        //ventana.add(sc);
        //scroll.add(tabla);
        panel.add(sc);
    }

}
