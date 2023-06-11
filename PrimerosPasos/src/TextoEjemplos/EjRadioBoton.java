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
public class EjRadioBoton {
    public static void main(String[] args){
         Marco_Radio mimarco=new Marco_Radio();
    }
   
}


class Marco_Radio extends JFrame{
    public Marco_Radio(){
        setVisible(true);
        setBounds(200, 150, 400, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Radio());
    }
}

class Lamina_Radio extends JPanel{
    public Lamina_Radio(){
        ButtonGroup migrupo1= new ButtonGroup();
        JRadioButton radio1= new JRadioButton("Azul", true);
        JRadioButton radio2= new JRadioButton("Rojo", false);
        JRadioButton radio3= new JRadioButton("Verde", false);
        
        migrupo1.add(radio1);
        migrupo1.add(radio2);
        migrupo1.add(radio3);
        
        add(radio1);
        add(radio2);
        add(radio3);
    }
}