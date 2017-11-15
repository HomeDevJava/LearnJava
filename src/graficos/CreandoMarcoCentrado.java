/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class CreandoMarcoCentrado {
    
    public static void main(String[] args){
                
        PruebaDibujo dibujo=new PruebaDibujo();
        dibujo.ejecuta();
        
        
        
        MarcoCentrado mimarco= new MarcoCentrado();        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class MarcoCentrado extends JFrame{
    
    public MarcoCentrado(){
        //obtiene la resolucion de pantalla
        Toolkit mipantalla= Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla= mipantalla.getScreenSize();
        //se asigna a 2 variables int
        int alturapantalla=tamanoPantalla.height;
        int anchopantalla= tamanoPantalla.width;
        
        
        
        
        setTitle("Marco Centrado");
        setVisible(true);
        setSize(anchopantalla/2, alturapantalla/2);
        setLocation(anchopantalla/4, alturapantalla/4);
        
        //agregar lamina
         Lamina miLamina= new Lamina("Dibujando Swing", 100, 80);
         add(miLamina);
                 
        //cambiando el icono
        Image mi_icono= mipantalla.getImage("src/graficos/icono.png");
        setIconImage(mi_icono);
        
        
        
       
        
    }
    
}

class Lamina extends JPanel{
    
    String texto;
    int x, y;
    
    public Lamina(String texto, int x, int y){
        this.texto=texto;
        this.x=x;
        this.y=y;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawString(texto, x, y);
        
    }
    
    
}
