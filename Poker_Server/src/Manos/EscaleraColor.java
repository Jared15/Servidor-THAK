package Manos;



public class EscaleraColor implements Clasificacion {

    private Clasificacion siguiente;
    private int valor;
    public EscaleraColor( ) {
        this.siguiente = new Poker();
    }

    public Clasificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Clasificacion siguiente) {
        this.siguiente = siguiente;
    }

    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("Palo"); //ordenar cartas para una facil comparacion    

        int clasificacion = 2;
        String[] palos = mano.getPalos();
        int i = 1, largo = 1, mayor = 0;
        while (i < mano.numCartas()) {            
            if (mano.getValorCarta(i) == mano.getValorCarta(i - 1) + 1) {
                if (mano.getPaloCarta(i).trim().equalsIgnoreCase(mano.getPaloCarta(i - 1).trim())) {
                    largo++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                        valor=mano.getValorCarta(i - 1);
                    }
                    largo = 1;
                }

            } else {
                if (largo > mayor) {
                    mayor = largo;
                    valor=mano.getValorCarta(i - 1);
                }
                largo = 1;
            }
            i++;
        }
        if (largo > mayor) {
            mayor = largo;
            valor=mano.getValorCarta(i - 1);
        }        
        if (mayor < 5) { //no es escalera de color
            clasificacion = siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=2){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=valor;
        clasificarMano(mano2);
        int valor2=valor;
        return valor2-valor1;
    }

    
    
}
