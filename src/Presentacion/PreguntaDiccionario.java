package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Logica.Partida;
import Logica.PreguntaDiccionarioLogica;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PreguntaDiccionario extends JFrame {

	private JPanel contentPane;
	private PreguntaDiccionarioLogica pregunta;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public PreguntaDiccionario(Partida partida) throws InterruptedException {
		pregunta= new PreguntaDiccionarioLogica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000, 600);
		// setBounds(100, 100, 450, 300);
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
		// background.add(btnCHECK);
		contentPane.add(btnCHECK);

		// Palabra ejemplo ABOMINABLEMENTE (15) A_O_INA_B_LEM_T_ (tapar 15/3=5)
		// palabra.length la longitud sera la palabra
		// char [] palabra= new char[14];

		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir ruleta
//				PreguntaMates pM = new PreguntaMates();
//				pM.setVisible(true);
				PreguntaDiccionario.this.dispose();
			}
		});
		btnNEXT.setForeground(Color.WHITE);
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNEXT.setBackground(Color.BLUE);
		btnNEXT.setBounds(433, 369, 99, 38);
		// background.add(btnNEXT);
		contentPane.add(btnNEXT);

		JLabel labelAviso = new JLabel("New label");
		labelAviso.setBounds(287, 302, 91, 27);
		contentPane.add(labelAviso);

		// String palabraDiccionario="abominablemente";
		// String palabraDiccionario="otorrinolaringólogico";//21 palabras, cubrir 7
		//String palabraDiccionario = "Andrés";// prueba corta
		//int longitudPalabra = palabraDiccionario.length();
		int longitud=pregunta.getPalabraDiccionario().length();
		
		JTextField vectorRelleno[] = new JTextField[longitud];
		//int vacio = longitudPalabra / 3;
		//JTextField vectorVacio[] = new JTextField[vacio];
		// char letra= palabraDiccionario.charAt(5);
		// System.out.println(letra);

		int posicionX = 70;
		int[] numElegidos;
		
		
		for (int i = 0; i < longitud; i++) {
			vectorRelleno[i] = new JTextField();

			posicionX += 40;
			vectorRelleno[i].setColumns(10);
			vectorRelleno[i].setBounds(posicionX, 207, 18, 20);
			setFont(new Font("Tahoma", Font.BOLD, 15));
			vectorRelleno[i].setHorizontalAlignment(SwingConstants.CENTER);
			// char letra= palabraDiccionario.charAt(i);
			String letra = String.valueOf(pregunta.getPalabraDiccionario().toUpperCase().charAt(i));
			numElegidos=generarNumerosAleatorios(longitud);
			if (!comprobarRepetidos(numElegidos, i)) {
				vectorRelleno[i].setText(letra);
				vectorRelleno[i].setEditable(false);
				vectorRelleno[i].setBackground(Color.WHITE);
				// vectorVacio[i].setText(null);
			}

			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				vectorRelleno[i].setBorder(border);
				// vector[i].setVisible(false);// el setvisible esconde el Jtfield completo
				// vectorRelleno[i].setForeground(Color.WHITE);// Escondemos el texto con el
				// mismo color del fondo
				// vector[i].setBackground(null);
				// vectorRelleno[i].setText(letra);

				vectorRelleno[i].setText("");
				// vectorVacio[i].setText(letra);
				// System.out.println("Letra es: "+vectorVacio[i]+"la i es: "+i);
			}

			contentPane.add(vectorRelleno[i]);
		}

		btnCHECK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int i,cont=0;
				int i;
				boolean casillaRellenada = true;

				for (i = 0; i < longitud && casillaRellenada; i++) {
					if (vectorRelleno[i].getText().equals(" ")) {
						// casillaRellenada=false;
						// System.out.println("Campo no rellenado.Entro en IF equals ");
						
						casillaRellenada = false;

					}

//		        			else {
//		        				System.out.println("No has rellenado todos los campos");
//		        				casillaRellenada=false;
//		        			}
				}
				

				if (casillaRellenada) {
					System.out.println("Perfecto!!");
					
				} else {
					JOptionPane.showMessageDialog(null, "No has rellenado los campos", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("Falta casilla");
					// btnCHECK.setEnabled(true);
				}
//		        		int num=palabraDiccionario.length()-1;
//		        		System.out.println("num es:"+num);

//		        		if((i==num)){
//	        				System.out.println("Entro en IF -1 length");
//	        				if(casillaRellenada) {
//	        					salir=true;
//	        				}
//	        				
//	        			}

				

				for (i = 0; i < longitud; i += 3) {
					// String letra = String.valueOf(palabraDiccionario.toUpperCase().charAt(i));
					char letraDiccionario = pregunta.getPalabraDiccionario().charAt(i);
					char letraIntroducida = vectorRelleno[i].getText().charAt(0);

					vectorRelleno[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (letraDiccionario == letraDiccionario) {
								System.out.println("Es lo mismo " + letraDiccionario);
							}
						}
//	        					}

					});
					// vectorRelleno[i].setForeground(Color.BLACK);
					// Thread.sleep(4000);// duerme todo el programa

				}
			}

		});

		// FALTA EN LOGICA LIMITAR LOS CARACTER A 1, QUE SOLO PUEDA INTRODUCIR UN CHAR
