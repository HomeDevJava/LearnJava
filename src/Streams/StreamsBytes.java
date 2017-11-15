/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class StreamsBytes {
    public static void main(String[] args){
        
        int contador=0;
        
        int[] datos_entrada= new int[29094];
        
        try {
            FileInputStream archivo= new FileInputStream("src/Streams/ETIRUTA411.pdf");
            boolean final_ar=false;
            while(final_ar!=true){
                int byte_entrada= archivo.read();
                
                if(byte_entrada==-1)
                    final_ar=true;
                else
                    datos_entrada[contador]=byte_entrada;
                
                
                System.out.println(datos_entrada[contador]);
                contador++;
            }
           
            archivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(StreamsBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Contador de Bytes: "+ contador);
        crea_fichero(datos_entrada);
        
    }
    
    static void crea_fichero(int[] datos_nuevo){
        
        try {
            FileOutputStream nuevo_arch= new FileOutputStream("src/Streams/ETIRUTA411_copia.pdf");
            
            for (int i = 0; i < datos_nuevo.length; i++) {
                nuevo_arch.write(datos_nuevo[i]);
            }
            
            nuevo_arch.close();
        } catch (IOException ex) {
            System.out.println("No se puede crear fichero");
        }
    }
    
}

