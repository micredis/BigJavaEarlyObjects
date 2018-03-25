public class Room {
	public static Layout[][] generateRoomPlan(int width, int height) {
		Layout[][] plan = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((i == 0 || i == height - 1) && 
					(j == 0 || j == width - 1) ||
					(i == 0 && j == 1 ||
						i == 0 && j == width - 2 ||
						i == 1 && j == 0 ||
						i == 1 && j == width - 1 ||
						i == height - 2 && j == 0 ||
						i == height - 2 && j == width - 1 ||
						i == height - 1 && j == 1 ||
						i == height - 1 && j == width  - 2)) {
					plan[i][j] = Layout.WALL;
				} else if ((i == 0 || i == height - 1 ||
					j == 0 || j == width - 1) && (Math.random() > 0.4)) {
					plan[i][j] = Layout.WALL;
				} else if (i == 0 || i == height - 1 ||
					j == 0 || j == width - 1) {
					plan[i][j] = Layout.WINDOW;
				} else {
					plan[i][j] = Layout.FLOOR;
				}
			}
		}
		return plan;
	}
}