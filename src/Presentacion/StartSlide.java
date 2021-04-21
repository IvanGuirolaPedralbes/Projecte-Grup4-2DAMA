package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class StartSlide extends JFrame {

	public StartSlide() {
		final SlideInLayout slideIn = new SlideInLayout();
		JPanel slideInContainer = new JPanel(slideIn);
		
		JPanel presentacionSlide = new JPanel();
		final MenuPrincipal menuPrincipal = new MenuPrincipal(this);
		menuPrincipal.setBackground(Color.RED);
		
		JLabel background;
        ImageIcon img = new ImageIcon("resources/jordihurtado.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        presentacionSlide.add(background);
        setResizable(false);        
		slideInContainer.add(presentacionSlide);
		slideInContainer.add(menuPrincipal);
		add(slideInContainer, BorderLayout.CENTER);
		
		slideIn.show(presentacionSlide);
		
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				slideIn.show(menuPrincipal);
			}
		}).start();
	}
	
	public class SlideInLayout implements LayoutManager {
		private Component focusedComponent;
		
		@Override
		public void addLayoutComponent(String name, Component comp) {}
		
		@Override
		public void removeLayoutComponent(Component comp) {}

		@Override
		public void layoutContainer(Container parent) {
			setSizes(parent);
			
			if (hasFocusedComponent()) {
				focusedComponent.setVisible(true);
			}
		}
		
		private void setSizes(Container parent) {
			Insets insets = parent.getInsets();
	        int maxWidth = parent.getWidth() - (insets.left + insets.right);
	        int maxHeight = parent.getHeight() - (insets.top + insets.bottom);
	        
	        for (Component component : parent.getComponents()) {
				component.setBounds(0, 0, maxWidth, maxHeight);
			}
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			return new Dimension(0, 0);
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			Dimension preferredSize = new Dimension(0, 0);
			
			if (hasFocusedComponent()) {
				preferredSize = focusedComponent.getPreferredSize();
			}
			else if (parent.getComponentCount() > 0) {
				int maxWidth = 0;
				int maxHeight = 0;
				
				for (Component component : parent.getComponents()) {
					Dimension componentSize = component.getPreferredSize();
					maxWidth = Math.max(maxWidth, componentSize.width);
					maxHeight = Math.max(maxHeight, componentSize.height);
				}
				
				preferredSize = new Dimension(maxWidth, maxHeight);
			}
			
			return preferredSize;
		}
		
		private boolean hasFocusedComponent() {
			return focusedComponent != null;
		}
		
		public void show(Component component) {
			if (hasFocusedComponent())
				swap(focusedComponent, component);
			
			focusedComponent = component;
		}
		
		private void swap(Component transitionOut, Component transitionIn) {
			new SwapTimerAction(transitionOut, transitionIn).start();
		}
		
		private class SwapTimerAction implements ActionListener {
			private Timer timer;
			private Component transitionOut;
			private Component transitionIn;
			private static final int tick = 16; //16ms
			private static final int speed = 12;
			
			public SwapTimerAction(Component transitionOut, Component transitionIn) {
				this.transitionOut = transitionOut;
				this.transitionIn = transitionIn;
			}
			
			public void start() {
				Container container = transitionOut.getParent();
				container.setComponentZOrder(transitionOut, 1);
				container.setComponentZOrder(transitionIn, 0);
				transitionIn.setBounds(-transitionOut.getWidth(), 0, transitionOut.getWidth(), transitionOut.getHeight());
				timer = new Timer(tick, this);
				timer.start();
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int newX = Math.min(transitionIn.getX() + speed, transitionOut.getX());
				transitionIn.setLocation(newX, 0);
				
				if (newX == transitionOut.getX()) {
					timer.stop();
				}
			}
		}
	}
}


