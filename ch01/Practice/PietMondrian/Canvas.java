public class Canvas {
	private static Layout[][] canvas;

	public static Layout[][] generateCanvas(int width, int height) {
		canvas = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width - 2; j++) {
				int jFirst = j;
				while (jFirst < width &&
					canvas[i][jFirst] != null) {
					jFirst++;
				}
				int jLast = jFirst;
				while (jLast < width &&
					canvas[i][jLast] == null) {
					jLast++;
				}
				int iLast = random(i + 1, height);
				jLast = random(jFirst + 1, jLast);
				Layout color = Layout.getRandomColor();
				putRect(color, i, iLast, jFirst, jLast);
				putRightAndBottomBorders();
			}
		}

		/*int numOfRectangles = random(4, 15);
		int iFirst = 0;
		int jFirst = 0;
		for (int r = 0; r < numOfRectangles; r++) {
			Layout color = Layout.getRandomColor();
			int iLast = random(iFirst + 1, height - 2);
			int jLast = random(jFirst + 1, width - 2);
			drawRect(canvas, iFirst, iLast, jFirst, jLast);
			//iLast = (iLast)
		}*/

		/*for (int i = 0; i < height - 1; i++) {
			for (int j = 0; j < width - 1; j++) {
				Layout color = Layout.getRandomColor();
				int imax = random(i, height - 2);
				int jmax = random(j, width - 2);
				for (int )
			}
		}*/

		/*for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0) {
					canvas[i][j] = Layout.H_LINE;
				} else if (j == 0) {
					canvas[i][j] = Layout.V_LINE;
				} else if (canvas[i][j] == null) {
					Layout color = Layout.getRandomColor();
					int imin = 
				}
			}
		}*/
		return canvas;
	}

	private static int random(int min, int max) {
		if (min > max) return max;
		return (int) (Math.random() * (max - min + 1) + min);
	}

	private static void putRect(Layout color,
		int iFirst, int iLast, int jFirst, int jLast) {
		for (int i = iFirst; i < iLast; i++) {
			for (int j = jFirst; j < jLast; j++) {
				if ((j == jFirst) &&
					jFirst != jLast - 1) {
					Canvas.canvas[i][j] = Layout.V_LINE;
				} else {
					Canvas.canvas[i][j] = color;
				}
			}
		}
	}

	private static void putRightAndBottomBorders() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				if (i == canvas.length - 1) {
					canvas[i][j] = Layout.H_LINE;
				} else if (j == canvas[i].length - 1) {
					canvas[i][j] = Layout.V_LINE;
				}
			}
		}
	}
}