package Logica;

import java.util.ArrayList;
import java.util.List;

import Manos.Carta;

public class Jugador {
	
	public Jugador(String nombre, int puntos, int partidasGanadas,String avatar) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
		this.partidasGanadas = partidasGanadas;
		this.avatar = avatar;
	}

	private String nombre;
	private String pass;

	private int puntos;
	private int partidasGanadas;
	private List<Carta> mano= new ArrayList<Carta>();
	private String avatar;
	
	
	
	public Jugador(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}
	public Jugador() {
		// TODO Auto-generated constructor stub
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
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	
}