//	
//		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
//		
//		textField = new JTextField();
//		textField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		textField.setEditable(false);
//		textField.setForeground(Color.WHITE);
//		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
//		textField.setHorizontalAlignment(SwingConstants.CENTER);
//		textField.setColumns(10);
//		textField.setBounds(230, 207, 18, 20);
//		contentPane.add(textField);
//		

	}
	public static int [] generarNumerosAleatorios(int longitud) {
		
        int numerosrandom = (int) (longitud / 3);
        int[] numerosElegidos = new int[numerosrandom];
        
        //inicializa el array para que se puedan introducir 0
        for (int i = 0; i < numerosElegidos.length; i++) {
            numerosElegidos[i] = longitud + 1; //ponemos un numero que no exista en el array
        }

        //rellena el array
        for (int i = 0; i < numerosrandom; i++) {
            int numeroRandom;
            do {
                numeroRandom = generarRandom(0, 9);
            } while (comprobarRepetidos(numerosElegidos, numeroRandom));
            numerosElegidos[i] = numeroRandom;

        }
        
        return numerosElegidos;
    }
    
    //genera numeros aleatorios 
    public static int generarRandom(int min, int max) {
        Random random = new Random();
        if (min >= max) {
            throw new IllegalArgumentException("Max debe ser mas grande que Min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
    
    //comprueba que el numero recibido no este en el array recibido
    public static boolean comprobarRepetidos(int[] arrayNumeros, int numero) {
        for (int i = 0; i < arrayNumeros.length; i++) {
            if (numero == arrayNumeros[i]) {
                return true;
            }
        }
        return false;
    }
}

/*
 * // // textField1 = new JTextField(); // textField1.setColumns(10); //
 * textField1.setBounds(260, 207, 18, 20); // contentPane.add(textField1); // //
 * textField2 = new JTextField(); // textField2.setColumns(10); //
 * textField2.setBounds(290, 207, 18, 20); // contentPane.add(textField2); // //
 * // textField3 = new JTextField(); // textField3.setColumns(10); //
 * textField3.setBounds(320, 207, 18, 20); // contentPane.add(textField3); // //
 * textField4 = new JTextField(); // textField4.setBounds(350, 207, 18, 20); //
 * contentPane.add(textField4); // textField4.setColumns(10); // // textField5 =
 * new JTextField(); // textField5.setColumns(10); // textField5.setBounds(380,
 * 207, 18, 20); // contentPane.add(textField5); // // // textField6 = new
 * JTextField(); // textField6.setColumns(10); // textField6.setBounds(410, 207,
 * 18, 20); // contentPane.add(textField6); // // textField7 = new JTextField();
 * // textField7.setColumns(10); // textField7.setBounds(440, 207, 18, 20); //
 * contentPane.add(textField7); // // textField8 = new JTextField(); //
 * textField8.setColumns(10); // textField8.setBounds(470, 207, 18, 20); //
 * contentPane.add(textField8); // // // textField9 = new JTextField(); //
 * textField9.setColumns(10); // textField9.setBounds(500, 207, 18, 20); //
 * contentPane.add(textField9); // // textField10 = new JTextField(); //
 * textField10.setColumns(10); // textField10.setBounds(530, 207, 18, 20); //
 * contentPane.add(textField10); // // // textField11 = new JTextField(); //
 * textField11.setColumns(10); // textField11.setBounds(560, 207, 18, 20); //
 * contentPane.add(textField11); // // textField12 = new JTextField(); //
 * textField12.setColumns(10); // textField12.setBounds(590, 207, 18, 20); //
 * contentPane.add(textField12); // // // textField13 = new JTextField(); //
 * textField13.setColumns(10); // textField13.setBounds(620, 207, 18, 20); //
 * contentPane.add(textField13); // // // textField14 = new JTextField(); //
 * textField14.setColumns(10); // textField14.setBounds(650, 207, 18, 20); //
 * contentPane.add(textField14); // // textField15 = new JTextField(); //
 * textField15.setColumns(10); // textField15.setBounds(680, 207, 18, 20); //
 * contentPane.add(textField15); // // textField16 = new JTextField(); //
 * textField16.setColumns(10); // textField16.setBounds(710, 207, 18, 20); //
 * contentPane.add(textField16); // // textField17 = new JTextField(); //
 * textField17.setColumns(10); // textField17.setBounds(740, 207, 18, 20); //
 * contentPane.add(textField17); // // // textField18 = new JTextField(); //
 * textField18.setColumns(10); // textField18.setBounds(770, 207, 18, 20); //
 * contentPane.add(textField18); // // // textField19 = new JTextField(); //
 * textField19.setColumns(10); // textField19.setBounds(800, 207, 18, 20); //
 * contentPane.add(textField19); // // textField20 = new JTextField(); //
 * textField20.setColumns(10); // textField20.setBounds(830, 207, 18, 20); //
 * contentPane.add(textField); // //
 * 
 */