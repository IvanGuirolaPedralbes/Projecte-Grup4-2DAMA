package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class listaJugadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public listaJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(listaJugadores.class.getResource("/pruebas/saicle160200142.jpg")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);
		
		
	}

}
