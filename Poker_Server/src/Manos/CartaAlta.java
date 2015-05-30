package Manos;

/**
 * Esta es la clase que da la prioridad a una carta mas Alta. 
 * @author Jacoj
 */

public class CartaAlta implements Clasificacion {
 /**
  * Este método retorna un valor a la mano
  * @param es el parámetro Mano.
  */
    @Override
    public int clasificarMano(Mano mano) {        
        return 10;
    }
/**
 * Este método compara dor manos.
 * @param mano1 Es la mano numero uno que se va a comparar.
 * @param mano2 Es la mano numero dos que se va a comparara.
 * @return Retorna un entero con el mayor valor de dicha mano.
 */
    @Override
    public int comparar(Mano mano1, Mano mano2) {
        mano1.OrdenarMano("valor");
        mano2.OrdenarMano("valor");
        for(int i=0;i<5;i++){
            if(mano1.getValorCarta(i)!=mano2.getValorCarta(i)){
                return mano2.getValorCarta(i)-mano1.getValorCarta(i);
            }
        }
        return 0;
    }

    

}
