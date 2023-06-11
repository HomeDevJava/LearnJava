/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author 50098250
 */
public class Coche {

   
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_plataforma;
    private String Color;
    private int peso_total;
    private boolean asientos_cuero, climatizador;
    
    
    public Coche(){
        
        ruedas=4;
        largo=200;
        ancho=160;
        motor=1600;
        peso_plataforma=500;  
        Color="Azul";
    } 
    
    public String datos_generales(){      
        return "La plataforma del vehiculo tiene es "+ruedas+ " ruedas, " +
                "Mide: "+ (largo/100) + " Metros con un ancho de "+ (ancho/100) +
                " Metro y un peso de plataforma de: "+ peso_plataforma;        
    }    
     
    public String getColor() {
        return " El Color del Coche es "+ Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    public void setColor() {
        this.Color ="Amarillo";
    }
    
    public void configura_asientos(String asientos_cuero){
        if(asientos_cuero.equalsIgnoreCase("si"))
        {
            this.asientos_cuero=true;
        }
        else
        {
            this.asientos_cuero=false;
            
        }
        
    }
    
    public String dime_asientos(){
        if(true==asientos_cuero){
            return "E l coche tiene asientos de Cuero";
        }
        else
        {
            return " El coche tiene asientos de serie";
        }
    }

    public String dime_Climatizador() {
        if(climatizador==true)
        {
            return " El coche incorpora climatizador";
        }
        else{
            return " El Coche no cuenta con climatizador";
        }
        
    }

    public void setClimatizador(String climatizador) {
        this.climatizador = "si".equalsIgnoreCase(climatizador);
        
    }
    
    public String dime_peso_coche(){
        
        int peso_carroceria=500;
        
        peso_total=peso_plataforma+peso_carroceria;
        
        if(asientos_cuero==true){
            peso_total= peso_total+50;
        }
        if(climatizador==true){
            peso_total= peso_total+20;
        }
        
        return "El peso del coche es de: "+peso_total + " Kg";
    }
    
    
    public int precio_coche(){
        int precio_final=10000;
        
        if(asientos_cuero==true){
            precio_final+=2050;
        }
        if(climatizador==true){
            precio_final+=1500;
        }
        
        return precio_final;
    }
    
    
}
