package listadobleenlase;

/**
 *
 * @author maryse
 */
public class ListaDoble
{

    Nodo cabeza;
// métodos de la clase (implementación en apartado 8.9)

    public ListaDoble()
    {;
    }

    public ListaDoble insertarCabezaLista(int entrada)
    {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.adelante = cabeza;
        if (cabeza != null)
        {
            cabeza.atras = nuevo;
        }
        cabeza = nuevo;
        return this;
    }

    public ListaDoble insertaDespues(Nodo anterior, int entrada)
    {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.adelante = anterior.adelante;
        if (anterior.adelante != null)
        {
            anterior.adelante.atras = nuevo;
        }
        anterior.adelante = nuevo;
        nuevo.atras = anterior;
        return this;
    }

    public void eliminar(int entrada)
    {
        Nodo actual;
        boolean encontrado = false;
        actual = cabeza;

        // Bucle de búsqueda
        while ((actual != null) && (!encontrado))
        {
            /* la comparación se realiza con el método equals()...,	
            depende del tipo Elemento */
            encontrado = (actual.dato == entrada);
            if (!encontrado)
            {
                actual = actual.adelante;
            }
        }

        // Enlace de nodo anterior con el siguiente
        if (actual != null)
        {
            //distingue entre nodo cabecera o resto de la lista
            if (actual == cabeza)
            {
                cabeza = actual.adelante;
                if (actual.adelante != null)
                {
                    actual.adelante.atras = null;
                }
            } else if (actual.adelante != null) // No es el último nodo
            {
                actual.atras.adelante = actual.adelante;
                actual.adelante.atras = actual.atras;
            } else // último nodo
            {
                actual.atras.adelante = null;
            }
            actual = null;
        }
    }

    public void visualizar()
    {
        Nodo actual = cabeza;
        while (actual != null)
        {
            System.out.print(actual.dato + " ");
            actual = actual.adelante;
        }
        System.out.println();

    }

    public void buscarLista(int destino)
    {
        Nodo actual = cabeza;
        int posicion = 0;
        boolean encontrado = false;
        for (actual = cabeza; actual != null; actual = actual.adelante)
        {
            if (actual.dato == destino)
            {
                encontrado = true;
                break;
            }
            posicion++;
        }
        if (encontrado)
        {
            System.out.println("El elemento " + destino + " se encuentra en la posición " + (posicion+1));
        } else
        {
            System.out.println("El elemento " + destino + " no se encuentra en la lista");
        }
    }

}
