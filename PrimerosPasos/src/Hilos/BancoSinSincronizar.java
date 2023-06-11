/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class BancoSinSincronizar {
    
    public static void main(String[] args){
        Banco mibanco= new Banco();
        
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r= new EjecucionTransferencias(mibanco, i, 2000);
            Thread t= new Thread(r);
            t.start();
        }
    }
    
}


class Banco{
    private final double[] cuentas;
    //private Lock cierreBanco= new ReentrantLock();
    private Condition saldoSuficiente;
    
    public Banco(){
        cuentas= new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=2000;
        }
        
        //saldoSuficiente= cierreBanco.newCondition();
        
    }
    
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
        //bloqueo del codigo para que no lo ejecute otro hilo
        //cierreBanco.lock();
        //try{
            //evalua que el saldo no es inferior a la transferencia
            /*if (cuentas[cuentaOrigen]<cantidad) {
                System.out.printf("\n---- SALDO INSUFICIENTE EN LA CTA: %d  EL SALDO ES: %10.2f Y EL RETIRO ES: %10.2f ", cuentaOrigen, cuentas[cuentaOrigen], cantidad);
                
                return;
            }else{
                System.out.println("---CANTIDAD OK---");
            }*/
            
            //para realiuzar todas las transferencias
            while(cuentas[cuentaOrigen]<cantidad){
                //saldoSuficiente.await();
                wait();
                System.out.println("Hilo en espera...");
            }

            System.out.println(Thread.currentThread());

            //dinero que sale de la cuenta origen
            cuentas[cuentaOrigen]-=cantidad;
            System.out.printf("\n %10.2f de cta: %d para la cta: %d ", cantidad, cuentaOrigen, cuentaDestino);

            cuentas[cuentaDestino]+=cantidad;

            System.out.printf("\nel saldo total de las cuentas es %10.2f ", getSaldoTotal());
            
            notifyAll();
            //avisa a los demas hilos
            //saldoSuficiente.signalAll();
            
        //}
        /*finally{
            cierreBanco.unlock();
        }*/
        
    }
    
    public double getSaldoTotal(){
        double suma_cuentas=0;
        for(double a: cuentas){
            suma_cuentas+=a;
        }
        return suma_cuentas;
    }
       
}

class EjecucionTransferencias implements Runnable{
    
    private Banco banco;
    private int deLaCuenta;
    private double max;

    @Override
    public void run() {
        while(true){
            
            try {
                int paraLacuenta= (int) (Math.random()*100);
                
                double cantidad= max*Math.random();
                
                banco.transferencia(deLaCuenta, paraLacuenta, cantidad);
                
                Thread.sleep((long) (Math.random()*20));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public EjecucionTransferencias(Banco b, int de, double max) {
        this.banco = b;
        this.deLaCuenta = de;
        this.max = max;
    }

    
    
    
    
}