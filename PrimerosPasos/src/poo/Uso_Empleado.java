/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author 50098250
 */
public class Uso_Empleado {
    
    public static void main(String[] args){
     
//        Empleado empleado1= new Empleado("Abel Ramos", 150000, 2013, 3, 16);//        
//        Empleado empleado2= new Empleado("Ana Lopez", 125000, 2011, 6, 2);//        
//        Empleado empleado3= new Empleado("Maria Martinez", 105000, 2008, 5, 17);//        
//        empleado1.subir_sueldo(4);//        
//        empleado2.subir_sueldo(4);//        
//        empleado3.subir_sueldo(4);//        
//        System.out.println(empleado1.datos_empleado());//        
//        System.out.println(empleado2.datos_empleado());//        
//        System.out.println(empleado3.datos_empleado());
        Jefatura jefe_RH= new Jefatura("Francisco", 20000, 2003, 7, 14);
        jefe_RH.establece_incentivo(2570);
                
        Empleado2[] misEmpleados=new Empleado2[6];
        
        misEmpleados[0]=new Empleado2("Abel Ramos", 15000, 2013, 3, 16);
        misEmpleados[1]=new Empleado2("Ana Lopez", 25000, 2011, 6, 2);
        misEmpleados[2]=new Empleado2("Maria Martinez", 10500, 2008, 5, 17);
        misEmpleados[3]= new Empleado2("Adolfo Garibaldi");
        
        //polimorfismo, principio de sustitucion
        misEmpleados[4]= jefe_RH;
        misEmpleados[5]= new Jefatura("Carmen", 18000, 1999,5, 27);
        
        //casting para aplicar incremento a Carmen
        Jefatura jefa_finanzas=(Jefatura) misEmpleados[5];
        jefa_finanzas.establece_incentivo(15500);
        
        //interface
        System.out.println("El Jefe " + jefa_finanzas.dame_nombre() +" tiene bonus de " + jefa_finanzas.establece_bonus(500));
        
        System.out.println("el empleado " + misEmpleados[3].dame_nombre() + " tiene un bonus de: " +misEmpleados[3].establece_bonus(200));
        //
        System.out.println(jefa_finanzas.tomardecisiones("Dar mas dias de vacaiones a empleados"));
                       
        //for para subir el sueldo a empleados
        for (Empleado2 misEmpleado : misEmpleados) {
            misEmpleado.subir_sueldo(4);            
        }
        
        //implementacion de interface con el metodo sort para ordenar
        Arrays.sort(misEmpleados);
        //bucle for each o bucle mejorado para imprimir los datos
        for(Empleado2 elemento:misEmpleados){
            System.out.println(elemento.datos_empleado());
        }
        
        System.out.println(Empleado2.dameIdSiguiente());


    }
    
}


class Empleado2 implements Comparable, Trabajadores{
    
    private String Nombre;
    private double Sueldo;
    private Date altaContrato;
    private int Id;
    private static int IdSiguiente=1;
    
    //Constructor
    public Empleado2(String Name, double Salary, int Anio, int Mes, int Dia){
        
        Nombre= Name;        
        Sueldo= Salary;        
        GregorianCalendar calendario= new GregorianCalendar(Anio, Mes-1, Dia);        
        altaContrato= calendario.getTime();
        Id=IdSiguiente;
        
        IdSiguiente++;
                
    }
    
    public Empleado2(String Name){
        this(Name, 10000, 2017, 1,01); 
    }
    
    //getter
    public String dame_nombre(){
        return Nombre;
    }
    
    public double dame_sueldo(){
        return Sueldo;
    }
    
    public Date dame_altaContrato(){
        return altaContrato;
    }
    
    public String datos_empleado(){
        return "Nombre: "+ dame_nombre() + "\nSueldo: " + dame_sueldo() + " \nFecha Alta: " + dame_altaContrato()
                + " \nEl Id es " + Id + "\n";
    }
    
    public static  String dameIdSiguiente(){
        return "El Id Siguiente es : " + IdSiguiente;
    }
    
    //setter
    public void subir_sueldo(double porcentaje){
        double aumento= Sueldo*porcentaje/100;
        Sueldo+=aumento;
    }

    @Override
    public int compareTo(Object o) {
        Empleado2 otroEmpleado= (Empleado2) o;
        
        if(this.Id<otroEmpleado.Id){
            return -1;
        }
        else if(this.Id > otroEmpleado.Id){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public double establece_bonus(double gratificacion) {
        
        return Trabajadores.bonus_base + gratificacion;
    }
    
    
   
    
}

//clase Jefatura que hereda de empleado
 class Jefatura extends Empleado2 implements Jefes{
    //constructor
    public Jefatura(String Name, double Salary, int Anio, int Mes, int Dia) {
        super(Name, Salary, Anio, Mes, Dia);
    }
    
    //setter
    public void establece_incentivo(double b){
        incentivo=b;
    }
    
    private double incentivo;
    
    @Override
    public double dame_sueldo(){
        double sueldoJefe= super.dame_sueldo();
        return sueldoJefe + incentivo ;
    }

    @Override
    public String tomardecisiones(String decision) {
        return "Un miembro de la direccion ha tomado la decision de : "+ decision;
        
    }

    @Override
    public double establece_bonus(double gratificacion) {
        
        double prima=2000;
        
        return Trabajadores.bonus_base + prima + gratificacion;
    }
       
}

class Director extends Jefatura{
    
    public Director(String Name, double Salary, int Anio, int Mes, int Dia) {
        super(Name, Salary, Anio, Mes, Dia);
    }
    
    
}