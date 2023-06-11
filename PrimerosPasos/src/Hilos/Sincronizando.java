/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class Sincronizando {
    
    public static void main(String[] args) throws InterruptedException{
        
        HilosVarios hilo1= new HilosVarios();
        HilosVarios2 hilo2= new HilosVarios2(hilo1);
        HilosVarios2 hilo3= new HilosVarios2(hilo2);
        
        hilo2.start();
        hilo1.start();
        hilo3.start();
        
        System.out.println("Terminada las tareas");

        /*
        try {
             hilo1.start();            
             hilo1.join();              
             hilo2.start();            
             hilo2.join();             
             System.out.println("Tareas terminadas..." + Thread.currentThread().getName());
           
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Sincronizando.class.getName()).log(Level.SEVERE, null, ex);
        } */ 
    }
    
}


class HilosVarios extends Thread{
    
    @Override
    public void run(){
        
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Ejecutando Hilo..." + getName());
                Thread.sleep(317);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}

class HilosVarios2 extends Thread{
    private Thread hilo;
    
    public HilosVarios2(Thread hilo){
        this.hilo=hilo;
    }
    
    
    @Override
    public void run(){
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Ejecutando Hilo..." + getName());
                Thread.sleep(517);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}