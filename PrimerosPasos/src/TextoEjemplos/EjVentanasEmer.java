/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class EjVentanasEmer {
    public static void main(String[] args){
        Marco_dialogo v= new Marco_dialogo();
    }
}

class Marco_dialogo extends JFrame{
    public Marco_dialogo(){
        setVisible(true);
        setTitle("Ejemplo de Ventanas Emergentes");
        setBounds(100, 100, 555, 444);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Dialogo());
    }
}

class Lamina_Dialogo extends JPanel{
    JButton boton1, boton2, boton3, boton4;
    public Lamina_Dialogo(){
    
        boton1= new JButton("boton1");
        boton2= new JButton("boton2");
        boton3= new JButton("boton3");
        boton4= new JButton("boton4");
        
        boton1.addActionListener(new accion_botones());
        boton2.addActionListener(new accion_botones());
        boton3.addActionListener(new accion_botones());
        boton4.addActionListener(new accion_botones());
        
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
    }
    
    private class accion_botones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource()==boton1) {
                JOptionPane.showMessageDialog(Lamina_Dialogo.this, "Mensaje de boton 1");
                JOptionPane.showMessageDialog(Lamina_Dialogo.this, "Mensaje de boton1", "Advetencia", 3);
            }else if (e.getSource()==boton2) {
                JOptionPane.showInputDialog(Lamina_Dialogo.this, "Introduce nombre:", "Entrada de Datos", 2);
            }else if (e.getSource()==boton3) {
                JOptionPane.showConfirmDialog(Lamina_Dialogo.this, "Elige Opcion", "Ejemplo de ShowconfirmDialog",JOptionPane.YES_NO_OPTION);
            }else if (e.getSource()==boton4) {
                JOptionPane.showOptionDialog(Lamina_Dialogo.this,"Elije la Opcion", "Ejemplo de ShowOptionDialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, ALLBITS);
            }
            
        }
        
    }
}

