package Pruebas;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import DB.SQLite;
import Logica.Servidor;

public class PUnitarias_DB {

	SQLite DBTested = new SQLite();
	
	@Test
	//Se prueba que la base de datos se cree satisfactoriamente
	public void prueba_crearBD()
	{
		SQLite DBTested1 = new SQLite();	
		assertTrue(DBTested1.crearDB() != false);
		DBTested1 =null;
	}/*
	@Test
	public void prueba_InsertarJugadores()
	{
		DBTested = new SQLite();
		DBTested.crearDB();
		String nombre = generarCadenas();
		String psw = generarCadenas();
		for (int i = 1; i <=5; i++) {
		assertTrue("Prueba de insersión de jugadores",  DBTested.agregarJugador(
				nombre, psw, null));
		}
		DBTested =null;
		
	}
	@Test
	public void prueba_ActualizarJugadores()
	{
		DBTested = new SQLite();
		DBTested.crearDB();
		String nombre = generarCadenas();
		String psw = generarCadenas();
		for (int i = 1; i <=5; i++) {
			assertTrue("Prueba de actualización de jugadores", DBTested.actualizarJugador("user"+i, "newPsw"+i, ""));
			System.out.println("Actualizado el usuario: user" + i);
		}
		DBTested =null;
	}
	@Test
	public void prueba_EliminarJugadores
	()
	{
		DBTested = new SQLite();
		DBTested.crearDB();
		String nombre = generarCadenas();
		String psw = generarCadenas();
		for (int i = 1; i <=5; i++) {
			assertTrue("Prueba de eliminación de jugadores", DBTested.eliminarJugador("user"+i));
			System.out.println("Eliminado el usuario: user" + i);
		}
		DBTested =null;
	}	*/
	@Test
	public void prueba_verificarAdmin()
	{
		DBTested = new SQLite();
		DBTested.crearDB();
		String nombreAdminReal= "pinedo";
		String nombreAdminFalso= generarCadenas();
		assertTrue("Prueba de entrada del admin", DBTested.verificarAdministrador(nombreAdminReal));
		//assertTrue("Prueba de entrada del admin", DBTested.verificarAdministrador(nombreAdminFalso));
		DBTested =null;
	}	
	
	
	public String generarCadenas()
	{
		String cadena = new String();
		for (int i = 0; i < Math.random(); i++) {
			cadena+=Long.toHexString(Double.doubleToLongBits(Math.random())) + Math.random();
		}
		return cadena;
	}
	
	
	
}
