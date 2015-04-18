package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Manos.Carta;
import Manos.Palo;

public class Dealer {
	
	private List<Carta> cartas;
	
	

	

	public Dealer(List<Carta> cartas) {
		super();
		this.cartas = cartas;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	/**
	 * Este metodo se encarga de sacar una carta al azar dentro del mazo que posee el dealer y la elimina de este 
	 * @return
	 */
	public Carta azar(){
		int random;
		Carta c;
		 Random r = new Random();
         random = (r.nextInt(cartas.size()-1) );
         c=cartas.get(random);
         cartas.remove(random);
         return c;
	}

}



