/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;

/**
 *
 * @author 50098250
 */
public class EjBarraHerramientas {
    
    public static void main(String[] args){
        
        MarcoAccion mimarco= new MarcoAccion();        
    }    
}

class MarcoAccion extends JFrame{
    
    AccionColor AccionAmarillo, AccionAzul, AccionRojo;
    JPanel lamina;
    
    public MarcoAccion(){
        setVisible(true);
        setTitle("Ejemplo de Multiples Fuentes");
        setBounds(100, 100, 450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lamina= new JPanel();
        add(lamina);
        
        AccionAmarillo= new AccionColor("Amarillo",new ImageIcon("src/graficos/bola_amarilla.jpg"), Color.yellow);
        AccionAzul= new AccionColor("Azul", new ImageIcon("src/graficos/bola_azul.jpg"), Color.blue);
        AccionRojo= new AccionColor("Rojo", new ImageIcon("src/graficos/bola_roja.jpg"), Color.red);
        
        //para no crear otra clase se instacia directamente y se programa el metodo abstracto
        Action accionsalir= new AbstractAction("Salir", new ImageIcon("src/graficos/salir.png")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
           
//        add(new JButton(AccionRojo));
//        add(new JButton(AccionAmarillo));
//        add(new JButton(AccionAzul));
        
        //----Menu----------------------------
        JMenu menu= new JMenu("Color");
        menu.add(AccionAzul);
        menu.add(AccionRojo);
        menu.add(AccionAmarillo);
        
        JMenuBar Barra_menus= new JMenuBar();
        Barra_menus.add(menu);
        setJMenuBar(Barra_menus);
        
        //----Barra de Herramientas-----------
        JToolBar barra= new JToolBar();
        barra.add(AccionAzul);
        barra.add(AccionAmarillo);
        barra.add(AccionRojo);
        barra.addSeparator();
        barra.add(accionsalir);
        //se agrega la barra de herrramientas al borderllayout para permitir moverla
        add(barra, BorderLayout.NORTH);
        
        
    }
    
    class AccionColor extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {

            Color c= (Color) getValue("color_de_fondo");
            lamina.setBackground(c);
            System.out.println("Nombre del Boton:" + getValue(NAME));
            System.out.println("Descripcion: "+ getValue(SHORT_DESCRIPTION));
            
        }

        //constructor
        public AccionColor(String nombre, Icon icono, Color c){

            putValue(NAME, nombre);
            putValue(SMALL_ICON, icono);
            putValue(SHORT_DESCRIPTION, "poner la lamina de color "+ nombre);
            putValue("color_de_fondo", c);

        }

    }
    
  
}



