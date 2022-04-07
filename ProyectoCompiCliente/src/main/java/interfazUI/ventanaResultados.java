/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazUI;

import reporteHtml.EtiquetasReporteHtml;
import analisisHtml.HtmlSintactico;
import analisisHtml.LexicoHtml;
import analisisJson.JsonSintactico;
import analisisJson.LexicoJson;
import funcionesCliente.crearReporte;
import funcionesUi.NumeroLinea;
import funcionesUi.abrirArchivo;
import funcionesUi.guardarArchivos;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import tablaSimbolo.TablaSimbolo;

/**
 *
 * @author andaryus7
 */
public class ventanaResultados extends javax.swing.JFrame {

    /**
     * Creates new form ventanaResultados
     */
    File directorio;
    TablaSimbolo tablaSimbolos;
    NumeroLinea numeroLinea;
    NumeroLinea numeroLinea2;
    
    public ventanaResultados() {
        initComponents();
        numeroLinea = new NumeroLinea(jTextAreaJson);
        jScrollPane1.setRowHeaderView(numeroLinea);
        numeroLinea2 = new NumeroLinea(jTextAreaDef);
        jScrollPane2.setRowHeaderView(numeroLinea2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanelSuperior = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelDerecho = new javax.swing.JPanel();
        jPanelIzquierdo = new javax.swing.JPanel();
        jPanelInferior = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaConsolaJson = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaJson = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaConsolaDef = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDef = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemNuevoAnalisis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanelSuperior.setBackground(new java.awt.Color(0, 153, 255));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Definicion Json");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel9)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(39, 39, 39))
        );

        jPanel1.add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelDerecho.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanelDerechoLayout = new javax.swing.GroupLayout(jPanelDerecho);
        jPanelDerecho.setLayout(jPanelDerechoLayout);
        jPanelDerechoLayout.setHorizontalGroup(
            jPanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelDerechoLayout.setVerticalGroup(
            jPanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelDerecho, java.awt.BorderLayout.LINE_END);

        jPanelIzquierdo.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanelIzquierdoLayout = new javax.swing.GroupLayout(jPanelIzquierdo);
        jPanelIzquierdo.setLayout(jPanelIzquierdoLayout);
        jPanelIzquierdoLayout.setHorizontalGroup(
            jPanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelIzquierdoLayout.setVerticalGroup(
            jPanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelIzquierdo, java.awt.BorderLayout.LINE_START);

        jPanelInferior.setBackground(new java.awt.Color(0, 153, 255));
        jPanelInferior.setLayout(new javax.swing.BoxLayout(jPanelInferior, javax.swing.BoxLayout.Y_AXIS));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("Consola :");
        jPanelInferior.add(jLabel6);

        jTextAreaConsolaJson.setColumns(20);
        jTextAreaConsolaJson.setRows(5);
        jScrollPane4.setViewportView(jTextAreaConsolaJson);

        jPanelInferior.add(jScrollPane4);

        jLabel7.setText("     ");
        jPanelInferior.add(jLabel7);

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelInferior.add(jButton1);

        jLabel8.setText("     ");
        jPanelInferior.add(jLabel8);

        jPanel1.add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setLayout(new javax.swing.BoxLayout(jPanelCentral, javax.swing.BoxLayout.LINE_AXIS));

        jTextAreaJson.setColumns(20);
        jTextAreaJson.setRows(5);
        jScrollPane1.setViewportView(jTextAreaJson);

        jPanelCentral.add(jScrollPane1);

        jPanel1.add(jPanelCentral, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Json", jPanel1);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Definicion def");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(38, 38, 38))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Consola :");
        jPanel7.add(jLabel2);

        jLabel3.setText("   ");
        jPanel7.add(jLabel3);

        jTextAreaConsolaDef.setColumns(20);
        jTextAreaConsolaDef.setRows(5);
        jScrollPane3.setViewportView(jTextAreaConsolaDef);

        jPanel7.add(jScrollPane3);

        jLabel4.setText("   ");
        jPanel7.add(jLabel4);

        jButton3.setText("Generar Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);

        jLabel5.setText("    ");
        jPanel7.add(jLabel5);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jTextAreaDef.setColumns(20);
        jTextAreaDef.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDef);

        jPanel8.add(jScrollPane2);

        jLabel1.setText("              ");
        jPanel8.add(jLabel1);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("def", jPanel3);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jTabbedPane1.addTab("Reporte", jPanel2);

        getContentPane().add(jTabbedPane1);

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItemNuevoAnalisis.setText("Nuevo Analisis");
        jMenuItemNuevoAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoAnalisisActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNuevoAnalisis);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        guardarArchivos guardar = new guardarArchivos();
        if (directorio != null) {
            
            System.out.println(directorio.getAbsolutePath());
            System.out.println(directorio.getParent());
            System.out.println(directorio.getName());
            System.out.println(directorio.getAbsolutePath().substring(0, directorio.getAbsolutePath().length() - 5));
            File nuevo = new File(directorio.getAbsolutePath().substring(0, directorio.getAbsolutePath().length() - 5));
            guardar.sobreEscribir(nuevo, jTextAreaJson.getText(), jTextAreaDef.getText());
        } else {
            guardar.ventanaGuardar(jTextAreaJson.getText(), jTextAreaDef.getText());
            this.directorio = guardar.getDirectorio();
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        abrirArchivo abrir = new abrirArchivo();
        abrir.abir();
        if (abrir.isCorrecto()) {
            ventanaResultados ventana = new ventanaResultados();
            ventana.setVisible(true);
            ventana.getAreaJson().setText(abrir.getJson());
            ventana.getAreaDef().setText(abrir.getDef());
            ventana.setDirectorio(abrir.getDirectorio());
            this.dispose();
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextAreaConsolaDef.setText("");
        Reader reader = new StringReader(jTextAreaDef.getText());
        LexicoHtml lexer = new LexicoHtml(reader);
        HtmlSintactico parser = new HtmlSintactico(lexer);
        EtiquetasReporteHtml salida = new EtiquetasReporteHtml();
        
        parser.setTabla(tablaSimbolos);
        if (tablaSimbolos != null) {
            try {
                parser.parse();
                jTextAreaConsolaDef.removeAll();
                if (parser.getErrores().isEmpty()) {
                    salida = parser.getAccionSalida();
                    crearReporte reporte = new crearReporte();
                    reporte.setPanel(jPanel2);
                    reporte.generarReporteLu(salida.getEtiquetas());
                    jTextAreaConsolaDef.append("\n" + "No tienen nigun error");
                } else {
                    JOptionPane.showMessageDialog(this, "La definicion def tiene errores");
                    
                    for (int i = 0; i < parser.getErrores().size(); i++) {
                        jTextAreaConsolaDef.append("\n" + "Error Simbolo" + parser.getErrores().get(i).getLexeman() + "Fila" + parser.getErrores().get(i).getFila() + "Columna" + parser.getErrores().get(i).getColumna());
                    }
                    
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe analizar el json primero");
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextAreaConsolaJson.setText("");
        Reader reader = new StringReader(jTextAreaJson.getText());
        LexicoJson lexico = new LexicoJson(reader);
        JsonSintactico parser = new JsonSintactico(lexico);
        try {
            parser.parse();
            jTextAreaConsolaJson.removeAll();
            if (parser.getErrores().isEmpty()) {
                tablaSimbolos = parser.getTabla();
                jTextAreaConsolaJson.append("\n" + "No tiene ningun error");
            } else {
                JOptionPane.showMessageDialog(this, "La definicion Json tiene errores");
                for (int i = 0; i < parser.getErrores().size(); i++) {
                    jTextAreaConsolaJson.append("\n" + "Error Simbolo" + parser.getErrores().get(i).getLexeman() + "Fila" + parser.getErrores().get(i).getFila() + "Columna" + parser.getErrores().get(i).getColumna());
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemNuevoAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoAnalisisActionPerformed
        // TODO add your handling code here:
        ventanaSeleccion ventana = new ventanaSeleccion();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemNuevoAnalisisActionPerformed
    
    public JTextArea getAreaJson() {
        return jTextAreaJson;
    }
    
    public JTextArea getAreaDef() {
        return jTextAreaDef;
    }
    
    public void setDirectorio(File direc) {
        this.directorio = direc;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemNuevoAnalisis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelDerecho;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelIzquierdo;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaConsolaDef;
    private javax.swing.JTextArea jTextAreaConsolaJson;
    private javax.swing.JTextArea jTextAreaDef;
    private javax.swing.JTextArea jTextAreaJson;
    // End of variables declaration//GEN-END:variables
}