public enum Layout {
	WALL, EXIT, FLOOR, ROBOT;

	public static String toString(Layout layout) {
		String representation = "?";
		switch (layout) {
			case WALL: representation = "X";
				break;
			case EXIT: representation = " ";
				break;
			case FLOOR: representation = ".";
				break;
			case ROBOT: representation = "R";
				break;
			default: break;
		}
		return representation;
	}
}