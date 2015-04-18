package Manos;



public class CartaAlta implements Comparacion {
 
    @Override
    public int clasificarMano(Mano mano) {        
        return 10;
    }

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
