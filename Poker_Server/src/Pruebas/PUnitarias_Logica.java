package Pruebas;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import Logica.*;
public class PUnitarias_Logica {
	
	Apuesta tested = new Apuesta(new Jugador(), 1);
	Jugador testedJ = new Jugador("usuario", 3);
	Servidor testedServer = new Servidor();
	Mesa testedMesa= new Mesa();
	//Pruebas a la clase Apuesta
	/**
	 * Pruebas para la clase Apuesta, en la cual se ingresa un monto, se realizan dos pruebas,
	 * luego se cambia el monto y se realizan otras dos pruebas para verificar que la clase trabaja 
	 * correctamente
	 * @param: Jugador Es un jugador de la mesa, para la prueba se simula un jugador cualquiera
	 * @param: Monto: Es la cantidad que se va a agregar a la apuesta.
	 */
	
	@Test
	public void prueba1_Apuesta() {
		assertEquals("Prueba de la apuesta no.1", 1, tested.getMonto());
	}
	@Test
	public void prueba2_Apuesta() {
		assertEquals("Prueba de la apuesta no.2", 2, tested.getMonto());
	}
	@Test
	public void prueba3_Apuesta() {
		tested.setMonto(2);
		assertEquals("Prueba de la apuesta no.3", 2, tested.getMonto());
	}
	@Test
	public void prueba4_Apuesta() {
		assertEquals("Prueba de la apuesta no.4", 1, tested.getMonto());
	}
	//Pruebas a la clase Jugador
	/**
	 * Pruebas para la clase Jugador, en las cuales se verifica el nombre del jugador y la
	 * cantidad de puntos que éste tiene
	 * @param: nombreUsuario
	 * @param: getNombre: mediante este método se obtiene el nombre del jugador, para poderlo comparar
	 * con el ingresado manualmente en la prueba
	 * @param: getPuntos(): mediante este método se obtiene el puntaje del jugador, para poderlo comparar
	 * con el ingresado manualmente en la prueba
	 */
	@Test
	public void prueba1_JugadorNombre()
	{
		assertEquals("usuario", testedJ.getNombre());
	}
	@Test
	public void prueba2_JugadorNombre()
	{
		assertEquals("usuarioFalso", testedJ.getNombre());
	}
	@Test
	public void prueba3_JugadorPuntos()
	{
		assertEquals(3, testedJ.getPuntos());
	}
	@Test
	public void prueba4_JugadorPuntos()
	{
		assertEquals(1, testedJ.getPuntos());
	}
	//Pruebas a la clase Servidor
	/**
	 * Pruebas realizadas a la clase servidor para verificar que se agregan y eliminan jugadores, además se 
	 * trae la dirección del avatar del jugador.
	 * @param: nombreUsuario
	 */
	/*@Test
	public void prueba1_AgregarJugador()
	{
		try {
			assertTrue(testedServer.addJugador(null)==true);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void prueba2_AgregarJugador()
	{
		try {
			assertTrue(testedServer.addJugador("omalagon")==true);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void prueba1_SacarJugador()
	{
		try {
			assertTrue(testedServer.sacarJugador("usuarioFalso")==true);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void prueba2_SacarJugador()
	{
		try {
			assertTrue(testedServer.sacarJugador("omalagon")==true);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void prueba1_traerAvatar()
	{
		try {
			assertNotNull(testedServer.traerAvatar("omalagon"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void prueba2_traerAvatar()
	{
		try {
			assertNotNull(testedServer.traerAvatar(null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Pruebas a la clase mesa
	/**
	 * Pruebas realizadas a la clase Mesa, para verificar que se hace correcto retorno de los objetos cartas, 
	 * mazo y juego
	 */
	@Test
	public void prueba_getCartas()
	{
		assertNotNull(testedMesa.getCartas());
	}
	@Test
	public void prueba_getMazo()
	{
		assertNotNull(testedMesa.getMazo());
	}
	@Test
	public void prueba_getJuego()
	{
		for (int i = 0; i < 500000; i++) {
			System.out.println();
			
		}
		assertNotNull(testedMesa.getJuego());
	}
}
