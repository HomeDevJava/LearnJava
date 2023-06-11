/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 50098250
 */
public class Leyendo {
    
    public static void main(String[] args){
        
        LeerFichero accediendo= new LeerFichero();
        accediendo.lee();
        
    }
    
}

class LeerFichero{
    
    public void lee(){
        
        try {
            FileReader entrada= new FileReader(new File("src/Streams/ejemplo.txt"));
            
            int c=entrada.read();
            System.out.println(c);
            while(c!=-1){
                c=entrada.read();
                char letra=(char) c;
                //System.out.print(c +",");
                System.out.print(letra);
            }
            entrada.close();
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo.");
        }
    }
    
}
