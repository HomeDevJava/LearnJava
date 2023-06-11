/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerospasos;

import java.util.Scanner;

/**
 *
 * @author 50098250
 */
public class UsoEnum {
//    enum Talla{MINI, MEDIANO, GRANDE, MUY_GRANDE};
    enum Talla{
        
        MINI("S"), MEDIANO("M"), GRANDE("G"), MUY_GRANDE("XL");
        
        private String abreviatura;
        
        private Talla(String abreviatura){
            this.abreviatura= abreviatura;
        }
        
        public String dameAbreviatura(){
            return abreviatura;
        }
        
    }
   
    
    
    public static void ejecutar(){
        
//        Talla s= Talla.MINI;        
//        Talla m= Talla.MEDIANO;        
//        Talla l= Talla.GRANDE;        
//        Talla xl= Talla.MUY_GRANDE;
        
        Scanner escan= new Scanner(System.in);
        
        System.out.println("Escribe una Talla:(MINI MEDIANO, GRANDE O MUY GRANDE) ");
        String datos=escan.next().toUpperCase();
        
        Talla la_talla= Enum.valueOf(Talla.class, datos);
        
        System.out.println("la talla: " +la_talla);
        System.out.println("Abreviatura: " + la_talla.dameAbreviatura());
    }
    
    
    
}
