package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.CPU;
import Logica.Partida;
import Logica.PreguntaMatematicasLogica;
import Logica.StyledButtonUI;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

public class PreguntaMates extends JFrame {

	private JPanel contentPane;
	JLabel lblRespuestaUsuario;
	PreguntaMatematicasLogica pregunta;
	JButton btndelete;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public PreguntaMates(Partida partida) {
		pregunta = new PreguntaMatematicasLogica();
		//TODO FALTA CONTROLAR NUMEROS NEGATIVOS
		System.out.println(pregunta.getOperacion());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
			
		
		   
			
			JButton btnNext = new JButton("NEXT");
			btnNext.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(partida.isPartidaTerminada()) {
						ventanaFin fin = new ventanaFin();
						fin.setVisible(true);
						PreguntaMates.this.dispose();
					}
					else {
						try {
							Ruleta ruleta = new Ruleta(partida);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						PreguntaMates.this.dispose();
					};
				}
			});
			btnNext.setBounds(817, 275, 116, 59);
			btnNext.setUI(new StyledButtonUI());
			contentPane.add(btnNext);
			btnNext.setVisible(false);
			
			lblRespuestaUsuario = new JLabel("0");
			lblRespuestaUsuario.setFont(new Font("Power Clear", Font.BOLD, 25));
			lblRespuestaUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRespuestaUsuario.setBounds(317, 90, 353, 35);
			contentPane.add(lblRespuestaUsuario);
			
			JLabel lblPregunta = new JLabel(pregunta.getOperacion());
			lblPregunta.setFont(new Font("Power Clear", Font.BOLD, 32));
			lblPregunta.setBounds(317, 44, 364, 35);
			contentPane.add(lblPregunta);
	        
			
			
			JButton btn7 = new JButton("7");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(7);
				}
			});
			btn7.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn7.setBounds(317, 146, 86, 88);
			btn7.setUI(new StyledButtonUI());
			contentPane.add(btn7);
	        
			
			
			JButton btn8 = new JButton("8");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(8);
				}
			});
			btn8.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn8.setBounds(413, 146, 86, 88);
			btn8.setUI(new StyledButtonUI());
			contentPane.add(btn8);
			
			JButton btn9 = new JButton("9");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(9);
				}
			});
			btn9.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn9.setUI(new StyledButtonUI());
			btn9.setBounds(506, 146, 86, 88);
			contentPane.add(btn9);
			
			JButton btn4 = new JButton("4");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(4);
				}
			});
			btn4.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn4.setUI(new StyledButtonUI());
			btn4.setBounds(317, 240, 86, 88);
			contentPane.add(btn4);
			
			JButton btn5 = new JButton("5");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(5);
				}
			});
			btn5.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn5.setUI(new StyledButtonUI());
			btn5.setBounds(413, 240, 86, 88);
			contentPane.add(btn5);
			
			JButton btn6 = new JButton("6");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(6);
				}
			});
			btn6.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn6.setUI(new StyledButtonUI());
			btn6.setBounds(506, 240, 86, 88);
			contentPane.add(btn6);
	        
			
			
			JButton btn3 = new JButton("3");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(3);
				}
			});
			btn3.setFont(new Font("Tahoma", Font.PLAIN, 61));
			
			btn3.setBounds(317, 334, 86, 88);
			btn3.setUI(new StyledButtonUI());
			contentPane.add(btn3);
			
			JButton btn2 = new JButton("2");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(2);
				}
			});
			btn2.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn2.setUI(new StyledButtonUI());
			btn2.setBounds(413, 334, 86, 88);
			contentPane.add(btn2);
			
			JButton btn1 = new JButton("1");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(1);
				}
			});
			btn1.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn1.setUI(new StyledButtonUI());
			btn1.setBounds(506, 334, 86, 88);
			contentPane.add(btn1);
			
			JButton btn0 = new JButton("0");
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertNumber(0);
				}
			});
			btn0.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btn0.setUI(new StyledButtonUI());
			btn0.setBounds(317, 427, 86, 88);
			contentPane.add(btn0);
			
			JButton btncheck = new JButton("check");
			btncheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pregunta.getRespuestaCorrecta() == Integer.parseInt(lblRespuestaUsuario.getText())){
						//si acierta
						lblPregunta.setText("CORRECTO!!!");
						lblPregunta.setForeground(Color.GREEN);
						lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
						partida.getJugadores().get(partida.getPosActual()).sumarPunto();
						partida.almacenarRonda(pregunta.getId_Pregunta(), 1);
					}
					else {
						//si falla
						lblPregunta.setText("ERROR!!!");
						lblPregunta.setForeground(Color.RED);
						lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
						partida.almacenarRonda(pregunta.getId_Pregunta(), 0);
					}
					lblRespuestaUsuario.setText(pregunta.getOperacion() +" = " + pregunta.getRespuestaCorrecta());
					lblRespuestaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
					btn0.setEnabled(false);
					btn1.setEnabled(false);
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn4.setEnabled(false);
					btn5.setEnabled(false);
					btn6.setEnabled(false);
					btn7.setEnabled(false);
					btn8.setEnabled(false);
					btn9.setEnabled(false);
					btncheck.setEnabled(false);
					btndelete.setEnabled(false);
					
					//boton next se hace visible a la derecha
					btnNext.setVisible(true);
				}
			});
			btncheck.setForeground(Color.GREEN);
			btncheck.setFont(new Font("Tahoma", Font.BOLD, 18));
			btncheck.setUI(new StyledButtonUI());
			btncheck.setBounds(506, 427, 86, 88);
			contentPane.add(btncheck);
			
			btndelete = new JButton("DEL");
			btndelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteNumber();
				}
			});
			btndelete.setForeground(Color.RED);
			btndelete.setFont(new Font("Tahoma", Font.BOLD, 27));
			btndelete.setUI(new StyledButtonUI());
			btndelete.setBounds(412, 427, 86, 88);
			contentPane.add(btndelete);
			
			JLabel background;
			
			JButton btnMenos = new JButton("-");
			btnMenos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					convertNegative();
				}
			});
			btnMenos.setFont(new Font("Tahoma", Font.PLAIN, 67));
			btnMenos.setBounds(600, 334, 86, 88);
			btnMenos.setUI(new StyledButtonUI());
			contentPane.add(btnMenos);
			
			JButton btnMas = new JButton("+");
			btnMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					convertPositive();
				}
			});
			btnMas.setFont(new Font("Tahoma", Font.PLAIN, 61));
			btnMas.setBounds(600, 427, 86, 88);
			btnMas.setUI(new StyledButtonUI());
			contentPane.add(btnMas);
			background = new JLabel("");
			background.setIcon(new ImageIcon("resources/Calculadora2.jpg"));
			background.setBounds(300, 0, 550, 550);
			contentPane.add(background);

			
			JLabel background2;
	        ImageIcon img = new ImageIcon("resources/FondoPreguntaMatematicas1.jpg");
	        background2 = new JLabel("", img, JLabel.CENTER);
	        background2.setBounds(0, 0, 1000, 600);
	        contentPane.add(background2);
	        
	        
	        if(partida.getJugadores().get(partida.getPosActual()) instanceof CPU) {
	        	//acierta automaticamente
				lblPregunta.setText("CORRECTO!!!");
				lblPregunta.setForeground(Color.GREEN);
				lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
				partida.getJugadores().get(partida.getPosActual()).sumarPunto();
				partida.almacenarRonda(pregunta.getId_Pregunta(), 1);
				lblRespuestaUsuario.setText(pregunta.getOperacion() +" = " + pregunta.getRespuestaCorrecta());
				lblRespuestaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				btn0.setEnabled(false);
				btn1.setEnabled(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				btncheck.setEnabled(false);
				btndelete.setEnabled(false);
				
				//boton next se hace visible a la derecha
				btnNext.setVisible(true);
	        }
      
	}
	
	public void insertNumber(int number) {
		String respuesta = lblRespuestaUsuario.getText();
		if (respuesta.equals("0")){
			lblRespuestaUsuario.setText(Integer.toString(number));
		}
		else {
			lblRespuestaUsuario.setText(respuesta + number);
		}
		
	}
	
	public void convertNegative() {
		//hacer que el numero se vuelva negativo
		int respuesta = Integer.parseInt(lblRespuestaUsuario.getText());
		if (respuesta >=0){
			respuesta*=-1;
			lblRespuestaUsuario.setText(Integer.toString(respuesta));
		}
		
		
	}
	
	
	public void convertPositive() {
		int respuesta = Integer.parseInt(lblRespuestaUsuario.getText());
		if (respuesta <0){
			respuesta = Math.abs(respuesta);
			lblRespuestaUsuario.setText(Integer.toString(respuesta));
		}
		
		
	}
	
	
	public void deleteNumber() {
		String respuesta = lblRespuestaUsuario.getText();
		lblRespuestaUsuario.setText(respuesta.substring(0, respuesta.length()-1));
	}
}
