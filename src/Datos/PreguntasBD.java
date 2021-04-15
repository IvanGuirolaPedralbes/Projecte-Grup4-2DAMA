package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Auxiliar.ProjectDatabaseConnection;
import Logica.PreguntaInglesLogica;

public class PreguntasBD {

	
	
	
	public static  String[] getPreguntaIngles() throws SQLException {
		// Creado por Iván Guirola
		String preguntaIngles[] = new String[6];
		String username = null;
		String pregunta = null;
		String correcta = null;
		String alt1 = null;
		String alt2 = null;
		String alt3 = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM INGLES ORDER BY RAND() LIMIT 1";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (RS.next()) {
			preguntaIngles[0] = RS.getString(1);
			preguntaIngles[1] = RS.getString(2);
			preguntaIngles[2] = RS.getString(3);
			preguntaIngles[3] = RS.getString(4);
			preguntaIngles[4] = RS.getString(5);
			preguntaIngles[5] = RS.getString(6);
		}
		
		PS = null;
		RS = null;
		conn.desconectar();
		
	return preguntaIngles;
	}
	
	public static  String[] getPreguntaMatematicas() throws SQLException {
		// Creado por Iván Guirola
		String preguntaMates[] = new String[2];
		String id_Pregunta = null;
		String operacion = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM MATEMATICAS ORDER BY RAND() LIMIT 1";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (RS.next()) {
			preguntaMates[0] = RS.getString(1);
			preguntaMates[1] = RS.getString(2);
			
		}
		
		PS = null;
		RS = null;
		conn.desconectar();
	return preguntaMates;
	}
	
	public static String [] getPreguntaDiccionario() throws SQLException {
		String preguntaDiccionario[] = new String[2];
		String id_Pregunta = null;
		String palabraDiccionario = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM DICCIONARIO ORDER BY RAND() LIMIT 1";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (RS.next()) {
			preguntaDiccionario[0] = RS.getString(1);
			preguntaDiccionario[1] = RS.getString(2);
			
		}
		
		PS = null;
		RS = null;
		conn.desconectar();
	return preguntaDiccionario;
	}
}
