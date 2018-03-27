public class Canvas {
	public static Layout[][] generateCanvas(int width, int height) {
		Layout[][] canvas = new Layout[height][width];
		int numOfRectangles = random(4, 15);
		int iFirst = 0;
		int jFirst = 0;
		for (int r = 0; r < numOfRectangles; r++) {
			Layout color = Layout.getRandomColor();
			int iLast = random(iFirst + 1, height - 2);
			int jLast = random(jFirst + 1, width - 2);
			drawRect(canvas, iFirst, iLast, jFirst, jLast);
			//iLast = (iLast)
		}

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
		return (int) (Math.random() * (max - min + 1) + min);
	}
}