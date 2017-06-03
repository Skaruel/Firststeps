package lineales;
import java.util.NoSuchElementException;

/**
 * class ColaIntArray.
 * 
 */

public class ColaIntArray {
    private static final int MAX = 10;
    private int[] elArray;
    private int primero;
    private int ultimo;
    private int talla;
    
    public ColaIntArray() {
        elArray = new int[MAX];
        talla = 0;
        primero = 0; 
        ultimo = -1;
    }
   
    public void encolar(int x) {
        if (talla == elArray.length) { duplicaArray(); }
        ultimo = (ultimo + 1) % elArray.length;
        elArray[ultimo] = x;
        talla++;
    }
   
    private void duplicaArray() {
        int[] aux = new int[2 * elArray.length]; 
        int pos = primero;
        for (int i = 0; i < elArray.length; i++) {
            aux[i] = elArray[pos]; 
            pos = (pos + 1) % elArray.length; 
        }
        primero = 0;
        ultimo = elArray.length - 1;
        elArray = aux;
    }

    public int desencolar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacia");
        }
        int x = elArray[primero];
        primero = (primero + 1) % elArray.length;
        talla--;
        return x;
    }

    public int primero() { 
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacia");
        }
        return elArray[primero]; 
    }

    public boolean esVacia() { 
        return talla == 0; 
    }

    public int talla() { 
        return talla; 
    } 
}