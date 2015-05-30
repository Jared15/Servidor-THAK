package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Jugador;

public class SQLite {

	Connection c = null;
	Statement stmt = null;

	public void crearDB() {

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:thak.db");
			System.out.println("Base de Datos Iniciada");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void agregarJugador(String nombre, String pass, String PathAvatar) {

		try {
			PreparedStatement prep = c
					.prepareStatement("INSERT INTO JUGADOR (NOMBRE,PASS,PATH,PUNTOS,PARTIDASGANADAS) VALUES (?, ?, ?, ?, ?);");
			prep.setString(1, nombre);
			prep.setString(2, pass);
			prep.setString(3, PathAvatar);
			prep.setString(4, "1000");
			prep.setString(5, "0");

			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void actualizarJugador(String nombre, String pass, String PathAvatar) {

		try {
			String sql = "UPDATE JUGADOR set PASS = " + pass
					+ " where NOMBRE =" + nombre + ";";
			PreparedStatement prep = c
					.prepareStatement("UPDATE JUGADOR set PASS = ? where NOMBRE = ?;");
			prep.setString(1, pass);
			prep.setString(2, nombre);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();
			prep = c.prepareStatement("UPDATE JUGADOR set PATH = ? where NOMBRE = ?;");
			prep.setString(1, PathAvatar);
			prep.setString(2, nombre);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void eliminarJugador(String nombre) {

		try {
			stmt = c.createStatement();
			String sql = "DELETE from JUGADOR where NOMBRE=\"" + nombre + "\";";
			stmt.executeUpdate(sql);
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	public boolean verificarUsuario(String us, String pass) {

		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR;");

			while (rs.next()) {
				if ((rs.getString("NOMBRE").equals(us))
						&& (rs.getString("PASS").equalsIgnoreCase(pass))
						&& (rs.getString("BLOQUEADO").equalsIgnoreCase("no"))) {
					return true;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public boolean verificarAdministrador(String us) {

		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR;");

			while (rs.next()) {
				if ((rs.getString("NOMBRE").equals(us))
						&& (rs.getString("ADMINISTRADOR")
								.equalsIgnoreCase("si"))) {
					return true;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	public List<String> traerPathAvatar(String us) {

		ResultSet rs;
		List<String> jugador = new ArrayList<String>();
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR;");

			while (rs.next()) {
				if (rs.getString("NOMBRE").equalsIgnoreCase(us)) {
					jugador.add(rs.getString("NOMBRE"));
					jugador.add(rs.getString("PUNTOS"));
					jugador.add(rs.getString("PARTIDASGANADAS"));
					jugador.add(rs.getString("PATH"));

					return jugador;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public Jugador getJugador(String us) {

		ResultSet rs;
		Jugador j;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR WHERE NOMBRE =\""
					+ us + "\";");

			while (rs.next()) {
				if (rs.getString("NOMBRE").equalsIgnoreCase(us)) {

					j = new Jugador(rs.getString("NOMBRE"), Integer.parseInt(rs
							.getString("PUNTOS")));
					return j;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public String getPathJugador(String us) {

		ResultSet rs;
		String j;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR WHERE NOMBRE =\""
					+ us + "\";");

			while (rs.next()) {
				if (rs.getString("NOMBRE").equalsIgnoreCase(us)) {
					j = rs.getString("PATH");
					return j;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public List<List<String>> listaUsuarios() {
		ResultSet rs;
		String j;
		List<List<String>> listadeListas = new ArrayList<List<String>>();
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR;");

			while (rs.next()) {
				List<String> lista = new ArrayList<String>();
				lista.add(rs.getString("NOMBRE"));
				lista.add(rs.getString("PASS"));
				lista.add(rs.getString("PUNTOS"));
				lista.add(rs.getString("PARTIDASGANADAS"));

				listadeListas.add(lista);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return listadeListas;

	}

	public void registrarDenuncio(String jugador,String motivo, String descripcion) {
		try {
			PreparedStatement prep = c
					.prepareStatement("INSERT INTO DENUNCIO (JUGADOR,MOTIVO,DESCRIPCION) VALUES (?, ?, ?);");
			prep.setString(1, jugador);
			prep.setString(2, motivo);
			prep.setString(3, descripcion);

			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	public void bloquearUsuario(String nombre) {
		try {
			PreparedStatement prep = c
					.prepareStatement("UPDATE JUGADOR set BLOQUEADO = ? where NOMBRE = ?;");
			prep.setString(1, "si");
			prep.setString(2, nombre);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}

	public void actualizarDinero(String nombre, int cantidad) {
		ResultSet rs;
		int dinero=0;
		try {
			PreparedStatement prep = c
					.prepareStatement("SELECT * FROM JUGADOR WHERE NOMBRE =?;");
			prep.setString(1, nombre);
			rs=prep.executeQuery();

			while (rs.next()) {
					dinero = Integer.parseInt(rs.getString("PUNTOS"));	
					System.out.println("dinero"+dinero);
			}
			rs.close();
			stmt.close();
			
			if(dinero!=0){
				PreparedStatement prep1 = c
						.prepareStatement("UPDATE JUGADOR set PUNTOS = ? where NOMBRE = ?;");
				prep1.setInt(1, dinero-cantidad);
				prep1.setString(2, nombre);
				prep1.executeUpdate();
				c.setAutoCommit(false);
				c.commit();
			}			

		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
	}

	public void registrarGanador(String nombre) {
		ResultSet rs;
		int ganadas=0;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR WHERE NOMBRE =?");

			while (rs.next()) {
					ganadas = Integer.parseInt(rs.getString("PARTIDASGANADAS"));				
			}
			rs.close();
			stmt.close();
			
			if(ganadas!=0){
				PreparedStatement prep = c
						.prepareStatement("UPDATE JUGADOR set PARTIDASGANADAS = ? where NOMBRE = ?;");
				prep.setInt(1, ganadas+1);
				prep.setString(2, nombre);
				prep.executeUpdate();
				c.setAutoCommit(false);
				c.commit();
			}			

		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		
	}

	public void guardarColores(String fondo, int carta, String mesa, String usuario) {
		try {			
			PreparedStatement prep = c
					.prepareStatement("UPDATE JUGADOR set FONDO = ? where NOMBRE = ?;");
			prep.setString(1, fondo);
			prep.setString(2, usuario);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();
			prep = c.prepareStatement("UPDATE JUGADOR set Mesa = ? where NOMBRE = ?;");
			prep.setString(1, mesa);
			prep.setString(2, usuario);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();
			prep = c.prepareStatement("UPDATE JUGADOR set CARTA = ? where NOMBRE = ?;");
			prep.setString(1, carta+"");
			prep.setString(2, usuario);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

	public double promedioGanadas() {
		ResultSet rs;
		double promedio=0;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JUGADOR WHERE NOMBRE =?");

			while (rs.next()) {
					promedio = rs.getDouble(0);				
			}
			rs.close();
			stmt.close();				

		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return promedio;
	}

	public List<List<String>> getReportes() {
		ResultSet rs;
		String j;
		List<List<String>> listadeListas = new ArrayList<List<String>>();
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM DENUNCIO;");

			while (rs.next()) {
				List<String> lista = new ArrayList<String>();
				lista.add(rs.getString("JUGADOR"));
				lista.add(rs.getString("MOTIVO"));
				lista.add(rs.getString("DESCRIPCION"));
				lista.add(rs.getString("LEIDO"));

				listadeListas.add(lista);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return listadeListas;
	}

}