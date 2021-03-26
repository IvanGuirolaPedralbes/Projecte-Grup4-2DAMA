package Backend;

import java.util.Scanner;

public class Humano extends Jugador{
//Creamos el constructor de la clase
	public Humano(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
	
//	public int respuestaMatematicas(int resultat) {
//		return resultat;
//	}
	public void respuestaDiccionario() {
		
	}
	public int respuestaAngles() {
		return (int) (Math.random()*4+1);
	}

}
