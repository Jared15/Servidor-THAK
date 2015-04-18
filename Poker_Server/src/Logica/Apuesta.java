package Logica;

public class Apuesta {
		private Jugador apostador;
		int monto;
		
		
		
		public Apuesta(Jugador apostador, int monto) {
			super();
			this.apostador = apostador;
			this.monto = monto;
		}
		
		public Jugador getApostador() {
			return apostador;
		}
		public void setApostador(Jugador apostador) {
			this.apostador = apostador;
		}
		public int getMonto() {
			return monto;
		}
		public void setMonto(int monto) {
			this.monto = monto;
		}
		
		
		
}
