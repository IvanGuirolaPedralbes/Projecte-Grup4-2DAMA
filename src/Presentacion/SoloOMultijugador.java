package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.StyledButtonUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SoloOMultijugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoloOMultijugador frame = new SoloOMultijugador();
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
	public SoloOMultijugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonSolo = new JButton("SOLO");
		buttonSolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoloOMultijugador.this.dispose();
			}
		});
		buttonSolo.setFont(new Font("Tahoma", Font.BOLD, 22));
		buttonSolo.setBounds(414, 191, 152, 37);
		buttonSolo.setUI(new StyledButtonUI());
		contentPane.add(buttonSolo);
		
		JButton buttonMultiplayer = new JButton("Multijugador");
		buttonMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultiplesJugadores multi =new MultiplesJugadores();
				multi.setVisible(true);
				SoloOMultijugador.this.dispose();
				
			}
		});
		buttonMultiplayer.setUI(new StyledButtonUI());
		buttonMultiplayer.setFont(new Font("Tahoma", Font.BOLD, 22));
		buttonMultiplayer.setBounds(414, 259, 174, 37);
		contentPane.add(buttonMultiplayer);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/jordihurtado.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
	}
	
	
}
