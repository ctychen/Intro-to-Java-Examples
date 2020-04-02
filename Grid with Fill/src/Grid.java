import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class Grid extends JPanel{

	private boolean[][] grid;
	private int x = 0, y = 0;
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	public static final int GRID_WIDTH = 300, GRID_HEIGHT = 300;
	public static final int GRID_LINE_WIDTH = 8;
	public static final int CANVAS_WIDTH = GRID_WIDTH + (ROWS - 1) * GRID_LINE_WIDTH;
	public static final int CANVAS_HEIGHT = GRID_HEIGHT + (COLUMNS - 1) * GRID_LINE_WIDTH;

	
	public Grid() {
		grid = new boolean[ROWS][COLUMNS];
		// grid[row][column], note that arrays start at 0
		grid[0][1] = true;
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(180, 180, 180));
		g.fillRect((int)(x), (int)(y), (int)(GRID_WIDTH), (int)(GRID_HEIGHT));

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j])
					g.setColor(Color.YELLOW);
				else
					g.setColor(Color.RED);
				g.fillRect((int)(x + GRID_WIDTH / COLUMNS * j), (int)(y + GRID_HEIGHT / ROWS * i), (int)(GRID_WIDTH / COLUMNS),
						(int)(GRID_HEIGHT / ROWS));
			}
		}
		g.setColor(Color.BLACK);
		for (int row = 1; row < ROWS; row++) {
			g.fillRect(0, y + GRID_HEIGHT/ROWS*row, GRID_WIDTH, GRID_LINE_WIDTH);
		}
		for (int col = 1; col < COLUMNS; col++) {
			g.fillRect(x+GRID_WIDTH/COLUMNS*col, 0, GRID_LINE_WIDTH, GRID_HEIGHT);
		}


	}

	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		Rectangle2D.Float r = new Rectangle2D.Float(x, y, width, height);
		if (!r.contains(p))
			return null;
		int clickX = (int) ((p.x - x) * grid.length / width);
		int clickY = (int) ((p.y - x) * grid[0].length / height);

		return new Point(clickY, clickX);
	}
}
