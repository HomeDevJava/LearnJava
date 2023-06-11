package Practica1;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

/**
  * @author 50098250
 */
public class ProcesadorTexto {
    
    public static void main(String[] args){
        Marco_Procesador mimarco= new Marco_Procesador();
    }    
}

class Marco_Procesador extends JFrame{
    
    public Marco_Procesador(){
        setTitle("Procesador Rudimentario");
        setVisible(true);
        setBounds(100, 150, 490, 390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new Lamina_Procesador());
    }
}

class Lamina_Procesador extends JPanel{
    
    JTextPane texto;    
    JMenu fuente, estilo, tamano;
    Font letras;
    JPopupMenu emergente;
    JButton negritaBarra, cursivaBarra, subrayarBarra, izqBarra, derBarra, cenBarra, jusBarra,
            azulBarra, rojoBarra, amarilloBarra;
    JToolBar barra_herramientas;
    
    public Lamina_Procesador(){
        setLayout(new BorderLayout());
        
        JPanel laminamenu= new JPanel(new FlowLayout());
        
        JMenuBar mibarra= new JMenuBar();
        //----------Menu Principal-----------------------
        fuente= new JMenu("Fuente");
        estilo= new JMenu("Estilo");
        tamano= new JMenu("Tamaño");
        //-------Menu Emergente---------------------
        emergente= new JPopupMenu("Emergente");
        JMenuItem opcion1= new JMenuItem("Negrita");
        JMenuItem opcion2= new JMenuItem("Cursiva");        
        emergente.add(opcion1);
        emergente.add(opcion2);
        opcion1.addActionListener(new StyledEditorKit.BoldAction());
        opcion1.addActionListener(new StyledEditorKit.ItalicAction());
        opcion1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        opcion1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
        //-----------Items de Menu Fuente----------------------
        configura_menu("Arial", "fuente", "Arial", 9, 10,"");
        configura_menu("Calibri", "fuente", "Calibri", 9, 10,"");
        configura_menu("Verdana", "fuente", "Verdana", 9, 10,"");
        //-----------Items de Menu Estilos-----------------
        configura_menu("Negrita", "estilo", "", Font.BOLD, 1, "src/TextoEjemplos/Negrita.png");
        configura_menu("Cursiva", "estilo", "", Font.ITALIC, 1,"src/TextoEjemplos/Cursiva.png");
        //-------------Items de Menu Tamaño-----------------------
        configura_menu("12", "tamaño", "", 9, 12,"");
        configura_menu("16", "tamaño", "", 9, 16,"");
        configura_menu("20", "tamaño", "", 9, 20,"");
        configura_menu("24", "tamaño", "", 9, 24,"");
        
        //------------------------------------------
        texto= new JTextPane();  
        texto.setComponentPopupMenu(emergente);
        
        //---------Barra de Herramientas--------
        /*JToolBar barra_herramientas= new JToolBar("Herramientas");
        JButton negritaBarra= new JButton(new ImageIcon("src/TextoEjemplos/Negrita.png"));
        JButton cursivaBarra= new JButton(new ImageIcon("src/TextoEjemplos/Cursiva.png"));
        JButton subrayarBarra= new JButton(new ImageIcon("src/TextoEjemplos/subrayar.png"));
        
        JButton azulBarra= new JButton(new ImageIcon("src/TextoEjemplos/bola_azul.jpg"));
        JButton rojoBarra= new JButton(new ImageIcon("src/TextoEjemplos/bola_roja.jpg"));
        JButton amarilloBarra= new JButton(new ImageIcon("src/TextoEjemplos/bola_amarilla.jpg"));
        
        JButton izqBarra= new JButton(new ImageIcon("src/TextoEjemplos/izquierda.png"));
        JButton derBarra= new JButton(new ImageIcon("src/TextoEjemplos/derecha.png"));
        JButton cenBarra= new JButton(new ImageIcon("src/TextoEjemplos/centro.png"));
        JButton jusBarra= new JButton(new ImageIcon("src/TextoEjemplos/justifica.png"));
        
        negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
        cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
        subrayarBarra.addActionListener(new StyledEditorKit.UnderlineAction());
        azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.blue));
        rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.red));
        amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.yellow));
        izqBarra.addActionListener(new StyledEditorKit.AlignmentAction("Alinea Izquierda", 0));
        cenBarra.addActionListener(new StyledEditorKit.AlignmentAction("centrado", 1));
        derBarra.addActionListener(new StyledEditorKit.AlignmentAction("Deracha", 2));
        jusBarra.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
        
        barra_herramientas.add(negritaBarra);
        barra_herramientas.add(cursivaBarra);
        barra_herramientas.add(subrayarBarra);
        
        barra_herramientas.add(azulBarra);
        barra_herramientas.add(rojoBarra);
        barra_herramientas.add(amarilloBarra);
        
        barra_herramientas.add(izqBarra);
        barra_herramientas.add(derBarra);
        barra_herramientas.add(cenBarra);
        barra_herramientas.add(jusBarra);*/
        
        barra_herramientas= new JToolBar();
        configura_barra("src/TextoEjemplos/Negrita.png").addActionListener(new StyledEditorKit.BoldAction());
        configura_barra("src/TextoEjemplos/Cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
        configura_barra("src/TextoEjemplos/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
        barra_herramientas.addSeparator();
        configura_barra("src/TextoEjemplos/bola_azul.jpg").addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.blue));
        configura_barra("src/TextoEjemplos/bola_roja.jpg").addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.red));
        configura_barra("src/TextoEjemplos/bola_amarilla.jpg").addActionListener(new StyledEditorKit.ForegroundAction("Azulear", Color.yellow));
        barra_herramientas.addSeparator();
        configura_barra("src/TextoEjemplos/izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configura_barra("src/TextoEjemplos/centro.png").addActionListener(new StyledEditorKit.AlignmentAction("centrado", 1));
        configura_barra("src/TextoEjemplos/derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        configura_barra("src/TextoEjemplos/justifica.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
        
        barra_herramientas.setOrientation(SwingConstants.VERTICAL);        
        //----Agrgando Todo a Lamina Principal--------------------
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamano);
        
        laminamenu.add(mibarra);        
        add(laminamenu, BorderLayout.NORTH);
        add(texto, BorderLayout.CENTER);
        add(barra_herramientas, BorderLayout.WEST);
    }
    
    public JButton configura_barra(String ruta){
        JButton boton= new JButton(new ImageIcon(ruta));
        barra_herramientas.add(boton);
        return boton;
    }
    
    
    private void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta){
        
        JMenuItem elem_menu= new JMenuItem(rotulo, new ImageIcon(ruta));
        
        if(null != menu)switch (menu) {
            case "fuente":
                fuente.add(elem_menu);
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambialetra", tipo_letra));//               
                break;
            case "estilo":
                //JCheckBoxMenuItem elem_estilo= new JCheckBoxMenuItem(rotulo, new ImageIcon(ruta));
                estilo.add(elem_menu);
                if(estilos==Font.BOLD){
                    elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                    //elem_estilo.addActionListener(new StyledEditorKit.BoldAction());
                    elem_menu.addActionListener(new StyledEditorKit.BoldAction());
                }else if(estilos==Font.ITALIC){
                    elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                    //elem_estilo.addActionListener(new StyledEditorKit.ItalicAction());
                    elem_menu.addActionListener(new StyledEditorKit.ItalicAction());                    
                }                
                break;
            case "tamaño":
                tamano.add(elem_menu);                
                elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam));
                break;
            default:
                break;
        }        
