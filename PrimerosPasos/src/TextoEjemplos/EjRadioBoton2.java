/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author 50098250
 */
public class EjRadioBoton2 {
    
    public static void main(String[] args){
        Marco_Radio2 mimarco= new Marco_Radio2();
    }
    
}

class Marco_Radio2 extends JFrame{
    public Marco_Radio2(){
        setVisible(true);
        setBounds(200, 150, 490, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Radio2());
    }

}

class Lamina_Radio2 extends JPanel{
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup migrupo;
    private JPanel laminabotones;
    
    public Lamina_Radio2(){
        
        setLayout(new BorderLayout());
        texto= new JLabel("En un Lugar de Chiapas cuyo nombre es...");
        texto.setFont(new Font("Arial", Font.PLAIN, 12));
        migrupo= new ButtonGroup();
        laminabotones= new JPanel();
        add(texto, BorderLayout.CENTER);
        ColocarBotones("Pequeño", false, 10);
        ColocarBotones("Mediano",false , 15);
        ColocarBotones("Grande", false, 20);
        ColocarBotones("Muy Grande", false, 24);
        
        add(laminabotones, BorderLayout.SOUTH);
//        
//        migrupo= new ButtonGroup();
//        boton1= new JRadioButton("Pequeño");
//        boton2= new JRadioButton("Mediano");
//        boton3= new JRadioButton("Grande");
//        boton4= new JRadioButton("Muy Grande");
//        
//        boton1.addActionListener(new Evento_Radio());
//        boton2.addActionListener(new Evento_Radio());
//        boton3.addActionListener(new Evento_Radio());
//        boton4.addActionListener(new Evento_Radio());
//        
//        migrupo.add(boton1);
//        migrupo.add(boton2);
//        migrupo.add(boton3);
//        migrupo.add(boton4);
//        
//        JPanel laminabotones= new JPanel();
//        laminabotones.add(boton1);
//        laminabotones.add(boton2);
//        laminabotones.add(boton3);
//        laminabotones.add(boton4);
//        
//        add(laminabotones, BorderLayout.SOUTH);
        
    }
    
//    private class Evento_Radio implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {            
//                      
//            if (e.getSource()==boton1) {
//                texto.setFont(new Font("Arial", Font.PLAIN, 10));
//            }else if (e.getSource()==boton2) {
//                 texto.setFont(new Font("Arial", Font.PLAIN, 15));
//            }else if (e.getSource()==boton3) {
//                 texto.setFont(new Font("Arial", Font.PLAIN, 20));
//            }else if (e.getSource()==boton4) {
//                 texto.setFont(new Font("Arial", Font.PLAIN, 24));
//            }
//            
//        }
//        
//    }
    
    public void ColocarBotones(String nombre, boolean seleccionado, final int tamano){
        JRadioButton boton= new JRadioButton(nombre, seleccionado);
        migrupo.add(boton);
        laminabotones.add(boton);
        
        ActionListener mievento= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, tamano));
            }
        };
        
        boton.addActionListener(mievento);
        
    } 
}