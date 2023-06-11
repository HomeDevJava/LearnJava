/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
/**
 *
 * @author 50098250
 */
public class PruebaTemporizador {
    
    public static void main(String[] args){
        
        DamelaHora oyente= new DamelaHora();
        Timer mitemporizador = new Timer(5000, oyente);
        
        
        
        mitemporizador.start();        
        JOptionPane.showMessageDialog(null, "pulsa aceptar para detener");
        System.exit(0);
    }
    
}

class DamelaHora implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        Date ahora= new Date();
        
        System.out.println("La hora de cada 5 segundos es: "+ ahora);
        Toolkit.getDefaultToolkit().beep();
    }
    
}