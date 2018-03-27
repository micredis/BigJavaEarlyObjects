public enum Layout {
	H_LINE, V_LINE, WHITE,
	COLOR1, COLOR2, COLOR3,
	COLOR4, COLOR5, COLOR6;

	public static String toString(Layout layout) {
		String representation = "?";
		switch (layout) {
			case H_LINE: representation = "-";
				break;
			case V_LINE: representation = "|";
				break;
			case WHITE: representation = " ";
				break;
			case COLOR1: representation = "@";
				break;
			case COLOR2: representation = ":";
				break;
			case COLOR3: representation = "#";
				break;
			case COLOR4: representation = "*";
				break;
			case COLOR5: representation = "+";
				break;
			case COLOR6: representation = "%";
				break;
			default: break;
		}
		return representation;
	}

	public static Layout getRandomColor() {
		Layout color = WHITE;
		// generate a random number within a range [3; 8]
		// which corresponds to colors [COLOR1; COLOR6]
		int colorNumber = (int) (Math.random() * (8 - 3 + 1) + 3);
		for (Layout l : Layout.values()) {
			// when position of a color in the enum l.ordinal()
			// is equal to the randomly generated colorNumber,
			// pick this color
			if (l.ordinal() == colorNumber) {
				color = l;
				break;
			}
		}
		return color;
	}
}