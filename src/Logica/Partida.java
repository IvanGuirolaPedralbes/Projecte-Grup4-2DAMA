package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Datos.PartidaBD;

public class Partida {
	// Creem els atributs de la clase
	private int id_Partida;
	private int rondaActual = 1;
	private int posActual = 0;
	private int duracionPartida; // cuando la ronda es duracionpartida< rondaactual +1 se ha terminado
	private ArrayList<Jugador> jugadores;

	public Partida(int duracionPartida) {
		this.duracionPartida = duracionPartida;
		try {
			id_Partida = PartidaBD.ultimaPartida() + 1;
			// iniciamos partida y ronda actual
			PartidaBD.iniciarPartida();
			PartidaBD.introducirRonda(id_Partida, rondaActual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void a�adirJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public int getPosActual() {
		return posActual;
	}

	public void setPosActual(int posActual) {
		this.posActual = posActual;
	}

	public void mezclarJugadores() {
		Collections.shuffle(jugadores);
	}

	public ArrayList<Jugador> ordenarJugadoresPorPuntos() {
		Jugador jugadorTemp;
		for (int i = 0; i < jugadores.size(); i++) {
			for (int j = 1; j < (jugadores.size() - i); j++) {
				if (jugadores.get(j-1).getPuntuacion()> jugadores.get(j).getPuntuacion()) {
					// swap elements
					jugadorTemp = jugadores.get(j-1);
					jugadores.set(j-1, jugadores.get(j));
					jugadores.set(j, jugadorTemp);
				}

			}
		}
		return jugadores;
	}

	// pregunta de quien es el turno y va sumando rondas y turnos
	public Jugador turnoJugador() {
		Jugador jugadorTurno = jugadores.get(posActual);

		return jugadorTurno;
	}

	// llama a insertajugador de cada jugador
	public void insertarJugadores() {
		for (Jugador jugador : jugadores) {
			jugador.insertaJugadorSiNoExiste();
		}
	}

	public void incrementarRonda() {

		rondaActual++;
	}

	public void almacenarRonda(String id_Pregunta, int puntos) {
		PartidaBD.introducirJugada(id_Partida, rondaActual, jugadores.get(posActual).username, id_Pregunta, puntos);

		if (posActual == jugadores.size() - 1) {
			this.rondaActual++;
			this.posActual = 0;
			if (!(rondaActual == duracionPartida + 1))
				PartidaBD.introducirRonda(id_Partida, rondaActual);
		} else
			this.posActual++;
	}

	public boolean isPartidaTerminada() {
		if (rondaActual == duracionPartida + 1) {
			PartidaBD.finalizarPartida();
			return true;
		} else
			return false;

	}

	@Override
	public String toString() {
		return "Partida [rondaActual=" + rondaActual + ", duracionPartida=" + duracionPartida + ", jugadores="
				+ jugadores + "]";
	}

}
