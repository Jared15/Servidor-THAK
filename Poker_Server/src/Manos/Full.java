package Manos;



public class Full implements Clasificacion {

    private final Clasificacion siguiente;
    private int valorTrio;
    private int valorPar;
    
    public Full() {
        this.siguiente =new Color();
    }

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
