package lineales;
import java.util.NoSuchElementException;

/**
 * class PilaIntEnla.
 * 
 */

public class PilaIntEnla {
    private NodoInt cima;
    private int talla;  
   
    public PilaIntEnla() {
        cima = null;
        talla = 0;
    }

    public void apilar(int x) {
        cima = new NodoInt(x, cima);
        talla++;
    }   
   
    public int desapilar() {
        if (cima == null) {
            throw new NoSuchElementException("Pila vacia");
        }
        int x = cima.dato;
        cima = cima.siguiente;
        talla--;
        return x;
    }

    public int cima() { 
        if (cima == null) {
            throw new NoSuchElementException("Pila vacia");
        }
        return cima.dato; 
    }

    public boolean esVacia() {
        return cima == null; 
    }

    public int talla() { 
        return talla; 
    }   
}