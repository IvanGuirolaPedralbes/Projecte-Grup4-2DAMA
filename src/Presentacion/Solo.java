package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logica.Humano;
import Logica.Jugador;
import Logica.Partida;

public class Solo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJugador1;
	public ArrayList<Jugador> jugadores = new ArrayList<Jugador>();


	/**
	 * Create the frame.
	 */
	public Solo(Partida partida) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnJUGADOR1 = new JButton("JUGADOR 1");
		btnJUGADOR1.setBounds(341, 69, 128, 48);
		contentPane.add(btnJUGADOR1);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(285, 152, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jugadores.add(new Humano(textFieldJugador1.getText().substring(0, 1).toUpperCase()
						+ textFieldJugador1.getText().substring(1).toLowerCase()));
				
				partida.setCantidadJugadores(jugadores.size());
				partida.setJugadores(jugadores);
				partida.insertarJugadores();
				try {
					Ruleta ruleta = new Ruleta(partida);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Solo.this.dispose();
				
				
			}
		});
		btnJugar.setBounds(332, 236, 157, 68);
		contentPane.add(btnJugar);
	
		JLabel background;
        ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
		
	}
}
