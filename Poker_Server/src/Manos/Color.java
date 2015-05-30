package Manos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Esta clase implemente la interfaz Clasificación
 * Representa una de las posibles jugadas del juego.
 * @author Jacoj
 *
 */
public class Color implements Clasificacion {

	/**
	 * Es un atributo Clasificación que representa cual es el siguien en su cadena de mayores.
	 */
    private Clasificacion siguiente;
    /**
     * Es el atributo String palo que representa a que palo pertenece dicha jugada.
     */
    private String palo;
/**
 * Es un método que isntancia una escalera.
 */
    Color() {
        siguiente = new Escalera();
    }
/**
 * Es un método que se implementa pero viene de la interfaz.
 * Realiza una clasificación de una mano.
 */
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("palo");
        int i = 1, largo = 1, mayor = 0;
        while (i < mano.getTamano()) {
            if (mano.getPaloCarta(i).trim().equalsIgnoreCase(mano.getPaloCarta(i - 1).trim())) {
                largo++;
            } else {
                if (largo > mayor) {
                    mayor = largo;
                }
                largo = 1;
            }
            i++;
        }
        if (largo > mayor) {
            mayor = largo;
        }
        if (mayor < 5) {
            return siguiente.clasificarMano(mano);
        }
        return 5;
    }
/**
 * Es la implementación del método de la interfaz clasificación.
 * Realiza una comparación entre dos manos.
 */
    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if (mano1.getClasificacion() != 5) {
            return siguiente.comparar(mano1, mano2);
        }

        List<Carta> cartas1 = new ArrayList<>();
        for (Carta c : mano1.getCartas()) {
            if (c.getValorPalo().trim().equalsIgnoreCase(palo.trim())) {
                cartas1.add(c);
            }
        }
        List<Carta> cartas2 = new ArrayList<>();
        for (Carta c : mano2.getCartas()) {
            if (c.getValorPalo().trim().equalsIgnoreCase(palo.trim())) {
                cartas2.add(c);
            }
        }
        Collections.sort(cartas1, new ComparadorValor());
        Collections.sort(cartas2, new ComparadorValor());
        int i, j;
        i = cartas1.size() - 1;
        j = cartas2.size() - 1;
        int diferencia;
        for (int k = 0; k < 5; k++) {
            diferencia = cartas2.get(i).getValor() - cartas1.get(j).getValor();
            i--;
            j--;
            if (diferencia != 0) {
                return diferencia;
            }
        }
        return 0;
    }

}
