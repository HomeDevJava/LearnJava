/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import javax.swing.JOptionPane;

/**
 *
 * @author 50098250
 */
public class Uso_Vehiculo {
    
    public static void main(String[] args){
        
//         Coche Renault= new Coche();
//         
//         System.out.println(Renault.datos_generales());
//         
//         Renault.setColor(JOptionPane.showInputDialog("Introduce Color:"));
//         System.out.println(Renault.getColor());
//         
//         
//         Renault.configura_asientos(JOptionPane.showInputDialog("Tiene Asientos de Cuero(si/no)?"));
//         System.out.println(Renault.dime_asientos());
//         
//         Renault.setClimatizador(JOptionPane.showInputDialog("Tiene Climatizador(si/no)?"));
//         System.out.println(Renault.dime_Climatizador());
//         
//         System.out.println(Renault.dime_peso_coche());
//         
//         System.out.println("El precio final del Coche es: " + Renault.precio_coche()+ " Euros");
         
//         System.out.println("Este coche tiene "+ Renault.ruedas +" ruedas");


        Coche miCoche1= new Coche();        
        miCoche1.setColor("Plata");
        
        Furgoneta miFurgoneta1= new Furgoneta(7, 580);
        miFurgoneta1.setColor("Negro");
        miFurgoneta1.configura_asientos("si");
        miFurgoneta1.setClimatizador("si");
        
        System.out.println(miCoche1.datos_generales() + miCoche1.getColor());
        
        System.out.println(miFurgoneta1.datos_generales() + miFurgoneta1.dime_DatosFrugoneta());
        
    }
    
     
}
