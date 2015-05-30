package Manos;


import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase representa la jugada del poker Par
 * @author Jacoj
 */

public class Par implements Clasificacion {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private Clasificacion siguiente;
    /**
     * Es el valor del ignorado en un atributo
     */
    private int ignorado;
    /**
     * Es el valor del valor en un atributo
     */
    private int valor;
    /**
     * Es la instancia de un par
     */
    public Par() {
        siguiente=new CartaAlta();
    }

    
    /**
     * Es el metodo get del atributo Valor
     * @return El valor del atributo.
     */
    public int getValor() {
        return valor;
    }
/**
 * Es el metodo Set del atributo valor
 * @param valor Es el valor nuevo del atributo de la clase.
 */
    public void setValor(int valor) {
        this.valor = valor;
    }
/**
 * Es el metoro get del atributo Ignorado.
 * @return el valor del atributo ignorado de la clase.
 */
    public int getIgnorado() {
        return ignorado;
    }
/**
 * Es el metoro Set del atributo Ignorado.
 * @param ignorado Es el valor nuevo del atributo de clase.
 */
    public void setIgnorado(int ignorado) {
        this.ignorado = ignorado;
    }
    /**
     * Es el método que se implementa de la interfaz Clasification
     * Clasifica una mano.
     */
    @Override
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("valor");
        int clasificacion = 9;
        int iguales = 1, mayorIguales = 0;
        for (int i = 1; i < mano.getTamano(); i++) {
            if (mano.getValorCarta(i) != ignorado) {
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
        }
        if (iguales > mayorIguales) {
            mayorIguales = iguales;
            valor = mano.getValorCarta(mano.getTamano() - 2);
        }
        if (mayorIguales < 2) {
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
        if(mano1.getClasificacion()!=9){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=valor;
        clasificarMano(mano1);
        int valor2=valor;
        int diferencia=valor2-valor1;
        if (diferencia!=0){
            return diferencia;
        }
        List<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(valor1);
        List<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(valor2);
        valor1=mano1.mayorDistinto(lista1);
        valor2=mano2.mayorDistinto(lista2);
        diferencia=valor2-valor1;
        if (diferencia!=0){
            return diferencia;
        }
        lista1.add(valor1);
        lista2.add(valor2);
        
        valor1=mano1.mayorDistinto(lista1);
        valor2=mano2.mayorDistinto(lista2);
        diferencia=valor2-valor1;
        if (diferencia!=0){
            return diferencia;
        }
        lista1.add(valor1);
        lista2.add(valor2);
        
        return mano2.mayorDistinto(lista2) - mano1.mayorDistinto(lista1);
        
    }

   

}
