package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MultiplesJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJugador1;
	private JTextField textFieldJugador2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplesJugadores frame = new MultiplesJugadores();
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
	public MultiplesJugadores() {
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
		
		JButton btnJUGADOR2 = new JButton("JUGADOR 2");
		btnJUGADOR2.setBounds(62, 173, 128, 48);
		contentPane.add(btnJUGADOR2);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(263, 86, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		
		textFieldJugador2 = new JTextField();
		textFieldJugador2.setBounds(263, 174, 253, 47);
		contentPane.add(textFieldJugador2);
		textFieldJugador2.setColumns(10);
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreguntaIngles pregIngles= new PreguntaIngles();
				pregIngles.setVisible(true);
				MultiplesJugadores.this.dispose();
				
				
			}
		});
		btnJugar.setBounds(608, 117, 157, 68);
		contentPane.add(btnJugar);
		
		JButton btna�adir = new JButton("+");
		btna�adir.setBackground(Color.GREEN);
		btna�adir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btna�adir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btna�adir.setBounds(366, 260, 70, 47);
		contentPane.add(btna�adir);
		JLabel background;
        ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
		
	}
}
