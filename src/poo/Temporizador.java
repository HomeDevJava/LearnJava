/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author 50098250
 */
public class Temporizador {
    
    public static void main(String[] args){
        Reloj miReloj= new Reloj(3000, true);
        miReloj.enMarcha();
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
        System.exit(0);
    }
    
}

class Reloj{
    
    private int intervalo;
    private boolean  sonido;
    
    public Reloj(int intervalo, boolean sonido){
        
        this.intervalo=intervalo;
        this.sonido=sonido;       
        
    }
    
    public void enMarcha(){
        
        ActionListener oyente=new DameLaHora2();
        Timer mitemprorizador= new Timer(intervalo, oyente);
        mitemprorizador.start();
    }

    private class DameLaHora2 implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora=new Date();
            System.out.println(ahora);
            
            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
                
        }
    }
    
    
    
}
