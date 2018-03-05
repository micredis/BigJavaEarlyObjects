/* Write a program that prints an imitation of a Piet Mondrian painting. (Search the
Internet if you are not familiar with his paintings.) Use character sequences such as
@@@ or ::: to indicate different colors, and use - and | to form lines.
*/

public class PietMondrianPrinter {
	private static final char[] COLORS = 
		{' ', '@', ':', '#', '*', '+', '%'};
	private static final char H_LINE = '-';
	private static final char V_LINE = '|';

	public static void main(String[] args) {
		new PietMondrianPrinter().generatePicture();
	}

	public void generatePicture() {
		int width = 60;
		int height = 34;
		int rectCount = (int) (Math.random() * 20);
		char[][] canvas = new char[height][width];

		for (int h = 0; h < height; h++) {
			char color = COLORS[(int) (Math.random() * 7)];
			for (int w = 0; w < width; w++) {
				if (canvas[h][w] == '\u0000') { // if the cell is empty ('\u0000' is null)
					canvas[h][w] = color;
					int horizStretch = (int) (Math.random() * width )
				}
			}
		}
	}
}