package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Manos.Carta;
import Manos.ComparadorMano;
import Manos.Mano;
import Manos.Palo;

public class Mesa   {
		List<Carta> mazo= new ArrayList<Carta>();
		private List<Carta> cartas= new ArrayList<Carta>();

		Juego juego = new Juego();
		
		/**
		 * Contructor sin parametros de la clase mesa
		 */
		public Mesa() {
			super();
			
		}
		/**
		 * Contructor con parametros de la Clase mesa
		 * @param mazo
		 * @param juego
		 */
		public Mesa(List<Carta> mazo, Juego juego) {
			super();
			this.mazo = mazo;
			this.juego = juego;
		}
		/**
		 * Obtiene la lista de la cartas de la mesa
		 * @return lista de cartas que estan en la mesa
		 */
		public List<Carta> getCartas() {
			return cartas;
		}
		/**
		 * Establece las cartas que hay en la mesa 
		 * @param cartas que deben estar en la mesa
		 */
		public void setCartas(List<Carta> cartas) {
			this.cartas = cartas;
		}
		/**
		 * Obtiene el mazo de cartas la mesa
		 * @return el mazo de la mesa
		 */
		public List<Carta> getMazo() {
			return mazo;
		}
		/**
		 * Establece el mazo con el que se va a jugar en la mesa
		 * @param mazo del juego
		 */
		public void setMazo(List<Carta> mazo) {
			this.mazo = mazo;
		}
		/**
		 * Obtiene Obtiene el juego de la mesa
		 * @return el juego de la mesa
		 */
		public Juego getJuego() {
			return juego;
		}
		/**
		 * Establece el juego de la mesa
		 * @param juego parametro que establece la mesa
		 */
		public void setJuego(Juego juego) {
			this.juego = juego;
		}
		/**
		 * Se encarga de llenar una lista de cartas con su respectivo valor y direccion de la imagen correspondiente al palo y el numero
		 * Es el mazo #1 (primer diseno grafico de las cartas)
		 */
		public void llenarMazo (){
		mazo.clear();	
			//CARTAS
		Carta c= new Carta(1, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(2, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(3, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(4, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(5, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(6, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(7, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(8, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(9, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(10, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(11, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(12, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(13, Palo.TREBOL);
		mazo.add(c);
		c= new Carta(1, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(2, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(3, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(4, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(5, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(6, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(7, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(8, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(9, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(10, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(11, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(12, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(13, Palo.CORAZON);
		mazo.add(c);
		c= new Carta(1, Palo.PICA);
		mazo.add(c);
		c= new Carta(2, Palo.PICA);
		mazo.add(c);
		c= new Carta(3, Palo.PICA);
		mazo.add(c);
		c= new Carta(4, Palo.PICA);
		mazo.add(c);
		c= new Carta(5, Palo.PICA);
		mazo.add(c);
		c= new Carta(6, Palo.PICA);
		mazo.add(c);
		c= new Carta(7, Palo.PICA);
		mazo.add(c);
		c= new Carta(8, Palo.PICA);
		mazo.add(c);
		c= new Carta(9, Palo.PICA);
		mazo.add(c);
		c= new Carta(10, Palo.PICA);
		mazo.add(c);
		c= new Carta(11, Palo.PICA);
		mazo.add(c);
		c= new Carta(12, Palo.PICA);
		mazo.add(c);
		c= new Carta(13, Palo.PICA);
		mazo.add(c);
		c= new Carta(1, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(2, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(3, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(4, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(5, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(6, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(7, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(8, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(9, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(10, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(11, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(12, Palo.DIAMANTE);
		mazo.add(c);
		c= new Carta(13, Palo.DIAMANTE);
		mazo.add(c);		
		//FIN CARTAS
		System.out.println("------- Mazo de Cartas Nuevo--------");
		}
		

/**
 * Saca una carta pseudo-aleatoria del mazo de cartas
 * @return carta pseudo-aleatoria
 */
		public Carta azar(){
			int random;
			Carta c;
			 Random r = new Random();
	         random = (r.nextInt(mazo.size()-1) );
	         c=mazo.get(random);
	         mazo.remove(random);
	         return c;
		}

		/**
		 * se encarga de proporcinar las cartas que va a tener el dealer en la mesa ( las 5 cartas del juego)
		 * @param identificador de la ronda o estado en la cual se encuentra el juego 
		 */
		public void llenardealer(int ronda){
			cartas.add(azar());
			cartas.add(azar());
			cartas.add(azar());
			cartas.add(azar());
			cartas.add(azar());
		}
		
		
		/**
		 * Le ototga las 2 cartas a cada jugador con las cuales va a jugar en la partida
		 */
		public void llenarJugadores(){
			for(int i = 0 ; i<juego.getJugadores().size();i++){
				juego.getJugadores().get(i).getMano().getCartas().add(azar());
				juego.getJugadores().get(i).getMano().getCartas().add(azar());
			}
			for(int i = 0 ; i<juego.getJugadores().size();i++){
				//System.out.println(juego.getJugadores().get(i).getMano().getCartas().get(0)+"-----"+juego.getJugadores().get(i).getMano().getCartas().get(1));
			}
		}
		/**
		 * Genera las operaciones para crear una siguiente mano
		 */
		public void nuevaMano(){
			cartas.clear();
			for(int i = 0 ; i<juego.getJugadores().size();i++){
				juego.getJugadores().get(i).getMano().getCartas().clear();			
			}
		}
		
		
		/**
		 * LLena una estructura llamada manos en la cual de encuentran las 5 cartas que estan en la mesa y las dos que tiene cada jugador en la mano con el fin de compararlas e identificar la mano ganadora
		 * @param participando Lista de los identificadores de los jugadores que estan en la mesa
		 */
		public void llenarManos(List<Integer> participando){
			List<Carta> cartas;
			for(Integer i:participando){
				cartas= new ArrayList<Carta>();
				cartas.addAll(juego.getJugadores().get(i-1).getMano().getCartas());
				cartas.addAll(this.cartas);
				Mano m = new Mano(cartas,i);
				juego.getManos().add(m);
			}			
			Collections.sort(juego.getManos(),new ComparadorMano());
			
		}
		/**.
		 * Verifica cual es el ganador de la mano 
		 * @param participando Lista de los identificadores de los jugadores que estan en la mesa
		 * @return id de jugador ganador
		 */
		public int encontrarGanador(List<Integer> participando) {
			llenarManos(participando);
			
			return juego.getManos().get(0).getId();
		}
		
		
}
