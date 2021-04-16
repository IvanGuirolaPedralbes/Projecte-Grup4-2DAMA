package Logica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;

import javax.swing.JLabel;

public class ShadowText extends JLabel {
	String text;
  public ShadowText(String text) {
	  this.text = text;
  }

  public void paint(Graphics g) {
  
    int x = 10;
    int y = 100;

    Font font = new Font("Georgia", Font.ITALIC, 50);
    Graphics2D g1 = (Graphics2D) g;

    TextLayout textLayout = new TextLayout(text, font, g1.getFontRenderContext());
    g1.setPaint(new Color(150, 150, 150));
    textLayout.draw(g1, x + 3, y + 3);

    g1.setPaint(Color.BLACK);
    textLayout.draw(g1, x, y);
  }
}