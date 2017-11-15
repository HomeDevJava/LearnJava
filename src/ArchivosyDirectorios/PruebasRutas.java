/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivosyDirectorios;

/**
 *
 * @author 50098250
 */

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebasRutas {
    
    public static void main(String[] args){
        
        File ruta= new File("src"+File.separator +"Streams");
        
        System.out.println(ruta.getAbsolutePath());        
        System.out.println(ruta.exists());
        
        String[] archivos= ruta.getAbsoluteFile().list();
        
        
        for(String a:archivos){
            System.out.println(a);
            
            //Asigna a f el path absoluto + el nombre del archivo o directorio
            File f= new File(ruta.getAbsolutePath(), a);
            //si es un directorio se listara su contenido
            if(f.isDirectory()){
                String[] subcarpeta= f.list();
                for (int i = 0; i < subcarpeta.length; i++) {
                    System.out.println("--"+ subcarpeta[i]);
                }
            }
            
        }
        
        Creando dir= new Creando();
        dir.crear_dir();
        dir.crear_file();
        
    }
    
}

class Creando{
    
    public void crear_dir(){
        File ruta= new File("src"+File.separator +"Streams" +File.separator+"nuevo_dir");
        
        if(ruta.mkdir())
            System.out.println("se ha creado el directorio");
        
    }
    
    public void crear_file(){
        File ruta= new File("src"+File.separator +"Streams" +File.separator+"nuevo_dir"+File.separator+"nuevo_file.txt");
        
        String archivo_destino= ruta.getAbsolutePath();
        
        try {
            ruta.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Creando.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Escritura accede_es = new Escritura();
        accede_es.escribir(archivo_destino);
    }
}

class Escritura{
    public void escribir(String ruta_archivo){
        String frase="Esto es un Ejemplo";
        
        try {
            FileWriter w=new FileWriter(ruta_archivo);
            w.write(frase);
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

class Eliminando{
    public void borrar(){
        File ruta= new File("src"+File.separator +"Streams" +File.separator+"nuevo_dir"+File.separator+"nuevo_file.txt");
        ruta.delete();
    }
}