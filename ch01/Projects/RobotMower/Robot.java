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
		switch (this.direction) {
			case UP: unit = field[yPos - 1][xPos];
				break;
			case DOWN: unit = field[yPos + 1][xPos];
				break;
			case LEFT: unit = field[yPos][xPos - 1];
				break;
			case RIGHT: unit = field[yPos][xPos + 1];
				break;
			default: break;
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