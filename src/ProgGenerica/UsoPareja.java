package ProgGenerica;

public class UsoPareja {
    public static void main(String[] args){
        Pareja<String> una= new Pareja<>();
        
        una.setPrimero("Juan");
        
        System.out.println(una.getPrimero());
        
        Persona pers1= new Persona("Abel");
        Pareja<Persona> lista= new Pareja<>(pers1);
        System.out.println(lista.getPrimero());
        
    }
    
}


class Persona{
    
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}