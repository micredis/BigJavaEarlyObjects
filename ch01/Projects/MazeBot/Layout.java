public enum Layout {
	WALL, WINDOW, FLOOR, ROBOT;

	public static String toString(Layout layout) {
		String representation = "?";
		switch (layout) {
			case WALL: representation = "X";
				break;
			case WINDOW: representation = ":";
				break;
			case FLOOR: representation = " ";
				break;
			case ROBOT: representation = "R";
				break;
			default: break;
		}
		return representation;
	}
}