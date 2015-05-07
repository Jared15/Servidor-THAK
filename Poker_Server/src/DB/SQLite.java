package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Jugador;

public class SQLite
{
	
	Connection c = null;
    Statement stmt = null;
  public void crearDB()
  {
    
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:/home/javier-vasquez/Escritorio/thak.db");
      System.out.println("Base de Datos Iniciada");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
  }
  
  
  public void agregarJugador(String nombre, String pass, String PathAvatar){
	  
	  try {
		 PreparedStatement prep = c.prepareStatement("INSERT INTO JUGADOR (NOMBRE,PASS,PATH,PUNTOS,PARTIDASGANADAS) VALUES (?, ?, ?, ?, ?);");
		 prep.setString(1, nombre);
		 prep.setString(2, pass);
		 prep.setString(3, PathAvatar);
		 prep.setString(4, "0");
		 prep.setString(5, "0");

		 prep.executeUpdate();
		 c.setAutoCommit(false);
		 c.commit();

	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void actualizarJugador(String nombre, String pass, String PathAvatar){
	  
	  try {
	      String sql = "UPDATE JUGADOR set PASS = "+pass+" where NOMBRE ="+nombre+";";
	      PreparedStatement prep = c.prepareStatement("UPDATE JUGADOR set PASS = ? where NOMBRE = ?;");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  public void eliminarJugador(String nombre){
	  
	  try {
		  stmt = c.createStatement();
	      String sql = "DELETE from JUGADOR where NOMBRE=\""+nombre+"\";";
	      stmt.executeUpdate(sql);
			 c.setAutoCommit(false);
			 c.commit();

	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public boolean verificarUsuario(String us, String pass){
	  
	  ResultSet rs;
	try {
		stmt = c.createStatement();
		rs = stmt.executeQuery( "SELECT * FROM JUGADOR;" );
	
      while ( rs.next() ) {
         if((rs.getString("NOMBRE").equals(us))&&(rs.getString("PASS").equalsIgnoreCase(pass))){
        	 return true;
         }
      }
      rs.close();
      stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	  
  }
  public List<String> traerPathAvatar(String us){
	  
	  ResultSet rs;
	  List<String> jugador = new ArrayList<String>();
	try {
		stmt = c.createStatement();
		rs = stmt.executeQuery( "SELECT * FROM JUGADOR;" );
	
      while ( rs.next() ) {
         if(rs.getString("NOMBRE").equalsIgnoreCase(us)){
        	jugador.add(rs.getString("NOMBRE"));
        	jugador.add(rs.getString("PUNTOS"));
        	jugador.add(rs.getString("PARTIDASGANADAS"));
        	jugador.add(rs.getString("PATH"));
        	 
        	 return  jugador;
         }
      }
      rs.close();
      stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	  
  }
  
  public Jugador getJugador(String us){
	  
	  ResultSet rs;
	  Jugador j;
	try {
		stmt = c.createStatement();
		rs = stmt.executeQuery( "SELECT * FROM JUGADOR WHERE NOMBRE =\""+us+"\";" );
	
      while ( rs.next() ) {
         if(rs.getString("NOMBRE").equalsIgnoreCase(us)){
        	 j= new Jugador(rs.getString("NOMBRE"),Integer.parseInt(rs.getString("PUNTOS")),Integer.parseInt(rs.getString("PARTIDASGANADAS")),rs.getString("PATH"));
        	 return  j;
         }
      }
      rs.close();
      stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	  
  }
}