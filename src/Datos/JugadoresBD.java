package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Auxiliar.ProjectDatabaseConnection;

public class JugadoresBD {
	
	
	
	//comprueba si existe jugador, si no existe devuelve false si existe true
	public static boolean comprobarJugador(String nombre) throws SQLException {
		String username = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM JUGADOR WHERE username='"+nombre+"'";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		if (RS.next()) {
			username=RS.getString(1);
			PS = null;
			RS = null;
			conn.desconectar();
			if(username.equals(nombre)) {
				return true;
			}
			else {
				PS = null;
				RS = null;
				conn.desconectar();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static void crearJugador(String nombre) throws SQLException {
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		Connection conexion = conn.getConnection();
		PreparedStatement PS = null;
		PS = conexion.prepareStatement("INSERT INTO JUGADOR VALUES (?)");
		PS.setString(1, nombre);
		PS.executeUpdate();
		conn.desconectar();
	}
	
	
}
