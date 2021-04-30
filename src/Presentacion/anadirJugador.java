package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Datos.JugadoresBD;
import Logica.Jugador;
import Logica.StyledButtonUI;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class anadirJugador extends JFrame {

	private JPanel contentPane;

	public anadirJugador() {
		Jugador jugador2 = null;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lbladdPlayer = new JLabel();
		lbladdPlayer.setIcon(new ImageIcon(anadirJugador.class.getResource("/pruebas/soccer-player.png")));
		lbladdPlayer.setBounds(316, 81, 180, 158);
		contentPane.add(lbladdPlayer);
		
		JLabel lblNewLabel = new JLabel("Escribe el nombre del jugador");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 24));
		lblNewLabel.setBounds(230, 250, 427, 35);
		contentPane.add(lblNewLabel);
		
		JTextField textFieldJugador = new JTextField();
		textFieldJugador.setBounds(230, 296, 342, 49);
		contentPane.add(textFieldJugador);
		textFieldJugador.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(316, 370, 180, 68);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnEnviar.setUI(new StyledButtonUI());
		btnEnviar.setBackground(Color.WHITE);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (JugadoresBD.getJugadores().size()>44) {
						JOptionPane.showMessageDialog(null, "Ha llegado al número máximo de usuarios, elimine uno para poder añadir nuevos usuarios.", "Alerta",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if(JugadoresBD.comprobarJugador(textFieldJugador.getText())) {
							JOptionPane.showMessageDialog(null, "El jugador ya existe.", "Alerta",
									JOptionPane.WARNING_MESSAGE);
						}else {
							JugadoresBD.crearJugador(textFieldJugador.getText());
							JOptionPane.showMessageDialog(null, "El jugador se ha creado con éxito.", "Alerta",
									JOptionPane.WARNING_MESSAGE);
							Jugadors jugador = new Jugadors(jugador2);
			            	jugador.setVisible(true);
							anadirJugador.this.dispose();
						}
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblAtras = new JLabel();
		lblAtras.setIcon(new ImageIcon(anadirJugador.class.getResource("/pruebas/atras.png")));
		lblAtras.setBounds(10, 0, 80, 80);
		lblAtras.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Jugadors jugador = new Jugadors(jugador2);
            	jugador.setVisible(true);
				anadirJugador.this.dispose();
            }
		});
		contentPane.add(lblAtras);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(listaJugadores.class.getResource("/pruebas/saicle160200142.jpg")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);
		
		
		
	}
}
