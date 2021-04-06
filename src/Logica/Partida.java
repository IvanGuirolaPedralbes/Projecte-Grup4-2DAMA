package Logica;

import java.util.ArrayList;
import java.util.Arrays;

public class Partida {
	//Creem els atributs de la clase
	private int rondaActual;
	private int duracionPartida;
	private ArrayList<Jugador> jugadores;
	
	
	public Partida(int duracionPartida) {
		this.duracionPartida = duracionPartida;
	}

	public void setCantidadJugadores(int Jugadores) {
		jugadores = new ArrayList<Jugador>(Jugadores);
	}
	public int getRondaActual() {
		return rondaActual;
	}

	public void setRondaActual(int rondaActual) {
		this.rondaActual = rondaActual;
	}

	public int getDuracionPartida() {
		return duracionPartida;
	}

	public void setDuracionPartida(int duracionPartida) {
		this.duracionPartida = duracionPartida;
	}

	
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void añadirJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	@Override
	public String toString() {
		return "Partida [rondaActual=" + rondaActual + ", duracionPartida=" + duracionPartida + ", jugadores="
				+ jugadores + "]";
	}

	
	
	
	
	
	
}
