/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class Escribiendo {
    
    public static void main(String[] args){
        Escribe e= new Escribe();
        e.Escribir();
    }
    
}

class Escribe{
    
    public void Escribir(){
        FileWriter escritura=null;
        try {
            String frase="\nEsto es una prueba de escritura4 ";
            
            //se agrega true para no sobreescribir, anexa a lo que ya tiene el fichero
            escritura = new FileWriter(new File("src/Streams/Ejemplo1.txt"),true);
            escritura.write(frase, 0, frase.length());
//            for (int i = 0; i < frase.length(); i++) {
//                escritura.write(frase.charAt(i));
//            }
            
        } catch (IOException ex) {
            System.out.println("Error");
        } finally {
            try {
                escritura.close();
            } catch (IOException ex) {
                Logger.getLogger(Escribe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    } 
    
}