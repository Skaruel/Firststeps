package lineales;
import java.util.NoSuchElementException;

/**
 * class ListaPIIntEnla.
 * 
 */

public class ListaPIIntEnla {
    private NodoInt primero;
    private NodoInt pI;
    private NodoInt antPI;
    private int talla;
   
    public ListaPIIntEnla() {
        primero = null;
        pI = null;
        antPI = null;
        talla = 0;
    }
   
    public boolean esVacia() { 
        return talla == 0; 
    }
   
    public int talla() { 
        return talla;
    }

    public void inicio() {
        pI = primero;
        antPI = null;
    }
   
    public void siguiente() {
        if (pI == null) {
            throw new NoSuchElementException("Cursor al final");
        }
        antPI = pI;
        pI = pI.siguiente;
    }
   
    public boolean esFin() { 
        return pI == null;
    }

    public void insertar(int x) {
        if (pI == primero) {
            primero = new NodoInt(x, pI);
            antPI = primero;
        } 
        else {
            antPI.siguiente = new NodoInt(x, pI);
            antPI = antPI.siguiente;
        }
        talla++;
    }

    public int eliminar() {
        if (pI == null) {
            throw new NoSuchElementException("Cursor al final");
        }
        int x = pI.dato;
        if (pI == primero) {
            primero = primero.siguiente;
        } 
        else {
            antPI.siguiente = pI.siguiente;
        }
        pI = pI.siguiente;
        talla--;
        return x; 
    }

    public int recuperar() { 
        if (pI == null) {
            throw new NoSuchElementException("Cursor al final");
        }
        return pI.dato; 
    }

    private boolean buscar(NodoInt ant, int x) {
        NodoInt aux = (ant == null) ? primero : ant.siguiente;
        while (aux != null && aux.dato != x) {
            ant = aux;
            aux = aux.siguiente;
        }
        if (aux == null) { return false; }
        else { 
            pI = aux; 
            antPI = ant; 
            return true; 
        }
    }

    public boolean buscarInicio(int x) {
        return buscar(null, x);
    }

    public boolean buscarSiguiente(int x) {
        return buscar(antPI, x);
    }
}