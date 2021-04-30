package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Auxiliar.ProjectDatabaseConnection;
import Logica.Humano;
import Logica.Jugador;

public class JugadoresBD {

	// comprueba si existe jugador, si no existe devuelve false si existe true
	public static boolean comprobarJugador(String nombre) throws SQLException {
		String username = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM JUGADOR WHERE username='" + nombre + "'";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		if (RS.next()) {
			username = RS.getString(1);
			PS = null;
			RS = null;
			conn.desconectar();
			if (username.equals(nombre)) {
				return true;
			} else {
				PS = null;
				RS = null;
				conn.desconectar();
				return false;
			}
		} else {
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

	public static int nPartidas() throws SQLException {
		int nPartidas = 0;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT id_Partida from JUGADA order by id_Partida DESC";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		if (RS.next()) {
			nPartidas = RS.getInt(1);
		}
		return nPartidas;

	}

	public static Map historicPartida(int id_Partida) throws SQLException {
		String username = null;
		Map<String, Integer> historico = new HashMap<String, Integer>();
		Boolean aux = true;
		int puntuacion, nPartidas;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT username, sum(puntos) as Puntuacion from JUGADA WHERE id_Partida=" + id_Partida
				+ " group by username order by Puntuacion ASC;";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (aux) {
			if (RS.next()) {
				username = RS.getString(1);
				puntuacion = RS.getInt(2);
				historico.put(username, puntuacion);
			} else {
				aux = false;
			}
		}
		conn.desconectar();
		return historico;
	}

	public static void eliminarJugador(String nombre) throws SQLException {
		Connection conexion = null;
		Statement stmt = null;
		try {
			ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
			conexion = conn.getConnection();
			System.out.println("Connection is created successfully:");
			stmt = (Statement) (conexion.createStatement());
			String query1 = "delete from  JUGADOR " + "where username='" + nombre + "';";
			stmt.executeUpdate(query1);
			System.out.println("Record is deleted from the table successfully..................");

		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conexion.close();
			} catch (SQLException se) {
			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Please check it in the MySQL Table. Record is now deleted.......");
	}

	public static ArrayList<Jugador> getJugadores() throws SQLException {
		PreparedStatement PS;
		String username;
		int nJugadors = 0;
		ArrayList<Jugador> listaJugadores = new ArrayList();
		ResultSet RS;
		String SQL_CountJugadores = "SELECT COUNT(*) FROM JUGADOR where username not like 'IA%';";
		// String SQL_SELECT = "SELECT username, sum(puntos) as Puntuacion from JUGADA
		// WHERE username not like 'IA%' group by username order by sum(puntos) DESC;";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_CountJugadores);
		RS = PS.executeQuery();
		if (RS.next()) {
			nJugadors = Integer.parseInt(RS.getString(1));
		}
		for (int i = 0; i < nJugadors; i++) {
			String SQL_SELECT = "SELECT username FROM JUGADOR WHERE username not like 'IA%' limit " + i + ",1;";
			PS = conn.getConnection().prepareStatement(SQL_SELECT);
			RS = PS.executeQuery();
			if (RS.next()) {
				username = RS.getString(1);
				listaJugadores.add(new Humano(username));
				System.out.println("Username: " + username);
				PS = null;
				RS = null;
			}
		}
		conn.desconectar();
		return listaJugadores;
	}

}
