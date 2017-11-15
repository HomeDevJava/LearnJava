package graficos;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import sun.java2d.pipe.DrawImage;

public class CreandoImagenes {
    
    public static void main(String[] args){
       
        Marco mimarco= new Marco();
        mimarco.setVisible(true);              
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}

class Marco extends JFrame{
    
    public Marco(){
        
        setTitle("Ejemplo de manupulacion de Imagenes");
        setBackground(Color.gray.brighter());
        setSize(400, 400);
        Laminas milamina= new Laminas();
        add(milamina);
    }
    
}

class Laminas extends JPanel{
    private Image imagen;
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponents(g);
        
//        Graphics2D g2=(Graphics2D) g;
       
//         Rectangle2D rectangulo= new Rectangle2D.Double(0, 0,100 ,100); 
//         g2.setPaint(Color.BLUE);
//         g2.fill(rectangulo);
//         g2.setPaint(Color.WHITE);
//         g2.draw(rectangulo);
         
//         //copy Area
//         
//         for (int i = 0; i < 300; i++) {
//             for (int j = 0; j < 300; j++) {
//                 g2.copyArea(0, 0, 100, 102, i*100, j*100);
//             }
//        }  
        try {
            //File mifile= new File("src/graficos/imagen.jpg");
            imagen=ImageIO.read(new File("src/graficos/gepp.png"));
            
            g.drawImage(imagen, 0, 0, this);
        } 
        catch (IOException ex) {
            Logger.getLogger(Laminas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int anchura=imagen.getWidth(this);
        int altura= imagen.getHeight(this);
         for (int i = 0; i < 300; i++) {
             for (int j = 0; j < 300; j++) {
                 g.copyArea(0, 0, anchura, altura, i*anchura, j*altura);
             }
        }
    }    
}