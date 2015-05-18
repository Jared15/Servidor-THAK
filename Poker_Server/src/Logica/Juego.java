package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Manos.Carta;
import Manos.ComparadorMano;
import Manos.Mano;

public class Juego {
	
	private int creador;
	private int noJugadores;
	private String estiloMesa;
	private Date hora;
	private List<Jugador> jugadores= new ArrayList<Jugador>();
	private List<Mano> manos;
	




	public List<Jugador> getJugadores() {
		return jugadores;
	}


	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


	public List<Mano> getManos() {
		return manos;
	}


	public void setManos(List<Mano> manos) {
		this.manos = manos;
	}


	public Jugador getCreador() {
		return jugadores.get(creador);
	}


	public void setCreador(Jugador creador) {
		this.creador = jugadores.indexOf(creador);
	}


	public int getNoJugadores() {
		noJugadores=jugadores.size();
		return noJugadores;
	}


	public void setNoJugadores(int noJugadores) {
		this.noJugadores = noJugadores;
	}


	public String getEstiloMesa() {
		return estiloMesa;
	}


	public void setEstiloMesa(String estiloMesa) {
		this.estiloMesa = estiloMesa;
	}


	public Date getHora() {
		return hora;
	}


	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
	


}
