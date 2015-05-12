package Manos;



public class Escalera implements Clasificacion {

    private Clasificacion siguiente;
    private int mayorEscalera;

    Escalera() {
        siguiente=new Trio();
        
    }
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
