/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerospasos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author 50098250
 */
public class UsoBucleFor {
    //realiza la tabla de multiplicar del numero introducido
    public static void ejecutar() throws IOException{
        System.out.print("tablas de multiplicar : ");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int numero=Integer.parseInt(br.readLine());
        System.out.println(numero);
        for(int i=0; i<10; i++){
            System.out.println(numero +" x "+ i +" = "+ numero*i);
        }
    }
    
    public static void comprueba_mail(){
        int arroba=0;
        boolean punto=false;
        String mail=JOptionPane.showInputDialog(null,"Introduce Mail","Comprobar Email");
        for (int i = 0; i < mail.length(); i++) {
            
            if (mail.charAt(i)=='@') {
                arroba++;
            }
            
            if (mail.charAt(i)=='.') {
                punto=true;
            }
        }
        
        if(arroba==1 && punto==true )
        {
            System.out.println("El mail es correcto");
        }
        else
        {
            System.out.println("El mail no es correcta");
        }
        
    }
    
    public static void factorial(){
        
        int resultado=1;
        
        int numero= Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un numero", "Calcular Factorial", JOptionPane.QUESTION_MESSAGE));
        
        for (int i = numero; i>0; i--) {
            resultado= resultado*i;
        }
        
        System.out.println("El factorial de "+ numero +"es: "+resultado);
    }

    
    
}
