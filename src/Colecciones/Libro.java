package Colecciones;

/*** @author 50098250
 */
public class Libro {
    
    private String nombre;
    private String autor;
    private int ISBN;

    public Libro(String nombre, String autor, int ISBN) {
        this.nombre = nombre;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return "El titulo es: "+nombre+ " , El Autor es: " + autor + " el ISBN es: "+ ISBN + "\n hashcode:"+hashCode();
    }
    
//    public boolean equals(Object obj){
//        
//        if (obj instanceof  Libro) {
//            Libro otro= (Libro) obj;
//            if (this.ISBN==otro.ISBN) {
//                return true;
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.ISBN;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        return true;
    }
    
    
}
