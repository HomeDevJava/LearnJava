/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsEjemplos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.*;

/**
 *
 * @author 50098250
 */
public class DisposicionLibre {
    
    public static void main(String[] args){
        Marco_Libre mimuelle= new Marco_Libre();
    }
    
}

class Marco_Libre extends JFrame {
    
    public Marco_Libre(){
        setTitle("Ejemplo Muelles");
        setBounds(50,50, 650, 550);        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Libre());
                
        add(new Lamina_libre2());
        
        
    }
}


class Lamina_Libre extends JPanel{
    
    public Lamina_Libre(){
      
        setLayout(null);
        setSize(300,300);
        setLocation(250, 0);
        JButton boton1= new JButton("boton 1");
        boton1.setBounds(50, 50, 100,20);
        JButton boton2= new JButton("boton 2");
        boton2.setBounds(155, 50, 100, 20);
        
        add(boton1);
        add(boton2);
        
    }
}

class Lamina_libre2 extends JPanel{
    public Lamina_libre2(){
        setLayout(new Encolumnas());            
        setSize(300, 300);
        setLocation(20, 20);
        JLabel name= new JLabel("Nombre:");
        JLabel lastname= new JLabel("Apellidos:");
        JLabel edad= new JLabel("Edad:");
        
        JTextField c_name= new JTextField();
        JTextField c_lastname= new JTextField();
        JTextField c_edad= new JTextField();
        
        add(name);
        add(c_name);
        add(lastname);
        add(c_lastname);
        add(edad);
        add(c_edad);
        
    }
}

class Encolumnas implements LayoutManager{
    private int x= 20;
    private int y=20;

    @Override
    public void addLayoutComponent(String name, Component comp) { }

    @Override
    public void removeLayoutComponent(Component comp) { }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container micontenedor) {
       int contador=0;
       int n=micontenedor.getComponentCount();
       
        for (int i = 0; i < n; i++) {
            
            contador++;
            Component c= micontenedor.getComponent(i);
            c.setBounds(x, y, 100, 20);
            x+=100;
            
            if (contador%2==0) {
                x=20;
                y+=40;
            }
        }
    }
    
}