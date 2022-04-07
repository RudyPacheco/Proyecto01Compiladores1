/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecucion;

import consola.consolaSalida;
import run.servidor;

/**
 *
 * @author andaryus7
 */
public class run {
 
    
    
    public static void main(String[] args) {
        consolaSalida consol = new consolaSalida();
        consol.setVisible(true);
        servidor server = new servidor();
        server.setTextArea(consol.getTextArea());
        server.IniciarServer();
        
        
    }
    
    
}
