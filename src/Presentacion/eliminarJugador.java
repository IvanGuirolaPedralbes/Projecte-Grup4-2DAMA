package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Datos.JugadoresBD;
import Logica.StyledButtonUI;

public class eliminarJugador extends JFrame {

	private JPanel contentPane;
	
	public eliminarJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel deletePlayer = new JLabel();
		deletePlayer.setIcon(new ImageIcon(anadirJugador.class.getResource("/pruebas/eliminarJugador.png")));
		deletePlayer.setBounds(316, 81, 180, 158);
		contentPane.add(deletePlayer);
		
		JLabel lblNewLabel = new JLabel("Selecciona el jugador que desea eliminar");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 24));
		lblNewLabel.setBounds(170, 250, 506, 35);
		contentPane.add(lblNewLabel);
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(316, 370, 180, 68);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnEnviar.setUI(new StyledButtonUI());
		btnEnviar.setBackground(Color.WHITE);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox comboJugadores = new JComboBox();
		comboJugadores.setBounds(230, 296, 342, 49);
		int jugadoresTotal = 0;
		try {
			jugadoresTotal = JugadoresBD.getJugadores().size();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for(int i=0; i<jugadoresTotal; i++) {
			try {
				comboJugadores.addItem(JugadoresBD.getJugadores().get(i).getUsername());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		contentPane.add(comboJugadores);
		
		JLabel lblAtras = new JLabel();
		lblAtras.setIcon(new ImageIcon(anadirJugador.class.getResource("/pruebas/atras.png")));
		lblAtras.setBounds(10, 0, 80, 80);
		lblAtras.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Jugadors jugador = new Jugadors(null);
            	jugador.setVisible(true);
				eliminarJugador.this.dispose();
            }
		});
		contentPane.add(lblAtras);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(listaJugadores.class.getResource("/pruebas/saicle160200142.jpg")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);
	}

}
