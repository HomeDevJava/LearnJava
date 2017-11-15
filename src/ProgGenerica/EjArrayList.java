/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgGenerica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 50098250
 */
public class EjArrayList {
    public static void main (String[] args){
        /*
        Empleado listaEmpleado[]= new Empleado[3];
        
        listaEmpleado[0]= new Empleado("Ana", 45, 2500);
        listaEmpleado[1]= new Empleado("Abel", 35, 5000);
        listaEmpleado[2]= new Empleado("Romeo", 38, 1500);
        */
        
        //definicion de Arraylist, solo almacena objetos pero no datos primitivos como enteros,
        
        
        ArrayList<Empleado> listaEmpleado= new ArrayList<>();
        //listaEmpleado.ensureCapacity(15);
        listaEmpleado.add(new Empleado("Jisashi", 35, 15900));
        listaEmpleado.add(new Empleado("Ana", 25, 10000));
        listaEmpleado.add(new Empleado("Abril", 24, 11800));
        listaEmpleado.add(new Empleado("Mavi", 35, 15900));
        listaEmpleado.add(new Empleado("Luvi", 25, 10000));
        listaEmpleado.add(new Empleado("Fede", 24, 11800));
        listaEmpleado.add(new Empleado("Miguel", 35, 5900));
        listaEmpleado.add(new Empleado("Lulu", 25, 9000));
        listaEmpleado.add(new Empleado("Elsira", 24, 5800));
        listaEmpleado.add(new Empleado("Eli", 24, 8000));
        listaEmpleado.add(new Empleado("Pedro", 28, 9800));
        
        //listaEmpleado.trimToSize();
        //listaEmpleado.set(1, new Empleado("Olga", 22, 2200));        
        //System.out.println(listaEmpleado.get(5).damedatos());
        
        System.out.println("El tamaño del ArrayList es: " +listaEmpleado.size());
        for(Empleado e:listaEmpleado){
            System.out.println(e.damedatos());
        }
        
        
        //usando el iterator
        System.out.println("\n\n Usando el Iterador para recorrer el arraylist");
        Iterator<Empleado> iterator = listaEmpleado.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().damedatos());
            
        }
        
    }
}

