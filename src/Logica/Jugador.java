package Logica;

import java.sql.SQLException;

import Datos.JugadoresBD;

public abstract class Jugador{
	//Cremos los atributos de la clase
	protected String username;
	protected int puntuacion;
	
	
	//Creem el constructor de la clase
	public Jugador(String username) {
		this.username = username;
		this.puntuacion = 0;
	}
	
	public void sumarPunto() {
		puntuacion++;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	};
	
	//inserta el jugador en la base de datos si no existe
	public void insertaJugadorSiNoExiste() {
		try {
			if(!JugadoresBD.comprobarJugador(username)) {
				JugadoresBD.crearJugador(username);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
