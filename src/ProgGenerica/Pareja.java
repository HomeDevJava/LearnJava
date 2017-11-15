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
public class Pareja<T>{
    
    private T primero;
    
    public Pareja() {
        this.primero = null;
    }
    public Pareja(T primero) {
        this.primero = primero;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

    public T getPrimero() {
        return primero;
    }
    
    //La herencia en clase generica se usa "? extends Empleado"
    public static void imprimetrabajador(Pareja<? extends Empleado> p){
       Empleado primero=p.getPrimero();
        System.out.println(primero);
    }
    
    
    
}
