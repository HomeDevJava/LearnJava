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
public class Furgoneta extends Coche{
    
    private int capacidad_carga;
    private int plazas_extra;
    
    //contructor de furgoneta para dar estado inicial a furgoneta
    public Furgoneta(int plazas_extra, int capacidad_carga){
        
        super(); //llamar al contructor de la clase padre
        
        this.capacidad_carga=capacidad_carga;
        this.plazas_extra=plazas_extra;
        
    }
    
    public String dime_DatosFrugoneta(){
        return " La capacidad de Carga es " + capacidad_carga + " y las plazas son: " + plazas_extra; 
    }
    
    
}
