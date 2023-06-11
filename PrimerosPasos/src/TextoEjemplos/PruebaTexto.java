/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextoEjemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author 50098250
 */
public class PruebaTexto {
    
    public static void main(String[] args){
        Marco_Texto mimarco=new Marco_Texto();
    }
    
}

class Marco_Texto extends JFrame{
    
    public Marco_Texto(){
        setVisible(true);
        setTitle("Ejemplo de Caja de Texto");
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Lamina_Texto lamina= new Lamina_Texto();
        add(lamina);
        
    }
}

class Lamina_Texto extends JPanel{
    private JTextField campo1;
    private JLabel validacion1;
    
    public Lamina_Texto(){
        setLayout(new BorderLayout());
        JPanel lamina2= new JPanel();
        lamina2.setLayout(new FlowLayout());
        
        
        JLabel label1= new JLabel("Email: ");
        lamina2.add(label1);
    
        campo1= new JTextField(18);        
        lamina2.add(campo1);
        
        Document midoc=campo1.getDocument();
        midoc.addDocumentListener(new EscuchaTexto());
        
        
        validacion1= new JLabel("", JLabel.CENTER);
        add(validacion1, BorderLayout.CENTER);
        
        JButton miboton= new JButton("Dale");        
        DameTexto mievento= new DameTexto();
        miboton.addActionListener(mievento);
        lamina2.add(miboton);
        
        add(lamina2, BorderLayout.NORTH);
    }
    
    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(campo1.getText().trim());
            int correcto=0;
            String email= campo1.getText().trim();
            
            for (int i = 0; i < email.length(); i++) {
                
                if (email.charAt(i)== '@') {
                    correcto++;
                }
            }
            
            if (correcto>=1) {
                validacion1.setText("Correcto");
            }else{
                validacion1.setText("Incorrecto");
            }
        }
        
    }
    
    class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("has insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
