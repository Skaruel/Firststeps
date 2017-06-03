package lineales;

/**
 * class NodoInt.
 * 
 */

public class NodoInt {
    int dato;
    NodoInt siguiente; 
  
    /** Constructor A */
    NodoInt(int d) {
        this(d, null);
    } 
  
    /** Constructor B */
    NodoInt(int d, NodoInt s) {
        dato = d;
        siguiente = s;
    }
  
    public static void mostrar(NodoInt sec) { 
        NodoInt aux = sec;
        while (aux != null) {
            System.out.print(aux.dato + ", ");
            aux = aux.siguiente;
        }
        System.out.println();
    } 
    
    public static void saturar(NodoInt sec, int maximo) { 
        NodoInt aux = sec;
        while (aux != null) {
            if (aux.dato > maximo) { aux.dato = maximo; }
            aux = aux.siguiente;
        }
    }
   
    public static NodoInt buscar(NodoInt sec, int i) {
        NodoInt aux = sec; 
        int k = 0;
        while (aux != null && k < i) {
            aux = aux.siguiente;
            k++;
        }
        return aux;
    }
   
    public static NodoInt insertar(NodoInt sec, int d, int i) {
        if (i == 0) { sec = new NodoInt(d, sec); }
        else { 
            NodoInt aux = sec; 
            int k = 0;
            while (aux != null && k < i - 1) {
                aux = aux.siguiente; 
                k++;
            }
            if (aux != null) {
                aux.siguiente = new NodoInt(d, aux.siguiente);
            }
        }
        return sec;
    }

    public static NodoInt insertar(NodoInt sec, int d) {
        NodoInt aux = sec; 
        NodoInt ant = null;  
        while (aux != null && aux.dato < d) {
            ant = aux; 
            aux = aux.siguiente;  
        }
        if (aux == sec) {
            sec = new NodoInt(d, sec); 
        } 
        else {
            ant.siguiente = new NodoInt(d, aux); 
        }
        return sec;
    }
  
    public static NodoInt borrar(NodoInt sec, int d) {
        NodoInt aux = sec;
        NodoInt ant = null;
        while (aux != null && aux.dato != d) {
            ant = aux;
            aux = aux.siguiente;
        }
        if (aux != null) { // exito en la busqueda
            if (aux == sec) { sec = sec.siguiente; }
            else { ant.siguiente = aux.siguiente; }
        }
        // parametro sec puede cambiar, devolver su valor
        return sec;
    }

    public static NodoInt borrar2(NodoInt sec, int umbral) {
        NodoInt aux = sec;
        NodoInt ant = null;
        while (aux != null) {
            if (aux.dato < umbral) { // nodo a borrar
                if (aux == sec) { sec = sec.siguiente; }
                else { ant.siguiente = aux.siguiente; }
                // ant no se actualiza
            } 
            else { ant = aux; }
            aux = aux.siguiente;
        }
        // parametro sec puede cambiar, devolver su valor
        return sec;  
    }
}