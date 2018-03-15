/* Write a program that prints an imitation of a Piet Mondrian painting. (Search the
Internet if you are not familiar with his paintings.) Use character sequences such as
@@@ or ::: to indicate different colors, and use - and | to form lines.
*/

public class PietMondrianPrinter {
	private static final char[] COLORS = 
		{'@', ':', '#', '*', '+', '%'};
	private static final char WHITE = ' ';
	private static final char H_LINE = '-';
	private static final char V_LINE = '|';
	private int frameWidth = 60;
	private int frameHeight = 34;

	public static void main(String[] args) {
		new PietMondrianPrinter().generatePicture();
	}

	public void generatePicture() {
		//int rectCount = (int) (Math.random() * 20);
		char[][] canvas = new char[frameHeight][frameWidth];

		/*for (int h = 0; h < frameHeight; h++) {
			char color = COLORS[(int) (Math.random() * 7)];
			for (int w = 0; w < frameWidth; w++) {
				if (canvas[h][w] == '\u0000') { // if the cell is empty ('\u0000' is null)
					canvas[h][w] = color;
					//int horizStretch = (int) (Math.random() * frameWidth )
				}
			}
		}*/

		fillColor(canvas, WHITE);
		placeRectangles(canvas, 25);
		printCanvas(canvas);
	}

	public void fillColor(char[][] canvas, char color) {
		for (int h = 0; h < canvas.length; h++) {
			for (int w = 0; w < canvas[0].length; w++) {
				canvas[h][w] = color;
			}
		}
	}

	public void placeRectangles(char[][] canvas, int quantity) {
		int hOffset = (int) (Math.random() * canvas.length * 0.4);
		int wOffset = (int) (Math.random() * canvas[0].length * 0.4);
		for (int i = 0; i < quantity; i++) {
			char[][] rectangle = getRectangle();
			for (int h = hOffset; h < canvas.length && h < rectangle.length; h++) {
				for (int w = wOffset; w < canvas[0].length && w < rectangle[0].length; w++) {
					if (canvas[h][w] == WHITE) {
						canvas[h][w] = rectangle[h][w];
					}
				}
			}
			//hOffset += rectangle.length;
			//wOffset += rectangle[0].length;
		}
	}

	public char[][] getRectangle() {
		int width = (int) (Math.random() * frameWidth * 0.5 + 5);
		int height = (int) (Math.random() * frameHeight * 0.5 + 5);
		char color = COLORS[(int) (Math.random() * 6)];
		char[][] rectangle = new char[height][width];
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				if (h == 0 || h == height - 1) {
					rectangle[h][w] = H_LINE;
				} else if (w == 0 || w == width - 1) {
					rectangle[h][w] = V_LINE;
				} else {
					rectangle[h][w] = color;
				}
			}
		}
		return rectangle;
	}

	public void printCanvas(char[][] canvas) {
		for (int h = 0; h < canvas.length; h++) {
			for (int w = 0; w < canvas[h].length; w++) {
				System.out.print(canvas[h][w]);
			}
			System.out.println();
		}
	}
}