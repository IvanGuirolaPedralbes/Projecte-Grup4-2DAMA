package Auxiliar;

import java.sql.*;

public class ProjectDatabaseConnection {
	
	private static Connection conn = null;
	
	private static final String IP = "192.168.12.208"; //Cambiar ip segun la ip de tu maquina virtual
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://"+IP+":3306/saberyganar";
	
	public ProjectDatabaseConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
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
		try {
			conn.close();
			System.out.println("Conexion terminada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Algo ha salido mal al cerrar la conexión con la base de datos");
			e.printStackTrace();
		}
	}
}
