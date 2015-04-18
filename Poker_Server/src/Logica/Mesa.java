package Logica;

import java.util.ArrayList;
import java.util.List;

import Manos.Carta;
import Manos.Palo;

public class Mesa   {
		List<Carta> mazo= new ArrayList<Carta>();
		Dealer dealer= new Dealer(mazo);
		Juego j = new Juego();
		
		
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
		
		}
		
		public String getPath(){
			return dealer.azar().getPath();
		}
		
		
		
}
