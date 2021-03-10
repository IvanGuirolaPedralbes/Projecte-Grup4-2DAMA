package Auxiliar;

import java.sql.*;

public class ProjectDatabaseConnection {
	
	private static Connection conn = null;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost:3306/saberyganar";
	
	public ProjectDatabaseConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			if(conn != null) {
				System.out.println("Conexión establecida.");
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return conn;
	}
	
	public void desconectar() {
		conn = null;
		if(conn == null) {
			System.out.println("Conexion terminada");
		}
	}
}
