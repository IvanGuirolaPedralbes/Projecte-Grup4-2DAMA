package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Datos.JugadoresBD;
import Datos.PartidaBD;
import Logica.Jugador;
import Logica.Partida;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Historico extends JFrame {

	private JPanel contentPane;
	StartSlide ventanaInicio;
	Jugador jugador2;
	private JTable table;

	public Historico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);

		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
        
		JLabel lblNewLabel = new JLabel("Selecciona la partida que desea mostrar");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel.setBounds(260, 56, 506, 35);
		contentPane.add(lblNewLabel);
		
		JLabel vectorRelleno[] = new JLabel[6];
		int posicionY = 177, posicionX = 260;
		for(int j=0; j<6;j++) {
		vectorRelleno[j] = new JLabel();
		vectorRelleno[j].setBounds(posicionX, posicionY, 500, 35);
		vectorRelleno[j].setVisible(false);
		contentPane.add(vectorRelleno[j]);
		posicionY += 37;
		}

		// Creamos el comboBox de partidas
		JComboBox comboPartidas = new JComboBox();
		comboPartidas.setBounds(310, 102, 326, 41);
		int partidesTotal = 0;
		try {
			partidesTotal = JugadoresBD.nPartidas();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (int i = 1; i < partidesTotal; i++) {
			comboPartidas.addItem("Partida " + i);
		}
		contentPane.add(comboPartidas);

		Boolean aux = true;
		// Dependiendo de que esté seleccionado en el comboBox mostramos una Partida u
		// otra.
		String itemSeleccionado1 = (String) comboPartidas.getSelectedItem();
		String[] datos = itemSeleccionado1.split(" ");
		int id_Partida = Integer.parseInt(datos[1]);
		System.out.println(id_Partida);
		
		comboPartidas.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String itemSeleccionado1 = (String) comboPartidas.getSelectedItem();
				String[] datos = itemSeleccionado1.split(" ");
				int id_Partida = Integer.parseInt(datos[1]);
				System.out.println(id_Partida);

				try {
					Map partidas = JugadoresBD.historicPartida(id_Partida);
//						int[] numElegidos = generarNumerosAleatorios(longitud)
					// vectorRelleno[i].setHorizontalAlignment(SwingConstants.CENTER);
					Iterator<String> iter = partidas.keySet().iterator();
					int i=0;
					while (iter.hasNext()) {
//						vectorRelleno[i] = new JLabel();
//						vectorRelleno[i].setBounds(posicionX, posicionY, 458, 35);
//						posicionY += 37;
						String model = iter.next().toString();
						vectorRelleno[i].setText(i+1 + ". NOM: " + model + " | PUNTS: " + partidas.get(model));
//						System.out.println(i+1 + ". NOM: " + model + " | PUNTS: " + partidas.get(model));
						vectorRelleno[i].setForeground(Color.WHITE);
						vectorRelleno[i].setFont(new Font("Tahoma", Font.BOLD, 30));
//						contentPane.add(vectorRelleno[i]);
						vectorRelleno[i].setVisible(true);
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// try {
//				JugadoresBD.historicPartida(id_Partida);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

//		JLabel lblNewLabel_1 = new JLabel("New label");
//		lblNewLabel_1.setForeground(Color.WHITE);
//		lblNewLabel_1.setBounds(260, 177, 458, 28);
//		contentPane.add(lblNewLabel_1);
//		String itemSeleccionado = (String) comboPartidas.getSelectedItem();
//		if(comboPartidas.)
//		ArrayList<Jugador> jugadores = partida.ordenarJugadoresPorPuntos();
//		JButton  = new JButton("New button");
//		btnNewButton.setBounds(68, 62, 89, 23);
//		contentPane.add(btnNewButton);

		JLabel lblAtras = new JLabel();
		lblAtras.setIcon(new ImageIcon(Jugadors.class.getResource("/pruebas/atras.png")));
		lblAtras.setBounds(10, 0, 80, 80);
		lblAtras.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	new StartSlide();
				Historico.this.dispose();
            }

        });
		
		contentPane.add(lblAtras);
        
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(Historico.class.getResource("/pruebas/podioFondo.jpg")));
		background.setBounds(0, 0, 1000, 600);
//		background.setSize(1000, 600);
		contentPane.add(background);

	}
}
