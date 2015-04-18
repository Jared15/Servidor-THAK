package Logica;

import java.util.List;

import Manos.Carta;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private int partidasGanadas;
	private List<Carta> mano;
	private String avatar;
	
	
	public Jugador(String nombre, int puntos, int partidasGanadas,
			List<Carta> mano) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.partidasGanadas = partidasGanadas;
		this.mano = mano;
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
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getPartidasGanadas() {
		return partidasGanadas;
	}
	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	
	
	
}
