/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class Bufferes {
    public static void main(String[] args){
        Lee_Buffer l= new Lee_Buffer();
        l.lee();
    }
    
}

class Lee_Buffer{
    public void lee(){
        
        try {
            FileReader lectura= new FileReader("src/Streams/Ejemplo1.txt");
            BufferedReader mibufer= new BufferedReader(lectura);
            
            String linea="";
            
            while(linea!=null){
                try {
                    linea=mibufer.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Lee_Buffer.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(linea);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error" +ex);
        }
        
    }
}