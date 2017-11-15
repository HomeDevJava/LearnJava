/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author 50098250
 */
public class Uso_Persona {
    
    public static void main(String[] args){
        
        Persona[] lasPersonas= new Persona[2];
        
        lasPersonas[0]=new Empleado("Jisashi", 18000, 2013, 2, 16);
        lasPersonas[1]= new Alumno("Antonio", "Biologia");
        
        for(Persona p: lasPersonas){
            System.out.println(p.dame_nombre() + " ," + p.dame_descripcion());
        }
    }
 
    
    
}

abstract class Persona{
    
    private String Nombre;
    
    public Persona(String nombre){
        Nombre=nombre;
    }
    
    public String dame_nombre(){
        return Nombre;
    }
    
    public abstract String dame_descripcion();
    
}


class Empleado extends Persona{
    
    
    private double Sueldo;
    private Date altaContrato;
    private int Id;
    private static int IdSiguiente=1;
    
    //Constructor
    public Empleado(String Name, double Salary, int Anio, int Mes, int Dia){
        
        super(Name);     
        Sueldo= Salary;        
        GregorianCalendar calendario= new GregorianCalendar(Anio, Mes-1, Dia);        
        altaContrato= calendario.getTime();
        Id=IdSiguiente;
        
        IdSiguiente++;
                
    }
    
    public Empleado(String Name){
        this(Name, 10000, 2017, 1,01); 
    }
    
    //getter    
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
    public String dame_descripcion() {
        return "Este empleado tiene un Id= " + Id + " con un suelado de " + dame_sueldo();
    }
    
    
   
    
}

class Alumno extends Persona{
    
    private String Carrera;
    
    public Alumno(String nombre, String carrera){
        super(nombre);
        Carrera=carrera;
    }

    @Override
    public String dame_descripcion() {
        return "Este Alumno esta estudiando la Carrera de " + Carrera;
    }
}
