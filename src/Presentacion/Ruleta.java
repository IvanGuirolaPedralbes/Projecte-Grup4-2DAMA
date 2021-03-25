package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import SelectionWheel.SelectionWheel;

public class Ruleta {

	public Ruleta() throws Exception {
        
        int width = 1000, height = 600;
        
		File RuletaAgudo = new File("ruletaAgudo.wav");
		File RuletaGrave = new File("ruletaGrave.wav");
		File Victory = new File("victory.wav");
		
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("  Matematicas");
        list.add("Ingles");
        list.add("Diccionario");
        list.add("  Matematicas");
        list.add("Ingles");
        list.add("Diccionario");
       
       
        
        
        SelectionWheel wheel = new SelectionWheel(list);
        wheel.hasBorders(true);
       
       
        wheel.setBounds(250, 45, 500, 500);
        ArrayList<Color> Colores = new ArrayList<Color>();
        Colores.add(Color.GRAY);
        Colores.add(Color.RED);
        Colores.add(Color.WHITE);
        wheel.setColorScheme(Colores);
        
        frame.add(wheel);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);
        JLabel background;
        ImageIcon img = new ImageIcon("resources/fondoRuleta.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 600);
        frame.add(background);
        
        final SwingWorker worker = new SwingWorker(){
        	 
			@Override
			protected Object doInBackground() throws Exception {
				String nombrePos="0", nombrePosActual="0";
				boolean switcher = false;
				while(true) {
		            // wait for action
		            while(true)
		            {
						if(nombrePos!=nombrePosActual) {
							if (switcher) {
								PlaySound(RuletaAgudo);
								switcher = false;
							}
							else {
								PlaySound(RuletaGrave);
								switcher = true;
							}
						}
						nombrePos=nombrePosActual;
		                try {
		                    Thread.sleep(10);
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		                if(wheel.isSpinning())
		                    break;
		            }
		            // while spinning
		            while(wheel.isSpinning())
		            {
		            	nombrePosActual=wheel.getSelectedString();
						if(nombrePos!=nombrePosActual) {
							if (switcher) {
								PlaySound(RuletaAgudo);
								switcher = false;
							}
							else {
								PlaySound(RuletaGrave);
								switcher = true;
							}
						}
						nombrePos=nombrePosActual;
		               
		                try {
		                    Thread.sleep(10);
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		            }
		           
		            // show selection
		            PlaySound(Victory);
		            JOptionPane.showMessageDialog(frame, "Selection: " + wheel.getSelectedString());
		            frame.dispose();
		        }
			}	
		};
		worker.execute();
			
    }
	
	public static void PlaySound(File Sound) {
		Clip clip;
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
