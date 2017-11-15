/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgGenerica;

public class Herencia {
    
    public static void main(String[] args){
        /*
        Empleado Administrativa= new Empleado("Elena", 45, 1500);
        Jefe Directora= new Jefe("Ana", 27, 3600);        
        Empleado nuevEmpleado=Directora;
        */
        
        Pareja<Empleado> Administrativa= new Pareja<>();
        Pareja<Jefe> Directora= new Pareja<>();
        //Pareja<Empleado> Administrativa2= Directora;
        Pareja.imprimetrabajador(Directora);
        Pareja.imprimetrabajador(Administrativa);
        
    }
}
