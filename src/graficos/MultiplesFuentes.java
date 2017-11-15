/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

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
public class MultiplesFuentes {
    
    public static void main(String[] args){
        MarcoAccion mimarco= new MarcoAccion();
        
    }    
}

class MarcoAccion extends JFrame{
    
    public MarcoAccion(){
        setVisible(true);
        setTitle("Ejemplo de Multiples Fuentes");
        setBounds(100, 100, 450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        PanelAccion lamina= new PanelAccion();
        add(lamina);
        
    }
}

class PanelAccion extends JPanel{
    public PanelAccion(){
        
        AccionColor AccionAmarillo= new AccionColor("Amarillo",new ImageIcon("src/graficos/bola_amarilla.jpg"), Color.yellow);
        AccionColor AccionAzul= new AccionColor("Azul", new ImageIcon("src/graficos/bola_azul.jpg"), Color.blue);
        AccionColor AccionRojo= new AccionColor("Rojo", new ImageIcon("src/graficos/bola_roja.jpg"), Color.red);
           
        add(new JButton(AccionRojo));
        add(new JButton(AccionAmarillo));
        add(new JButton(AccionAzul));
        
        InputMap mapaEntrada= getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        //una forma de asignar el keystroke o atajo
        KeyStroke teclaRojo= KeyStroke.getKeyStroke("ctrl R");
        mapaEntrada.put(teclaRojo, "fondo_rojo");
        
        //2a forma de asignar el atajo
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");        
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
        
        //asignando la accion al mapa
        ActionMap mapaAccion=getActionMap();
        
        mapaAccion.put("fondo_amarillo", AccionAmarillo);
        mapaAccion.put("fondo_azul", AccionAzul);
        mapaAccion.put("fondo_rojo", AccionRojo);
        
    }
    
    //clase oyente e interna
    //se utilizara AbstractAccion para no implementar la interfaza Action y programar todos los methods

    class AccionColor extends AbstractAction{

        @Override

        public void actionPerformed(ActionEvent e) {

            Color c= (Color) getValue("color_de_fondo");
            setBackground(c);
            System.out.println("Nombre del Boton:" + getValue(NAME));
            System.out.println("Descripcion: "+ getValue(SHORT_DESCRIPTION));
            
        }

        //constructor
        public AccionColor(String nombre, Icon icono, Color col_boton){

            putValue(NAME, nombre);
            putValue(SMALL_ICON, icono);
            putValue(SHORT_DESCRIPTION, "poner la lamina de color "+ nombre);
            putValue("color_de_fondo", col_boton);

        }
}
    
    
    
    
    
}



