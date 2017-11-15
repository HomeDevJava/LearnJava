/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.event.*;

import javax.swing.JFrame;

/**
 *
 * @author 50098250
 */
public class EventoTeclas {
    
    public static void main(String[] args){
        MarcoconTeclas mimarco= new MarcoconTeclas();
    }
    
}

class MarcoconTeclas extends JFrame{
    
    public MarcoconTeclas(){
        setTitle("Ejemplo de Evento de Teclado");
        setVisible(true);
        setBounds(100, 100, 400, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        addKeyListener(new EventodeTeclado());
        addMouseMotionListener(new EventoRaton());
        addMouseListener(new EventoRaton2());
    }    
}

class EventodeTeclado implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla=e.getKeyCode();
        System.out.print(tecla);
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
  
}

class EventoRaton implements MouseListener, MouseMotionListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("acabas de presionar");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("acabas de levantar");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("acabas de entrar");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("acabas de salir");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("estas arrastrando");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("estas moviendo el raton");
    }
    
}

//para utilizar solo un metodo se utiliza el Adapter en lugar del Listener
class EventoRaton2 extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Coordenada X: " +e.getX() + " Coordenada Y: " + e.getY());
    }
    
    @Override
     public void mousePressed(MouseEvent e) {
        
         switch (e.getModifiersEx()){             
             case MouseEvent.BUTTON1_DOWN_MASK:
                 System.out.println("has pulsado boton IZQ");
                 break;
             case MouseEvent.BUTTON2_DOWN_MASK:
                 System.out.println("has pulsado Rueda");
                 break;
             case MouseEvent.BUTTON3_DOWN_MASK:
                 System.out.println("has pulsado el boton DER");
                 break;             
         }
         
         
    }
}