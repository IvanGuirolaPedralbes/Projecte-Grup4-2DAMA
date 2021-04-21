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

import Logica.Jugador;
import Logica.Partida;
import Logica.StyledButtonUI;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		btnEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
            }

        });
		contentPane.add(lblAtras);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(Jugadors.class.getResource("/pruebas/abstract-black-and-red-modern-material-background-metallic-technology-wallpaper-abstract-widescreen-background-vector.png")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);

	}
}
