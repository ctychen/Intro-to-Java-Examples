import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTimerExample extends JPanel implements ActionListener {

	Timer fancyClock;
	int i = 0;
	
	int amp = 20; //This sets the amplitude of the wave
	double w = Math.PI/12; //This sets the phase constant of the wave
	
	String spooky;
	
	public SimpleTimerExample() { //This is where the magic happens
		
		spookySetup();
		
		System.out.println("Starting Clock");
		fancyClock = new Timer(50, (ActionListener) this); //Timer fires every 50 milliseconds
		fancyClock.setInitialDelay(500); //Wait half a second before starting
		fancyClock.setRepeats(true);
		fancyClock.start();
		System.out.println("Is the clock running? --> " + fancyClock.isRunning());
		System.out.println("Clock's ActionListener: " + fancyClock.getActionListeners()[0].toString());
	}
	
	public static void main(String[] args) {
		SimpleTimerExample yeet = new SimpleTimerExample();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //Magic also happens here
		// TODO Auto-generated method stub
		System.out.println(spooky());
		i++;
	}
	
	public void spookySetup() {
		spooky = "";
		for (int i = 0; i < amp*2; i++)
			spooky += "-";
	}
	
	public String spooky() {
		int f = (int) (Math.sin(i*Math.PI/12)*((spooky.length()-1)/2)) + spooky.length()/2;
		return spooky.substring(0, f) + "*" + spooky.substring(f);
	}
	
}
