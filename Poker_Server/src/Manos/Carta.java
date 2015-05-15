package Manos;
public class Carta {

	private int valor;
	private Palo palo;

	public Carta(int valor, Palo palo) {
		super();
		this.valor = valor;
		this.palo = palo;
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
