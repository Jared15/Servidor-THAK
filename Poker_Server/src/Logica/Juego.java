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
	
	private Jugador creador;
	private int noJugadores;
	private String estiloMesa;
	private Date hora;
	private List<Jugador> jugadores;
	private List<Ronda> rondas;
	private Dealer dealer;
	private List<Carta> mesa;
	private List<Mano> manos;
	




	public List<Jugador> getJugadores() {
		return jugadores;
	}


	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


	public List<Ronda> getRondas() {
		return rondas;
	}


	public void setRondas(List<Ronda> rondas) {
		this.rondas = rondas;
	}


	public Dealer getDealer() {
		return dealer;
	}


	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	public List<Carta> getMesa() {
		return mesa;
	}


	public void setMesa(List<Carta> mesa) {
		this.mesa = mesa;
	}


	public List<Mano> getManos() {
		return manos;
	}


	public void setManos(List<Mano> manos) {
		this.manos = manos;
	}


	public Jugador getCreador() {
		return creador;
	}


	public void setCreador(Jugador creador) {
		this.creador = creador;
	}


	public int getNoJugadores() {
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
	
	
	
	public void llenarManos(){
		List<Carta> cartas;
		for(Jugador j: jugadores){
			cartas= new ArrayList<Carta>();
			cartas.addAll(j.getMano());
			cartas.addAll(mesa);
			Mano m = new Mano(cartas);
			manos.add(m);
			
		}
		Collections.sort(manos,new ComparadorMano());
	}

}
