/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgGenerica;

import java.util.Date;

public class MetodosGenericos {
    public static void main(String[] args){
        
        String nombres[]={"Jose", "Maria", "Pepe", "Javier"};
        
        System.out.println(MisMatrices.getElementos(nombres));
        
        System.out.println("El menor es: " + MisMatrices.getElemMenor(nombres));
        
        Date fechas[]={ 
            new Date(2016, 07, 15),
            new Date(2016, 11, 14),
            new Date(2016, 06, 13)  
        };
        
        System.out.println(MisMatrices.getElemMenor(fechas));
        
       
    }
    
}


class MisMatrices{
    //Metodo Generico, debe ser static para no instanciar la clase
    public static <T> String getElementos(T[] a){
        return "El Array tiene " +a.length + " Elementos";
    }
    
    public static <T extends Comparable> T getElemMenor(T[] a){
        if(a==null || a.length==0){
            return null;
        }
        
        T elementoMenor=a[0];
        
        for (int i = 1; i < a.length; i++) {
            if(elementoMenor.compareTo(a[i])>0){
                elementoMenor=a[i];
            }
        }
        return elementoMenor;
        
    }
    
    
}