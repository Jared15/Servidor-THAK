package Logica;

import java.util.List;

public class Ronda {
		private List<Apuesta> apuestas;
		private int apuestaCompleta;
		
		
		
		
		public Ronda(List<Apuesta> apuestas, int apuestaCompleta) {
			super();
			this.apuestas = apuestas;
			this.apuestaCompleta = apuestaCompleta;
		}
		public List<Apuesta> getApuestas() {
			return apuestas;
		}
		public void setApuestas(List<Apuesta> apuestas) {
			this.apuestas = apuestas;
		}
		public int getApuestaCompleta() {
			return apuestaCompleta;
		}
		public void setApuestaCompleta(int apuestaCompleta) {
			this.apuestaCompleta = apuestaCompleta;
		}
		
		
		
}
