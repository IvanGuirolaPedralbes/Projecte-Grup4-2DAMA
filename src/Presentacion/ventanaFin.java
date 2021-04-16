package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;
import Logica.Partida;
import Logica.ShadowText;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;

public class ventanaFin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ventanaFin(Partida partida) {
		ArrayList<Jugador> jugadores = partida.ordenarJugadoresPorPuntos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTitulo = new JLabel("FELICIDADES " + jugadores.get(0).getUsername().toUpperCase() + "!!!" );
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblTitulo.setBounds(152, 11, 704, 106);
		contentPane.add(lblTitulo);
		
		JLabel logo_1 = new JLabel("");
		logo_1.setBounds(618, 223, 60, 85);
		logo_1.setIcon(new ImageIcon(ventanaFin.class.getResource("/pruebas/SaberyGanarLogo50.png")));
		contentPane.add(logo_1);
		
		JLabel logo_2 = new JLabel("");
		logo_2.setBounds(323, 201, 60, 85);
		logo_2.setIcon(new ImageIcon(ventanaFin.class.getResource("/pruebas/SaberyGanarLogo50.png")));
		contentPane.add(logo_2);
		
		
		JLabel logo = new JLabel("");
		logo.setLocation(470, 176);
		logo.setIcon(new ImageIcon(ventanaFin.class.getResource("/pruebas/SaberyGanarLogo50.png")));
		logo.setSize(60, 85);
		contentPane.add(logo);
		//mirar medida adecuada
		
		if(jugadores.size()>=2) {
		JLabel lblSegundo = new JLabel(jugadores.get(1).getUsername());
		lblSegundo.setForeground(Color.GRAY);
		lblSegundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblSegundo.setBounds(266, 384, 147, 43);
		contentPane.add(lblSegundo);
		}
		
		
		
		JLabel lblPrimero = new JLabel(jugadores.get(0).getUsername());
		lblPrimero.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
		lblPrimero.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimero.setForeground(Color.ORANGE);
		
		lblPrimero.setBounds(425, 359, 147, 29);
		contentPane.add(lblPrimero);
		if(jugadores.size()>=3) {
		JLabel lblTercero = new JLabel(jugadores.get(2).getUsername());
		lblTercero.setForeground(new Color(255, 99, 71));
		lblTercero.setHorizontalAlignment(SwingConstants.CENTER);
		lblTercero.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblTercero.setBounds(586, 413, 147, 29);
		contentPane.add(lblTercero);
		}
		
		if(jugadores.size()>=4) {
		JLabel lblCuarto = new JLabel(jugadores.get(3).getUsername());
		lblCuarto.setBounds(266, 486, 147, 29);
		lblCuarto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuarto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		contentPane.add(lblCuarto);
		}
		if(jugadores.size()>=5) {
		JLabel lblQuinto = new JLabel(jugadores.get(4).getUsername());
		lblQuinto.setBounds(425, 486, 147, 29);
		lblQuinto.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuinto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		contentPane.add(lblQuinto);
		}
		if(jugadores.size()>=6) {
		JLabel lblSexto = new JLabel(jugadores.get(5).getUsername());
		lblSexto.setBounds(598, 486, 147, 29);
		lblSexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		contentPane.add(lblSexto);
		}
		/*JLabel background;
		ImageIcon img = new ImageIcon("resources/prizebackground2.png");
		
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);*/
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(ventanaFin.class.getResource("/pruebas/prizebackground2.png")));
		background.setSize(1000, 600);
		contentPane.add(background);
		
		
		for(int i=0; i<jugadores.size();i++) {
			System.out.println((i+1) +". " + jugadores.get(i).getUsername()+ " : " + jugadores.get(i).getPuntuacion());
		}
	}
}
