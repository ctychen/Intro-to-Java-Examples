import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * Draws animated color-shifting rainbows
 * 
 * Processing code: @author clfrca
 * 
 * This: @author ctychen
 *
 */
public class SpookyColors {

	/**
	 * Possible directions for the colors to scroll. VERTICAL for vertical rainbows,
	 * colors scroll top-bottom, HORIZONTAL for horizontal rainbows, colors scroll
	 * left-right
	 * 
	 * TODO: Add radial rainbows
	 */
	public static enum Direction {
		VERTICAL, HORIZONTAL, RADIAL
	}

	private int x1, y1, x2, y2;
	private int c = 0;
	private int delay = 0;
	private int[] indexes = new int[200];
	private Color[] colors = new Color[200];
	private Direction orientation;

	public SpookyColors(int x1, int y1, int x2, int y2, int delay, Direction orientation) {
		for (int k = 0; k < colors.length; k++) {
			colors[k] = new Color(0, 0, 0);
			indexes[k] = k;
		}
		this.delay = delay;
		dims(x1, y1, x2, y2, orientation);
	}

	public void draw(Graphics g) {
		int width = x2 - x1;
		int height = y2 - y1;
		float s = (float) width / colors.length;
		float vs = (float) height / colors.length;
		g.fillRect(x1, y1, x2, y2);
		for (int j = 0; j < colors.length; j++) {
			changeColors(j, g);
			if (orientation == Direction.VERTICAL)
				g.fillRect(x1, (int) (y1 + j * vs), width, (int) (y1 + vs));
			else
				g.fillRect((int) (x1 + j * s), y1, (int) (x1 + s), height);
		}
	}

	/**
	 * Sets coordinates and dimensions
	 * 
	 * @param orientation VERTICAL for vertical rainbows, colors scroll top-bottom,
	 *                    HORIZONTAL for horizontal rainbows, colors scroll
	 *                    left-right
	 */
	public void dims(int x1, int y1, int x2, int y2, Direction orientation) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.orientation = orientation;
	}

	private void changeColors(int index, Graphics g) {

		int i = indexes[index];
		int l = 4;
		int r = colors[index].getRed();
		int gr = colors[index].getGreen();
		int b = colors[index].getBlue();
		if ((double) ((int) (System.currentTimeMillis() / 15)) % this.delay == 0) {

			// Starts with green
			if (i == 0) {
				r = 100;
				gr = 255;
				b = 100;
			}
			// Adds red to make yellow
			else if (i < 155 / l) {
				r += l;
				gr = 255;
				b = 100;
			}
			// Removes green to make red
			else if (i < 2 * 155 / l) {
				r = 255;
				gr -= l;
				b = 100;
			}
			// Adds blue to make purple
			else if (i < 3 * 155 / l) {
				r = 255;
				gr = 100;
				b += l;
			}
			// Removes the red to make blue
			else if (i < 4 * 155 / l) {
				r -= l;
				gr = 100;
				b = 255;
			}
			// Adds green to make turquoise
			else if (i < 5 * 155 / l) {
				r = 100;
				gr += l;
				b = 255;
			}
			// Removes blue to get back to green
			else if (i < 6 * 155 / l) {
				r = 100;
				gr = 255;
				b -= l;
				// if(index == 0 ) System.out.println(r + " " + g + " " + b);
			} else if (i >= 6 * 155 / l)
				indexes[index] = -1;

			// Makes all colors lighter
			if (r < 100)
				r = 100;
			if (gr < 100)
				gr = 100;
			if (b < 100)
				b = 100;

			// Makes sure no value gets above 255
			if (r > 255)
				r = 255;
			if (gr > 255)
				gr = 255;
			if (b > 255)
				b = 255;

			// Makes sure no value is negative
			r = Math.abs(r);
			gr = Math.abs(gr);
			b = Math.abs(b);
			indexes[index]++;
		}
		g.setColor(new Color(r, gr, b));
		colors[index] = new Color(r, gr, b);
	}

}