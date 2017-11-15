/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 50098250
 */
public class PruebaTextArea {
    
    public static void main(String[] args){
        Marco_area mimarco= new Marco_area();
    }
    
}

class Marco_area extends JFrame{
    public  Marco_area(){
        setVisible(true);
        setBounds(100, 150, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new LaminaArea());
        
        
        
    }
}

class LaminaArea extends JPanel{
    private JTextArea miArea;
    public LaminaArea(){
        
        miArea= new JTextArea(8, 20);
        miArea.setLineWrap(true);
        JScrollPane laminaBarras= new JScrollPane(miArea);
        
        add(laminaBarras);
        
        JButton miboton= new JButton("Dale");
        miboton.addActionListener(new GestionaArea());
        
        add(miboton);
        
    }
    
    private class GestionaArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("" + miArea.getText());
        }
        
    }
    
}
