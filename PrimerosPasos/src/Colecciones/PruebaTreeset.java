/*
 * el treeset ordena los elementos de manera automatica ya que implementa la Interface
Comparable por lo que hay que implementar el metodo CompareTO
 */
package Colecciones;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author 50098250
 */
public class PruebaTreeset {
    
    public static void main(String[] args){
        
        TreeSet<String> ordenaPersonas= new TreeSet<>();
        ordenaPersonas.add("Sandra");
        ordenaPersonas.add("Amanda");
        ordenaPersonas.add("Diana");
        
        System.out.println("Lista TreeSet ordena automaticamente los elementos String");
        for (String s : ordenaPersonas) {
            System.out.println(s);
        }
        //------------------------------------------------------------------------
        Articulo primero= new Articulo(1, "Primer Articulo");
        Articulo segundo= new Articulo(22, "segundo Articulo");
        Articulo tercero= new Articulo(3, "Este es tercer Articulo");
        
        TreeSet<Articulo> ordenaArticulos= new TreeSet<>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);
        
        System.out.println("\nlista TreeSet ordenado por numero implementando CompareTo");
        for (Articulo a : ordenaArticulos) {
            System.out.println(a.getDescripcion());
        }
        
        
        //-----------------------------------------------------------------
         Articulo comparadorArticulos=new Articulo();
         TreeSet<Articulo> ordenaAlfabetico= new TreeSet<>(comparadorArticulos);
        
        ordenaAlfabetico.add(primero);
        ordenaAlfabetico.add(segundo);
        ordenaAlfabetico.add(tercero);
        
        System.out.println("\nLista TreeSet ordenado implementado comparator");
        for (Articulo articulo : ordenaAlfabetico) {
            System.out.println(articulo.getDescripcion());
        }
        
        
        //--------------------------------------------------------------------
        ComparadoArticulos compara_art= new ComparadoArticulos();
        TreeSet<Articulo> compara2= new TreeSet<>(compara_art);
        compara2.add(tercero);
        compara2.add(primero);
        compara2.add(segundo);
        
        System.out.println("\nOrdenando con nueva clase implentando solo comparator");
        for (Articulo articulo : compara2) {
            System.out.println(articulo.getDescripcion());
        }
        
        
        //------------------------------------------------------------------
         //--------------------------------------------------------------------
        
        TreeSet<Articulo> comparado= new TreeSet<>( new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                 String descripcionA=o1.getDescripcion();        
                 String descripcionB=o2.getDescripcion();
                 return descripcionA.compareTo(descripcionB);
            }
        });
        comparado.add(tercero);
        comparado.add(primero);
        comparado.add(segundo);
        
        System.out.println("\nOrdenando implentando comparator en clase anonima");
        for (Articulo art : comparado) {
            System.out.println(art.getDescripcion());
        }
        
    }
    
   
    
}


class Articulo implements Comparable<Articulo>,Comparator<Articulo>{

    private int num;
    private String desc;
    
    public Articulo(){
        
    }

    public Articulo(int num, String desc) {
        this.num = num;
        this.desc = desc;
    }

    public String getDescripcion() {
        return desc;
    }
    
    
    
    @Override
    public int compareTo(Articulo o) {
        return num - o.num;
    }

    @Override
    public int compare(Articulo o1, Articulo o2) {
        String descripcionA=o1.getDescripcion();
        String descripcionB=o2.getDescripcion();
        
        return descripcionA.compareTo(descripcionB);
    }
    
}

class ComparadoArticulos implements Comparator<Articulo>{

    @Override
    public int compare(Articulo o1, Articulo o2) {
        String descripcionA=o1.getDescripcion();
        String descripcionB=o2.getDescripcion();
        
        return descripcionA.compareTo(descripcionB);
    }
    
    
    
    
}