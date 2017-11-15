/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author 50098250
 */
public class CuentasUsuarios {
    
    public static void main(String[] args){
        
        Cliente cl1= new Cliente("Antonio Banderas", "00001", 200000);
        Cliente cl2= new Cliente("James Bond", "00002", 300000);
        Cliente cl3= new Cliente("Chris Andersen", "00003", 50000);
        Cliente cl4= new Cliente("Michael Jordan", "00004", 450000);
        Cliente cl5= new Cliente("Michael Jordan", "00004", 450000);
        
        //Coleccion SET->HashSet, no permite duplicados, ordenamiento y ac. aleatorio 
        //pero hay que contruir los metodos hashcode/equals
        Set<Cliente> clientesBanco= new HashSet<>(); 
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);
        
        
        for (Cliente cliente : clientesBanco) {
            System.out.printf("Cliente:%s Cuenta:%s Saldo:%10.2f \n",
                    cliente.getNombre(),cliente.getN_cuenta(),cliente.getSaldo());
            
            //esta forma no funciona para remover elementos de una coleccion
            /*if (cliente.getNombre().equals("Chris Andersen")) {
                clientesBanco.remove(cliente);
            }*/
        }
                
        //Para eliminar objetos de una coleccion se utiliza un iterador pq no se puede con 
        //un foreach ya que marca error Exception
        System.out.println("-----------------------------------------");
        Iterator<Cliente> it=clientesBanco.iterator();        
        while(it.hasNext()){
            String nombre_cliente=it.next().getNombre();
            if (nombre_cliente=="Chris Andersen") {
                it.remove();
            }
        }
        
        
        
         for (Cliente clientes : clientesBanco) {
            System.out.printf("\nCliente:%s Cuenta:%s Saldo:%10.2f \n",
                    clientes.getNombre(),clientes.getN_cuenta(),clientes.getSaldo());
        }
    }
    
}
