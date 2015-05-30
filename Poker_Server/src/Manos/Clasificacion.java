package Manos;
/**
 * Esta es un interfaz que se encarga de "Factorizar" los comparadores.
 * @author Jacoj
 *
 */
public interface Clasificacion {
/**
 * Este metodo clasifica una  manos.
 * @param mano Es una de las manos.
 * @return Retorna el valor en entero de la clasificacion de la mano.
 */
    public int clasificarMano(Mano mano);
    
    /**
     *Este metodo compara dos manos. 
     * @param mano1 Es la primera mano a comparar.
     * @param mano2 Es la segunda mano a comparar.
     * @return Retorna el entero con mayor valor.
     */
    public int comparar(Mano mano1,Mano mano2);
}
