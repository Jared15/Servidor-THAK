package Manos;

/**
 * Esta clase representa la jugada del poker Escalera
 * @author Jacoj
 */

public class EscaleraColor implements Clasificacion {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private Clasificacion siguiente;
    /**
     * Es el valor en un atributo
     */
    private int valor;
    /**
     * Es la instancia de un Poker
     */
    public EscaleraColor( ) {
        this.siguiente = new Poker();
    }
/**
 * Es el método Get del atributo Siguiente.
 * @return el valor del atributo Siguiente.
 */
    public Clasificacion getSiguiente() {
        return siguiente;
    }
/**
 * Es el método Set del atributo Siguiente.
 * @param siguiente Es el nuevo valor del atributo.
 */
    public void setSiguiente(Clasificacion siguiente) {
        this.siguiente = siguiente;
    }
    /**
     * Es el método que se implementa de la interfaz Clasification
     * Clasifica una mano.
     */
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("Palo"); //ordenar cartas para una facil comparacion    

        int clasificacion = 2;
        String[] palos = mano.getPalos();
        int i = 1, largo = 1, mayor = 0;
        while (i < mano.numCartas()) {            
            if (mano.getValorCarta(i) == mano.getValorCarta(i - 1) + 1) {
                if (mano.getPaloCarta(i).trim().equalsIgnoreCase(mano.getPaloCarta(i - 1).trim())) {
                    largo++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                        valor=mano.getValorCarta(i - 1);
                    }
                    largo = 1;
                }

            } else {
                if (largo > mayor) {
                    mayor = largo;
                    valor=mano.getValorCarta(i - 1);
                }
                largo = 1;
            }
            i++;
        }
        if (largo > mayor) {
            mayor = largo;
            valor=mano.getValorCarta(i - 1);
        }        
        if (mayor < 5) { //no es escalera de color
            clasificacion = siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }
    /**
     * Es el metodo que se implementa de la interfaz clasification
     * Compara dos manos y retorna la de mayor valor.
     */
    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=2){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=valor;
        clasificarMano(mano2);
        int valor2=valor;
        return valor2-valor1;
    }

    
    
}
