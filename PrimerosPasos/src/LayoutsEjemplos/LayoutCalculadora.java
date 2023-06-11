/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayoutsEjemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class LayoutCalculadora {
    
    public static void main(String[] args){
        Marco_Calculadora mimarco = new Marco_Calculadora();
    }
}
    

class Marco_Calculadora extends JFrame{
    
    public Marco_Calculadora(){
        setTitle("Ejemplo de Calculadora");
        setVisible(true);
        setBounds(150, 100, 350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        add(new LaminaCalculadora());
        pack();
        
        
    }
}

class LaminaCalculadora extends JPanel{
    
    private JPanel Lamina2;
    private JButton Pantalla;
    private boolean principio;
    private double resultado;
    private String ultimaoperacion;
    
    public LaminaCalculadora(){
        principio=true;
        setLayout(new BorderLayout(15, 15));
        Pantalla =new JButton("0");
        Pantalla.setEnabled(false);
        add(Pantalla, BorderLayout.NORTH);
        
        Lamina2= new JPanel();
        Lamina2.setLayout(new GridLayout(4, 4));
        
        ActionListener insertar= new InsertaNumero();
        ActionListener accion= new AccionOrden();
        ponerboton("7", insertar);
        ponerboton("8", insertar);
        ponerboton("9", insertar);
        ponerboton("/", accion );
        ponerboton("4", insertar);
        ponerboton("5", insertar);
        ponerboton("6", insertar);
        ponerboton("*", accion);
        ponerboton("1", insertar);
        ponerboton("2", insertar);
        ponerboton("3", insertar);
        ponerboton("-", accion);
        ponerboton("0", insertar);
        ponerboton(".", insertar);
        ponerboton("=", accion);
        ponerboton("+", accion);
        
        add(Lamina2, BorderLayout.CENTER);
        
        ultimaoperacion="=";
        
        
    }
    
    private void ponerboton(String rotulo, ActionListener oyente){
        
        JButton boton= new JButton(rotulo);
        boton.addActionListener(oyente);
        Lamina2.add(boton);
            
    }
    
    private class InsertaNumero implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String entrada= e.getActionCommand();
            if (principio) {
                Pantalla.setText("");
                principio=false;
            }
            Pantalla.setText(Pantalla.getText() + entrada);
            
        }
        
    }
    
    private class AccionOrden implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion= e.getActionCommand();
            
            calcular(Double.parseDouble(Pantalla.getText()));
            ultimaoperacion= operacion;
            principio=true;
            
        }
        
        public void calcular(double x){
            
            if (ultimaoperacion.equals("+")) {
                resultado+=x;
            }else if (ultimaoperacion.equals("-")) {
                resultado-=x;
            }else if (ultimaoperacion.equals("*")){
                resultado*=x;
            }else if (ultimaoperacion.equals("/")){
                resultado/=x;
            }
            if (ultimaoperacion.equals("=")) {
                resultado=x;
            }
            
            Pantalla.setText(""+resultado);
        }
        
    }
}
