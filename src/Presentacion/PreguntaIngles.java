package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.CPU;
import Logica.Partida;
import Logica.PreguntaInglesLogica;
import Logica.StyledButtonUI;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class PreguntaIngles extends JFrame {

	private JPanel contentPane;
	PreguntaInglesLogica pregunta;
	String respuesta = null;
	JToggleButton btnA;
	JToggleButton btnB;
	JToggleButton btnC;
	JToggleButton btnD;
	

	public PreguntaIngles(Partida partida) {
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
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		ButtonGroup grupo = new ButtonGroup();
		
		JLabel jlabelPregunta = new JLabel(pregunta.getPregunta());
		jlabelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelPregunta.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		jlabelPregunta.setBounds(0, 24, 974, 38);
		contentPane.add(jlabelPregunta);
		
		 JLabel lblAviso = new JLabel("");
		 lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
	     lblAviso.setBounds(328, 333, 181, 37);
	     contentPane.add(lblAviso);
	        
		
        
        btnA = new JToggleButton(respuestas.get(0));
        btnA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnA.getText();
        		repintarBotones(btnA);
        	
        	}
        });
        btnA.setBackground(Color.LIGHT_GRAY);
        btnA.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnA.setBounds(85, 127, 280, 47);
        btnA.setUI(new StyledButtonUI());
        contentPane.add(btnA);
        
        btnB = new JToggleButton(respuestas.get(1));
        btnB.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnB.getText();
        		repintarBotones(btnB);
        	}
        });
        btnB.setBackground(Color.LIGHT_GRAY);
        btnB.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnB.setBounds(476, 127, 280, 47);
        btnB.setUI(new StyledButtonUI());
        contentPane.add(btnB);
        
        btnC = new JToggleButton(respuestas.get(2));
        btnC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnC.getText();
        		repintarBotones(btnC);
        	}
        });
        btnC.setBackground(Color.LIGHT_GRAY);
        btnC.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnC.setBounds(85, 230,280, 47);
        btnC.setUI(new StyledButtonUI());
        contentPane.add(btnC);
        
        btnD = new JToggleButton(respuestas.get(3));
        btnD.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		respuesta = btnD.getText();
        		repintarBotones(btnD);
        	}
        });
        btnD.setBackground(Color.LIGHT_GRAY);
        btnD.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnD.setBounds(476, 230, 280, 47);
        btnD.setUI(new StyledButtonUI());
        contentPane.add(btnD);
        ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        JButton btnCHECK = new JButton("CHECK");
		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCHECK.getText().equals("NEXT")) {
					if(partida.isPartidaTerminada()) {
						ventanaFin fin = new ventanaFin();
						fin.setVisible(true);
						PreguntaIngles.this.dispose();
					}
					else {
						try {
							Ruleta ruleta = new Ruleta(partida);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						PreguntaIngles.this.dispose();
					}
				}
				else {
					if(respuesta == null) {
						lblAviso.setText("Escoge una respuesta!");
						jlabelPregunta.setFont(new Font("Bahnschrift", Font.BOLD, 17));
						
						lblAviso.setForeground(Color.RED);
					}
					else {
					
						if(pregunta.comprobarRespuesta(respuesta)) {
							jlabelPregunta.setText("CORRECTO");
							btnCHECK.setText("NEXT");
							repintarBotonesCheck(btnA,btnB,btnC,btnD);
							partida.getJugadores().get(partida.getPosActual()).sumarPunto();
							partida.almacenarRonda(pregunta.getId_Pregunta(), 1);
						}
						else {
							jlabelPregunta.setText("ERROR");
							btnCHECK.setText("NEXT");
							repintarBotonesCheck(btnA,btnB,btnC,btnD);
							partida.almacenarRonda(pregunta.getId_Pregunta(), 0);
							
						}
				
					}
				
				}
			}
		});
		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(375, 381, 99, 38);
		btnCHECK.setUI(new StyledButtonUI());
		contentPane.add(btnCHECK);
       // ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        grupo.add(btnA);
        grupo.add(btnB);
        grupo.add(btnC);
        grupo.add(btnD);
        
        
        if(partida.getJugadores().get(partida.getPosActual()) instanceof CPU) {
        		Random numeroRandom = new Random();
               int opt = numeroRandom.nextInt((4 - 1) + 1) + 1;
               switch(opt) {
	               case 1:
	            	   repintarBotones(btnA);
	            	   respuesta = btnA.getText();
	            	   break;
	               case 2:
	            	   repintarBotones(btnB);
	            	   respuesta = btnB.getText();
	            	   break;
	               case 3:
	            	   repintarBotones(btnC);
	            	   respuesta = btnC.getText();
	            	   break;
	               case 4:
	            	   repintarBotones(btnD);
	            	   respuesta = btnD.getText();
	            	   break;
               }

               if(pregunta.comprobarRespuesta(respuesta)) {
					jlabelPregunta.setText("CORRECTO");
					btnCHECK.setText("NEXT");
					repintarBotonesCheck(btnA,btnB,btnC,btnD);
					partida.getJugadores().get(partida.getPosActual()).sumarPunto();
					partida.almacenarRonda(pregunta.getId_Pregunta(), 1);
				}
				else {
					jlabelPregunta.setText("ERROR");
					btnCHECK.setText("NEXT");
					repintarBotonesCheck(btnA,btnB,btnC,btnD);
					partida.almacenarRonda(pregunta.getId_Pregunta(), 0);
					
				}
               
            
        }
        
       
	}
	
	public void repintarBotonesCheck(JToggleButton btnA, JToggleButton btnB, JToggleButton btnC, JToggleButton btnD) {
		JToggleButton Correcto = null;
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
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		
		
	}
	public void repintarBotones(JToggleButton pressedbtn) {
		
		pressedbtn.setBackground(Color.YELLOW);
		if(!pressedbtn.equals(btnA)) {
			btnA.setBackground(Color.LIGHT_GRAY);
		}
		if(!pressedbtn.equals(btnB)) {
			btnB.setBackground(Color.LIGHT_GRAY);
		}
		if(!pressedbtn.equals(btnC)) {
			btnC.setBackground(Color.LIGHT_GRAY);
		}
		if(!pressedbtn.equals(btnD)) {
			btnD.setBackground(Color.LIGHT_GRAY);
		}
		
		
	}
}
