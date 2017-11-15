
package ProgGenerica;

/** * @author 50098250 */
public class Empleado {
     String nombre;
    int edad;
    double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

   public String damedatos(){
       return "El empleado se llama: "+nombre+", Tiene "+ edad + " Años, y un salario de $"+salario;
   }
    
}
