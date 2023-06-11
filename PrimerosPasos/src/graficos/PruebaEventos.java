/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class PruebaEventos {
    
    public static void main(String[] args){
        MarcoBotones mimarco= new MarcoBotones();
        
        mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        MarcoBotones mimarco2= new MarcoBotones();
        mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoBotones extends JFrame{
    
    public MarcoBotones(){
        setTitle("Ejemplo de Eventos");
        setBounds(300, 290, 500, 300);
        setVisible(true);
        
        LaminaBotones milamina= new LaminaBotones();
        add(milamina);
        
        M_ventana oyente_ventana= new M_ventana();
        addWindowListener(oyente_ventana);
        
    }
    
}

class LaminaBotones extends JPanel{
     JButton botonAzul= new JButton("Azul");
     JButton botonRojo= new JButton("Rojo");
     JButton botonGris= new JButton("Gris");
     
   
    public LaminaBotones(){
       
        add(botonAzul);
        add(botonRojo);
        add(botonGris);
        
        ColorFondo Gris= new ColorFondo(Color.gray);
        ColorFondo Azul= new ColorFondo(Color.blue);
        ColorFondo Rojo= new ColorFondo(Color.red);
        
        botonAzul.addActionListener(Azul);
        botonRojo.addActionListener(Rojo);
        botonGris.addActionListener(Gris);
    }
    
    private class ColorFondo implements ActionListener{
        
        private final Color colorDeFondo;
    
        public ColorFondo(Color c){
        
            colorDeFondo=c;
    
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(colorDeFondo);
        }    
}
    

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//        setBackground(Color.BLUE);
//        
//        Object botonPulsado=e.getSource();
//        
//        if(botonPulsado == botonAzul){
//            setBackground(Color.blue);
//        }
//        else if(botonPulsado==botonRojo){
//            setBackground(Color.red);
//        }
//        else
//            setBackground(Color.gray.brighter());
//        
//    }
    
}

class M_ventana implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana Abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ventana Cerrandose");
    }

    @Override
    public void windowClosed(WindowEvent e) { 
        System.out.println("Ventana Cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) { 
        System.out.println("Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) { 
        System.out.println("Ventana Restaurada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana Activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {  
        System.out.println("Ventana Desactivada");
    }
    
}