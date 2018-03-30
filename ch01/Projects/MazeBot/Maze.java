public class Maze {
	private static final Layout[][] defaultMaze;
	static {
		int width = 35;
		int height = 11;
		StringBuilder sbMaze = new StringBuilder();
		sbMaze.append("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		sbMaze.append("X.................X........X......X");
		sbMaze.append("X..X.....X.....................X..X");
		sbMaze.append("XXXXXXXXXXXXXXX.XXXXXX.XXXXXXXXXX.X");
		sbMaze.append("X....X...X........X......X.....X..X");
		sbMaze.append("X........X........X............X..X");
		sbMaze.append(" ....X...XXXXX.XXXXXXXXXXXX.XXXXXXX");
		sbMaze.append("X....X...X........X...X........X..X");
		sbMaze.append("XXXXXXX.XXXXXXXX.XX...XXXXXXXX....X");
		sbMaze.append("X.................X............X.. ");
		sbMaze.append("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		char[] chMaze = sbMaze.toString().toCharArray();
		int chIndex = 0;
		defaultMaze = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				defaultMaze[i][j] = Layout.toLayout(String.valueOf(chMaze[chIndex]));
				chIndex++;
			}
		}
	}

	public static Layout[][] getDefaultMaze() {
		int height = defaultMaze.length;
		int width = defaultMaze[0].length;
		Layout[][] copy = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				copy[i][j] = defaultMaze[i][j];
			}
		}
		return copy;
	}
}