package Logica;

import java.util.ArrayList;
import java.util.List;

import Manos.Carta;
import Manos.Mano;
/**
 * Esta es la clase Jugador, donde se guarda toda la información del jugador.
 * @author Jacoj
 *
 */
public class Jugador {
	/**
	 * Constructor por defecto de la clase.
	 * @param nombre Recibe el nombre del usuario.
	 * @param puntos Recibe los puntos de dicho usuario.
	 */
	public Jugador(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.dinero = puntos;
		this.mano = new Mano();
	}
	/**
	 * String nombre del usuario
	 */
	private String nombre;

/**
 * Entero del dinero del usuario.
 */
	private int dinero;
	/**
	 * Es la mano que el usuario tiene en el momento de la jugada en la mesa.
	 */
	private Mano mano;
	
	/**
	 * Es el Set de un jugador.
	 * @param nombre Recibe el nombre del jugador que se va a retornar
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;

	}
	/**
	 * Es el constructor por defecto sin parametros de la clase.
	 */
	public Jugador() {
	}
	/**
	 * Es el get del atributo nombre
	 * @return Retorna el nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Es el metodo get del atributo mano.
	 * @return Retorna un atributo de tipo Mano.
	 */
	public Mano getMano() {
		return mano;
	}
	/**
	 * Es el metodo Set del atributo mano.
	 * @param mano Es la mano que se desea acceder de la clase.
	 */
	public void setMano(Mano mano) {
		this.mano = mano;
	}
	/**
	 * Es el metodo Set del atributo nombre
	 * @param nombre Es el String nombre que se desea modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Es el metodo get del atributo puntos.
	 * @return Retorna una variable entera con la información de los puntos solicitados.
	 */
	public int getPuntos() {
		return dinero;
	}
	/**
	 * Es el metodo Set del atributo puntos.
	 * @param Es el entero puntos que se desea acceder para modificar.
	 */
	public void setPuntos(int puntos) {
		this.dinero = puntos;
	}

	
	
}
