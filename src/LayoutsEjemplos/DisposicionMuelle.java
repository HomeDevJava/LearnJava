/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsEjemplos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 *
 * @author 50098250
 */
public class DisposicionMuelle {
    
    public static void main(String[] args){
        Marco_Muelle mimuelle= new Marco_Muelle();
    }
    
}

class Marco_Muelle extends JFrame{
    
    public Marco_Muelle(){
        setTitle("Ejemplo Muelles");
        setBounds(190,190, 550, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        add(new Lamina_Muelle());
        
    }
}


class Lamina_Muelle extends JPanel{
    
    public Lamina_Muelle(){
        //se crean 3 botones
        JButton boton1 = new JButton("boton 1");
        JButton boton2 = new JButton("boton 2");
        JButton boton3 = new JButton("boton 3");
        
        //se contruye el muelle
        SpringLayout milayout= new SpringLayout();
        setLayout(milayout);
        
        //se agrgan los botones a la lamina
        add(boton1);
        add(boton2);
        add(boton3);
        
        Spring muelle=Spring.constant(10, 0, 9);
        milayout.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
        milayout.putConstraint(SpringLayout.WEST, boton2, muelle, SpringLayout.EAST, boton1);
        milayout.putConstraint(SpringLayout.WEST, boton3, muelle, SpringLayout.EAST, boton2);
        milayout.putConstraint(SpringLayout.EAST, this, muelle, SpringLayout.EAST, boton3);
        
    }
}