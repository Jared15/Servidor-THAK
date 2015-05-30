package Manos;

/**
 * Esta clase representa la jugada del poker Full
 * @author Jacoj
 */

public class Full implements Clasificacion {
	/**
	 * Es el atributo clasificación que representa su siguiente jugada mayor
	 */
    private final Clasificacion siguiente;
    /**
     * Es el valor del valorTrio en un atributo
     */
    private int valorTrio;
    /**
     * Es el valor del valorPar en un atributo
     */
    private int valorPar;
    /**
     * Es la instancia de un par
     */
    public Full() {
        this.siguiente =new Color();
    }
    /**
     * Es el método que se implementa de la interfaz Clasification
     * Clasifica una mano.
     */
    public int clasificarMano(Mano mano) {
        int clasificacion = 4;
        mano.OrdenarMano("valor");
        Trio trio = new Trio();
        boolean full = true;
        if (trio.clasificarMano(mano)==7) {
            Par par = new Par();
            valorTrio=trio.getValor();
            par.setIgnorado(trio.getValor());
            if (par.clasificarMano(mano)!=9) {
                full = false;
            }else{
                valorPar=par.getValor();
            }
        } else {
            full = false;
        }
        if (!full) {
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
        
        if(mano1.getClasificacion()!=4){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valorTrio1=valorTrio;
        int valorPar1=valorPar;
        clasificarMano(mano2);
        int valorTrio2=valorTrio;
        int valorPar2=valorPar;
        int comparacion=valorTrio2-valorTrio1;
        if(comparacion!=0){
            return comparacion;
        }
        return valorPar2-valorPar1;
        
    }

    
}
