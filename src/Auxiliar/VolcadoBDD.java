package Auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class VolcadoBDD {

	public static void main(String[] args) {
		// Creado por Iván Guirola
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		
		Connection conexion = conn.getConnection();
		BufferedReader inputFichero;
		String linea;
		PreparedStatement PS = null;
		int i = 1;
		
			//se busca una pregunta aleatoria que exista
			
			try {
				inputFichero = new BufferedReader(new FileReader("diccionari.txt"));
				while((linea=inputFichero.readLine())!=null) {
					String id = "Diccionario_"+i;
					PS = conexion.prepareStatement("INSERT INTO PREGUNTAS VALUES (?)");
					PS.setString(1, id);
					PS.executeUpdate();
					
					PS = conexion.prepareStatement("INSERT INTO DICCIONARIO VALUES (?,?)");
					PS.setString(1, id);
					PS.setString(2, linea);
					PS.executeUpdate();
					i = (i+1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
	           
				
				
				
	      
		
	}

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
	

	public static int generarNumeroAleatorio(int min, int max) {
		Random numeroRandom = new Random();
        if (min >= max) {
            throw new IllegalArgumentException("Max debe ser mas grande que Min");
        }

        return numeroRandom.nextInt((max - min) + 1) + min;
    }
}
