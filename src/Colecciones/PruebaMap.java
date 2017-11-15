/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 50098250
 */
public class PruebaMap {
    
    public static void main(String[] args){
        
        HashMap<String, Empleado> Personal= new HashMap<>();
        Personal.put("145", new Empleado("Abel"));
        Personal.put("146", new Empleado("Ana"));
        Personal.put("147", new Empleado("Said"));
        Personal.put("148", new Empleado("Juan"));
        
        System.out.println(Personal);
        
        Personal.remove("147");
        Personal.put("148", new Empleado("Natalia"));
        
        System.out.println(Personal);
        
        
        //System.out.println(Personal.entrySet());
        
        for (Map.Entry<String, Empleado> entrada : Personal.entrySet()) {
            
            System.out.printf("Clave: %s  Valor: %s \n", entrada.getKey(),  entrada.getValue());
            
        }
    }
    
}

class Empleado{
    
    private String nombre;
    private double sueldo;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.sueldo = 2000;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }
    
    
    
    
    
}
