/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsEjemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 50098250
 */
public class EjemploBox {
    
    public static void main(String[] args){
        Marco_Box mibox= new Marco_Box();
    }
    
}


class Marco_Box extends JFrame{
    
    public Marco_Box(){
        setTitle("Ejemplo de Cajas");
        setBounds(190, 190, 400, 300);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JLabel rotulo1= new JLabel("Nombre:");
        JTextField texto1= new JTextField(10);
        texto1.setMaximumSize(texto1.getPreferredSize());
        
        Box cajaH1= Box.createHorizontalBox();        
        cajaH1.add(rotulo1);
        cajaH1.add(Box.createHorizontalStrut(10));
        cajaH1.add(texto1);
        
        JLabel rotulo2= new JLabel("Contraseña:");
        JTextField texto2= new JTextField(10);
        texto2.setMaximumSize(texto2.getPreferredSize());
        
        Box cajaH2= Box.createHorizontalBox();
        cajaH2.add(rotulo2);
        cajaH2.add(Box.createHorizontalStrut(10));
        cajaH2.add(texto2);
        
        JButton boton1= new JButton("OK");
        JButton boton2= new JButton("Cancelar");
        
        Box cajaH3= Box.createHorizontalBox();
        cajaH3.add(boton1);
        cajaH3.add(Box.createGlue());
        cajaH3.add(boton2);
        
        
        Box cajaVertical= Box.createVerticalBox();
        
        cajaVertical.add(cajaH1);
        cajaVertical.add(cajaH2);
        cajaVertical.add(cajaH3);
        
        
        add(cajaVertical, BorderLayout.CENTER);
        
    }
    
    
}

class Lamina_Box extends JPanel{
    
    public Lamina_Box(){
        
    }
    
}