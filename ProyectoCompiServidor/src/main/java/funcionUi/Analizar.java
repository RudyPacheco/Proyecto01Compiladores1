
package funcionUi;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import lexico.LexicoJava;



import objetosAnalisis.errorE;
import objetosAnalisis.listaProyectos;
import sintactico.SintacticoJava;



import tablaSimbolo.TablaSimbolo;

/**
 *
 * @author andaryus7
 */
public class Analizar {

    ArrayList<errorE> erroresP1 = new ArrayList<>();
    TablaSimbolo tablaP1 = new TablaSimbolo();
    ArrayList<errorE> erroresP2 = new ArrayList<>();
    TablaSimbolo tablaP2 = new TablaSimbolo();
    TablaSimbolo tablaGeneral;
    double score=0;
    String json="";

    public void analizarProyecto(listaProyectos archivos) {
        for (int i = 0; i < archivos.getProyecto1().size(); i++) {
             String texto = abrirArchivo(archivos.getProyecto1().get(i));
            analizarArchivo(texto, erroresP1, tablaP1);

        }
          for (int i = 0; i < archivos.getProyecto2().size(); i++) {
             String texto = abrirArchivo(archivos.getProyecto2().get(i));
            analizarArchivo(texto, erroresP2, tablaP2);

        }
          
        comparacionProyecto comparar = new comparacionProyecto();
        comparar.setProyect1(tablaP1);
        comparar.setProyecto2(tablaP2);
        comparar.realizarAcciones();
        tablaGeneral=comparar.getProyecto();
                score=comparar.getScore();

       json= generarJSON(tablaGeneral,score);

    }
    
    public String generarJSON(TablaSimbolo tabla1, double score){
        generarJson json = new generarJson(tabla1,score);
        String jsonGenerado = json.generarJson();
        return jsonGenerado;
    }

    public void analizarArchivo(String texto, ArrayList<errorE> errors, TablaSimbolo tabla) {

        Reader reader = new StringReader(texto);
        LexicoJava lexer = new LexicoJava(reader);
        lexer.setErrores(errors);
        lexer.setTabla(tabla);
        SintacticoJava parser = new SintacticoJava(lexer);

        try {
            parser.setTabla(tabla);
            parser.setErrores(errors);
            parser.parse();

            tabla = parser.getTable();


        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public String abrirArchivo(File archivo) {
        String documento = "";
        try {
            FileInputStream entrada = new FileInputStream(archivo);
            int ascc;
            while ((ascc = entrada.read()) != -1) {
                char caracter = (char) ascc;
                documento += caracter;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documento;
    }

    public ArrayList<errorE> getErroresP1() {
        return erroresP1;
    }

    public TablaSimbolo getTablaP1() {
        return tablaP1;
    }

    public ArrayList<errorE> getErroresP2() {
        return erroresP2;
    }

    public TablaSimbolo getTablaP2() {
        return tablaP2;
    }

    public String getJson() {
        return json;
    }
    
    public ArrayList<errorE> getErroresGenerales(){
        ArrayList<errorE> erroresG = new ArrayList<>();
        for (errorE e : erroresP1) {
            e.setProyecto("Proyecto 1");
        }
        for (errorE e : erroresP2) {
            e.setProyecto("Proyecto 2");
        }
        
        erroresG.addAll(erroresP1);
        erroresG.addAll(erroresP2);
        return erroresG;
    }

    
    
}
