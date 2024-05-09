package listadobleenlase;
import java.io.*;
import java.util.Random;

/**
 *
 * @author maryse
 * 
 * Lista Doble
 * Crea el objeto lista doble e inserta datos enteros generados aleatoriamente.
 * Crea objeto iterador de lista, para recorrer sus elementos y
 * aquellos fuera de rango se eliminan. El rango se lee del teclado.
 */

public class ListaEnRango {

    public static void main(String[] ar) throws IOException {
        Random r = new Random();
        final int M = 29; // número de elementos de la lista
        final int MX = 999;
        ListaDoble listaDb = new ListaDoble();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        // Llenar la lista con números aleatorios
        for (int j = 1; j <= M; j++) {
            int d = r.nextInt(MX) + 1;
            listaDb.insertarCabezaLista(d);
        }

        System.out.println("Elementos de la lista original");
        listaDb.visualizar(); // Mostrar la lista original

        // Leer el rango de valores desde el teclado
        System.out.println("\nIngrese el rango que va a contener la lista:");
        System.out.print("Valor mínimo: ");
        int x1 = Integer.parseInt(entrada.readLine());
        System.out.print("Valor máximo: ");
        int x2 = Integer.parseInt(entrada.readLine());

        // Filtrar los elementos fuera del rango
        IteradorLista iterador = new IteradorLista(listaDb);
        Nodo a = iterador.siguiente();
        while (a != null) {
            int w = a.getDato();
            if (!(w >= x1 && w <= x2)) {
                listaDb.eliminar(w);
            }
            a = iterador.siguiente();
        }

        System.out.println("\nElementos actuales de la lista");
        listaDb.visualizar(); // Mostrar la lista después de eliminar elementos no deseados

        // Ejemplo de búsqueda
        System.out.print("\nIngrese el elemento que desea buscar en la lista: ");
        int elementoABuscar = Integer.parseInt(entrada.readLine());
        listaDb.buscarLista(elementoABuscar); // Buscar el elemento en la lista
    }
}
