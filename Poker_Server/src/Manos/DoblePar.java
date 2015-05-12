package Manos;


import java.util.ArrayList;
import java.util.List;


public class DoblePar implements Clasificacion {

    private Clasificacion siguiente;
    private int valorPar1;
    private int valorPar2;

    public DoblePar() {
        siguiente = new Par();
    }

    @Override
    public int clasificarMano(Mano mano) {
        int clasificacion = 8;
        Par par = new Par();
        boolean esPar = true;
        if (par.clasificarMano(mano) == 9) {
            par.setIgnorado(par.getValor());
            if (par.clasificarMano(mano) != 9) {
                esPar = false;
            }
        } else {
            esPar = false;
        }
        if (!esPar) {
            return siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if (mano1.getClasificacion() != 8) {
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int mayor1 = 0, menor1 = 0;
        if (valorPar1 > valorPar2) {
            mayor1 = valorPar1;
            menor1 = valorPar2;
        }
        clasificarMano(mano2);
        int mayor2 = 0, menor2 = 0;
        if (valorPar1 > valorPar2) {
            mayor2 = valorPar1;
            menor2 = valorPar2;
        }
        int diferencia = mayor2 - mayor1;
        if (diferencia != 0) {
            return diferencia;
        }
        diferencia = menor2 - menor1;
        if (diferencia != 0) {
            return diferencia;
        }
        List<Integer> numeros1;
        numeros1 = new ArrayList<Integer>();
        numeros1.add(mayor1);
        numeros1.add(menor1);
        List<Integer> numeros2;
        numeros2 = new ArrayList<Integer>();
        numeros2.add(mayor2);
        numeros2.add(menor2);
        
        return mano2.mayorDistinto(numeros2)-mano1.mayorDistinto(numeros1);
        
        

    }

}
