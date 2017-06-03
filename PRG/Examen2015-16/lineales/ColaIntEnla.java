package lineales;
import java.util.NoSuchElementException;

/**
 * class ColaIntEnla.
 * 
 */

public class ColaIntEnla { 
    private NodoInt primero;
    private NodoInt ultimo;
    private int talla;
   
    public ColaIntEnla() {
        primero = null;
        ultimo = null;
        talla = 0;
    }

    public void encolar(int x) {
        NodoInt nuevo = new NodoInt(x);
        if (ultimo != null) { ultimo.siguiente = nuevo; }
        else { primero = nuevo; }
        ultimo = nuevo;
        talla++;
    }
   
    public int desencolar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacia");
        }
        int x = primero.dato;
        primero = primero.siguiente;
        if (primero == null) { ultimo = null; }
        talla--;
        return x;
    }

    public int primero() { 
        if (talla == 0) { 
            throw new NoSuchElementException("Cola vacia");
        }
        return primero.dato; 
    }
   
    public boolean esVacia() { 
        return primero == null; 
    }

    public int talla() { 
        return talla; 
    }
    
    public int desencolar(int x) {
        if (this.talla == 0) { throw new NoSuchElementException("Cola vacia"); }
        NodoInt ant = null;
        NodoInt aux = this.primero;
        while(aux.dato != x || aux != null) {
            ant = aux;
            aux = aux.siguiente;
        }
        if (aux != null) {
            if (this.primero == aux) { this.primero = aux.siguiente; }
            else { ant.siguiente = aux.siguiente;}
            if (aux == this.ultimo) { this.ultimo = ant; }
            this.talla--;
            return x;
        } else { throw new NoSuchElementException(x + " no esta en la cola"); }
    }
    
}