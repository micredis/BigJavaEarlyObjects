public class PicShrinker {
	public static void main(String[] args) {
		Picture picture = new Picture();
		picture.pick();
		int width = picture.getWidth();
		int height = picture.getHeight();
		int dx = width / 10;
		int dy = height / 10;
		picture.scale(width - dx, height - dy);
		picture.move(dx / 2, dy / 2);
		picture.border(dx / 4);
	}
}