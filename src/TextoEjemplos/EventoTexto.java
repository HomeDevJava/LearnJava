/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author 50098250
 */
public class EventoTexto {
    
    public static void main(String[] args){
        Marco_Evento mimarco= new Marco_Evento();
    }
    
}

class Marco_Evento extends JFrame{
    
    public Marco_Evento(){
        setVisible(true);
        setTitle("Login");
        setBounds(122, 122, 380, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new LaminaEvento());
        
    }
}

class LaminaEvento extends JPanel{
    private JPasswordField c_contra;
    public LaminaEvento(){
        
        setLayout(new BorderLayout(15,15));
        
        JPanel lamina_superior=new JPanel(new GridLayout(2, 2));        
        
        
        JLabel etiqueta1= new JLabel("usuario: ");
        JLabel etiqueta2= new JLabel("Contraseña: ");
        JTextField c_usuario= new JTextField(15);
         c_contra= new JPasswordField(15);
         c_contra.getDocument().addDocumentListener(new Comprueba_pass());
        
        lamina_superior.add(etiqueta1);
        lamina_superior.add(c_usuario);
        lamina_superior.add(etiqueta2);
        lamina_superior.add(c_contra);
        
        JButton enviar= new JButton("Enviar");
        add(enviar, BorderLayout.SOUTH);
        add(lamina_superior, BorderLayout.NORTH);
    }
    
    private class Comprueba_pass implements DocumentListener{
        char[] contrasena;

        @Override
        public void insertUpdate(DocumentEvent e) {
            contrasena=c_contra.getPassword();
            if(contrasena.length<8 || contrasena.length>12){
                c_contra.setBackground(Color.red);
            }else{
                c_contra.setBackground(Color.white);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            contrasena=c_contra.getPassword();
            if(contrasena.length<8 || contrasena.length>12){
                c_contra.setBackground(Color.red);
            }else{
                c_contra.setBackground(Color.white);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
    }
    
}