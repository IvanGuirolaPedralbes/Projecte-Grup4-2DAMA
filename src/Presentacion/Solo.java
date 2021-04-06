package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Solo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJugador1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solo frame = new Solo();
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
	public Solo(Partida partida) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJUGADOR1 = new JButton("JUGADOR 1");
		btnJUGADOR1.setBounds(62, 85, 128, 48);
		contentPane.add(btnJUGADOR1);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(263, 86, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreguntaIngles pregIngles= new PreguntaIngles();
				pregIngles.setVisible(true);
				Solo.this.dispose();
				
				
			}
		});
		btnJugar.setBounds(600, 75, 157, 68);
		contentPane.add(btnJugar);
	
		JLabel background;
        ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
		
	}
}
