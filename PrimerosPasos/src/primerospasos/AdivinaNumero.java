/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerospasos;
import java.util.*;
/**
 *
 * @author 50098250
 */
public class AdivinaNumero {
    public static void ejecuta(){
         /*programa que genera un numero entre 0 y 100, el juego se trata de adivinarlo*/
    int quiz=(int)(Math.random()*100);
    
    Scanner entrada= new Scanner(System.in);
    int numero=0;
    int intentos=0;
    
    while(numero!=quiz)
    {
        intentos++;
        System.out.println("Introduce un numero");
        numero=entrada.nextInt();
        
        if(quiz<numero){
            System.out.println("MAS BAJO");
        }
        else if(quiz>numero)
        {
            System.out.println("MAS ALTO");
        }
        else{
            System.out.println("Correcto, lo has logrado en "+ intentos+ " intentos");
        }
  
    }
    }
   
}
