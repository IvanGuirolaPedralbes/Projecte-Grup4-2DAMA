package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Logica.Partida;
import Logica.PreguntaDiccionarioLogica;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PreguntaDiccionario extends JFrame {

	private JPanel contentPane;
	private PreguntaDiccionarioLogica pregunta;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public PreguntaDiccionario(Partida partida) throws InterruptedException {
		pregunta = new PreguntaDiccionarioLogica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 600);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel background;
		ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
		contentPane.setLayout(null);
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(492, 10, 0, 0);
		contentPane.add(background);
		JButton btnCHECK = new JButton("CHECK");

		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(248, 369, 99, 38);
		// background.add(btnCHECK);
		contentPane.add(btnCHECK);

		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Ruleta ruleta = new Ruleta(partida);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PreguntaDiccionario.this.dispose();
			}
		});
		btnNEXT.setForeground(Color.WHITE);
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNEXT.setBackground(Color.BLUE);
		btnNEXT.setBounds(433, 369, 99, 38);
		contentPane.add(btnNEXT);


		int longitud = pregunta.getPalabraDiccionario().length();

		JTextField vectorRelleno[] = new JTextField[longitud];

		int posicionX = 70;
		int[] numElegidos = generarNumerosAleatorios(longitud);
		for(int i = 0; i<numElegidos.length; i++) {
			System.out.println(numElegidos[i]);
		}
		System.out.println("ARRAYARRIBA");
		for (int i = 0; i < longitud; i++) {
			vectorRelleno[i] = new JTextField();

			posicionX += 40;
			vectorRelleno[i].setColumns(10);
			vectorRelleno[i].setBounds(posicionX, 207, 18, 20);
			setFont(new Font("Tahoma", Font.BOLD, 15));
			vectorRelleno[i].setHorizontalAlignment(SwingConstants.CENTER);
			String letra = String.valueOf(pregunta.getPalabraDiccionario().toUpperCase().charAt(i));
			System.out.println(i);
			if (!comprobarRepetidos(numElegidos, i)) {
				System.out.println("no");
				vectorRelleno[i].setText(letra);
				vectorRelleno[i].setEditable(false);
				vectorRelleno[i].setBackground(Color.WHITE);

			}

			else {
				System.out.println("si");
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				vectorRelleno[i].setBorder(border);
				vectorRelleno[i].setText("");

			}

			contentPane.add(vectorRelleno[i]);
		}

		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				boolean casillaRellenada = true;

				for (i = 0; i < longitud && casillaRellenada; i++) {
					if (vectorRelleno[i].getText().equals("")) {
						casillaRellenada = false;

					}
	        			
				}

				if (casillaRellenada) {
					System.out.println("Perfecto!!");

				} else {
					JOptionPane.showMessageDialog(null, "No has rellenado los campos", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("Falta casilla");
				}

				for (i = 0; i < longitud; i += 3) {
					char letraDiccionario = pregunta.getPalabraDiccionario().charAt(i);
					try {
						char letraIntroducida = vectorRelleno[i].getText().charAt(0);

					} catch (Exception e1) {
						System.out.println("Falta por rellenar!");
					}
					vectorRelleno[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (letraDiccionario == letraDiccionario) {
								System.out.println("Es lo mismo " + letraDiccionario);
							}
						}

					});

				}
			}

		});

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
				numeroRandom = generarRandom(0, longitud-1);
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
}
