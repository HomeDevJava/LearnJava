
package Hilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** * @author 50098250
 */
public class UsoHilos {
    
    public static void main(String[] args){
        MarcoRebote marco= new MarcoRebote();
    }
    
}

class Pelota{
    
    private static final int TAMX=15;	
    private static final int TAMY=15;
    private double x=0;	
    private double y=0;	
    private double dx=1;	
    private double dy=1;
    
    public Ellipse2D getShape(){
        
        return new Ellipse2D.Double(x,y,TAMX,TAMY);
			
    }
    
    public void mueve_pelota(Rectangle2D limites){
        
        x+=dx;		
        y+=dy;

        if(x<limites.getMinX()){

                x=limites.getMinX();			
                dx=-dx;
        }

        if(x + TAMX>=limites.getMaxX()){

                x=limites.getMaxX() - TAMX;			
                dx=-dx;
        }

        if(y<limites.getMinY()){

                y=limites.getMinY();			
                dy=-dy;
        }

        if(y + TAMY>=limites.getMaxY()){

                y=limites.getMaxY()-TAMY;			
                dy=-dy;

        }
    }

}

// Lamina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{
    
    private ArrayList<Pelota> pelotas= new ArrayList<>();
    
    public void add(Pelota b){
        pelotas.add(b);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2= (Graphics2D) g;
        g2.setColor(Color.red);
        for(Pelota b:pelotas){
            g2.fill(b.getShape());
        }
    }
    
}


class MarcoRebote extends JFrame{
    private LaminaPelota lamina;
    Thread t1, t2, t3;
    JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
    
    public MarcoRebote(){
        setBounds(100, 100, 500, 400);
        setTitle("Rebote");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lamina= new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        
        JPanel laminabotones = new JPanel();
        
        arranca1= new JButton("Hilo1");
        arranca1.addActionListener((ActionEvent e) -> {
            comienza_juego(e);
        });
        
        arranca2= new JButton("Hilo2");
        arranca2.addActionListener((ActionEvent e) -> {
            comienza_juego(e);
        });
        
        arranca3= new JButton("Hilo3");
        arranca3.addActionListener((ActionEvent e) -> {
            comienza_juego(e);
        });
        
        detener1= new JButton("Detener1");
        detener1.addActionListener((ActionEvent e) -> {
            detener(e);
        });
        
        detener2= new JButton("Detener2");
        detener2.addActionListener((ActionEvent e) -> {
            detener(e);
        });
        
        detener3= new JButton("Detener3");
        detener3.addActionListener((ActionEvent e) -> {
            detener(e);
        });
        
        
        /*ponerboton(laminabotones, "Dale!", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_juego();
            }
        });
        
        ponerboton(laminabotones, "Salir", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        ponerboton(laminabotones, "Detener", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener();
            }
        });*/
        laminabotones.add(arranca1);
        laminabotones.add(arranca2);
        laminabotones.add(arranca3);
        laminabotones.add(detener1);
        laminabotones.add(detener2);
        laminabotones.add(detener3);
        
        add(laminabotones, BorderLayout.SOUTH);
        
    }
    
    /*public void ponerboton(Container c, String titulo, ActionListener oyente){
        JButton boton= new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
        
    }*/
    
    public void comienza_juego(ActionEvent e){
        Pelota pelota= new Pelota();
        
        lamina.add(pelota);
        
        Runnable r= new PelotaHilos(pelota, lamina);
        
        if(e.getSource().equals(arranca1)){
            t1=new Thread(r);
            t1.start();
        }else if(e.getSource().equals(arranca2)){
            t2=new Thread(r);
            t2.start();
        }else if(e.getSource().equals(arranca3)){
            t3=new Thread(r);
            t3.start();
        }
            
                
        
    }
    
    public void detener(ActionEvent e){
        //t.stop();
        //t.interrupt();
        if(e.getSource().equals(detener1)){
            t1.interrupt();
        }else if(e.getSource().equals(detener2)){           
            t2.interrupt();
        }else if(e.getSource().equals(detener3)){
            t3.interrupt();
        }
    }
    
}

class PelotaHilos implements Runnable{

    private Pelota pelota;
    private Component lamina;

    public PelotaHilos(Pelota pelota, Component componente) {
        this.pelota = pelota;
        this.lamina = componente;
    }
    
        
    @Override
    public void run() {
        System.out.println("El estdo del hilo: "+Thread.currentThread().isInterrupted());
        //for (int i = 0; i < 3000; i++) {
        while(!Thread.currentThread().isInterrupted()){
            pelota.mueve_pelota(lamina.getBounds());
            lamina.paint(lamina.getGraphics());
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("ha ocurrido un Error");
            }
        }
        System.out.println("El estdo del hilo: "+Thread.currentThread().isInterrupted());
    }
    
}
