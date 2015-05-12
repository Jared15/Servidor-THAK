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
		
		
		public Mesa() {
			super();
			
		}

		public Mesa(List<Carta> mazo, Juego juego) {
			super();
			this.mazo = mazo;
			this.juego = juego;
		}

		public List<Carta> getCartas() {
			return cartas;
		}

		public void setCartas(List<Carta> cartas) {
			this.cartas = cartas;
		}

		public List<Carta> getMazo() {
			return mazo;
		}

		public void setMazo(List<Carta> mazo) {
			this.mazo = mazo;
		}

		public Juego getJuego() {
			return juego;
		}

		public void setJuego(Juego juego) {
			this.juego = juego;
		}
		/**
		 * Se encarga de llenar una lista de cartas con su respectivo valor y direccion de la imagen correspondiente al palo y el numero
		 * Es el mazo #1 (primer diseno grafico de las cartas)
		 */
		public void llenarMazo (){
			
			//CARTAS
		Carta c= new Carta(1, Palo.TREBOL,"Cartas/Cartas-1/ta.png");
		mazo.add(c);
		c= new Carta(2, Palo.TREBOL,"Cartas/Cartas-1/t2.png");
		mazo.add(c);
		c= new Carta(3, Palo.TREBOL,"Cartas/Cartas-1/t3.png");
		mazo.add(c);
		c= new Carta(4, Palo.TREBOL,"Cartas/Cartas-1/t4.png");
		mazo.add(c);
		c= new Carta(5, Palo.TREBOL,"Cartas/Cartas-1/t5.png");
		mazo.add(c);
		c= new Carta(6, Palo.TREBOL,"Cartas/Cartas-1/t6.png");
		mazo.add(c);
		c= new Carta(7, Palo.TREBOL,"Cartas/Cartas-1/t7.png");
		mazo.add(c);
		c= new Carta(8, Palo.TREBOL,"Cartas/Cartas-1/t8.png");
		mazo.add(c);
		c= new Carta(9, Palo.TREBOL,"Cartas/Cartas-1/t9.png");
		mazo.add(c);
		c= new Carta(10, Palo.TREBOL,"Cartas/Cartas-1/td.png");
		mazo.add(c);
		c= new Carta(11, Palo.TREBOL,"Cartas/Cartas-1/tj.png");
		mazo.add(c);
		c= new Carta(12, Palo.TREBOL,"Cartas/Cartas-1/tq.png");
		mazo.add(c);
		c= new Carta(13, Palo.TREBOL,"Cartas/Cartas-1/tk.png");
		mazo.add(c);
		c= new Carta(1, Palo.CORAZON,"Cartas/Cartas-1/ca.png");
		mazo.add(c);
		c= new Carta(2, Palo.CORAZON,"Cartas/Cartas-1/c2.png");
		mazo.add(c);
		c= new Carta(3, Palo.CORAZON,"Cartas/Cartas-1/c3.png");
		mazo.add(c);
		c= new Carta(4, Palo.CORAZON,"Cartas/Cartas-1/c4.png");
		mazo.add(c);
		c= new Carta(5, Palo.CORAZON,"Cartas/Cartas-1/c5.png");
		mazo.add(c);
		c= new Carta(6, Palo.CORAZON,"Cartas/Cartas-1/c6.png");
		mazo.add(c);
		c= new Carta(7, Palo.CORAZON,"Cartas/Cartas-1/c7.png");
		mazo.add(c);
		c= new Carta(8, Palo.CORAZON,"Cartas/Cartas-1/c8.png");
		mazo.add(c);
		c= new Carta(9, Palo.CORAZON,"Cartas/Cartas-1/c9.png");
		mazo.add(c);
		c= new Carta(10, Palo.CORAZON,"Cartas/Cartas-1/cd.png");
		mazo.add(c);
		c= new Carta(11, Palo.CORAZON,"Cartas/Cartas-1/cj.png");
		mazo.add(c);
		c= new Carta(12, Palo.CORAZON,"Cartas/Cartas-1/cq.png");
		mazo.add(c);
		c= new Carta(13, Palo.CORAZON,"Cartas/Cartas-1/ck.png");
		mazo.add(c);
		c= new Carta(1, Palo.PICA,"Cartas/Cartas-1/pa.png");
		mazo.add(c);
		c= new Carta(2, Palo.PICA,"Cartas/Cartas-1/p2.png");
		mazo.add(c);
		c= new Carta(3, Palo.PICA,"Cartas/Cartas-1/p3.png");
		mazo.add(c);
		c= new Carta(4, Palo.PICA,"Cartas/Cartas-1/p4.png");
		mazo.add(c);
		c= new Carta(5, Palo.PICA,"Cartas/Cartas-1/p5.png");
		mazo.add(c);
		c= new Carta(6, Palo.PICA,"Cartas/Cartas-1/p6.png");
		mazo.add(c);
		c= new Carta(7, Palo.PICA,"Cartas/Cartas-1/p7.png");
		mazo.add(c);
		c= new Carta(8, Palo.PICA,"Cartas/Cartas-1/p8.png");
		mazo.add(c);
		c= new Carta(9, Palo.PICA,"Cartas/Cartas-1/p9.png");
		mazo.add(c);
		c= new Carta(10, Palo.PICA,"Cartas/Cartas-1/pd.png");
		mazo.add(c);
		c= new Carta(11, Palo.PICA,"Cartas/Cartas-1/pj.png");
		mazo.add(c);
		c= new Carta(12, Palo.PICA,"Cartas/Cartas-1/pq.png");
		mazo.add(c);
		c= new Carta(13, Palo.PICA,"Cartas/Cartas-1/pk.png");
		mazo.add(c);
		c= new Carta(1, Palo.DIAMANTE,"Cartas/Cartas-1/da.png");
		mazo.add(c);
		c= new Carta(2, Palo.DIAMANTE,"Cartas/Cartas-1/d2.png");
		mazo.add(c);
		c= new Carta(3, Palo.DIAMANTE,"Cartas/Cartas-1/d3.png");
		mazo.add(c);
		c= new Carta(4, Palo.DIAMANTE,"Cartas/Cartas-1/d4.png");
		mazo.add(c);
		c= new Carta(5, Palo.DIAMANTE,"Cartas/Cartas-1/d5.png");
		mazo.add(c);
		c= new Carta(6, Palo.DIAMANTE,"Cartas/Cartas-1/d6.png");
		mazo.add(c);
		c= new Carta(7, Palo.DIAMANTE,"Cartas/Cartas-1/d7.png");
		mazo.add(c);
		c= new Carta(8, Palo.DIAMANTE,"Cartas/Cartas-1/d8.png");
		mazo.add(c);
		c= new Carta(9, Palo.DIAMANTE,"Cartas/Cartas-1/d9.png");
		mazo.add(c);
		c= new Carta(10, Palo.DIAMANTE,"Cartas/Cartas-1/dd.png");
		mazo.add(c);
		c= new Carta(11, Palo.DIAMANTE,"Cartas/Cartas-1/dj.png");
		mazo.add(c);
		c= new Carta(12, Palo.DIAMANTE,"Cartas/Cartas-1/dq.png");
		mazo.add(c);
		c= new Carta(13, Palo.DIAMANTE,"Cartas/Cartas-1/dk.png");
		mazo.add(c);		
		//FIN CARTAS
		System.out.println("------- Mazo de Cartas Nuevo--------");
		}
		
		
		/**
		 * Se encarga de llenar una lista de cartas con su respectivo valor y direccion de la imagen correspondiente al palo y el numero
		 * Es el mazo #2 (Segundo diseno grafico de las cartas)
		 */
