package Logica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

	public void añadirJugador(Jugador jugador) {
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
		Collections.sort(jugadores, new Comparator<Jugador>() {
		    @Override
		    public int compare(Jugador z1, Jugador z2) {
		        if (z1.getPuntuacion() > z2.getPuntuacion())
		            return 1;
		        if (z1.getPuntuacion() < z2.getPuntuacion())
		            return -1;
		        return 0;
		    }
		});

		Collections.reverse(jugadores);
		return jugadores;
	}

	// pregunta de quien es el turno y va sumando rondas y turnos
	public Jugador turnoJugador() {
		Jugador jugadorTurno = jugadores.get(posActual);
		//TODO tira error corregir

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
		System.out.println("jugadores:");
		for(int i = 0; i<jugadores.size();i++) {
			System.out.println(jugadores.get(i).getUsername() + " " + i);
		}
		PartidaBD.introducirJugada(id_Partida, rondaActual, jugadores.get(posActual).getUsername(), id_Pregunta, puntos);
		System.out.println("almacenarronda: es "+ posActual + "igual a " +(jugadores.size() - 1) + "?");
		if (posActual == jugadores.size() - 1) {
			System.out.println("si");
			this.rondaActual++;
			this.posActual = 0;
			if (rondaActual != (duracionPartida + 1)) {
				PartidaBD.introducirRonda(id_Partida, rondaActual);
			}
		} else {
			System.out.println("no");
			this.posActual++;
		}
	}

	public boolean isPartidaTerminada() {
		System.out.println("partiterm: es "+ rondaActual + "igual a " +(duracionPartida + 1) + "?");
		if (rondaActual == duracionPartida + 1) {
			System.out.println("si");
			try {
				PartidaBD.finalizarPartida();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else
			System.out.println("no");
			return false;

	}

	@Override
	public String toString() {
		return "Partida [rondaActual=" + rondaActual + ", duracionPartida=" + duracionPartida + ", jugadores="
				+ jugadores + "]";
	}

}
