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

public class PreguntaDiccionario extends JFrame {

	private JPanel contentPane;

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
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
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
		
		JPanel panelLetras = new JPanel();
		panelLetras.setOpaque(false);
		panelLetras.setBackground(Color.GRAY);
		panelLetras.setSize(600,200);
		
		panelLetras.setBounds(200, 300, 300, 200);
		
		background.add(panelLetras);
		panelLetras.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	

}
