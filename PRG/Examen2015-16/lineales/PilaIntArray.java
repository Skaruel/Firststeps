package lineales;
import java.util.NoSuchElementException;

/**
 * class PilaIntArray.
 * 
 */

public class PilaIntArray {
    private static final int MAX = 10;
    private int[] elArray;
    private int cima;
   
    public PilaIntArray() {
        elArray = new int[MAX];
        cima = -1;
    }
   
    public void apilar(int x) {
        if (cima + 1 == elArray.length) { duplicaArray(); }
        cima++;
        elArray[cima] = x;
    }

    private void duplicaArray() {
        int[] aux = new int[2 * elArray.length]; 
        for (int i = 0; i < elArray.length; i++) {
            aux[i] = elArray[i]; 
        }
        elArray = aux;
    }
    
    public int desapilar() {
        if (cima < 0) { 
            throw new NoSuchElementException("Pila vacia");
        }
        int x = elArray[cima];
        cima--;
        return x;
    }

    public int cima() { 
        if (cima < 0) {
            throw new NoSuchElementException("Pila vacia");
        }
        return elArray[cima]; 
    }

    public boolean esVacia() { 
        return cima == -1; 
    }

    public int talla() { 
        return cima + 1;
    }
}