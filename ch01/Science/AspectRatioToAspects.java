/* A television manufacturer advertises that a
TV-set has a certain size, measured diagonally.
You wonder how the set will fit into your living
room. Write an algorithm that yields the horizontal
and vertical size of the television. Your inputs are
the diagonal size and the aspect ratio (the ratio of
width to height, usually 16 : 9 for television sets).
*/

public class AspectRatioToAspects {
	private static double diagonal;
	private static double aspectRatio;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java AspectRatioToAspects " +
				"<diagonal> <relative_width/relative_height>");
			System.exit(-1);
		}
		try {
			diagonal = Double.parseDouble(args[0]);
			String[] sAspectRatio = args[1].split("/");
			double numerator = Double.parseDouble(sAspectRatio[0]);
			double denominator = Double.parseDouble(sAspectRatio[1]);
			aspectRatio = numerator / denominator;
			if (Double.isInfinite(aspectRatio)) throw new NumberFormatException();
		} catch (NumberFormatException | IndexOutOfBoundsException ex) {
			System.err.println("Must be doubles: " +
				"<diagonal> <relative_width/relative_height>");
			System.exit(-1);
		}
		double width = diagonal * aspectRatio /
			Math.sqrt(Math.pow(aspectRatio, 2) + 1);
		double height = diagonal / Math.sqrt(1 + Math.pow(aspectRatio, 2));
		System.out.format("The TV-set is %.2f x %.2f rel.units.%n", width, height);
	}
}