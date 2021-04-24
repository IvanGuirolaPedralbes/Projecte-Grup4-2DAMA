package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Datos.JugadoresBD;
import Logica.Jugador;
import Logica.StyledButtonUI;

public class listaJugadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public listaJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		// Creem un vector de ... amb tot el llistat d'usuaris creats
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		try {
			listaJugadores = JugadoresBD.getJugadores();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int longitud = listaJugadores.size();

		JTextField vectorRelleno[] = new JTextField[longitud];

		int posicionY = 10, posicionX = 100;
//		int[] numElegidos = generarNumerosAleatorios(longitud);

		for (int i = 0; i < longitud; i++) {
			vectorRelleno[i] = new JTextField();
			posicionY += 32;
			if(i%15==0 && i!=0) {
				posicionX += 225;
				posicionY = 42;
			}
			vectorRelleno[i].setBounds(posicionX, posicionY, 200, 30);
			setFont(new Font("Tahoma", Font.BOLD, 15));
			//vectorRelleno[i].setHorizontalAlignment(SwingConstants.CENTER);

			vectorRelleno[i].setText(listaJugadores.get(i).getUsername());
			vectorRelleno[i].setEditable(false);
			vectorRelleno[i].setVisible(true);
			
			contentPane.add(vectorRelleno[i]);
		}
		JButton btnAnadir = new JButton("Añadir jugador");
		btnAnadir.setBounds(550, 415, 200, 50);
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAnadir.setUI(new StyledButtonUI());
		btnAnadir.setBackground(Color.BLACK);
		btnAnadir.setForeground(Color.WHITE);
		contentPane.add(btnAnadir);
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirJugador anadirJugador = new anadirJugador();
				anadirJugador.setVisible(true);
				listaJugadores.this.dispose();
			}
		});
		
		
		JButton btnEliminar = new JButton("Eliminar jugador");
		btnEliminar.setBounds(550, 470, 200, 50);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setUI(new StyledButtonUI());
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setForeground(Color.WHITE);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirJugador anadirJugador = new anadirJugador();
				anadirJugador.setVisible(true);
				listaJugadores.this.dispose();
			}
		});

		JLabel lblAtras = new JLabel();
		lblAtras.setIcon(new ImageIcon(anadirJugador.class.getResource("/pruebas/atras.png")));
		lblAtras.setBounds(10, 0, 80, 80);
		lblAtras.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Jugadors jugador = new Jugadors(null);
            	jugador.setVisible(true);
				listaJugadores.this.dispose();
            }
		});
		contentPane.add(lblAtras);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(listaJugadores.class.getResource("/pruebas/saicle160200142.jpg")));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);

	}

}
