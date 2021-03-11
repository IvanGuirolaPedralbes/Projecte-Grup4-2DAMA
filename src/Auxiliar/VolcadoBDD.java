package Auxiliar;

import java.sql.*;
import java.util.*;

public class VolcadoBDD {

	public static void main(String[] args) {
		// Creado por Iván Guirola
		ProjectDatabaseConnection conn = new ProjectDatabaseConnection();
		
		Connection reg = conn.getConnection();
		
		System.out.println(generarPreguntaMatematica());
		System.out.println(generarPreguntaMatematica());
		System.out.println(generarPreguntaMatematica());
		System.out.println(generarPreguntaMatematica());
		System.out.println(generarPreguntaMatematica());
		System.out.println(generarPreguntaMatematica());
		
		
		
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
