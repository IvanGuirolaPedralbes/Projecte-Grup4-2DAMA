package Presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class RankingUsuarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public RankingUsuarios() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ranking user");
		lblNewLabel.setBounds(355, 198, 221, 91);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prueba ranking user");
		lblNewLabel_1.setBounds(288, 367, 244, 67);
		add(lblNewLabel_1);

	}
}
