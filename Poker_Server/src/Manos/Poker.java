package Manos;


import java.util.ArrayList;
import java.util.List;


public class Poker implements Comparacion {

    private final Comparacion siguiente;
    private int valor;

    public Poker() {
        this.siguiente = new Full();
    }

    public int clasificarMano(Mano mano) {
        int clasificacion = 3;
        mano.OrdenarMano("valor");
        int iguales = 1, mayorIguales = 0;
        int i = 1;
        for (i = 1; i < mano.getTamano(); i++) {
            if (mano.getValorCarta(i) == mano.getValorCarta(i - 1)) {
                iguales++;
            } else {
                if (iguales > mayorIguales) {                	
                    mayorIguales = iguales;
                    valor = mano.getValorCarta(i-1);
                }
                iguales = 1;
            }
        }
        if (iguales > mayorIguales) {
        	
            mayorIguales = iguales;
            valor = mano.getValorCarta(i-1);
        }
       
        if (mayorIguales < 4) {
            return siguiente.clasificarMano(mano);
        }
        
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if (mano1.getClasificacion() != 3) {
            return siguiente.comparar(mano1, mano2);
        }        
        clasificarMano(mano1);
        int valor1 = valor;       
        clasificarMano(mano2);        
        int valor2 = valor;   
        int comparacion = valor2-valor1;
        if (comparacion != 0) {
            return comparacion;
        }
        List<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(valor1);
        List<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(valor2);
        return mano1.mayorDistinto(lista1) - mano2.mayorDistinto(lista2);

    }

}
