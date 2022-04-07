
package funcionUi;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import objetosAnalisis.errorE;

/**
 *
 * @author andaryus7
 */
public class llenarTabla {

    public void reporteErrores(ArrayList<errorE> errores, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        //Anadir columnas
        modelo.addColumn("Simbolo");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        modelo.addColumn("Tipo");
        modelo.addColumn("Descripcion");
        for (errorE errore : errores) {
            modelo.addRow(new Object[]{errore.getLexeman(),errore.getFila(),errore.getColumna(),errore.getTipo(),errore.getDescripcion()});
        }
        
     
    }
    
    
    public void imprimirErrores(JTextArea area , ArrayList<errorE> errores){
        for (errorE errore : errores) {
            area.append("Error Simbolo : "+errore.getLexeman()+"Tipo : "+errore.getTipo()+" Fila : "+errore.getFila()+" Columna : "+errore.getColumna()+"Proyecto :"+errore.getProyecto()+"\n" );
        }
        
        
        
    }

}
