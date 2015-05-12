package Manos;


import java.util.List;


public class EscaleraReal implements Clasificacion {
    
    private Clasificacion siguiente;
    
    public EscaleraReal() {
        this.siguiente = new EscaleraColor();
    }
    
    public Clasificacion getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Clasificacion siguiente) {
        this.siguiente = siguiente;
    }
    
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("palo"); //ordenar cartas para comparar despues
        int valor = 10;
        int clasificacion = 1;
        String[] palos = mano.getPalos();
        int i = 0, j = 0, largo = 0, mayor = 0;
        while (i < mano.numCartas()) {
            if (palos[j].trim().equalsIgnoreCase(mano.getPaloCarta(i).trim())) {
                if (mano.getValorCarta(i) == valor) {
                    largo++;
                    i++;
                    valor++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                    }
                    valor = 10;
                    largo = 0;
                    if (mano.getValorCarta(i) != valor) {
                        i++;
                    }
                    
                    
                }
            } else {
                if (largo > mayor) {
                    mayor = largo;
                }
                valor = 10;
                largo = 0;
                if (largo > mayor) {
                    mayor = largo;
                }
                j++;
            }
        }
        if (largo > mayor) {
            mayor = largo;
        }
        
        if (mayor < 5) { //no es escalera real            
            clasificacion = siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
    	
    	
        if(mano1.getClasificacion()!=1){
            return siguiente.comparar(mano1, mano2);
        }
        return 0;
    }

    

    
}
