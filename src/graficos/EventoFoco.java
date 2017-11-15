/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 50098250
 */
public class EventoFoco {
    
    public static void main(String[] args){
        MarcoFoco mimarco= new MarcoFoco();
    }
}


class MarcoFoco extends JFrame{
    
    public MarcoFoco(){
        setTitle("Ejemplo de Evento Foco");
        setVisible(true);
        setBounds(100, 100, 300, 350);
        add(new LaminaFoco());
        setDefaultCloseOperation(EXIT_ON_CLOSE);      
        
    }
}

class LaminaFoco extends JPanel{
    
    JTextField cuadro1, cuadro2;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        setLayout(null);        
        
        cuadro1= new JTextField();
        cuadro2= new JTextField();
        
        cuadro1.setBounds(50, 70, 120, 20);
        cuadro2.setBounds(50, 100, 120, 20);
        
        add(cuadro1);
        add(cuadro2);
        
        cuadro1.addFocusListener(new LanzaFocos());
        cuadro2.addFocusListener(new LanzaFocos());
    }
    
    //clase interna
    private class LanzaFocos implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            if(cuadro1.hasFocus()){
                 cuadro1.setBackground(Color.yellow); 
                 cuadro2.setBackground(Color.white); 
            }else if(cuadro2.hasFocus()){
                cuadro2.setBackground(Color.yellow);
                cuadro1.setBackground(Color.white);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            if(!cuadro1.hasFocus()){
                cuadro1.setBackground(Color.white.brighter());
                 String email= cuadro1.getText();
                int arroba=0;
                boolean punto=false;

                for (int i = 0; i < email.length(); i++) {

                    if(email.charAt(i)=='@')
                        arroba++;
                    if (email.charAt(i)=='.') 
                        punto=true;
                }

                if(arroba==1 && punto==true)
                    System.out.println("Correcto");
                else
                    System.out.println("Incorrecto");
                }
           
            
        }
    }
    
}

