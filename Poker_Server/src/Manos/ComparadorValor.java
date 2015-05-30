package Manos;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Esta clase compara dos valores e implemente la interfaz comparator
 * @author Jacoj
 *
 */
public class ComparadorValor implements Comparator {
	/**
	 * Es la implementación del metodo de la interfaz Comparator
	 * Compara dos objetos y retorna un String con el mayor,
	 */
    public int compare(Object o1, Object o2) {
        Carta c1 = (Carta) o1;
        Carta c2 = (Carta) o2;
        if (c1.getValor() < c2.getValor()) {
            return -1;
        }
        if (c1.getValor() > c2.getValor()) {
            return 1;
        }

        return c1.getPalo().compareTo(c2.getPalo());
    }

}
