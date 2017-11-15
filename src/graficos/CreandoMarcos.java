/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import javax.swing.*;

/**
 *
 * @author 50098250
 */
public class CreandoMarcos {
    
    public static void main(String[] args){
        miMarco ventana= new miMarco();        
      
    }
    
}

class miMarco extends JFrame{
    
    public miMarco(){
//        setSize(500, 300);
//        setLocation(300, 300);
        setBounds(250, 140, 400, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");
        
    }
    
}