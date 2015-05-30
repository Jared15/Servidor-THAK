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
	private List<Mano> manos=new ArrayList<Mano>();
/**
 * obtiene la lista de jugadores del juego
 * @return jugadores
 */
	public List<Jugador> getJugadores() {
		return jugadores;
	}

/**
 * establece la lista de jugadores de la mesa
 * @param jugadores lista de jugadores a establecer
 */
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
/**
 * obtiene la lista de manos del juego
 * @return lista de manos
 */

	public List<Mano> getManos() {
		return manos;
	}

/**
 * establece la lista de manos del juego
 * @param manos la lista de manos
 */
	public void setManos(List<Mano> manos) {
		this.manos = manos;
	}

/**
 * obtiene el creador de la mesa
 * @return jugador creador
 */
	public Jugador getCreador() {
		return jugadores.get(creador);
	}

/**
 * establece el creador de la mesa
 * @param creador jugador creador de la mano
 */
	public void setCreador(Jugador creador) {
		this.creador = jugadores.indexOf(creador);
	}

/**
 * obtiene el numero de jugadores del juego
 * @return numero de jugadores
 */
	public int getNoJugadores() {
		noJugadores=jugadores.size();
		return noJugadores;
	}

/**
 * establece el numero de jugadores
 * @param noJugadores jugadores a establecer 
 */
	public void setNoJugadores(int noJugadores) {
		this.noJugadores = noJugadores;
	}

/**
 * obtiene el estilo de la mesa
 * @return estilo de la mesa
 */
	public String getEstiloMesa() {
		return estiloMesa;
	}

/**
 * establece el estilo de la mesa
 * @param estiloMesa el estilo de la mesa a establecer
 */
	public void setEstiloMesa(String estiloMesa) {
		this.estiloMesa = estiloMesa;
	}

/**
 * obtiene la hora de la mesa
 * @return hora de la mesa
 */
	public Date getHora() {
		return hora;
	}

/**
 * establece la hora de el juego
 * @param hora hora a establecer
 */
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
	


}
