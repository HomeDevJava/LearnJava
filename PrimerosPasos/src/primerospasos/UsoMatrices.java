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
public class UsoMatrices {
    
    public static void ejecutar(){
        
        System.out.println("\n Ejemplo de Matrices Array \n ");
        int [] mi_matriz= new int[5];
        
        mi_matriz[0]=5;
        mi_matriz[1]=27;
        mi_matriz[2]=35;
        mi_matriz[3]=56;
        mi_matriz[4]=-7;
        
        int matriz[]={3,5,7,9,11,23,-3, -5};
        
        for (int i = 0; i < mi_matriz.length; i++) {
            System.out.println("Valor del Indice mi_matriz["+i+"]: "+mi_matriz[i]);
        }
        
        System.out.println("\n Impresion de Matriz\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Valor del Indice matriz["+i+"]: "+matriz[i]);
        }
    }
    
    public static void bucleforeach(){
        System.out.println("\nEjemplo de bucle for each \n");
        
        String paises[]= new String[8];
        
        paises[0]="Mexico";
        paises[1]="España";
        paises[2]="Cuba";
        paises[3]="Colombia";
        paises[4]="Venezuela";
        paises[5]="Peru";
        paises[6]="Chile";
        paises[7]="Argentina";
        
        for(String i:paises){
            System.out.println("Pais: "+ i);
        }
        
    }
    
    public static void RellenaMatriz(){
        System.out.println("\nEjemplo que pide nombre de paises con JoptionPane y los almacena en una Matriz\n");
        
        String matriz1[]= new String[8];
        
        for (int i = 0; i < 8; i++) {
            matriz1[i]=JOptionPane.showInputDialog("Introduce el pais " + (i+1));
        }
        
        for(String elemento:matriz1){
            System.out.println("Pais: " + elemento);
        }
        
    }
    
    public static void RellenaAleatorio(){
        System.out.println("\nEjemplo que almacena enteros en una Matriz utilizando el Random para generar numeros\n");
        int [] matriz= new int[133];
        
        for (int i = 0; i < matriz.length; i++) {
            matriz[i]=(int)Math.round(Math.random()*100);
        }
        
        for(int elemento: matriz){
            System.out.print(elemento +", ");
        }
    
    }
    
    public static void Array_bidimensional(){
        
        System.out.println("\n Ejemplo de Array Bidimensional\n");
        int [][] matrix=new int[3][2];
        
        matrix[0][0]=1;
        matrix[0][1]=2;
        
        matrix[1][0]=10;
        matrix[1][1]=20;
        
        matrix[2][0]=100;
        matrix[2][1]=200;
        
        
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            
        }
    }
    
    public static void Array_bidimensional2(){
        System.out.println("\nUsando for each para recorrer la matriz bidimensional y otra forma de llenar la matriz");
        int [][] matrix={
            {10,15,20,25,30},
            {23,45,56,55,48},
            {11,55,66,77,88},
        };
        
        for (int[] fila:matrix) {
            System.out.println(" ");
            for(int column: fila){
               System.out.print(column + " ");
            }
            
        }
    }
    
    public static void Ejemplo_array2D(){
        System.out.println("\n Ejemplo de calculo de interes al año, del 10%, 11%, 12%, 13%, 14%, 15%");
        
        double[][] saldo= new double[6][5];
        
        double interes=0.10;
        double acumulado;
        
        for (int i = 0; i < 6; i++) {
            
            saldo[i][0]=10000;
            acumulado=10000;
            
            for (int j = 1; j < 5; j++) {
                acumulado= acumulado+(acumulado*interes);
                saldo[i][j]=acumulado;
            }
            
            interes=interes +0.01;
        }
        
        
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.printf(" %1.2f", saldo[i][j]);
                System.out.print(" ");
            }
        }
        
    }
    
  
}
