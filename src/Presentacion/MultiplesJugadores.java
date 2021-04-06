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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class MultiplesJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJugador1;
	private JTextField textFieldJugador2;
	private static int CPU=0;

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
	public MultiplesJugadores(Partida partida) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJugador1 = new JButton("Jugador");
		btnJugador1.setBounds(62,85,128,48);
		contentPane.add(btnJugador1);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(263, 86, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
//		JComboBox comboJuagdor1 = new JComboBox();
//		comboJuagdor1.setBounds(62, 85, 128, 48);
//		comboJuagdor1.addItem("Jugador");
//		comboJuagdor1.addItem("CPU");
//        contentPane.add(comboJuagdor1);
//		textFieldJugador1 = new JTextField();
//		textFieldJugador1.setBounds(263, 86, 253, 47);
//		contentPane.add(textFieldJugador1);
//		textFieldJugador1.setColumns(10);
//        comboJuagdor1.addItemListener(new ItemListener() {
//		    public void itemStateChanged(ItemEvent arg0) {
//		    	String itemSeleccionado1 = (String)comboJuagdor1.getSelectedItem();
//		    	if ("Jugador".equals(itemSeleccionado1)) {
//		            //Creamos una instancia de Humano donde recogeremos del inputtext el Username.
//		    		textFieldJugador1.setText("");
//		         	textFieldJugador1.setEditable(true);
//		         	CPU--;
//		         }else{
//		         	//Creamos una instancia de CPU donde recogeremos del inputtext .
//		         	textFieldJugador1.setText("Al"+CPU);
//		         	textFieldJugador1.setEditable(false);
//		         	CPU++;
//		         	}
//		    }
//        });
        
        
        JComboBox comboJuagdor1 = new JComboBox();
        comboJuagdor1.setBounds(62, 143, 128, 48);
        comboJuagdor1.addItem("Jugador");
        comboJuagdor1.addItem("CPU");
        contentPane.add(comboJuagdor1);
        textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(263, 143, 253, 47);
		contentPane.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		comboJuagdor1.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent arg0) {
		    	String itemSeleccionado1 = (String)comboJuagdor1.getSelectedItem();
		    	if ("Jugador".equals(itemSeleccionado1)) {
		            //Creamos una instancia de Humano donde recogeremos del inputtext el Username.
		    		textFieldJugador1.setText("");
		         	textFieldJugador1.setEditable(true);
		         	CPU--;
		         }else{
		         	//Creamos una instancia de CPU donde recogeremos del inputtext .
		         	textFieldJugador1.setText("Al"+CPU);
		         	textFieldJugador1.setEditable(false);
		         	CPU++;
		         	}
		    }
		});
		
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
		
		JButton btnanadir = new JButton("+");
		btnanadir.setBackground(Color.BLUE);
		btnanadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnanadir.setBounds(608, 400, 70, 47);
		contentPane.add(btnanadir);
		btnanadir.addActionListener(new ActionListener() {
		int ultimaposiciony=173, i=3; 
			public void actionPerformed(ActionEvent e) {
				JButton BtnJugador = new JButton("JUGADOR "+i);
				i++;
				ultimaposiciony+= 60;
				BtnJugador.setBounds(62, ultimaposiciony, 128, 48);
				contentPane.add(BtnJugador);
				contentPane.repaint();
			}
		});
		JLabel background;
        ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        contentPane.add(background);
		
	}
}
