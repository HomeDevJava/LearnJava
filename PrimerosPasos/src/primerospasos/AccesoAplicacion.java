/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerospasos;
import javax.swing.*;

/**
 *
 * @author 50098250
 */
public class AccesoAplicacion {
    
    public static void ejecutar(){
         String clave="Abel";
         String psw="";
         
         while(clave.equals(psw)==false){
             psw= JOptionPane.showInputDialog("Introduce la contraseña, por favor");
             if (clave.equals(psw)==false) {
                 System.out.println("Contraeña Incorrecta");
             }
             else
             {
                 System.out.println("Contraseña Correcta. Acceso permitido");
             }
        
         }
    }
   
    
    
}
