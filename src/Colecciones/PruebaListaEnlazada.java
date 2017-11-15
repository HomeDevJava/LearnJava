/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 50098250
 * en este ejemplo se crearan 2 listas enlazadas(Paises y Capitales), pero las capitales deberan
 * insertarse en la lista de Paises despues de su pais correspondiente
 */
public class PruebaListaEnlazada {
    
    public static void main(String[] args){
        LinkedList<String> paises= new LinkedList<>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");
        
        LinkedList<String> capitales= new LinkedList<>();
        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("DF");
        capitales.add("Lima");
        
        System.out.println("Lista de paises: "+paises);
        System.out.println("Lista de Capitales: "+capitales);
        
//creando iterador para recorrer ambas listas
        ListIterator<String> iterP=paises.listIterator();
        ListIterator<String> iterC=capitales.listIterator();
        
//Insertando las capitales en la lista de Paises
        
        while(iterC.hasNext()){
            if (iterP.hasNext()) {
                iterP.next();
                
            }
            iterP.add(iterC.next());
        }
        System.out.println("\nCapitales insertadas a la Lista de Paises...\n"+paises);
       
        
//Eliminando las posiciones 2 y 4 de la lista de capitales       
        
        iterC=capitales.listIterator();
        while(iterC.hasNext()){
            iterC.next();
            if (iterC.hasNext()) {
                iterC.next();
                iterC.remove();                        
            }
        }
        
        System.out.println("\nCapitales 2 y 4 eliminadas de la lista de Capitales...\n"+capitales);
        
        
        
//Eliminando de la lista de paises la coleccion de capitales que sobraron
        
        paises.removeAll(capitales);
        
        System.out.println("\nLista de Paises eliminando x medio de coleccion:\n "+paises);
        
        
    }
    
}
