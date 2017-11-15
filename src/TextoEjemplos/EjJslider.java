/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author 50098250
 */
public class EjJslider {
    
    public static void main(String[] args){
        Marco_slider mimarco= new Marco_slider();
    }    
}

class Marco_slider extends JFrame{
    public Marco_slider(){
        setVisible(true);
        setBounds(200, 180, 499, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_slider());
        
    }
}

class Lamina_slider extends JPanel{
    private JLabel texto;
    private JSlider control;
    
    public Lamina_slider(){
        setLayout(new BorderLayout());
        control= new JSlider(8,50,15);
        control.setMinorTickSpacing(5);
        control.setMajorTickSpacing(25);
        control.setPaintTicks(true);
        control.setFont(new Font("Calibri", Font.ITALIC, 9));
        control.setPaintLabels(true);
        control.setSnapToTicks(true);
        
        ChangeListener evento= new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {                
                texto.setFont(new Font("Calibri", Font.PLAIN, control.getValue()));
            }
        };
        
        control.addChangeListener(evento);
        
        add(control, BorderLayout.NORTH);
        add(new lamina_jslidertext(), BorderLayout.CENTER);
        add(new Lamina_spinner(), BorderLayout.SOUTH);
    }
    
    private class lamina_jslidertext extends JPanel{
        public lamina_jslidertext(){
            texto= new JLabel("En un Lugar como Chiapas en donde esta el..");
            add(texto);
        }           
    }
    
    private class Lamina_spinner extends JPanel{
        public Lamina_spinner(){
            Dimension dim= new Dimension(150, 20);
            
            JSpinner mispinner1= new JSpinner(new SpinnerNumberModel(10, 8, 30, 2));            
            mispinner1.setPreferredSize(dim);
            
            JSpinner mispinner2= new JSpinner(new SpinnerDateModel());            
            mispinner2.setPreferredSize(dim);
            
            String[] lista= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            JSpinner mispinner3= new JSpinner(new SpinnerListModel(lista));
            mispinner3.setPreferredSize(dim);
            
            
             
            mispinner1.addChangeListener((ChangeEvent e) -> {
                texto.setFont(new Font(mispinner3.getValue().toString(), Font.PLAIN, (int) mispinner1.getValue()));
            });
            
            mispinner3.addChangeListener((ChangeEvent e) -> {
                texto.setFont(new Font(mispinner3.getValue().toString(), Font.PLAIN, (int) mispinner1.getValue()));
            });
            
            
            add(mispinner1);
            add(mispinner2);
            add(mispinner3);
        }
    }
}