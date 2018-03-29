public class Canvas {
	private static Layout[][] canvas;

	public static Layout[][] generateCanvas(int width, int height) {
		canvas = new Layout[height][width];
		for (int i = 0; i < height - 1; i++) {
			for (int j = 0; j < width - 1; j++) {
				int jFirst = j;
				while (jFirst < width - 1 &&
					canvas[i][jFirst] != null) {
					jFirst++;
				}
				int jLast = jFirst + 1;
				while (jLast < width - 1 &&
					canvas[i][jLast] == null) {
					jLast++;
				}
				int iLast = random(i + 1, height);
				if (jLast - jFirst > width / 3) {
					jLast = random(jFirst + width / 3, jLast);
				}
				Layout color = Layout.getRandomColor();
				putRect(color, i, iLast, jFirst, jLast);
				putExternalBorders();
			}
		}
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
				if (j == jFirst) {
					Canvas.canvas[i][j] = Layout.V_LINE;
				} else if (i == iFirst) {
					Canvas.canvas[i][j] = Layout.H_LINE;
				} else {
					Canvas.canvas[i][j] = color;
				}
			}
		}
	}

	private static void putExternalBorders() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				if (i == 0 || i == canvas.length - 1) {
					canvas[i][j] = Layout.H_LINE;
				} else if ((j == 0 ||
					j == canvas[i].length - 1) &&
					i != 0 && i != canvas.length - 1) {
					canvas[i][j] = Layout.V_LINE;
				}
			}
		}
	}
}