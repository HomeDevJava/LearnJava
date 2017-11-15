package graficos;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;

public class PruebaEventos2 {
    
    public static void main(String[] args){
        Marcoventana mimarco= new Marcoventana();        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}

class Marcoventana extends JFrame{
    
    public Marcoventana(){
        setBounds(100, 200, 500, 333);
        setTitle("Ejemplo Eventos windows Adapter");
        setVisible(true);
        
        Lamina_X milamina= new Lamina_X();
        add(milamina);
        
        //e_ventana ventana= new e_ventana();
        addWindowListener(new e_ventana()); 
        addWindowStateListener(new CambiaEstado());
    }   
}

class Lamina_X extends JPanel{
        
        JButton btnAzul= new JButton("Azul");
        JButton btnGris= new JButton("Gris");
        
        public Lamina_X(){
            add(btnAzul);
            add(btnGris);
            
            ColorFondo FondoAzul= new ColorFondo(Color.blue);
            ColorFondo FondoGris= new ColorFondo(Color.gray);
            
            btnAzul.addActionListener(FondoAzul);
            btnGris.addActionListener(FondoGris);
        }
        
        private class ColorFondo implements ActionListener{
        
            private Color micolor;
        
            public ColorFondo(Color c){
                micolor=c;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(micolor);
            }        
        }
}

class e_ventana extends WindowAdapter{
    @Override
    public void windowIconified(WindowEvent e) { 
        System.out.println("Ventana Minimizada");
    }
}

class CambiaEstado implements WindowStateListener{

    @Override
    public void windowStateChanged(WindowEvent e) {
        
        int estado= e.getNewState();
        
        switch(estado){
            
            case Frame.NORMAL:
                System.out.println("La ventana ha cambiado a estado: Normal");
                break;
                
            case Frame.ICONIFIED:
                System.out.println("La ventana ha cambiado a estado: MINIMIZADO");
                break;   
                
            case Frame.MAXIMIZED_BOTH:
                System.out.println("La ventana ha cambiado a estado: MAXIMIXADO ");
                break;
                
            default:
                System.out.println("La ventana ha cambiado a estado: ");
                break;
                    
            
        }
        
        
       
    }
    
}