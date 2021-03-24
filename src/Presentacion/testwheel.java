package Presentacion;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import SelectionWheel.SelectionWheel;

public class testwheel {

	public testwheel() throws Exception {
        
        int width = 1000, height = 1000;
        
		File RuletaAgudo = new File("ruletaAgudo.wav");
		File RuletaGrave = new File("ruletaGrave.wav");
		File Victory = new File("victory.wav");
		
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<String> list = new ArrayList<String>();
        list.add("Avatar");
        list.add("The Lord of the Rings: The Return of the King");
        list.add("Pirates of the Caribbean: Dead Man's Chest");
       
        
        SelectionWheel wheel = new SelectionWheel(list);
        wheel.hasBorders(true);
        wheel.setBounds(10, 10, 700, 700);
        
       
        frame.add(wheel);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
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
