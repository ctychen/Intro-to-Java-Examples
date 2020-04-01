import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Just for fun, a 3x3 grid but there's rainbows scrolling in the background and
 * the lines flash random colors
 * 
 * @author ctychen
 *
 */
public class Grid extends JPanel {

	public static final int ROWS = 3;
	public static final int COLUMNS = 3;

	public static final int BOX_SIZE = 200;
	public static final int GRID_LINE_WIDTH = 8;

	public static final int CANVAS_WIDTH = BOX_SIZE * COLUMNS + 2 * GRID_LINE_WIDTH;
	public static final int CANVAS_HEIGHT = BOX_SIZE * ROWS;

	private boolean[][] fancyGrid;
	
	// Does the color scroll changing background thing
	private SpookyColors fancyRainbow = new SpookyColors(0, 0, 0, 0, 10, SpookyColors.Direction.VERTICAL);
	private int colorChangeDelay = 10;
	
	public Grid() {
		fancyGrid = new boolean[ROWS][COLUMNS];
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		setBackground(Color.WHITE);

		fancyRainbow.dims(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT * 4, SpookyColors.Direction.VERTICAL);
		fancyRainbow.draw(g);

		g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));

		for (int row = 1; row < ROWS; row++) {
			g.fillRect(0, BOX_SIZE * row - GRID_LINE_WIDTH / 2, CANVAS_WIDTH - 1, GRID_LINE_WIDTH);
		}
		for (int col = 1; col < COLUMNS; col++) {
			g.fillRect(BOX_SIZE * col - GRID_LINE_WIDTH / 2, 0, GRID_LINE_WIDTH, CANVAS_HEIGHT - 1);
		}

		// Since we want things to change color, we'll have to redraw every time
		// to see it update
		repaint();
	}
}
