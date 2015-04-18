package Manos;


import java.util.ArrayList;
import java.util.List;


public class Trio implements Comparacion {

    private int valor;
    private Comparacion siguiente;

    public Trio() {
        siguiente = new DoblePar();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

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
