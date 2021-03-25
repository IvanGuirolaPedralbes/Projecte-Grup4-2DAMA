package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

public class PreguntaMates extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntaMates frame = new PreguntaMates();
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
	public PreguntaMates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		   JLabel background;
	        ImageIcon img = new ImageIcon("resources/FondoPreguntaMatematicas1.jpg");
	        background = new JLabel("", img, JLabel.CENTER);
	        background.setFont(new Font("Tahoma", Font.BOLD, 14));
	        background.setBounds(0, 0, 1000, 600);
	        contentPane.add(background);
	        
	        JLabel lblCalculadora = new JLabel("Calculadora");
	        ImageIcon img2 = new ImageIcon("resources/Calculadora2.jpg");
	        lblCalculadora= new JLabel ("",img2,JLabel.CENTER);
	        lblCalculadora.setBounds(50, 0, 550, 550);
	        background.add(lblCalculadora);
	        
	        JButton btnCHECK = new JButton("CHECK");
	        btnCHECK.setBounds(725, 406, 115, 46);
	        background.add(btnCHECK);
	        
	        JLabel lblPreguntaMatematica = new JLabel("Introducir Pregunta Matematica");
	        lblCalculadora.add(lblPreguntaMatematica);
	        lblPreguntaMatematica.setHorizontalAlignment(SwingConstants.CENTER);
	        lblPreguntaMatematica.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblPreguntaMatematica.setBounds(100, 40, 268, 44);
	        
	        JLabel lblRespuestaMatematica = new JLabel("Introducir Respuesta Matematica");
	        lblRespuestaMatematica.setOpaque(true);
	        
	        lblCalculadora.add(lblRespuestaMatematica);
	        lblRespuestaMatematica.setHorizontalAlignment(SwingConstants.CENTER);
	        lblRespuestaMatematica.setFont(new Font("Tahoma", Font.BOLD, 14));
	        lblRespuestaMatematica.setBounds(100, 80, 268, 44);
	        lblRespuestaMatematica.setBackground(Color.decode("#c1d797"));// este es mismo color que el fondo de calculadora, sino queda blanco
	        //Respuesta CORRECTA
	       // lblRespuestaMatematica.setBackground(Color.GREEN);
	        //Respuesta INCORRECTA
	        //lblRespuestaMatematica.setBackground(Color.RED);
	        JButton btnNEXT = new JButton("NEXT");
			btnNEXT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PreguntaDiccionario pD= new PreguntaDiccionario();
					pD.setVisible(true);
					PreguntaMates.this.dispose();
				}
			});
			btnNEXT.setForeground(Color.WHITE);
			btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNEXT.setBackground(Color.BLUE);
			btnNEXT.setBounds(725, 306, 115, 46);
			background.add(btnNEXT);
	        
	        
	        
	        
	        
	        
	        
	}
}
