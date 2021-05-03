package Presentacion;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.StyledButtonUI;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Informes2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informes2 frame = new Informes2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Informes2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRankingJugadores = new JButton("Ranking de Jugadores");
		btnRankingJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("resources/RankingJugadoresTransversal.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
				
			}
		});
		btnRankingJugadores.setBounds(314, 147, 430, 84);
		btnRankingJugadores.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRankingJugadores.setUI(new StyledButtonUI());
		contentPane.add(btnRankingJugadores);
		
		JButton btnRankingAcertadas = new JButton("Ranking Preguntas Acertadas");
		btnRankingAcertadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("resources/RankingPreguntasAcertadas.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
		btnRankingAcertadas.setBounds(314, 287, 430, 84);
		btnRankingAcertadas.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRankingAcertadas.setUI(new StyledButtonUI());
		contentPane.add(btnRankingAcertadas);
		
		JButton btnRankingFalladas = new JButton("Ranking Preguntas Fallidas");
		btnRankingFalladas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("resources/RankingPreguntasFalladas.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
		btnRankingFalladas.setBounds(314, 415, 430, 84);
		btnRankingFalladas.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRankingFalladas.setUI(new StyledButtonUI());
	
		contentPane.add(btnRankingFalladas);
		
		JLabel lblNewLabel = new JLabel("INFORMES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(307, 11, 403, 69);
		contentPane.add(lblNewLabel);
	}
}
