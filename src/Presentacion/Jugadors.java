package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.JugadoresBD;
import Logica.Jugador;
import Logica.Partida;
import Logica.StyledButtonUI;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Jugadors extends JFrame {
	private JPanel contentPane;
	StartSlide ventanaInicio;
	Jugador jugador2;

	public Jugadors(Jugador jugador) {
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

		JButton btnVeureJugadors = new JButton("Lista Jugadores");
		btnVeureJugadors.setForeground(Color.BLACK);
		btnVeureJugadors.setBackground(Color.WHITE);
		btnVeureJugadors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaJugadores listaJugadores = new listaJugadores();
				listaJugadores.setVisible(true);
				Jugadors.this.dispose();
				
			}
		});
		btnVeureJugadors.setBounds(340, 73, 278, 102);
		btnVeureJugadors.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVeureJugadors.setUI(new StyledButtonUI());
		getContentPane().add(btnVeureJugadors);

		JButton btnAfegirJugador = new JButton("Añadir jugador");
		btnAfegirJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAfegirJugador.setBounds(340, 219, 278, 102);
		btnAfegirJugador.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAfegirJugador.setUI(new StyledButtonUI());
		getContentPane().add(btnAfegirJugador);
		btnAfegirJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirJugador anadirJugador = new anadirJugador();
				anadirJugador.setVisible(true);
				Jugadors.this.dispose();
			}
		});
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		btnEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarJugador eliminarJugador = new eliminarJugador();
				eliminarJugador.setVisible(true);
				Jugadors.this.dispose();
			}
		});
		btnEliminarJugador.setBounds(340, 372, 278, 102);
		btnEliminarJugador.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminarJugador.setUI(new StyledButtonUI());
		getContentPane().add(btnEliminarJugador);

		JLabel lblAtras = new JLabel();
		lblAtras.setIcon(new ImageIcon(Jugadors.class.getResource("/pruebas/atras.png")));
		lblAtras.setBounds(10, 0, 80, 80);
		lblAtras.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	new StartSlide();
				Jugadors.this.dispose();
//            	System.out.println("########### BENVINGUT AL CATÀLEG ###########");
//        		System.out.println("########### DISPOSITIUS DISPONIBLES ###########");
//        		ArrayList<Jugador> listaJugadores;
//        		try {
//        			listaJugadores = JugadoresBD.getJugadores();
//        		} catch (SQLException e1) {
//        			// TODO Auto-generated catch block
//        			e1.printStackTrace();
//        		}
////        		Iterator<String> iter = jugadores.keySet().iterator();
////
////        		while (iter.hasNext()) {
////        			String model = iter.next().toString();
////        			System.out.println("| MODEL: " + model);
////        		}
            }

        });
		
		contentPane.add(lblAtras);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(Jugadors.class.getResource("/pruebas/abstract-black-and-red-modern-material-background-metallic-technology-wallpaper-abstract-widescreen-background-vector.png")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);

	}
}
