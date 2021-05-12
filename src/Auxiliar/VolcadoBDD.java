package Auxiliar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

import Datos.PreguntasBD;

public class VolcadoBDD {

	public static void main(String[] args) throws SQLException {
		// Creado por Iván Guirola
		
		//se conecta a la abse de datos
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		Connection conexion = conn.getConnection();
//		IntroducirPreguntasDiccionario(conexion);
//		IntroducirPreguntasIngles(conexion);
//		IntroducirPreguntasMates(conexion);
//		PreguntasBD.ObjectDBIngles();
//		PreguntasBD.ObjectDBMatematicas();
		PreguntasBD.ObjectDBDiccionario();
		conn.desconectar();
	}
	
	//genera una pregunta matematica siguiendo los parametros que pone en el ejercicio
	private static String generarPreguntaMatematica() {
		char[] operadores = {'+', '-', '*'};
		char operador;
		int cantidadNumeros = generarNumeroAleatorio(4, 8);
		String operacionMatematica = "";
		for(int i = 0; i<cantidadNumeros; i++) {
			int numero = generarNumeroAleatorio(2,12);
			operacionMatematica = operacionMatematica + numero;
			if(i!=cantidadNumeros-1) {
				operador = operadores[generarNumeroAleatorio(0,2)];
				operacionMatematica = operacionMatematica + operador;
			}			
		}
		return operacionMatematica;
	}
	
	//genera un numero aleatorio a partir de un minimo y un maximo recibido
	public static int generarNumeroAleatorio(int min, int max) {
		Random numeroRandom = new Random();
        if (min >= max) {
            throw new IllegalArgumentException("Max debe ser mas grande que Min");
        }

        return numeroRandom.nextInt((max - min) + 1) + min;
    }
	
	//introduce las preguntas en ingles  en la base de datos
	private static void IntroducirPreguntasIngles(Connection conexion) {
		BufferedReader inputFichero;
		String linea;
		PreparedStatement PS = null;
		try {
			int i = 1;
			inputFichero = new BufferedReader(new FileReader("resources"+File.separator+"angles.txt"));
			while((linea=inputFichero.readLine())!=null) {
				String id = "Ingles_"+i;
				PS = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES (?)");
				PS.setString(1, id);
				PS.executeUpdate();
				
				PS = conexion.prepareStatement("INSERT INTO INGLES VALUES (?,?,?,?,?,?)");
				PS.setString(1, id);
				PS.setString(2, linea);
				for(int j = 1; j<=4; j++) {
					linea=inputFichero.readLine();
					PS.setString(j+2, linea);
				}
				PS.executeUpdate();
				System.out.println(i + " de 1000");
				i = (i+1);
			}
			inputFichero.close();
			System.out.println("Ingles importado");
		} catch (Exception e) {
			System.err.println("error al pasar preguntas en ingles");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//introduce las preguntas del diccionario en la base de datos
	private static void IntroducirPreguntasDiccionario(Connection conexion) {
		BufferedReader inputFichero;
		String linea;
		PreparedStatement PS = null;
		
		try {
			int i = 1;
			inputFichero = new BufferedReader(new FileReader("resources"+File.separator+"diccionari.txt"));
			while((linea=inputFichero.readLine())!=null) {
				String id = "Diccionario_"+i;
				PS = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES (?)");
				PS.setString(1, id);
				PS.executeUpdate();
				
				PS = conexion.prepareStatement("INSERT INTO DICCIONARIO VALUES (?,?)");
				PS.setString(1, id);
				PS.setString(2, linea);
				PS.executeUpdate();
				System.out.println(i + " de 85220");
				i = (i+1);	            		    
			}
			inputFichero.close();
			System.out.println("Diccionario importado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("error al pasar preguntas en diccionario");
			e.printStackTrace();
		}
		
	}
	
	//introduce las preguntas de matematicas en la base de datos
	private static void IntroducirPreguntasMates(Connection conexion) {
		PreparedStatement PS = null;
		for(int i=1; i<=5500;i++) {
			String id = "Matematicas_"+i;
			try {
				PS = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES (?)");
				PS.setString(1, id);
				PS.executeUpdate();
				
				PS = conexion.prepareStatement("INSERT INTO MATEMATICAS VALUES (?,?)");
				PS.setString(1, id);
				PS.setString(2, generarPreguntaMatematica());
				PS.executeUpdate();
				System.out.println(i + " de 5500");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
