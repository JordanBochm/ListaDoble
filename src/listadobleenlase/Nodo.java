package listadobleenlase;

/**
 *
 * @author maryse
 */
public class Nodo {

    int dato;
    Nodo adelante;
    Nodo atras;

    public Nodo(int entrada) {
        dato = entrada;
        adelante = atras = null;
    }

// declaración de nodo de lista doble
    public int getDato() {
        return dato;
    }
}
