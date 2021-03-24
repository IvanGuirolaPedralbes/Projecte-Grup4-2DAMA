package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class PreguntaIngles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PreguntaIngles frame = new PreguntaIngles();
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
	public PreguntaIngles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlabelPregunta = new JLabel("Pregunta  ir a buscar a base datos");
		jlabelPregunta.setBounds(93, 23, 649, 38);
		contentPane.add(jlabelPregunta);
		
		JLabel lblRespuestaA = new JLabel("opcionRespuestaA");
		lblRespuestaA.setOpaque(true);
		lblRespuestaA.setBackground(Color.WHITE);
		lblRespuestaA.setBounds(303, 97, 338, 25);
		contentPane.add(lblRespuestaA);
		
		JLabel lblRespuestaB = new JLabel("opcionRespuestaB");
		lblRespuestaB.setBackground(Color.WHITE);
		lblRespuestaB.setOpaque(true);
		lblRespuestaB.setBounds(303, 151, 329, 25);
		contentPane.add(lblRespuestaB);
		
		JLabel lblRespuestaC = new JLabel("opcionRespuestaC");
		lblRespuestaC.setBackground(Color.WHITE);
		lblRespuestaC.setOpaque(true);
		lblRespuestaC.setBounds(303, 209, 338, 25);
		contentPane.add(lblRespuestaC);
		
		JLabel lblRespuestaD = new JLabel("opcionRespuestaD");
		lblRespuestaD.setBackground(Color.WHITE);
		lblRespuestaD.setOpaque(true);
		lblRespuestaD.setBounds(303, 268, 338, 25);
		contentPane.add(lblRespuestaD);
		
		JButton btnCHECK = new JButton("CHECK");
		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(248, 369, 99, 38);
		contentPane.add(btnCHECK);
		
		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.setForeground(Color.WHITE);
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNEXT.setBackground(Color.BLUE);
		btnNEXT.setBounds(433, 369, 99, 38);
		contentPane.add(btnNEXT);
       // ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        
        JButton btnA = new JButton("A");
        btnA.setBackground(Color.LIGHT_GRAY);
        btnA.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnA.setBounds(133, 90, 52, 38);
        contentPane.add(btnA);
        
        JButton btnB = new JButton("B");
        btnB.setBackground(Color.LIGHT_GRAY);
        btnB.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnB.setBounds(133, 141, 52, 38);
        contentPane.add(btnB);
        
        JButton btnC = new JButton("C");
        btnC.setBackground(Color.LIGHT_GRAY);
        btnC.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnC.setBounds(133, 199, 52, 38);
        contentPane.add(btnC);
        
        JButton btnD = new JButton("D");
        btnD.setBackground(Color.LIGHT_GRAY);
        btnD.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnD.setBounds(133, 258, 52, 38);
        contentPane.add(btnD);
        
        JLabel background;
        ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
	}
}
