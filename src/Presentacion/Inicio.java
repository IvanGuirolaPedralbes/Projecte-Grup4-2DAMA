package Presentacion;

import javax.swing.SwingUtilities;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            new StartSlide();
	         }
	      });

	}

}

//TODO
// CONTROLAR EMPATES, 
//TODO con mas de 5 jugadores y 3 bots no termina partida
//creo que es si turno final es un bot reproducido con 2 jugadores 1bot