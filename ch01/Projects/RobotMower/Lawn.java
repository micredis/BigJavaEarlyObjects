public class Lawn {
	private Layout[][] field;

	public Lawn() {
		setField(4, 4);
	}

	public Lawn(int width, int height) {
		setField(width, height);
	}

	public Layout[][] getField() {
		Layout[][] copy = new Layout[this.field.length][this.field[0].length];
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[i].length; j++) {
				copy[i][j] = this.field[i][j];
			}
		}
		return copy;
	}

	private void setField(int width, int height) {
		this.field = new Layout[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1 ||
					j == 0 || j == width - 1) {
					this.field[i][j] = Layout.BORDER;
				} else {
					this.field[i][j] = Layout.GRASS;
				}
			}
		}
	}

	public void setMower(int xPos, int yPos) {
		this.field[yPos][xPos] = Layout.MOWER;
	}

	public void mow(int xPos, int yPos) {
		this.field[yPos][xPos] = Layout.CLEAN;
	}

	public void printField() {
		System.out.println();
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field[i].length; j++) {
				System.out.print(Layout.toString(this.field[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}
}