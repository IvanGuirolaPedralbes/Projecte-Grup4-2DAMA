package Datos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Auxiliar.ProjectDatabaseConnection;
import Logica.Pregunta;
import Logica.PreguntaDiccionarioLogica;
import Logica.PreguntaInglesLogica;
import Logica.PreguntaMatematicasLogica;

public class PreguntasBD {

	public static String[] getPreguntaIngles() throws SQLException {
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

	public static String[] getPreguntasIngles(int i) throws SQLException {
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

	public static String[] getPreguntaMatematicas() throws SQLException {
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

	public static String[] getPreguntaDiccionario() throws SQLException {
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

	public static void ObjectDBIngles() throws SQLException {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/bdPreguntasIngles.odb");
		EntityManager em = emf.createEntityManager();

		// Store all questions in the database:
		em.getTransaction().begin();
		String preguntaIngles[] = new String[6];
		String username = null;
		String pregunta = null;
		String correcta = null;
		String alt1 = null;
		String alt2 = null;
		String alt3 = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM INGLES";
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
			PreguntaInglesLogica pi = new PreguntaInglesLogica(preguntaIngles[0],preguntaIngles[1],preguntaIngles[2],preguntaIngles[3],preguntaIngles[4],preguntaIngles[5]);
			em.persist(pi);
		}
		em.getTransaction().commit();
		 // Close the database connection:
        em.close();
        emf.close();

	}
	
	public static void ObjectDBMatematicas() throws SQLException {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/bdPreguntasMatematicas.odb");
		EntityManager em = emf.createEntityManager();

		// Store all questions in the database:
		em.getTransaction().begin();
		String preguntaMates[] = new String[2];
		String id_Pregunta = null;
		String operacion = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM MATEMATICAS";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (RS.next()) {
			preguntaMates[0] = RS.getString(1);
			preguntaMates[1] = RS.getString(2);
			PreguntaMatematicasLogica pm = new PreguntaMatematicasLogica(preguntaMates[0],preguntaMates[1]);
			em.persist(pm);
		}
		em.getTransaction().commit();
		 // Close the database connection:
        em.close();
        emf.close();

	}
	
	public static void ObjectDBDiccionario() throws SQLException {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/bdPreguntasDiccionario.odb");
		EntityManager em = emf.createEntityManager();

		// Store all questions in the database:
		em.getTransaction().begin();
		String preguntaDiccionario[] = new String[2];
		String id_Pregunta = null;
		String palabraDiccionario = null;
		PreparedStatement PS;
		ResultSet RS;
		String SQL_SELECT = "SELECT * FROM DICCIONARIO;";
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		PS = conn.getConnection().prepareStatement(SQL_SELECT);
		RS = PS.executeQuery();
		while (RS.next()) {
			preguntaDiccionario[0] = RS.getString(1);
			preguntaDiccionario[1] = RS.getString(2);
			PreguntaDiccionarioLogica pd = new PreguntaDiccionarioLogica(preguntaDiccionario[0],preguntaDiccionario[1]);
			em.persist(pd);
		}
		em.getTransaction().commit();
		 // Close the database connection:
        em.close();
        emf.close();

	}
}
