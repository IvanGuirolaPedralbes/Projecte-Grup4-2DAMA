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
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class PreguntaDiccionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField,textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9
	,textField10,textField11,textField12,textField13,textField14,textField15,textField16,textField17,textField18,textField19,textField20;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntaDiccionario frame = new PreguntaDiccionario();
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
	public PreguntaDiccionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000,600);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/fondoDuracionPartida3.jpg");
        contentPane.setLayout(null);
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(492, 10, 0, 0);
        contentPane.add(background);
        JButton btnCHECK = new JButton("CHECK");
		btnCHECK.setForeground(Color.BLACK);
		btnCHECK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCHECK.setBackground(Color.YELLOW);
		btnCHECK.setBounds(248, 369, 99, 38);
		background.add(btnCHECK);
		
		//Palabra ejemplo ABOMINABLEMENTE (15) A_O_INA_B_LEM_T_ (tapar 15/3=5)
		//palabra.length la longitud sera la palabra
		char [] palabra= new char[14];
		
		
		
		
		
		
		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreguntaMates pM= new PreguntaMates();
				pM.setVisible(true);
				PreguntaDiccionario.this.dispose();
			}
		});
		btnNEXT.setForeground(Color.WHITE);
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNEXT.setBackground(Color.BLUE);
		btnNEXT.setBounds(433, 369, 99, 38);
		background.add(btnNEXT);
		
		String palabraDiccionario="abominablemente";
		int longitudPalabra= palabraDiccionario.length();
		JTextField vector[]= new JTextField[longitudPalabra];
		//char letra= palabraDiccionario.charAt(5);
		//System.out.println(letra);
		
		int posicionX=230;
		for (int i=0;i<longitudPalabra;i++) {
			vector[i]= new JTextField();
			posicionX+=30;
			vector[i].setColumns(10);
			vector[i].setBounds(posicionX, 207, 18, 20);
			//char letra= palabraDiccionario.charAt(i);
			String letra = String.valueOf(palabraDiccionario.charAt(i));
			vector[i].setText(letra);
			contentPane.add(vector[i]);
		}
		//FALTA EN LOGICA LIMITAR LOS CARACTER A 1, QUE SOLO PUEDA INTRODUCIR UN CHAR
//	
//		textField = new JTextField();
//		textField.setColumns(10);
//		textField.setBounds(230, 207, 18, 20);
//		contentPane.add(textField);
//		
//		
//		textField1 = new JTextField();
//		textField1.setColumns(10);
//		textField1.setBounds(260, 207, 18, 20);
//		contentPane.add(textField1);
//		
//		textField2 = new JTextField();
//		textField2.setColumns(10);
//		textField2.setBounds(290, 207, 18, 20);
//		contentPane.add(textField2);
//		
//		
//		textField3 = new JTextField();
//		textField3.setColumns(10);
//		textField3.setBounds(320, 207, 18, 20);
//		contentPane.add(textField3);
//		
//		textField4 = new JTextField();
//		textField4.setBounds(350, 207, 18, 20);
//		contentPane.add(textField4);
//		textField4.setColumns(10);
//		
//		textField5 = new JTextField();
//		textField5.setColumns(10);
//		textField5.setBounds(380, 207, 18, 20);
//		contentPane.add(textField5);
//		
//		
//		textField6 = new JTextField();
//		textField6.setColumns(10);
//		textField6.setBounds(410, 207, 18, 20);
//		contentPane.add(textField6);
//		
//		textField7 = new JTextField();
//		textField7.setColumns(10);
//		textField7.setBounds(440, 207, 18, 20);
//		contentPane.add(textField7);
//		
//		textField8 = new JTextField();
//		textField8.setColumns(10);
//		textField8.setBounds(470, 207, 18, 20);
//		contentPane.add(textField8);
//		
//		
//		textField9 = new JTextField();
//		textField9.setColumns(10);
//		textField9.setBounds(500, 207, 18, 20);
//		contentPane.add(textField9);
//		
//		textField10 = new JTextField();
//		textField10.setColumns(10);
//		textField10.setBounds(530, 207, 18, 20);
//		contentPane.add(textField10);
//		
//		
//		textField11 = new JTextField();
//		textField11.setColumns(10);
//		textField11.setBounds(560, 207, 18, 20);
//		contentPane.add(textField11);
//		
//		textField12 = new JTextField();
//		textField12.setColumns(10);
//		textField12.setBounds(590, 207, 18, 20);
//		contentPane.add(textField12);
//		
//		
//		textField13 = new JTextField();
//		textField13.setColumns(10);
//		textField13.setBounds(620, 207, 18, 20);
//		contentPane.add(textField13);
//		
//		
//		textField14 = new JTextField();
//		textField14.setColumns(10);
//		textField14.setBounds(650, 207, 18, 20);
//		contentPane.add(textField14);
//		
//		textField15 = new JTextField();
//		textField15.setColumns(10);
//		textField15.setBounds(680, 207, 18, 20);
//		contentPane.add(textField15);
//		
//		textField16 = new JTextField();
//		textField16.setColumns(10);
//		textField16.setBounds(710, 207, 18, 20);
//		contentPane.add(textField16);
//		
//		textField17 = new JTextField();
//		textField17.setColumns(10);
//		textField17.setBounds(740, 207, 18, 20);
//		contentPane.add(textField17);
//		
//		
//		textField18 = new JTextField();
//		textField18.setColumns(10);
//		textField18.setBounds(770, 207, 18, 20);
//		contentPane.add(textField18);
//		
//		
//		textField19 = new JTextField();
//		textField19.setColumns(10);
//		textField19.setBounds(800, 207, 18, 20);
//		contentPane.add(textField19);
//		
//		textField20 = new JTextField();
//		textField20.setColumns(10);
//		textField20.setBounds(830, 207, 18, 20);
//		contentPane.add(textField);
//		
//		
		
	}
}
