package Presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;


public class Informes extends JFrame {

	private JPanel contentPane;
	private String[] nombresColumnas= {"Ranking", "Usuario", "Puntuacion"};
	private Object[][] datoFila= {
			{"1", 2444}
			
	};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informes frame = new Informes();
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
	public Informes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));		
		JPanel GuiIvaCard = new JPanel();
		contentPane.add(GuiIvaCard, BorderLayout.CENTER);
		CardLayout GuiIvaCL = new CardLayout(0, 0);
		GuiIvaCard.setLayout(GuiIvaCL);
		
		JPanel GuiIvaRed = new JPanel();
		
		
		
		
		GuiIvaRed.setBackground(Color.RED);
		GuiIvaCard.add(GuiIvaRed, "Jugadores");
		
		JPanel GuiIvaBlue = new JPanel();
		GuiIvaBlue.setBackground(Color.BLUE);
		GuiIvaCard.add(GuiIvaBlue, "Preguntas");
		
		
		
		JPanel GuiIvaButtons = new JPanel();
		contentPane.add(GuiIvaButtons,  BorderLayout.NORTH);
		
		JButton btnRed = new JButton("JugadoresRojo");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiIvaCL.show(GuiIvaCard, "Jugadores");
			}
		});
		GuiIvaButtons.add(btnRed);
		
		JButton btnBlue = new JButton("PreguntasAzul");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiIvaCL.show(GuiIvaCard, "Preguntas");
			}
		});
		GuiIvaButtons.add(btnBlue);
		
	
	}

}
