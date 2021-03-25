package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Logica.StyledButtonUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	StartSlide ventanaInicio;
	
	public MenuPrincipal(StartSlide ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
		setLayout(null);
		
		JButton btnInforme = new JButton("INFORMES");
		btnInforme.setBounds(400, 216, 191, 41);
		btnInforme.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInforme.setUI(new StyledButtonUI());
		add(btnInforme);
		
		JButton btnOpciones = new JButton("OPCIONES");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prueba
				
				
				
				ventanaInicio.dispose();
				
			}
		});
		btnOpciones.setBounds(400, 366, 191, 41);
		btnOpciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpciones.setUI(new StyledButtonUI());
		add(btnOpciones);
		
		JButton btnHistoricos = new JButton("HIST\u00D3RICOS");
		btnHistoricos.setBounds(400, 291, 191, 41);
		btnHistoricos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHistoricos.setUI(new StyledButtonUI());
		add(btnHistoricos);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaInicio.dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir.setBounds(400, 498, 191, 41);
		btnSalir.setUI(new StyledButtonUI());
		add(btnSalir);
		
		JButton btnJugar = new JButton("JUGAR PARTIDA");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DuracionPartida duracionPartida = new DuracionPartida();
				duracionPartida.setVisible(true);
				ventanaInicio.dispose();
			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnJugar.setBounds(400, 141, 191, 41);
		btnJugar.setUI(new StyledButtonUI());
		add(btnJugar);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/FondoJugadoresvs.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        add(background);

	}

}
