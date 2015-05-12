package Logica;

import java.util.ArrayList;
import java.util.List;

import Manos.Carta;

public class Jugador {
	
	public Jugador(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.dinero = puntos;
	}

	private String nombre;


	private int dinero;
	private List<Carta> mano= new ArrayList<Carta>();
	
	
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;

	}
	public Jugador() {
	}
	public String getNombre() {
		return nombre;
	}
	public List<Carta> getMano() {
		return mano;
	}
	public void setMano(List<Carta> mano) {
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
