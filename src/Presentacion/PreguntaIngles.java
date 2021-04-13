package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.PreguntaInglesLogica;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PreguntaIngles extends JFrame {

	private JPanel contentPane;
	PreguntaInglesLogica pregunta;
	String respuesta;


	public PreguntaIngles() {
		pregunta = new PreguntaInglesLogica();
		ArrayList<String> respuestas = new ArrayList<String>(4);
		respuestas = pregunta.respuestasMezcladas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlabelPregunta = new JLabel(pregunta.getPregunta());
		jlabelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelPregunta.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		jlabelPregunta.setBounds(0, 24, 974, 38);
		contentPane.add(jlabelPregunta);
		
		
        
        JButton btnA = new JButton(respuestas.get(0));
        btnA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnA.getText();
        		btnA.setSelected(true);
        	
        	}
        });
        
        btnA.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnA.setBounds(85, 127, 280, 47);
        contentPane.add(btnA);
        
        JButton btnB = new JButton(respuestas.get(1));
        btnB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnB.getText();
        		btnB.setSelected(true);
        	}
        });
        btnB.setBackground(Color.LIGHT_GRAY);
        btnB.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnB.setBounds(476, 127, 280, 47);
        contentPane.add(btnB);
        
        JButton btnC = new JButton(respuestas.get(2));
        btnC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnC.getText();
        		btnC.setSelected(true);
        	}
        });
        btnC.setBackground(Color.LIGHT_GRAY);
        btnC.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnC.setBounds(85, 230,280, 47);
        contentPane.add(btnC);
        
        JButton btnD = new JButton(respuestas.get(3));
        btnD.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnD.getText();
        		btnD.setSelected(true);
        	}
        });
        btnD.setBackground(Color.LIGHT_GRAY);
        btnD.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnD.setBounds(476, 230, 280, 47);
        contentPane.add(btnD);
        ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        JButton btnCHECK = new JButton("CHECK");
		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(pregunta.comprobarRespuesta(respuesta)) {
				jlabelPregunta.setText("CORRECTO");
			}
			else {
				jlabelPregunta.setText("ERROR");
			}
			btnCHECK.setText("NEXT");
			
			repintarBotones(btnA,btnB,btnC,btnD);
			}
			
		});
		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(375, 381, 99, 38);
		contentPane.add(btnCHECK);
       // ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        
        
	}
	
	public void repintarBotones(JButton btnA, JButton btnB, JButton btnC, JButton btnD) {
		JButton Correcto = null;
		if(pregunta.comprobarRespuesta(btnA.getText())) {
			Correcto = btnA;
			btnA.setBackground(Color.GREEN);
		}
		else if(pregunta.comprobarRespuesta(btnB.getText())){
			Correcto = btnB;
			btnB.setBackground(Color.GREEN);
		}
		else if(pregunta.comprobarRespuesta(btnC.getText())){
			Correcto = btnC;
			btnC.setBackground(Color.GREEN);
		}
		else if(pregunta.comprobarRespuesta(btnD.getText())){
			Correcto = btnD;
			btnD.setBackground(Color.GREEN);
		}
		
		if(!Correcto.equals(btnA)) {
			btnA.setBackground(Color.RED);
		}
		if(!Correcto.equals(btnB)) {
			btnB.setBackground(Color.RED);
		}
		if(!Correcto.equals(btnC)) {
			btnC.setBackground(Color.RED);
		}
		if(!Correcto.equals(btnD)) {
			btnD.setBackground(Color.RED);
		}
		
		
	}
	
	
}
