package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Logica.CPU;
import Logica.Partida;
import Logica.PreguntaDiccionarioLogica;
import Logica.StyledButtonUI;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PreguntaDiccionario extends JFrame {

	private JPanel contentPane;
	private PreguntaDiccionarioLogica pregunta;
	static Partida partida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					new PreguntaDiccionario(partida).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PreguntaDiccionario(Partida partida) throws InterruptedException {
		pregunta = new PreguntaDiccionarioLogica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1000, 600);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel background;
		ImageIcon img = new ImageIcon("resources/book.png");
		contentPane.setLayout(null);
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);

		JLabel lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMensaje.setBounds(269, 23, 337, 33);
		background.add(lblMensaje);

		JButton btnCHECK = new JButton("CHECK");
		background.add(btnCHECK);
		btnCHECK.setUI(new StyledButtonUI());
		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(755, 108, 99, 38);

		JPanel panelLetras = new JPanel();
		panelLetras.setBounds(0, 235, 1000, 40);
		panelLetras.setOpaque(false);
		background.add(panelLetras);

		System.out.println(pregunta.getPalabraDiccionario());
		System.out.println(pregunta.getId_Pregunta());

		int longitud = pregunta.getPalabraDiccionario().length();

		JTextField vectorRelleno[] = new JTextField[longitud];

		int posicionX = 70;
		int[] numElegidos = generarNumerosAleatorios(longitud);

		for (int i = 0; i < longitud; i++) {
			vectorRelleno[i] = new JTextField();

			posicionX += 40;
			vectorRelleno[i].setPreferredSize(new Dimension(35, 35));
			setFont(new Font("Tahoma", Font.BOLD, 30));
			vectorRelleno[i].setHorizontalAlignment(SwingConstants.CENTER);
			String letra = String.valueOf(pregunta.getPalabraDiccionario().toUpperCase().charAt(i));
			if (!comprobarRepetidos(numElegidos, i)) {
				vectorRelleno[i].setText(letra);
				vectorRelleno[i].setEditable(false);
				vectorRelleno[i].setBackground(Color.WHITE);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
				vectorRelleno[i].setBorder(border);

			}

			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				vectorRelleno[i].setBorder(border);
				vectorRelleno[i].setText("");

			}

			panelLetras.add(vectorRelleno[i]);
		}
		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				boolean casillasRellenadas = true;
				if (btnCHECK.getText() == "NEXT") {
					if (partida.isPartidaTerminada()) {
						ventanaFin fin = new ventanaFin(partida);
						fin.setVisible(true);
						PreguntaDiccionario.this.dispose();
					} else {
						try {
							Ruleta ruleta = new Ruleta(partida);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						PreguntaDiccionario.this.dispose();
					}
				} else {

					for (i = 0; i < longitud && casillasRellenadas; i++) {
						if (vectorRelleno[i].getText().equals("")) {
							casillasRellenadas = false;

						}

					}
					if (casillasRellenadas) {

						if (pregunta.comprobarRespuesta(jtextFieldArrayToCharArray(vectorRelleno))) {
							lblMensaje.setText("CORRECTO");
							lblMensaje.setBounds(285, 100, 200, 100);
							// lblMensaje.setBounds(500, y, width, height);
							lblMensaje.setForeground(Color.GREEN);
							btnCHECK.setText("NEXT");
							btnCHECK.setForeground(Color.WHITE);
							btnCHECK.setBackground(Color.GREEN);
							partida.getJugadores().get(partida.getPosActual()).sumarPunto();
							partida.almacenarRonda(pregunta.getId_Pregunta(), 1);
						} else {
							lblMensaje.setText("INCORRECTO");
							lblMensaje.setBounds(285, 100, 400, 200);
							JLabel respuestaCorrecta = new JLabel();
							respuestaCorrecta.setText("Respuesta correcta es: " + pregunta.getPalabraDiccionario());
							respuestaCorrecta.setBounds(285, 190, 250, 200);

							background.add(respuestaCorrecta);
							btnCHECK.setText("NEXT");
							lblMensaje.setForeground(Color.RED);
							btnCHECK.setBackground(Color.RED);
							btnCHECK.setForeground(Color.WHITE);
							partida.almacenarRonda(pregunta.getId_Pregunta(), 0);
						}

					} else {
						JOptionPane.showMessageDialog(null, "No has rellenado los campos", "Alerta",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}

		});

		if (partida.getJugadores().get(partida.getPosActual()) instanceof CPU) {
			lblMensaje.setText("ERROR");
			btnCHECK.setText("NEXT");
			btnCHECK.setForeground(Color.WHITE);
			btnCHECK.setBackground(Color.BLUE);
			partida.almacenarRonda(pregunta.getId_Pregunta(), 0);
			for (int i = 0; i < vectorRelleno.length; i++) {
				vectorRelleno[i].setEditable(false);
				vectorRelleno[i].setBackground(Color.WHITE);
			}
		}

	}

	public static int[] generarNumerosAleatorios(int longitud) {

		int numerosrandom = (int) (longitud / 3);
		int[] numerosElegidos = new int[numerosrandom];

		// inicializa el array para que se puedan introducir 0
		for (int i = 0; i < numerosElegidos.length; i++) {
			numerosElegidos[i] = longitud + 1; // ponemos un numero que no exista en el array
		}

		// rellena el array
		for (int i = 0; i < numerosrandom; i++) {
			int numeroRandom;
			do {
				numeroRandom = generarRandom(0, longitud - 1);
			} while (comprobarRepetidos(numerosElegidos, numeroRandom));
			numerosElegidos[i] = numeroRandom;

		}

		return numerosElegidos;
	}

	// genera numeros aleatorios

	public static int generarRandom(int min, int max) {
		Random random = new Random();
		if (min >= max) {
			throw new IllegalArgumentException("Max debe ser mas grande que Min");
		}

		return random.nextInt((max - min) + 1) + min;
	}

	// comprueba que el numero recibido no este en el array recibido
	public static boolean comprobarRepetidos(int[] arrayNumeros, int numero) {
		for (int i = 0; i < arrayNumeros.length; i++) {
			if (numero == arrayNumeros[i]) {
				return true;
			}
		}
		return false;
	}

	public char[] jtextFieldArrayToCharArray(JTextField[] jtextArray) {
		char[] charArray = new char[jtextArray.length];
		for (int i = 0; i < jtextArray.length; i++) {
			charArray[i] = jtextArray[i].getText().charAt(0);
		}

		return charArray;

	}
}