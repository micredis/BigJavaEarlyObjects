public class Maze {
	private static final Layout[][] DEFAULT_MAZE;
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
		DEFAULT_MAZE = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				DEFAULT_MAZE[i][j] = Layout.toLayout(String.valueOf(chMaze[chIndex]));
				chIndex++;
			}
		}
	}

	public static Layout[][] getDefaultMaze() {
		int height = DEFAULT_MAZE.length;
		int width = DEFAULT_MAZE[0].length;
		Layout[][] copy = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				copy[i][j] = DEFAULT_MAZE[i][j];
			}
		}
		return copy;
	}
}