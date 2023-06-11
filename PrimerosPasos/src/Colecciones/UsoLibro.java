/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

/**
 *
 * @author 50098250
 */
public class UsoLibro {
    
    public static void main(String[] args){
        
        Libro libro1= new Libro("P en Java", "Juan", 25);
        Libro libro2= new Libro("P en Java", "Juan", 25);
        
        if (libro1.equals(libro2)) {
            System.out.println("Es el mismo libro");
            System.out.println(libro1.getNombre());
            System.out.println(libro2.getNombre());
        }else{
            System.out.println("No es el mismo libro");
            System.out.println(libro1.getNombre());
            System.out.println(libro2.getNombre());
        }
        
    }
    
}
