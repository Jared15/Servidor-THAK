package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Jugador;
/**
 * Esta clase permite la conexión con la base de datos
 * @author Jacoj
 */
public class SQLite {

	Connection c = null;
	Statement stmt = null;
/**
 * Este método crea la base de datos a partir del archivo con la ruta especificada
 */
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
/**
 * Este metodo agrega un jugador a la base de datos.
 * @param nombre Es el nombre del jugador.
 * @param pass Es la contraseña del jugador.
 * @param PathAvatar Es la ruta donde se encuentra el Avatar.
 */
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
/**
 * Este metodo actualiza los datos del jugador a partir de las modificaciones hechas en el juego.
 * @param nombre Es el nombre del usuario.
 * @param pass Es la contraseña del usuario.
 * @param PathAvatar Es la ruta donde está el Avatar del usuario.
 */
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
/**
 * Este método elimina de la base de datos un usuario a partir del nombre dado.
 * @param nombre Es el nombre del jugador.
 */
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
/**
 * Este medoto realiza una validación del usuario que se esta conectando.
 * @param us Es el usuario al que se le desea realizar la verificación.
 * @param pass Es la contraseña del usuario.
 * @return una variable booelana con el resultado de la validación.
 */
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
/**
 * Este método verifica si un usuario es o no es administrador.
 * @param us Es el nombre del usuario que se desea comprobar si es o no administrador.
 * @return Retorna un booleano con el resultado de la validación.
 */
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

	/**
	 * Este método retorna la dirección con el Avatar de un usuario a partir de su nombre.
	 * @param us Es el nombre del usuario al que se le desea buscar el Avatar.
	 * @return Una lista de String con las rutas de los Avatars disponibles en la base de datos.
	 */
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
/**
 * Este método retorna una clase jugador a partir de un usuario dado.
 * @param us Es el nombre del usuario que se desea buscar.
 * @return Una clase jugador con toda la información de un jugador.
 */
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
/**
 * Este método retorna un String con la ruta a partir de un usuario dado.
 * @param us Es el nombre de usuario del jugador.
 * @return un String con la ruta del jugador.
 */
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
/**
 * Este método retorna toda la lista de usuarios disponibles en la base de datos.
 * @return una lista de String con los usuario disponibles en la base de datos.
 */
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
/**
 * Este metodo registra el denuncion hacia un jugador.
 * @param jugador Es el usuario del jugador.
 * @param motivo Es el motivo por el cual el jugador esta siendo sancionado.
 * @param descripcion Es la descripcion que la persona que denuncio dió.
 */
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
/**
 * Este método bloquea un usuario a partir de su nombre.
 * @param nombre Es el nombre del usuario.
 */
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
/**
 * Este método actualiza la cantidad de dinero de un usuario
 * @param nombre Es el nombre de usuario del jugador.
 * @param cantidad Es la cantidad del monto.
 */
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
/**
 * Este método registra un ganador a partir del nombre de usuario.
 * @param nombre nombre del usuario.
 */
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
/**
 * Este método guarda los colores  y configuración de una mesa.
 * @param fondo Es el fondo de la configuración.
 * @param carta Es la carta que esta en la configuración.
 * @param mesa Es la mesa que esta en la configuración.
 * @param usuario Es el nombre del usuario que esta solicitando el cambio y configuración.
 */
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
			prep = c.prepareStatement("UPDATE JUGADOR set CARTAS = ? where NOMBRE = ?;");
			prep.setString(1, carta+"");
			prep.setString(2, usuario);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
/**
 * Este método saca el promedio de partidas ganadas en general.
 * @return retorna un tipo double con el promedio general de partidas ganadas.
 */
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
/**
 * Esté método genera reporte de todos los usuarios en la base de datos.
 * @return retorna una lista de String con los usuarios retornados.
 */
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
/**
 * Este método agrega una nota digitada por un usuario en la interfaz
 * @param nota Es el String de la nota.
 * @param usuario Es el nombre de usuario que digita la nota.
 */
	public void agregarNota(String nota, String usuario) {
		try {			
			PreparedStatement prep = c
					.prepareStatement("UPDATE JUGADOR set NOTAS = ? where NOMBRE = ?;");
			prep.setString(1, nota);
			prep.setString(2, usuario);
			prep.executeUpdate();
			c.setAutoCommit(false);
			c.commit();

		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}