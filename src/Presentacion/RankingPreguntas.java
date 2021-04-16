package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingPreguntas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public RankingPreguntas() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(188, 105, 592, 320);
		add(table);
		
		JButton btnNewButton = new JButton("PRUEBA RANKING PREGUNTAS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(315, 53, 296, 29);
		add(btnNewButton);

	}
}
