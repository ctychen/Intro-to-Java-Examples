import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	public static void main(String[] args) {

		JFrame window = new JFrame();

		Grid grid = new Grid();

		window.getContentPane().add(grid);
		
		window.setTitle("3x3 from array with fill");
		
		window.setSize(Grid.CANVAS_WIDTH, Grid.CANVAS_HEIGHT);
		
		window.setVisible(true);
		window.setResizable(false);
	
	}

}
