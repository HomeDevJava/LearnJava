/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class PruebaDibujo {
    
    class MarcoDibujos extends JFrame{
        
        public MarcoDibujos(){
            
            setFont(new Font("Arial", Font.BOLD , 15));
            setTitle("Prueba de Dibujo");
            setSize(400, 400);
       
            LaminaconFiguras L= new LaminaconFiguras();           
            add(L); 
        }
}
    
    class LaminaconFiguras extends JPanel{
        
        public void paintComponent(Graphics g){                
            super.paintComponents(g);                
            g.drawRect(50, 50, 200, 200); 
            g.drawOval(50, 50, 200, 200);
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 26));
            g.drawString("Hola Mundo", 100, 101);
            
            g.setColor(Color.BLUE);
            g.setFont(new Font("Calibri", Font.ITALIC, 20));
            g.drawString("Learn Java", 100, 151);
            
        }
    
    
}
    
    class LaminaconRectangulo extends JPanel{
        
        @Override
        public void paintComponent(Graphics g){                
            super.paintComponents(g);                
            
            //refundicion o casting de la variable g para convertirla en Grraphics2D
            Graphics2D g2=(Graphics2D) g;
            
            //Dibujando un rectangulo con java2d, no se instancia rectangle2d por ser abstract
            //se utiliza rectangle2d.double
            Rectangle2D rectangulo= new Rectangle2D.Double(100, 100,200 ,150); 
            g2.setPaint(Color.BLUE);
            g2.fill(rectangulo);
            g2.setColor(Color.YELLOW);
            g2.draw(rectangulo);
            
            //dibujando una elipse con java2d
            Ellipse2D elipse= new Ellipse2D.Double();            
            elipse.setFrame(rectangulo);   
            g2.setPaint(new Color(70, 172, 166));
            g2.fill(elipse);
            
            g2.draw(elipse);            
            g2.draw(new Line2D.Double(100, 100, 300, 250));
            
//            dibujando un circulo con java2d
//            double centroenx= rectangulo.getCenterX();
//            double centroeny= rectangulo.getCenterY();
//            double radio=130;            
//            Ellipse2D circulo= new Ellipse2D.Double();
//            circulo.setFrameFromCenter(centroenx, centroeny, centroenx +radio, centroeny + radio);
//            g2.draw(circulo);         
            
        }
    
    
}
    
    public void ejecuta(){
         MarcoDibujos mimarco= new MarcoDibujos();
         mimarco.setVisible(true);
         mimarco.setBackground(Color.PINK);         
         mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
}




