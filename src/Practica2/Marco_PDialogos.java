/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Marco_PDialogos extends JFrame {
    
    Lamina_principal laminaprin;
    Lamina_principal_sur laminasur;
    String cadenaMensaje="Mensaje";
    Icon iconoMensaje= new ImageIcon("src/TextoEjemplos/bola_azul.jpg");
    Object objetoMensaje=new Date();
    private Component componenteMensaje= new lamina_Ejemplo();
    
    //............contructor........................
    Marco_PDialogos(){
        setBounds(100, 100,555,444);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Prueba de Cuadros de Dialogos");
        
        laminaprin= new Lamina_principal();
        laminasur= new Lamina_principal_sur();
        laminasur.boton.addActionListener(new AccionMostrar());
        
        add(laminaprin, BorderLayout.CENTER);
        add(laminasur, BorderLayout.SOUTH);
        
    } 
    
    //.................metodo proporciona el mensaje.......................
    public Object dameMensaje(){
        switch(laminaprin.mensaje.dameSeleccion()){
            case "Cadena":
                return cadenaMensaje;                
            case "Icono":
                return iconoMensaje;
            case "Componente":
                return componenteMensaje;
            case "Otros":
                return objetoMensaje;
            case "Object[]":
                return new Object[]{cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};                
            default:
                    return null;    
        }
    }
    //...................metodo proporciona el parametro del icono.........
    public int dametipomensaje(){
        switch(laminaprin.tipomensaje.dameSeleccion()){
            case "ERROR_MESSAGE":
                return JOptionPane.ERROR_MESSAGE;
            case "INFORMATION_MESSAGE":
                return JOptionPane.INFORMATION_MESSAGE;
            case "WARNING_MESSAGE":
                return JOptionPane.WARNING_MESSAGE;
            case "QUESTION_MESSAGE":
                return JOptionPane.QUESTION_MESSAGE;
            case "PLAIN_MESSAGE":
                return JOptionPane.PLAIN_MESSAGE;
            default:
                return 0;
        }
    }
    //...............metodo proporciona parametro de confirmShowDialog................
    public int dameopcion(){
        switch(laminaprin.confirmar.dameSeleccion()){
            case "DEFAULT_OPTION":
                return JOptionPane.DEFAULT_OPTION;
            case "YES_NO_OPTION":
                return JOptionPane.YES_NO_OPTION;
            case "YES_NO_CANCEL_OPTION":
                return JOptionPane.YES_NO_CANCEL_OPTION;
            case "OK_CANCEL_OPTION":
                return JOptionPane.OK_CANCEL_OPTION;
            default:
                return 0;                    
        }
    }
    //......metodo proporciona parametro de ShowoptionDialog...........
    public Object[] dameObjetos(){
        switch(laminaprin.opcion.dameSeleccion()){
            case "String[]":
                return new String[]{"Amarillo", "Azul", "Rojo"};
            case "Icon[]":
                return new Object[]{
                    new ImageIcon("src/TextoEjemplos/bola_azul.jpg"),
                    new ImageIcon("src/TextoEjemplos/bola_roja.jpg"),
                    new ImageIcon("src/TextoEjemplos/bola_amarilla.jpg")
                };
            case "Object[]":
                return new Object[]{cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};   
                
            default:
                return null;
            
        }
    }   
    //.......metodo proporciona parametro de ShowinputDialog...........
    //............. el accion del boton mostrar......................
    private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
               
            switch(laminaprin.tipo.dameSeleccion()){
                case "Mensaje":
                    JOptionPane.showMessageDialog(Marco_PDialogos.this, dameMensaje(), "ShowmessageDialog", dametipomensaje());
                    break;
                case "Confirmar":
                    JOptionPane.showConfirmDialog(Marco_PDialogos.this, dameMensaje(), "ShowconfirmDialog", dameopcion(), dametipomensaje());
                    break;
                case "Entrada":
                    if (laminaprin.entrada.dameSeleccion().equals("Campo de Texto")) {
                        JOptionPane.showInputDialog(Marco_PDialogos.this, dameMensaje(), "ShowInputDialog", dametipomensaje());
                    }else{
                        JOptionPane.showInputDialog(Marco_PDialogos.this, dameMensaje(), "ShowInputDialog", dametipomensaje(), null,new String[]{"Amarillo", "Azul","Rojo"},null);
                    }
                    
                    break;
                case "Opcion":
                    JOptionPane.showOptionDialog(Marco_PDialogos.this, dameMensaje(), "ShowInputDialog", dameopcion(),dametipomensaje(),null,dameObjetos(),null);
                    break;
            }                
               
        }
    }
}