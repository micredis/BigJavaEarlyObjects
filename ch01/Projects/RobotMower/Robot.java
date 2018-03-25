public class Robot {
	private int xPos;
	private int yPos;
	private String direction;
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String LEFT = "L";
	private static final String RIGHT = "R";

	public Robot() {
		this.xPos = 0;
		this.yPos = 0;
		direction = RIGHT;
	}

	public Robot(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		direction = RIGHT;
	}

	public void move() {
		switch (this.direction) {
			case UP: this.yPos--;
				break;
			case DOWN: this.yPos++;
				break;
			case LEFT: this.xPos--;
				break;
			case RIGHT: this.xPos++;
				break;
			default: break;
		}
	}

	public void turnLeft() {
		switch (this.direction) {
			case UP: this.direction = LEFT;
				break;
			case DOWN: this.direction = RIGHT;
				break;
			case LEFT: this.direction = DOWN;
				break;
			case RIGHT: this.direction = UP;
				break;
			default: break;
		}
	}

	public void turnRight() {
		switch (this.direction) {
			case UP: this.direction = RIGHT;
				break;
			case DOWN: this.direction = LEFT;
				break;
			case LEFT: this.direction = UP;
				break;
			case RIGHT: this.direction = DOWN;
				break;
			default: break;
		}
	}

	public Layout nextUnit(Layout[][] field) {
		Layout unit = Layout.BORDER;
		int i = this.yPos;
		int j = this.xPos;
		if (i >= 0 && i < field.length &&
			j >= 0 && j < field[i].length) {
			switch (this.direction) {
				case UP: unit = (i - 1 >= 0) ? field[i - 1][j] : unit;
					break;
				case DOWN: unit = (i + 1 < field.length) ? field[i + 1][j] : unit;
					break;
				case LEFT: unit = (j - 1 >= 0) ? field[i][j - 1] : unit;
					break;
				case RIGHT: unit = (j + 1 < field[i].length) ? field[i][j + 1] : unit;
					break;
				default: break;
			}
		}
		return unit;
	}

	public int getX() {
		return this.xPos;
	}

	public int getY() {
		return this.yPos;
	}
}