//        elem_menu.addActionListener(new Gestiona_eventos(rotulo, tipo_letra, estilos, tam));        
    }
}
    
//    private class Gestiona_eventos implements ActionListener{
//        String tipo_texto, menu;
//        int estiloletra, tamanoletra;
//
//        public Gestiona_eventos(String elemento, String texto2, int estilo2, int tam_letra) {
//            tipo_texto=texto2;
//            estiloletra=estilo2;
//            tamanoletra=tam_letra;
//            menu= elemento;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {        
//            letras=texto.getFont();
//            
//            if (menu=="Arial" || menu=="Courier" || menu=="Calibri") {
//                estiloletra=letras.getStyle();
//                tamanoletra=letras.getSize();
//            } else if (menu=="Cursiva" || menu=="Negrita") {
//                if (letras.getStyle()==1 || letras.getStyle()==2) {
//                    estiloletra=3;
//                }
//                tipo_texto= letras.getFontName();
//                tamanoletra=letras.getSize();
//            }else if (menu=="12" || menu=="16" || menu=="20" || menu=="24") {
//                estiloletra=letras.getStyle();
//                tipo_texto=letras.getFontName();
//            }
//            
//            
//            texto.setFont(new Font(tipo_texto, estiloletra, tamanoletra));
//            System.out.println("Tipo:" + tipo_texto +"\nestilo: " + estiloletra + "\ntamaño: " +tamanoletra);
//            
//        }
//        
//    }
   
           