package Datos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import Auxiliar.ProjectDatabaseConnection;

public class PartidaBD {

	static ProjectDatabaseConnection conn;
	static Connection conexion;

	public static int ultimaPartida() throws SQLException {
		int partida;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM PARTIDAS ORDER BY id_Partida DESC LIMIT 1";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		if (RS.next()) {
			partida = RS.getInt(1);
		} else {
			partida = 0;
		}
		PS = null;
		RS = null;
		return partida;
	}

	public static void iniciarPartida() {
		conn = new ProjectDatabaseConnection();
		conexion = conn.getConnection();
		PreparedStatement PS = null;

		try {
			conexion.setAutoCommit(false);
			PS = conexion.prepareStatement("INSERT INTO PARTIDAS VALUES (?)");

			PS.setInt(1, ultimaPartida() + 1);
			PS.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.desconectar();
	}

	public static void introducirRonda(int id_Partida, int id_Ronda) {
		PreparedStatement PS = null;
		try {
			PS = conexion.prepareStatement("INSERT INTO RONDA VALUES (?,?)");
			PS.setInt(1, id_Partida);
			PS.setInt(2, id_Ronda);
			PS.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void introducirJugada(int id_Partida, int id_Ronda, String usuario, String id_Pregunta, int puntos) {
		PreparedStatement PS = null;
		try {

			PS = conexion.prepareStatement("INSERT INTO JUGADA VALUES (?,?,?,?,?)");
			PS.setInt(1, id_Partida);
			PS.setInt(2, id_Ronda);
			PS.setString(3, usuario);
			PS.setString(4, id_Pregunta);
			PS.setInt(5, puntos);
			PS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void finalizarPartida() throws IOException {
		FileWriter fichero = new FileWriter("partidas.txt");
		try {
			conexion.commit();
			conn.desconectar();
			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 1; i < JugadoresBD.nPartidas(); i++) {
				Map partidas = JugadoresBD.historicPartida(i);
				Iterator<String> iter = partidas.keySet().iterator();
				pw.println("Partida "+i+":");
				while (iter.hasNext()) {
					String model = iter.next().toString();
					pw.println("NOM: " + model + " | PUNTS: " + partidas.get(model));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
