/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsEjemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class EjemploLayout {
    
    public static void main(String[] args){
        Marco_Layout mimarco = new Marco_Layout();
    }
    
    
}

class Marco_Layout extends JFrame{
    
    public Marco_Layout(){
        setTitle("Ejemplo de Layouts");
        setVisible(true);
        setBounds(100, 100, 550, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        add(new Panel_Layout(), BorderLayout.NORTH);
        add(new Panel_Layout2(), BorderLayout.SOUTH);
        
    }
}

class Panel_Layout extends JPanel{
    
    public Panel_Layout(){
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        //setLayout(new BorderLayout(10,10));
        add(new JButton("Amarillo"));        
        add(new JButton("Rojo"));
       
        
      
    }
    
}

class Panel_Layout2 extends JPanel{
    
    public Panel_Layout2(){
        setLayout(new BorderLayout());
        add(new JButton("Cyan"), BorderLayout.WEST);
        add(new JButton("Azul"), BorderLayout.EAST);
        add(new JButton("Verde"), BorderLayout.CENTER);
    }
}