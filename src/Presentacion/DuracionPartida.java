package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logica.Partida;
import Logica.StyledButtonUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DuracionPartida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	// partida 3:rapida 5:curta 10:mitjana 20:llarga
	/**
	 * Create the frame.
	 */
	public DuracionPartida() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnRapida = new JButton("PARTIDA RAPIDA");
		btnRapida.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRapida.setUI(new StyledButtonUI());
		btnRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partida = new Partida(3);
				SoloOMultijugador soloOMulti = new SoloOMultijugador(partida);
				soloOMulti.setVisible(true);
				DuracionPartida.this.dispose();
				//llamada a partida asignando rapida
			
			}
		});
		btnRapida.setBounds(71, 91, 275, 70);
		contentPane.add(btnRapida);
		
		JButton btnCorta = new JButton("PARTIDA CORTA");
		btnCorta.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCorta.setUI(new StyledButtonUI());
		btnCorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partida = new Partida(5);
				SoloOMultijugador soloOMulti = new SoloOMultijugador(partida);
				soloOMulti.setVisible(true);
				DuracionPartida.this.dispose();
				//llamada a partida asignando corta
			
			}
			
		});
		btnCorta.setBounds(71, 195, 275, 70);
		contentPane.add(btnCorta);
		
		JButton btnMedia = new JButton("PARTIDA MEDIA");
		btnMedia.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMedia.setUI(new StyledButtonUI());
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamada partida asignando media
				Partida partida = new Partida(10);
				SoloOMultijugador soloOMulti = new SoloOMultijugador(partida);
				soloOMulti.setVisible(true);
				DuracionPartida.this.dispose();
				
			}
		});
		btnMedia.setBounds(71, 300,275, 70);
		contentPane.add(btnMedia);
		
		JButton btnLarga = new JButton("PARTIDA LARGA");
		btnLarga.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLarga.setUI(new StyledButtonUI());
		btnLarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamada a partida asignando larga
				Partida partida = new Partida(20);
			}
		});
		btnLarga.setBounds(71, 407, 275, 70);
		contentPane.add(btnLarga);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/jordihurtado.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
	}

}
