package listadobleenlase;

/**
 *
 * @author maryse
 * 
 * Lista Doble
 */

public class IteradorLista {

    private Nodo actual;

    public IteradorLista(ListaDoble ld) {
        actual = ld.cabeza;
    }

    public Nodo siguiente() {
        Nodo a;
        a = actual;
        if (actual != null) {
            actual = actual.adelante;
        }
        return a;
    }
}
