/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import javax.swing.*;


/**
 *
 * @author 50098250
 */
public class EjMenus {
    public static void main(String[] args){
        Marco_Menu mimarco = new Marco_Menu();
    }
    
}

class Marco_Menu extends JFrame{
    public Marco_Menu(){
        setVisible(true);
        setBounds(150, 190, 460, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Menu());
    }
}

class Lamina_Menu extends JPanel{
    
    public Lamina_Menu(){
        JMenuBar mibarra= new JMenuBar();
        JMenu archivo= new JMenu("Archivo");
        JMenu edicion= new JMenu("Edicion");
        JMenu herramientas= new JMenu("Herramientas");
        JMenu opciones= new JMenu("Opciones");
       
        
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarcomo = new JMenuItem("Guardar Como");
        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/TextoEjemplos/Copiar.png"));
        JMenuItem cortar = new JMenuItem("Cortar",new ImageIcon("src/TextoEjemplos/Cortar.png"));
        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/TextoEjemplos/Pegar.png"));        
        JMenuItem generales= new JMenuItem("Generales");
        JMenuItem opcion1= new JMenuItem("Opcion1");
        JMenuItem opcion2= new JMenuItem("Opcion2");
        
        opciones.add(opcion1);
        opciones.add(opcion2);
        
        archivo.add(guardar);
        archivo.add(guardarcomo);
        edicion.add(copiar);
        edicion.add(cortar);
        edicion.add(pegar);
        edicion.addSeparator();
        edicion.add(opciones);
        herramientas.add(generales);
        
        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);
        add(mibarra);
        
    }
}
