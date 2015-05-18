package Logica;

import java.util.ArrayList;
import java.util.List;

import Manos.Carta;
import Manos.Mano;

public class Jugador {
	
	public Jugador(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.dinero = puntos;
		this.mano = new Mano();
	}

	private String nombre;


	private int dinero;
	//private List<Carta> mano= new ArrayList<Carta>();
	private Mano mano;
	
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;

	}
	public Jugador() {
	}
	public String getNombre() {
		return nombre;
	}
	public Mano getMano() {
		return mano;
	}
	public void setMano(Mano mano) {
		this.mano = mano;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return dinero;
	}
	public void setPuntos(int puntos) {
		this.dinero = puntos;
	}

	
	
}
