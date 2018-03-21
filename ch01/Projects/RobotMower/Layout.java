public enum Layout {
	BORDER, GRASS, CLEAN, MOWER;

	public static String toString(Layout layout) {
		String notation = "?";
		switch (layout) {
			case BORDER: notation = "X";
				break;
			case GRASS:	notation = ":";
				break;
			case CLEAN: notation = " ";
				break;
			case MOWER: notation = "R";
				break;
			default: break;
		}
		return notation;
	}
}