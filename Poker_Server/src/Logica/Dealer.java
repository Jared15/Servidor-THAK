package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Manos.Carta;
import Manos.Palo;

public class Dealer {
	
	private List<Carta> cartas= new ArrayList<Carta>();
	
	

	

	public Dealer() {
		super();
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}


}



