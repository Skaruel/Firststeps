package lineales;
import java.io.*;
import java.util.*;

/**
 * Write a description of class Examen2016 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Examen2016 {
    public static void m1(String[] lS) {
        int k = 0;
        boolean fin = false;
        while(!fin) {
            System.out.println("Posicion " + k + ": ");
            try {
                System.out.println(lS[k].length() + " caracteres");
                k++;
            } catch(NullPointerException e1) { System.out.println("String no inicializada.");
            } catch(ArrayIndexOutOfBoundsException e2) { System.out.println("Inexistente. Fin del array"); }
        }
    }

    public static ListaPIIntEnla leer(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(s);
        ListaPIIntEnla res = new ListaPIIntEnla();
        while(sc.hasNext()) {
            try {
                res.insertar(sc.nextInt());
            } catch(InputMismatchException e) { 
                System.err.println(e); 
                sc.next();
            }
        }
        sc.close();
        return res;
    }
    
    /** Precondicion: lista1 y lista2 no contienen elementos repetidos. **/
    public static ListaPIIntEnla eliminComunes(ListaPIIntEnla lista1, ListaPIIntEnla lista2) {
        ListaPIIntEnla comunes = new ListaPIIntEnla();
        lista1.inicio();
        while(!lista1.esFin()){
            lista2.inicio();
            while(!lista2.esFin()){
                if(lista1.recuperar() == lista2.recuperar()) {
                    comunes.insertar(lista1.recuperar());
                    lista1.eliminar();
                    lista2.siguiente();
                }
                else if(lista1.recuperar() != lista2.recuperar()) {
                    lista2.siguiente();
                }
            }
            lista1.siguiente();
        }
        return comunes;
    }
}
