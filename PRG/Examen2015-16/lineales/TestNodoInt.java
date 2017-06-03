package lineales;

/**
 * class TestNodoInt.
 * 
 */

public class TestNodoInt {
    public static void main(String[] args) {      
        NodoInt sec1 = null;
        sec1 = new NodoInt(10);
        sec1 = new NodoInt(5, sec1);
        sec1 = new NodoInt(-2, sec1);    
        NodoInt.mostrar(sec1);
    
        NodoInt sec = null;
        NodoInt ultimo = null; 
        sec = new NodoInt(10); 
        ultimo = sec;
        ultimo.siguiente = new NodoInt(5); 
        ultimo = ultimo.siguiente;         
        ultimo.siguiente = new NodoInt(-2);
        ultimo = ultimo.siguiente; 
        NodoInt.mostrar(sec);
    
        System.out.println("\nSaturar:");
        NodoInt.saturar(sec, 8);
        NodoInt.mostrar(sec);        
        
        System.out.println("\nBuscar nodos:");
        NodoInt segundo = NodoInt.buscar(sec, 2);
        NodoInt tercero = NodoInt.buscar(sec, 3);
        if (segundo != null) {
            System.out.println("segundo = " + segundo.dato);
        } 
        else {
            System.out.println("segundo no existe");
        }
        if (tercero != null) {
            System.out.println("tercero = " + tercero.dato);
        } 
        else {
            System.out.println("tercero no existe");
        }
        
        System.out.println("\nInsertar nodos:");
        NodoInt secB = null;
        for (int i = 0; i < 10; i++) {
            secB = NodoInt.insertar(secB, 2 * i, i);
        }
        NodoInt.mostrar(secB);
        
        secB = NodoInt.insertar(secB, -4, 11);
        secB = NodoInt.insertar(secB, -7, 2);
        secB = NodoInt.insertar(secB, -3, 0);
        secB = NodoInt.insertar(secB, -9, 12);
        NodoInt.mostrar(secB);
        
        System.out.println("\nInsertar nodos en orden:");
        NodoInt secC = null;
        secC = NodoInt.insertar(secC, 4);
        secC = NodoInt.insertar(secC, -3);
        secC = NodoInt.insertar(secC, 1);
        secC = NodoInt.insertar(secC, 0);
        secC = NodoInt.insertar(secC, 8);
        secC = NodoInt.insertar(secC, 6);
        secC = NodoInt.insertar(secC, 1);
        NodoInt.mostrar(secC);
        
        System.out.println("\nBorrar nodos:");
        secC = NodoInt.borrar(secC, 4);
        secC = NodoInt.borrar(secC, 1);
        secC = NodoInt.borrar(secC, 7);
        NodoInt.mostrar(secC);
        
        System.out.println("\nBorrar nodos inferiores a umbral:");
        secB = NodoInt.borrar2(secB, 0);
        NodoInt.mostrar(secB);
    }
}