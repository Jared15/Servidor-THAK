package Manos;
/**
 * Esta es la clase que almacena la informaci�n de Carta
 * @author Jacoj
 */
public class Carta {
/**
 * Atributo Entero del valor de la carta
 */
	private int valor;
	/**
	 * Atributo de tipo Palo que dice a que palo pertenece dicha carta.
	 */
	private Palo palo;

	/**
	 * Este es el constructor por defecto con par�metros.
	 * @param valor Es el valor de la carta.
	 * @param palo Es el palo al cual pertenece dicha carta.
	 */
	public Carta(int valor, Palo palo) {
		super();
		this.valor = valor;
		this.palo = palo;
	}
/**
 * Es el m�todo get del atributo Valor
 * @return Retorna el valor de dicha carta.
 */
	public int getValor() {
		return valor;
	}
/**
 * Es el m�todo Set del atributo valor
 * @param valor Es el entero que se va a modificar.
 */
	public void setValor(int valor) {
		this.valor = valor;
	}
/**
 * Es el m�todo get que retorna el atributo Palo de la clase
 * @return Un tipo de dato Palo con informaci�n del Palo de la clase.
 */
	public Palo getPalo() {
		return palo;
	}
/**
 * Es el m�todo Set del atributo Palo de la clase.
 * @param palo Es el Palo que se va a modificar.
 */
	public void setPalo(Palo palo) {
		this.palo = palo;
	}
/**
 * Es el m�todo get del Valor Palo convertido en toString.
 * @return Retorna un String con el valor del palo, convertido en una sola cadena.
 */
	public String getValorPalo() {
		return palo.toString();
	}
/**
 * Es un m�todo que busca y devuleve los valores de los palos.
 * @return un String con todos los palos a los que pertenece dicha carta.
 */
	static String[] getPalos() {
		Palo[] valores = Palo.values();
		String[] palos = new String[valores.length];
		for (int i = 0; i < valores.length; i++) {
			palos[i] = valores[i].toString();
		}
		return palos;
	}
/**
 * Es un m�todo que retorna un String con el nombre de la carta.
 * @return String con el nombre de la carta.
 */
	public String getPath() {
		switch(getValorPalo()){
		case "DIAMANTE":
			return ("d"+getValor());
		case "TREBOL":
			return ("t"+getValor());
		case "CORAZON":
			return ("c"+getValor());
		case "PICA":
			return ("p"+getValor());
			
		}
		return null;
	}
}
