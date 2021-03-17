package Presentacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Slider {

   JPanel panel;

   /**
    * @wbp.parser.entryPoint
    */
   public void Inicializar() {
      panel = new JPanel();
      panel.setBackground(Color.RED);
      
      panel.setBounds(0, 0, 900, 620);
      JFrame frame = new JFrame("Sliding Panel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(900, 620);
      frame.setLocationRelativeTo(null);
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(panel);
      frame.setResizable(false);
      
            JButton button = new JButton("Comenzar");
            button.setVerticalAlignment(SwingConstants.TOP);
            button.setForeground(new Color(178, 34, 34));
            button.setBackground(new Color(255, 255, 255));
            button.setBorderPainted(false);
            button.setBorder(null);
            button.setFont(new Font("Arial Black", Font.BOLD, 16));
            button.setBounds(352, 518, 188, 42);
            button.setUI(new StyledButtonUI());
            button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  ((JButton) e.getSource()).setEnabled(false);
                  new Timer(1, new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        panel.setLocation(panel.getX() - 8,0);
                        if (panel.getX() + panel.getWidth() == 0) {
                           ((Timer) e.getSource()).stop();
                     System.out.println("Timer stopped");
                  }
                     }
                  }).start();
               }
            });
            panel.setLayout(null);
            panel.add(button);
            
            JLabel background;
            ImageIcon img = new ImageIcon("libs/saberyganarInicio.jpg");
            
            background = new JLabel("", img, JLabel.CENTER);
            background.setBounds(0, 0, 900, 600);
            panel.add(background);
      frame.setVisible(true);
   }
}