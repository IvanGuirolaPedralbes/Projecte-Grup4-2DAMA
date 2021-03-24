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

public class PreguntaIngles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

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
		jlabelPregunta.setBounds(66, 23, 282, 14);
		contentPane.add(jlabelPregunta);
		
		JLabel lblopcionB = new JLabel("B-");
		lblopcionB.setHorizontalAlignment(SwingConstants.CENTER);
		lblopcionB.setBounds(66, 96, 31, 27);
		contentPane.add(lblopcionB);
		
		JLabel lblopcionA = new JLabel("A-");
		lblopcionA.setHorizontalAlignment(SwingConstants.CENTER);
		lblopcionA.setBounds(66, 61, 31, 27);
		contentPane.add(lblopcionA);
		
		JLabel lblopcionC = new JLabel("C-");
		lblopcionC.setHorizontalAlignment(SwingConstants.CENTER);
		lblopcionC.setBounds(66, 135, 31, 27);
		contentPane.add(lblopcionC);
		
		JLabel lblopcionD = new JLabel("D-");
		lblopcionD.setHorizontalAlignment(SwingConstants.CENTER);
		lblopcionD.setBounds(66, 173, 31, 27);
		contentPane.add(lblopcionD);
		
		JLabel lblRespuestaA = new JLabel("opcionRespuestaA");
		lblRespuestaA.setBounds(156, 61, 193, 25);
		contentPane.add(lblRespuestaA);
		
		JLabel lblRespuestaB = new JLabel("opcionRespuestaB");
		lblRespuestaB.setBounds(155, 102, 193, 25);
		contentPane.add(lblRespuestaB);
		
		JLabel lblRespuestaC = new JLabel("opcionRespuestaC");
		lblRespuestaC.setBounds(156, 136, 193, 25);
		contentPane.add(lblRespuestaC);
		
		JLabel lblRespuestaD = new JLabel("opcionRespuestaD");
		lblRespuestaD.setBounds(155, 174, 193, 25);
		contentPane.add(lblRespuestaD);
		
		JButton btnCHECK = new JButton("CHECK");
		btnCHECK.setBounds(85, 227, 89, 23);
		contentPane.add(btnCHECK);
		
		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.setBounds(206, 227, 89, 23);
		contentPane.add(btnNEXT);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
	}
}
