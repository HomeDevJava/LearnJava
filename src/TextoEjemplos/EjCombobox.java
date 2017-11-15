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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 50098250
 */
public class EjCombobox {
    
    public static void main(String[] args){
        Marco_Combo mimarco= new Marco_Combo();
       
    }
    
}

class Marco_Combo extends JFrame{
    public Marco_Combo(){
        setVisible(true);
        setBounds(200, 150, 499, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Combo());
    }

}

class Lamina_Combo extends JPanel{
    private JLabel texto;
    private JComboBox micombo;
    
    public Lamina_Combo(){
        setLayout(new BorderLayout());
        texto= new JLabel("En un Lugar de Chiapas cuyo nombre es...");
        texto.setFont(new Font("Arial", Font.PLAIN, 12));
        
        add(texto, BorderLayout.CENTER);      
        add(new lamina_comb(), BorderLayout.NORTH);
        
    }
    
    private class lamina_comb extends JPanel{
        public lamina_comb(){
            micombo= new JComboBox();
            micombo.addItem("Serif");
            micombo.addItem("Arial");
            micombo.addItem("Calibri");
            micombo.addItem("Verdana");
            micombo.setEditable(true);
            
            micombo.addActionListener(new Evento_combo());
            
            add(micombo);
            
            
        }
        private class Evento_combo implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font(micombo.getSelectedItem().toString(), Font.PLAIN, 12));
            }
            
        }
    }
    
    
}