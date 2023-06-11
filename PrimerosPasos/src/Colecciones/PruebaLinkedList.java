/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author 50098250
 */
public class PruebaLinkedList {
    
    public static void main(String[] args){
        
        LinkedList<String> personas = new LinkedList<>();
        
        personas.add("Abel");
        personas.add("Pepe");
        personas.add("Sandra");
        personas.add("Juan");
        personas.add("Laura");
        System.out.println("Elementos: "+ personas.size());
               
        ListIterator<String> it= personas.listIterator();
        it.next();
        it.add("Jisashi");
        
        for (String persona : personas) {
            System.out.println(persona);
        
        }
         
         
    }
}
