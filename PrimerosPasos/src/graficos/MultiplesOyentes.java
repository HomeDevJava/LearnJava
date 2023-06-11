/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class MultiplesOyentes {
    
    public static void main(String[] args){
        MarcoOyente mimarco=new MarcoOyente();
    }
    
}


class MarcoOyente extends JFrame{
    
    public MarcoOyente(){
        setTitle("Ejemplo Multiples Oyentes");
        setBounds(250, 50, 450, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        LaminaOyente lamina = new LaminaOyente();
        add(lamina);
        
    }
}

class LaminaOyente extends JPanel{
    
    JButton boton_Cerrar;
    
    public LaminaOyente(){
        
        JButton boton_nuevo= new JButton("Nuevo");
        boton_Cerrar= new JButton("Cerrar Todo");
        add(boton_nuevo);
        add(boton_Cerrar);
        
        OyenteNuevo mioyente= new OyenteNuevo();        
        boton_nuevo.addActionListener(mioyente);
        
    } 
    
    private class OyenteNuevo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Marco_Emergente marco= new Marco_Emergente(boton_Cerrar);
            
        }
        
    }
}

class Marco_Emergente extends JFrame{
    
    private static int contador=0;
    
    public Marco_Emergente(JButton boton_de_principal){
        contador++;
        setTitle("Ventana " + contador);
        setBounds(70*contador, 70*contador, 300, 150);
        setVisible(true);
        
        CierraTodos oyentecerrar= new CierraTodos();
        boton_de_principal.addActionListener(oyentecerrar);
        
    }
    
    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();           
        }
        
    }
    
}