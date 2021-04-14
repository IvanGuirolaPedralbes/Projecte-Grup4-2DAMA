package Logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Partida {
	//Creem els atributs de la clase
	private int id_Partida;
	private int rondaActual=0;
	private int posActual=0;
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
	
	public void mezclarJugadores() {
		Collections.shuffle(jugadores);
	}
	
	//pregunta de quien es el turno y va sumando rondas y turnos
	public Jugador turnoJugador() {
		Jugador jugadorTurno = jugadores.get(posActual);
		
		if(posActual == jugadores.size()-1) {
			this.rondaActual++;
			this.posActual=0;
		}
		else this.posActual++;
		
		return jugadorTurno;	
	}
	//llama a insertajugador de cada jugador
	public void insertarJugadores() {
		for(Jugador jugador : jugadores) {
			jugador.insertaJugadorSiNoExiste();
		}
	}
	
	@Override
	public String toString() {
		return "Partida [rondaActual=" + rondaActual + ", duracionPartida=" + duracionPartida + ", jugadores="
				+ jugadores + "]";
	}

	
	
	
	
	
	
}
