import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * Drawing a real simple 3 by 3 grid from a 2D array, in this case an array of
 * booleans.
 * 
 * Things you could try with this: 
 * - Change the values in the array and draw different things in the boxes
 * based on that
 * - Make it an array of integers instead and write the value of each index of the array
 * inside its corresponding box
 * 
 * ... 
 * 
 * @author ctychen
 *
 */
public class Grid extends JPanel {

	public static final int ROWS = 3;
	public static final int COLUMNS = 3;

	public static final int BOX_SIZE = 254;
	public static final int GRID_LINE_WIDTH = 8;

	public static final int CANVAS_WIDTH = BOX_SIZE * COLUMNS + 2 * GRID_LINE_WIDTH;
	public static final int CANVAS_HEIGHT = BOX_SIZE * ROWS;

	private boolean[][] fancyBoard;

	public Grid() {
		/*
		 * We make a 2D array of booleans, which you can think of like a table with ROWS
		 * rows and COLUMNS columns, where the rows are numbered from 0 to (ROWS-1) and
		 * columns are numbered from 0 to (COLUMNS-1).
		 * 
		 * By default, since these are booleans, all the values in the table are false.
		 * 
		 * To access the value of a particular element in this array (think a "box" in
		 * this table), we can say arrayName[i][j] where i is the row number and j is
		 * the column number.
		 * 
		 */
		fancyBoard = new boolean[ROWS][COLUMNS];
	}

	/**
	 * We're just drawing 2 sets of lines for the grid, nothing else. If you want to
	 * have the squares fill in with different colors, you'll have to draw
	 * rectangles for the grid boxes. But you can try putting different images in
	 * the boxes, that goes right on top
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		setBackground(Color.WHITE);

		g.setColor(Color.GREEN);

		for (int row = 1; row < ROWS; row++) {
			g.fillRect(0, BOX_SIZE * row - GRID_LINE_WIDTH / 2, CANVAS_WIDTH - 1, GRID_LINE_WIDTH);
		}
		for (int col = 1; col < COLUMNS; col++) {
			g.fillRect(BOX_SIZE * col - GRID_LINE_WIDTH / 2, 0, GRID_LINE_WIDTH, CANVAS_HEIGHT - 1);
		}

	}
}
