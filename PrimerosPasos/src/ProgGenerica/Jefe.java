/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgGenerica;

/**
 *
 * @author 50098250
 */
public class Jefe extends Empleado{
    
    public Jefe(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }
    
    double incentivo(double inc){
        return inc;
    }
    
}
