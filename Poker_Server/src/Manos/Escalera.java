package Manos;

/**
 * Esta clase representa la jugada del poker Escalera
 * @author Jacoj
 */

public class Escalera implements Clasificacion {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private Clasificacion siguiente;
    /**
     * Es el valor del mayorEscalera en un atributo
     */
    private int mayorEscalera;
    /**
     * Es la instancia de un Trio
     */
    Escalera() {
        siguiente=new Trio();
        
    }
    /**
     * Es el método que se implementa de la interfaz Clasification
     * Clasifica una mano.
     */
    @Override
    public int clasificarMano(Mano mano) {       
        mano.OrdenarMano("valor");
        int largo = 1, mayor = 0;
        
        for (int i = 1; i < mano.getTamano(); i++) {
            if (mano.getValorCarta(i) != mano.getValorCarta(i - 1)) {
                if (mano.getValorCarta(i) == mano.getValorCarta(i - 1) + 1) {
                    largo++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                        mayorEscalera=mano.getValorCarta(i);
                    }
                    largo = 1;
                }
            }
        }
        if (largo > mayor) {
            mayor = largo;
             mayorEscalera=mano.getValorCarta(mano.getTamano()-1);
        }
        if (mayor < 5) {
            return siguiente.clasificarMano(mano);
        }
        return 6;
    }
    /**
     * Es el metodo que se implementa de la interfaz clasification
     * Compara dos manos y retorna la de mayor valor.
     */
    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=6){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=mayorEscalera;
        clasificarMano(mano2);
        int valor2=mayorEscalera;
        return valor2-valor1;
    }

    

}
