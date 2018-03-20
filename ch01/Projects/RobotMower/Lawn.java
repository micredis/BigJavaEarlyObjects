public class Lawn {
	private String[][] field;
	private static final String BORDER = "X";
	private static final String GRASS = ":";
	private static final String CLEAN = " ";
	private static final String MOWER = "R";

	public Lawn() {
		setField(4, 4);
	}

	public Lawn(int width, int height) {
		setField(width, height);
	}

	public String[][] getField() {
		String[][] copy = new String[this.field.length][this.field[0].length];
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[i].length; j++) {
				copy[i][j] = this.field[i][j];
			}
		}
		return copy;
	}

	private void setField(int width, int height) {
		this.field = new String[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1 ||
					j == 0 || j == width - 1) {
					this.field[i][j] = BORDER;
				} else {
					this.field[i][j] = GRASS;
				}
			}
		}
	}

	public void setMower(int xPos, int yPos) {
		this.field[yPos][xPos] = MOWER;
	}

	public void mow(int xPos, int yPos) {
		this.field[yPos][xPos] = CLEAN;
	}
}