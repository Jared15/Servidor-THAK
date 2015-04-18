package Manos;


import java.util.Comparator;
import java.util.PriorityQueue;


public class ComparadorValor implements Comparator {

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
