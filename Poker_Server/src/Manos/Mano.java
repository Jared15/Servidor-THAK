package Manos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Esta clase representa la jugada del poker Mano
 * @author Jacoj
 */

public class Mano {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private int clasificacion;
    /**
     * Es el atributo Cartas que representa las cartas de una mano.
     */
    private List<Carta> cartas;
    /**
     * Es el atributo id que representa el id de la mano.
     */
    private int id;
   /**
    * Es el método get del atributo clasificación
    * @return El valor del atributo de la clase.
    */
    public int getClasificacion() {
        return clasificacion;
    }
/**
 * Es el método Set del atributo clasificación.
 * @param clasificacion Es el nuevo valor del atributo de clase.
 */
    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
/**
 * Es el método Set del atributo de clase Cartas
 * @param cartas Es el nuevo valor del atributo de clase.
 */
    public Mano(List<Carta> cartas) {
        this.cartas = cartas;
    }
    /**
     * Es la instancia de un Carta
     */
    public Mano() {
    	cartas=new ArrayList<Carta>();
	}
/**
 * Es el contrusctor por parámteros de la clase.
 * @param cartas2 es la lista de cartas de dicha mano.
 * @param i Es el identificador de la mano.
 */
	public Mano(List<Carta> cartas2, Integer i) {
		this.cartas=cartas2;
		this.id=i;
	}
/**
 * Es el método Set del atributo de clase Cartas 
 * @return
 */
	public List<Carta> getCartas() {
        return cartas;
    }
	/**
	 * Es el método Set del atributo de clase Cartas 
	 * @return
	 */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
    
    

    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * Este es un método que ordena la mano segun su prioridad
 * @param prioridad es el String de la prioridad de la mano.
 */
	public void OrdenarMano(String prioridad) {

        if (prioridad.equalsIgnoreCase("valor")) {
            Collections.sort(cartas, new ComparadorValor());
        }
        if (prioridad.equalsIgnoreCase("palo")) {
            Collections.sort(cartas, new ComparadorPalo());
        }
    }
/**
 *  Es el método Get del atributo Tamano.
 * @return el valor del atributo de la clase.
 */
    public int getTamano() {
        return cartas.size();
    }
/**
 *  Es el método get de una posición de el valor de la carta en la lista.
 * @param i es el entero que represetna la posicion de la lista.
 * @return El valor de la carta.
 */
    public int getValorCarta(int i) {
        return cartas.get(i).getValor();
    }
/**
 *  Es el método Set del atributo de clase Palos
 * @return El valor de los palos.
 */
    public String[] getPalos() {
        return Carta.getPalos();
    }
/**
 * Este método mide el numero de cartas en su tamaño.
 * @return el tamaño del numero de cartas en un entero.
 */
    public int numCartas() {
        return cartas.size();
    }
    /**
     *  Es el método get de una posición de el valor de la carta en la lista.
     * @param i es el entero que represetna la posicion de la lista.
     * @return El valor de la carta.
     */
    public String getPaloCarta(int i) {
        return cartas.get(i).getValorPalo();
    }
    /**
     * Este método calcula el meyor distintivo.
     * @param valores es una lista con los valores en enteros.
     * @return un entero con el mayor distintivo.
     */
    public int mayorDistinto(List<Integer> valores){
        int mayor=0;
        for(Carta c:cartas){
            if(valores.contains(new Integer(c.getValor()))){
                if(mayor<c.getValor()){
                    mayor=c.getValor();
                }
            }
        }
        return mayor;
    }
    /**
     * Este método clasifica la escalera.
     */
    void clasificar() {
        EscaleraReal escalera = new EscaleraReal();
        clasificacion = escalera.clasificarMano(this);
    }

}