public void llenarMazo2 (){
			
			//CARTAS
		Carta c= new Carta(1, Palo.TREBOL,"Cartas/Cartas-2/ta.png");
		mazo.add(c);
		c= new Carta(2, Palo.TREBOL,"Cartas/Cartas-2/t2.png");
		mazo.add(c);
		c= new Carta(3, Palo.TREBOL,"Cartas/Cartas-2/t3.png");
		mazo.add(c);
		c= new Carta(4, Palo.TREBOL,"Cartas/Cartas-2/t4.png");
		mazo.add(c);
		c= new Carta(5, Palo.TREBOL,"Cartas/Cartas-2/t5.png");
		mazo.add(c);
		c= new Carta(6, Palo.TREBOL,"Cartas/Cartas-2/t6.png");
		mazo.add(c);
		c= new Carta(7, Palo.TREBOL,"Cartas/Cartas-2/t7.png");
		mazo.add(c);
		c= new Carta(8, Palo.TREBOL,"Cartas/Cartas-2/t8.png");
		mazo.add(c);
		c= new Carta(9, Palo.TREBOL,"Cartas/Cartas-2/t9.png");
		mazo.add(c);
		c= new Carta(10, Palo.TREBOL,"Cartas/Cartas-2/td.png");
		mazo.add(c);
		c= new Carta(11, Palo.TREBOL,"Cartas/Cartas-2/tj.png");
		mazo.add(c);
		c= new Carta(12, Palo.TREBOL,"Cartas/Cartas-2/tq.png");
		mazo.add(c);
		c= new Carta(13, Palo.TREBOL,"Cartas/Cartas-2/tk.png");
		mazo.add(c);
		c= new Carta(1, Palo.CORAZON,"Cartas/Cartas-2/ca.png");
		mazo.add(c);
		c= new Carta(2, Palo.CORAZON,"Cartas/Cartas-2/c2.png");
		mazo.add(c);
		c= new Carta(3, Palo.CORAZON,"Cartas/Cartas-2/c3.png");
		mazo.add(c);
		c= new Carta(4, Palo.CORAZON,"Cartas/Cartas-2/c4.png");
		mazo.add(c);
		c= new Carta(5, Palo.CORAZON,"Cartas/Cartas-2/c5.png");
		mazo.add(c);
		c= new Carta(6, Palo.CORAZON,"Cartas/Cartas-2/c6.png");
		mazo.add(c);
		c= new Carta(7, Palo.CORAZON,"Cartas/Cartas-2/c7.png");
		mazo.add(c);
		c= new Carta(8, Palo.CORAZON,"Cartas/Cartas-2/c8.png");
		mazo.add(c);
		c= new Carta(9, Palo.CORAZON,"Cartas/Cartas-2/c9.png");
		mazo.add(c);
		c= new Carta(10, Palo.CORAZON,"Cartas/Cartas-2/cd.png");
		mazo.add(c);
		c= new Carta(11, Palo.CORAZON,"Cartas/Cartas-2/cj.png");
		mazo.add(c);
		c= new Carta(12, Palo.CORAZON,"Cartas/Cartas-2/cq.png");
		mazo.add(c);
		c= new Carta(13, Palo.CORAZON,"Cartas/Cartas-2/ck.png");
		mazo.add(c);
		c= new Carta(1, Palo.PICA,"Cartas/Cartas-2/pa.png");
		mazo.add(c);
		c= new Carta(2, Palo.PICA,"Cartas/Cartas-2/p2.png");
		mazo.add(c);
		c= new Carta(3, Palo.PICA,"Cartas/Cartas-2/p3.png");
		mazo.add(c);
		c= new Carta(4, Palo.PICA,"Cartas/Cartas-2/p4.png");
		mazo.add(c);
		c= new Carta(5, Palo.PICA,"Cartas/Cartas-2/p5.png");
		mazo.add(c);
		c= new Carta(6, Palo.PICA,"Cartas/Cartas-2/p6.png");
		mazo.add(c);
		c= new Carta(7, Palo.PICA,"Cartas/Cartas-2/p7.png");
		mazo.add(c);
		c= new Carta(8, Palo.PICA,"Cartas/Cartas-2/p8.png");
		mazo.add(c);
		c= new Carta(9, Palo.PICA,"Cartas/Cartas-2/p9.png");
		mazo.add(c);
		c= new Carta(10, Palo.PICA,"Cartas/Cartas-2/pd.png");
		mazo.add(c);
		c= new Carta(11, Palo.PICA,"Cartas/Cartas-2/pj.png");
		mazo.add(c);
		c= new Carta(12, Palo.PICA,"Cartas/Cartas-2/pq.png");
		mazo.add(c);
		c= new Carta(13, Palo.PICA,"Cartas/Cartas-2/pk.png");
		mazo.add(c);
		c= new Carta(1, Palo.DIAMANTE,"Cartas/Cartas-2/da.png");
		mazo.add(c);
		c= new Carta(2, Palo.DIAMANTE,"Cartas/Cartas-2/d2.png");
		mazo.add(c);
		c= new Carta(3, Palo.DIAMANTE,"Cartas/Cartas-2/d3.png");
		mazo.add(c);
		c= new Carta(4, Palo.DIAMANTE,"Cartas/Cartas-2/d4.png");
		mazo.add(c);
		c= new Carta(5, Palo.DIAMANTE,"Cartas/Cartas-2/d5.png");
		mazo.add(c);
		c= new Carta(6, Palo.DIAMANTE,"Cartas/Cartas-2/d6.png");
		mazo.add(c);
		c= new Carta(7, Palo.DIAMANTE,"Cartas/Cartas-2/d7.png");
		mazo.add(c);
		c= new Carta(8, Palo.DIAMANTE,"Cartas/Cartas-2/d8.png");
		mazo.add(c);
		c= new Carta(9, Palo.DIAMANTE,"Cartas/Cartas-2/d9.png");
		mazo.add(c);
		c= new Carta(10, Palo.DIAMANTE,"Cartas/Cartas-2/dd.png");
		mazo.add(c);
		c= new Carta(11, Palo.DIAMANTE,"Cartas/Cartas-2/dj.png");
		mazo.add(c);
		c= new Carta(12, Palo.DIAMANTE,"Cartas/Cartas-2/dq.png");
		mazo.add(c);
		c= new Carta(13, Palo.DIAMANTE,"Cartas/Cartas-2/dk.png");
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
				juego.getJugadores().get(i).getMano().add(azar());
				juego.getJugadores().get(i).getMano().add(azar());
			}
			for(int i = 0 ; i<juego.getJugadores().size();i++){
				System.out.println(juego.getJugadores().get(i).getMano().get(0)+"-----"+juego.getJugadores().get(i).getMano().get(1));
			}
		}
		
		
		/**
		 * LLena una estructura llamada manos en la cual de encuentran las 5 cartas que estan en la mesa y las dos que tiene cada jugador en la mano con el fin de compararlas e identificar la mano ganadora
		 */
		public void llenarManos(){
			List<Carta> cartas;
			for(Jugador j: juego.getJugadores()){
				cartas= new ArrayList<Carta>();
				cartas.addAll(j.getMano());
				cartas.addAll(cartas);
				Mano m = new Mano(cartas);
				juego.getManos().add(m);
				
			}
			Collections.sort(juego.getManos(),new ComparadorMano());
			
		}
		
		
}
