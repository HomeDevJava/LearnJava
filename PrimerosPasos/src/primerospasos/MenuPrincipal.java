package primerospasos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MenuPrincipal {

	public static void menu() throws IOException {
		// TODO Auto-generated method stub
                Scanner entrada;
                int bandera=1;
                do
                {
                    System.out.println("Menu Primeros pasos \n---------------------");
                    System.out.println("1.-Ej. bucle while(contraeña)");
                    System.out.println("2.- Ej. bucle while(adivina numero)");
                    System.out.println("3.-Ej. bucle do-while(calcula peso ideal)");
                    System.out.println("4.-Ej. bucle FOR (tabla de multiplicar)");
                    System.out.println("5.-Ej. bucle FOR (comprueba mail)");
                    System.out.println("6.-Ej. bucle FOR (factorial de numero)");
                    System.out.println("7.-Ej. Array");
                    System.out.println("8.-Ej. Array II (bucle for each)");
                    System.out.println("9.-Ej. Array II (rellena Matriz JoptionPane)");
                    System.out.println("10.-Ej. Array II (rellena Matriz MathRandom)");
                    System.out.println("11.-Ej. Array II (Matriz Bidimensional)");
                    System.out.println("12.-Ej. Array II (Ejemplo Calculo Bidimensional)");
                    System.out.println("13.-Ej. Enum (Tipos Enumerados)");
                    
                    System.out.println("0.-Exit");
                    System.out.println("-----------------------");
                    System.out.println("Elige una opcion: ");

                    entrada= new Scanner(System.in);

                    switch(entrada.nextInt()){
                        case 0:
                            bandera=0;
                            break;

                        case 1:
                            AccesoAplicacion.ejecutar();
                            pausar();
                            break;
                        case 2:
                            AdivinaNumero.ejecuta();
                            pausar();
                            break;
                        case 3:
                            Peso_Ideal.ejecutar();
                            pausar();
                            break;
                        case 4:
                            UsoBucleFor.ejecutar();
                            pausar();
                            break;
                        case 5:
                            UsoBucleFor.comprueba_mail();
                            pausar();
                            break;
                        case 6:
                            UsoBucleFor.factorial();
                            pausar();
                            break;                             
                        case 7:
                            UsoMatrices.ejecutar();
                            pausar();
                            break;                             
                        case 8:                                 
                            UsoMatrices.bucleforeach();
                            pausar();
                            break;                            
                        case 9:                                 
                            UsoMatrices.RellenaMatriz();
                            pausar();
                            break;                                                                      
                        case 10:                                 
                            UsoMatrices.RellenaAleatorio();
                            pausar();
                            break;                            
                        case 11:                                 
                            UsoMatrices.Array_bidimensional();
                            pausar();
                            break;                            
                        case 12:                                 
                            UsoMatrices.Ejemplo_array2D();
                            pausar();
                            break;
                        case 13:
                            UsoEnum.ejecutar();
                            pausar();
                            break;
                            
                                    

                        default:
                            System.out.println("ha elegido una opcion NO valida");
                            break;
                    }
                }while(bandera !=0);
		
                
                

	}
        
        public static void pausar() throws IOException{
            System.out.println("\nPresione ENTER para continuar...");
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            br.read();
        }

}
