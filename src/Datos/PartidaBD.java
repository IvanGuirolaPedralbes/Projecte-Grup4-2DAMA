package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Auxiliar.ProjectDatabaseConnection;

public class PartidaBD {

	/*public static String ultimaPartida() {
		String partida ="";
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
		
		
		
		return null;
	
	}*/
}
