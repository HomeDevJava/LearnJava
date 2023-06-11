package Practica2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author 50098250
 */
public class Laminas extends JPanel{
    ButtonGroup grupo;
    public Laminas(String titulo, String[] opciones){
       
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        grupo= new ButtonGroup();
        
        for (int i = 0; i < opciones.length; i++) {
            JRadioButton btn= new JRadioButton(opciones[i]);
            btn.setActionCommand(opciones[i]);
            
            add(btn);
            grupo.add(btn);
            btn.setSelected(i==0);
        }       
    }
    
    public String dameSeleccion(){
        //ButtonModel miboton= grupo.getSelection();
        //String s= miboton.getActionCommand();        
        return grupo.getSelection().getActionCommand();
    }
}


class Lamina_principal extends JPanel{
    public Laminas tipo, tipomensaje, mensaje, confirmar, opcion, entrada;
    
    public Lamina_principal(){
        setLayout(new GridLayout(2,3));
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);    
        
        String[] primero={"Mensaje", "Confirmar", "Opcion", "Entrada"};
        tipo= new Laminas("Tipo", primero);
        add(tipo);
        
        String[] segundo={"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE","PLAIN_MESSAGE"};
        tipomensaje= new Laminas("Tipo de Mensaje", segundo);
        add(tipomensaje);
        
        String[] tercero={"Cadena", "Icono", "Componente", "Otros", "Object[]"};
        mensaje= new Laminas("Mensaje", tercero);
        add(mensaje);
        
        String[] cuarto={"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"};
        confirmar=new Laminas("Confirmar", cuarto);
        add(confirmar);
        
        String[] quinto= {"String[]", "Icon[]", "Object[]"};
        opcion= new Laminas("Opcion", quinto);
        add(opcion);
        
        entrada= new Laminas("Entrada", new  String[]{
            "Campo de Texto", "Combo"            
        });
        add(entrada);
        
    }
}

 class Lamina_principal_sur extends JPanel{
    JButton boton;
    public Lamina_principal_sur() {
        setSize(444, 100);
        setBackground(Color.DARK_GRAY);
        boton= new JButton("Mostrar");        
        add(boton);        
    }
}

class lamina_Ejemplo extends JPanel{     
    @Override
        public void paintComponent(Graphics g){
            super.paintComponents(g);
            Graphics2D g2= (Graphics2D) g;
            Rectangle2D rectangulo= new Rectangle2D.Double(0, 0, 100, 20);
            g2.setPaint(Color.yellow);
            g2.fill(rectangulo);
        }
    }
    

