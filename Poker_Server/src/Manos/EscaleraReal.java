package Manos;


import java.util.List;
/**
 * Esta clase representa la jugada del poker Escalera
 * @author Jacoj
 */


public class EscaleraReal implements Clasificacion {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private Clasificacion siguiente;
    /**
     * Es la instancia de un EscaleraCOlor
     */
    public EscaleraReal() {
        this.siguiente = new EscaleraColor();
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
        mano.OrdenarMano("palo"); //ordenar cartas para comparar despues
        int valor = 10;
        int clasificacion = 1;
        String[] palos = mano.getPalos();
        int i = 0, j = 0, largo = 0, mayor = 0;
        while (i < mano.numCartas()) {
            if (palos[j].trim().equalsIgnoreCase(mano.getPaloCarta(i).trim())) {
                if (mano.getValorCarta(i) == valor) {
                    largo++;
                    i++;
                    valor++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                    }
                    valor = 10;
                    largo = 0;
                    if (mano.getValorCarta(i) != valor) {
                        i++;
                    }
                    
                    
                }
            } else {
                if (largo > mayor) {
                    mayor = largo;
                }
                valor = 10;
                largo = 0;
                if (largo > mayor) {
                    mayor = largo;
                }
                j++;
            }
        }
        if (largo > mayor) {
            mayor = largo;
        }
        
        if (mayor < 5) { //no es escalera real            
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
    	
    	
        if(mano1.getClasificacion()!=1){
            return siguiente.comparar(mano1, mano2);
        }
        return 0;
    }

    

    
}
