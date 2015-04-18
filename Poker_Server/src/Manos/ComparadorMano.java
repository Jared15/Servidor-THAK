package Manos;


import java.util.Comparator;


public class ComparadorMano implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Mano mano1=(Mano) o1;
        Mano mano2=(Mano) o2;
        int comparacion=mano1.getClasificacion()-mano2.getClasificacion();
        if(comparacion!=0){
            return comparacion;
        }
        EscaleraReal er=new EscaleraReal();
        return er.comparar(mano1, mano2);      
    }
}
