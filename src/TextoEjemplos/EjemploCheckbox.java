/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class EjemploCheckbox {
    
    public static void main(String[] args){
        Marco_Checks mimarco= new Marco_Checks();
    }
    
}

class Marco_Checks extends JFrame{
    public Marco_Checks(){
        setVisible(true);
        setBounds(200, 150, 490, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Checks());
    }

}

class Lamina_Checks extends JPanel{
    
    private JLabel texto;
    private JCheckBox check1, check2;
    Font miletra;
    
    public Lamina_Checks(){
        setLayout(new BorderLayout());
        miletra= new Font("Calibri", Font.PLAIN, 24);
        
        add(new Lamina_text(), BorderLayout.CENTER);
        add(new Lamina_ckeckbox(), BorderLayout.SOUTH);
        
        
        
    }
    
    private class Lamina_text extends JPanel{
    
        public Lamina_text(){
        
            texto= new JLabel("En un lugar de Chiapas cuyo nombre es...");        
            texto.setFont(miletra);
            add(texto);
    
        }
    }
    
    private class Lamina_ckeckbox extends JPanel{
        public Lamina_ckeckbox(){
            check1= new JCheckBox("Negrita");
            check2= new JCheckBox("Cursiva");
            
            check1.addActionListener(new ManejaCheckbox());
            check2.addActionListener(new ManejaCheckbox());
            
            add(check1);
            add(check2);
            
        }
        
        private class ManejaCheckbox implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                int tipo=0;
                
                if(check1.isSelected()) tipo+=Font.BOLD;                
                if(check2.isSelected()) tipo+=Font.ITALIC;                
                texto.setFont(new Font("Calibri", tipo, 24));
                
            }            
        }
    }
    
}

