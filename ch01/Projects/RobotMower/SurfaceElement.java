public class SurfaceElement {
	public static String getElement(ElementType elementType) {
		switch (elementType) {
			case BORDER:
				return "X";
			case GRASS:
				return ":";
			case CLEAN:
				return " ";
			case MOWER:
				return "R";
			default:
				return "?";
		}
	}
}