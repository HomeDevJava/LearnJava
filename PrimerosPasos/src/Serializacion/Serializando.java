/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50098250
 */
public class Serializando {
    
    public static void main(String[] args){
        
        ObjectOutputStream escribiendo_fichero= null;
        try {
            Administrador jefe= new Administrador("Juan", 80000, 2013, 12, 15);
            jefe.setIncentivo(5000);
            Empleado[] personal= new Empleado[3];
            personal[0]= jefe;
            personal[1]= new Empleado("Ana", 25000, 2008, 10, 1);
            personal[2]= new Empleado("Luis", 18000, 2012, 9, 15);
            
            //SERIALIZANDO OBJETO PERSONAL PARA GUARDARLO EN EL DISCO DURO
            escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("src/Streams/empleado.dat"));
            escribiendo_fichero.writeObject(personal);
            escribiendo_fichero.close();
            
            //DESERIALIZANDO ARCHIVO PARA RECUPERAR LOS DATOS GUARDADOS, DEBE RECUPERARSE A UN OBJETO DEL MISMO TIPO
            //Y POSTERIORMENTE APLICAR UN CASTING 
            ObjectInputStream recupera_fichero= new ObjectInputStream(new FileInputStream("src/Streams/empleado.dat"));            
            Empleado[] personal_recuperado=(Empleado[]) recupera_fichero.readObject();
            recupera_fichero.close();
            
            //RECORREMOS EL OBJETO PARA IMPRIMIR CADA POSICION DEL ARRAY
            for(Empleado e: personal_recuperado){
                System.out.println(e.toString());
            }
            
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Serializando.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}

class Empleado implements Serializable{
    
    private static final long serialVersionUID=1L;   
    public String nombre;
    public double sueldo;
    public Date fechacontrato;
    
    public  Empleado(String n, double s, int agno, int mes, int dia){
        
        nombre=n;        
        sueldo= s;
        
        GregorianCalendar calendario= new GregorianCalendar(agno, mes-1, dia);
        fechacontrato= calendario.getTime();                
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechacontrato() {
        return fechacontrato;
    }
    
    public void subirsueldo(double porcentaje){
        double aumento= sueldo*porcentaje/100;
        sueldo+=aumento;
    }
    
    @Override
    public String toString(){
        return "Nombre=" + nombre + ", sueldo=" + sueldo + ", fecha de contrato=" + fechacontrato;
    }
    
}


class Administrador extends Empleado{
    private static final long serialVersionUID=1L; 
    public double incentivo;  
    
    public Administrador(String n, double s, int agno, int mes, int dia){
       super(n,s,agno,mes,dia);
       incentivo=0;
    }
    
    @Override
    public double getSueldo(){
        double sueldobase= super.getSueldo();
        return sueldobase+incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Incentivo=" + incentivo;
    }
    
    
}