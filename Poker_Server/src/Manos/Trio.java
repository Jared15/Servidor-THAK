package Manos;
/**
 * Esta clase representa la jugada del poker Trio
 * @author Jacoj
 */

import java.util.ArrayList;
import java.util.List;


public class Trio implements Clasificacion {
	/**
     * Es el valor del valor en un atributo
     */
    private int valor;
    /**
     * Es el atributo clasificación que representa su siguiente jugada mayor
     */
    private Clasificacion siguiente;
    /**
     * Es la instancia de un DoblePar
     */
    public Trio() {
        siguiente = new DoblePar();
    }
/**
 * Es el método Get del atributo Valor
 * @return El valor del atributo de clase.
 */
    public int getValor() {
        return valor;
    }
/**
 * Es el método Set del atributo Valor
 * @param valor Es el nuevo valor del atributo de clase
 */
    public void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * Es el método que se implementa de la interfaz Clasification
     * Clasifica una mano.
     */
    public int clasificarMano(Mano mano) {
        int clasificacion = 7;
        mano.OrdenarMano("valor");
        int iguales = 1, mayorIguales = 0;
        for (int i = 1; i < mano.getTamano(); i++) {
            if (mano.getValorCarta(i) == mano.getValorCarta(i - 1)) {
                iguales++;
            } else {
                if (iguales > mayorIguales) {
                    mayorIguales = iguales;
                    valor = mano.getValorCarta(i - 1);
                }
                iguales = 1;
            }
        }
        if (iguales > mayorIguales) {
            mayorIguales = iguales;
            valor = mano.getValorCarta(mano.getTamano() - 2);
        }
        if (mayorIguales < 3) {
            return siguiente.clasificarMano(mano);
        }

        return clasificacion;
    }
    /**
     * Es el metodo que se implementa de la interfaz clasification
     * Compara dos manos y retorna la de mayor valor.
     */
    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=7){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=valor;
        clasificarMano(mano2);
        int valor2=valor;
        int diferencia=valor2-valor1;
        if(diferencia!=0){
            return diferencia;
        }
        List<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(valor1);
        List<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(valor2);
        valor1=mano1.mayorDistinto(lista1);
        valor2=mano2.mayorDistinto(lista2);
        diferencia=valor2-valor1;
        if(diferencia!=0){
            return diferencia;
        }
        lista1.add(valor1);
        lista2.add(valor2);
        return mano2.mayorDistinto(lista2) - mano1.mayorDistinto(lista1);
    }

    

}
