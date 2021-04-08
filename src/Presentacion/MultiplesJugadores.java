package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.CPU;
import Logica.Humano;
import Logica.Jugador;
import Logica.Partida;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class MultiplesJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJugador1;
	private JTextField textFieldJugador2;
	private JTextField textFieldJugador3;
	private JTextField textFieldJugador4;
	private JTextField textFieldJugador5;
	private JTextField textFieldJugador6;
	private static int i = 1;
	public ArrayList<Jugador> jugadores = new ArrayList<Jugador>();


	/**
	 * Create the frame.
	 */
	public MultiplesJugadores(Partida partida) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnJugador1 = new JButton("Jugador");
		btnJugador1.setBounds(62, 85, 128, 48);
		contentPane.add(btnJugador1);

		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(263, 86, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);

		JComboBox comboJugador2 = new JComboBox();
		comboJugador2.setBounds(62, 155, 128, 48);
		comboJugador2.addItem("Jugador");
		comboJugador2.addItem("CPU");
		contentPane.add(comboJugador2);
		textFieldJugador2 = new JTextField();
		textFieldJugador2.setBounds(263, 155, 253, 47);
		contentPane.add(textFieldJugador2);
		textFieldJugador2.setColumns(10);
		textFieldJugador2.setText("Jugador 2");
		comboJugador2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String itemSeleccionado1 = (String) comboJugador2.getSelectedItem();
				if ("Jugador".equals(itemSeleccionado1)) {
					// Creamos una instancia de Humano donde recogeremos del inputtext el Username.
					textFieldJugador2.setText("Jugador 2");
					textFieldJugador2.setEditable(true);
				} else if ("CPU".equals(itemSeleccionado1)) {
					// Creamos una instancia de CPU donde recogeremos del inputtext .
					textFieldJugador2.setText("IA 2");
					textFieldJugador2.setEditable(false);

				}
			}
		});

		JComboBox comboJugador3 = new JComboBox();
		comboJugador3.setBounds(62, 225, 128, 48);
		comboJugador3.addItem("Jugador");
		comboJugador3.addItem("CPU");
		contentPane.add(comboJugador3);
		textFieldJugador3 = new JTextField();
		textFieldJugador3.setBounds(263, 225, 253, 47);
		contentPane.add(textFieldJugador3);
		textFieldJugador3.setColumns(10);
		textFieldJugador3.setText("Jugador 3");
		comboJugador3.setVisible(false);
		textFieldJugador3.setVisible(false);
		comboJugador3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String itemSeleccionado2 = (String) comboJugador3.getSelectedItem();
				if ("Jugador".equals(itemSeleccionado2)) {
					// Creamos una instancia de Humano donde recogeremos del inputtext el Username.
					textFieldJugador3.setText("Jugador 3");
					textFieldJugador3.setEditable(true);
				} else {
					// Creamos una instancia de CPU donde recogeremos del inputtext .
					textFieldJugador3.setText("IA 3");
					textFieldJugador3.setEditable(false);
				}
			}
		});

		JComboBox comboJugador4 = new JComboBox();
		comboJugador4.setBounds(62, 295, 128, 48);
		comboJugador4.addItem("Jugador");
		comboJugador4.addItem("CPU");
		contentPane.add(comboJugador4);
		textFieldJugador4 = new JTextField();
		textFieldJugador4.setBounds(263, 295, 253, 47);
		contentPane.add(textFieldJugador4);
		textFieldJugador4.setColumns(10);
		textFieldJugador4.setText("Jugador 4");
		comboJugador4.setVisible(false);
		textFieldJugador4.setVisible(false);
		comboJugador4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String itemSeleccionado = (String) comboJugador4.getSelectedItem();
				if ("Jugador".equals(itemSeleccionado)) {
					// Creamos una instancia de Humano donde recogeremos del inputtext el Username.
					textFieldJugador4.setText("Jugador 4");
					textFieldJugador4.setEditable(true);
				} else {
					// Creamos una instancia de CPU donde recogeremos del inputtext .
					textFieldJugador4.setText("IA 4");
					textFieldJugador4.setEditable(false);
				}
			}
		});

		JComboBox comboJugador5 = new JComboBox();
		comboJugador5.setBounds(62, 365, 128, 48);
		comboJugador5.addItem("Jugador");
		comboJugador5.addItem("CPU");
		contentPane.add(comboJugador5);
		textFieldJugador5 = new JTextField();
		textFieldJugador5.setBounds(263, 365, 253, 47);
		contentPane.add(textFieldJugador5);
		textFieldJugador5.setColumns(10);
		textFieldJugador5.setText("Jugador 5");
		comboJugador5.setVisible(false);
		textFieldJugador5.setVisible(false);
		comboJugador5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String itemSeleccionado = (String) comboJugador5.getSelectedItem();
				if ("Jugador".equals(itemSeleccionado)) {
					// Creamos una instancia de Humano donde recogeremos del inputtext el Username.
					textFieldJugador5.setText("Jugador 5");
					textFieldJugador5.setEditable(true);
				} else {
					// Creamos una instancia de CPU donde recogeremos del inputtext .
					textFieldJugador5.setText("IA 5");
					textFieldJugador5.setEditable(false);
				}
			}
		});

		JComboBox comboJugador6 = new JComboBox();
		comboJugador6.setBounds(62, 435, 128, 48);
		comboJugador6.addItem("Jugador");
		comboJugador6.addItem("CPU");
		contentPane.add(comboJugador6);
		textFieldJugador6 = new JTextField();
		textFieldJugador6.setBounds(263, 435, 253, 47);
		contentPane.add(textFieldJugador6);
		textFieldJugador6.setColumns(10);
		textFieldJugador6.setText("Jugador 6");
		comboJugador6.setVisible(false);
		textFieldJugador6.setVisible(false);
		comboJugador6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String itemSeleccionado = (String) comboJugador6.getSelectedItem();
				if ("Jugador".equals(itemSeleccionado)) {
					// Creamos una instancia de Humano donde recogeremos del inputtext el Username.
					textFieldJugador6.setText("Jugador 6");
					textFieldJugador6.setEditable(true);
				} else {
					// Creamos una instancia de CPU donde recogeremos del inputtext .
					textFieldJugador6.setText("IA 6");
					textFieldJugador6.setEditable(false);
				}
			}
		});

		JButton btnanadir = new JButton("+");
		btnanadir.setBackground(Color.BLUE);
		btnanadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnanadir.setBounds(608, 400, 70, 47);
		contentPane.add(btnanadir);
		btnanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 1) {
					comboJugador3.setVisible(true);
					textFieldJugador3.setVisible(true);
					i++;
				} else if (i == 2) {
					comboJugador4.setVisible(true);
					textFieldJugador4.setVisible(true);
					i++;
				} else if (i == 3) {
					comboJugador5.setVisible(true);
					textFieldJugador5.setVisible(true);
					i++;
				} else if (i == 4) {
					comboJugador6.setVisible(true);
					textFieldJugador6.setVisible(true);
					i++;
				}

			}

		});

		JButton btnborrar = new JButton("-");
		btnborrar.setBackground(Color.BLUE);
		btnborrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnborrar.setBounds(608, 450, 70, 47);
		contentPane.add(btnborrar);
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 2) {
					comboJugador3.setVisible(false);
					textFieldJugador3.setVisible(false);
					i--;
				} else if (i == 3) {
					comboJugador4.setVisible(false);
					textFieldJugador4.setVisible(false);
					i--;
				} else if (i == 4) {
					comboJugador5.setVisible(false);
					textFieldJugador5.setVisible(false);
					i--;
				} else if (i == 5) {
					comboJugador6.setVisible(false);
					textFieldJugador6.setVisible(false);
					i--;
				}

			}

		});

		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(608, 117, 157, 68);
		btnJugar.setBackground(Color.WHITE);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugadores.add(new Humano(textFieldJugador1.getText()));
				if (comboJugador2.isVisible()) {
					if (comboJugador2.getSelectedItem().toString().equals("CPU")) {
						jugadores.add(new CPU(textFieldJugador2.getText()));
					} else {
						jugadores.add(new Humano(textFieldJugador2.getText()));
					}

				}
				if (comboJugador3.isVisible()) {
					if (comboJugador3.getSelectedItem().toString().equals("CPU")) {
						jugadores.add(new CPU(textFieldJugador3.getText()));
					} else {
						jugadores.add(new Humano(textFieldJugador3.getText()));
					}

				}
				if (comboJugador4.isVisible()) {
					if (comboJugador4.getSelectedItem().toString().equals("CPU")) {
						jugadores.add(new CPU(textFieldJugador4.getText()));
					} else {
						jugadores.add(new Humano(textFieldJugador4.getText()));
					}

				}
				if (comboJugador5.isVisible()) {
					if (comboJugador5.getSelectedItem().toString().equals("CPU")) {
						jugadores.add(new CPU(textFieldJugador5.getText()));
					} else {
						jugadores.add(new Humano(textFieldJugador5.getText()));
					}

				}
				if (comboJugador6.isVisible()) {
					if (comboJugador6.getSelectedItem().toString().equals("CPU")) {
						jugadores.add(new CPU(textFieldJugador6.getText()));
					} else {
						jugadores.add(new Humano(textFieldJugador6.getText()));
					}

				}
				partida.setCantidadJugadores(jugadores.size());
				partida.setJugadores(jugadores);
				
				//preguntar quien comienza primero si empieza una cpu, como se mueve la ruleta
				
				try {
	            	Ruleta ruleta = new Ruleta(partida);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            MultiplesJugadores.this.dispose();
				
				
			}
		});
		btnJugar.setBounds(608, 117, 157, 68);
		btnJugar.setBackground(Color.WHITE);
		contentPane.add(btnJugar);

		JLabel background;
		ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);

	}
}
