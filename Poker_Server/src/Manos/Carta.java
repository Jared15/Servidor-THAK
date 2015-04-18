package Manos;
public class Carta {

	private int valor;
	private Palo palo;
	private String path;



	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Carta(int valor, Palo palo, String path) {
		super();
		this.valor = valor;
		this.palo = palo;
		this.path = path;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public String getValorPalo() {
		return palo.toString();
	}

	static String[] getPalos() {
		Palo[] valores = Palo.values();
		String[] palos = new String[valores.length];
		for (int i = 0; i < valores.length; i++) {
			palos[i] = valores[i].toString();
		}
		return palos;
	}
}
