package lineales;
import java.util.NoSuchElementException;

/**
 * class ListaPIIntArray.
 * 
 */

public class ListaPIIntArray {
    private static final int MAX = 10;
    private int[] elArray;
    private int pI;
    private int talla;
   
    public ListaPIIntArray() {
        elArray = new int[MAX];
        talla = 0;
        pI = 0;
    }

    public boolean esVacia() { 
        return talla == 0;
    }

    public int talla() { 
        return talla;
    }
   
    public void inicio() { 
        pI = 0; 
    }
   
    public void siguiente() { 
        if (pI == talla) {
            throw new NoSuchElementException("Cursor al final");
        }
        pI++; 
    }
   
    public boolean esFin() { 
        return pI == talla; 
    }
   
    public void insertar(int x) {
        if (talla == elArray.length) { duplicaArray(); }
        for (int k = talla - 1; k >= pI; k--) {
            elArray[k + 1] = elArray[k];
        }
        elArray[pI] = x; 
        pI++; 
        talla++;
    }

    private void duplicaArray() {
        int[] aux = new int[2 * elArray.length]; 
        for (int i = 0; i < elArray.length; i++) {
            aux[i] = elArray[i]; 
        }
        elArray = aux;
    }

    public int eliminar() {
        if (pI == talla) {
            throw new NoSuchElementException("Cursor al final");
        }
        int x = elArray[pI];
        for (int k = pI + 1; k < talla; k++) {
            elArray[k - 1] = elArray[k];
        }
        talla--;
        return x;
    }

    public int recuperar() {
        if (pI == talla) {
            throw new NoSuchElementException("Cursor al final"); 
        }
        return elArray[pI]; 
    }
}