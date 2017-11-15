/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 50098250
 */
public class EventoFocoVentana extends JFrame implements WindowFocusListener{
    
    public static void main(String[] args){
        EventoFocoVentana miv= new EventoFocoVentana();
        miv.iniciar();
    }
    
    EventoFocoVentana marco1;
    EventoFocoVentana marco2;
    public void iniciar(){
        
        marco1= new EventoFocoVentana();
        marco2= new EventoFocoVentana();
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setBounds(200, 100, 350, 240);
        marco2.setBounds(550, 100, 350, 240);
        marco1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
    }
    
   

    @Override
    public void windowGainedFocus(WindowEvent e) {
        
        if (e.getSource()==marco1) {
            marco1.setTitle("tengo el foco!!");
        }else{
            marco2.setTitle("tengo el foco");
        }
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
         if (e.getSource()==marco1) {
            marco1.setTitle("");
        }else{
            marco2.setTitle("");
        }
    }
    
}
