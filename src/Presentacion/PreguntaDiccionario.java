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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(232, 207, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(343, 207, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(458, 207, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		textField_3 = new JTextField();
		textField_3.setBounds(564, 207, 86, 20);
		textField_3.disable();
		textField_3.setText("O");
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
	}
}
