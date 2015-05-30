package Logica;

public class Apuesta {
		private Jugador apostador;
		int monto;
		
		
		/**
		 * Crea una instancua de Apuesta
		 * @param apostador Jugador que hace la apuesta
		 * @param monto	cantidad de dinero de la apuesta
		 */
		public Apuesta(Jugador apostador, int monto) {
			super();
			this.apostador = apostador;
			this.monto = monto;
		}
		/**
		 * obtiene el jugador que hace la apuesta
		 * @return jugador que hace la apuesta
		 */
		public Jugador getApostador() {
			return apostador;
		}
		/**
		 * establece el jugador que hace la apuesta
		 * @param apostador jugador que hace la apuesta
		 */
		public void setApostador(Jugador apostador) {
			this.apostador = apostador;
		}
		/**
		 * obtiene el monto de la apuesta
		 * @return monto de la apuesta
		 */
		public int getMonto() {
			return monto;
		}
		/**
		 * establece el monto de la apuesta
		 * @param monto cantidad de dinero de la apuesta
		 */
		public void setMonto(int monto) {
			this.monto = monto;
		}		
		
}
