/* Write a program that prints an imitation of a Piet Mondrian painting. (Search the
Internet if you are not familiar with his paintings.) Use character sequences such as
@@@ or ::: to indicate different colors, and use - and | to form lines.
E.g.:
--------------------------------------
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|---------|@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|         |@@@@@@@@@@@@@@@@@@@@@@@@@@|
|------------------------------------|
|:::::::::|                   |      |
|:::::::::|                   |      |
|:::::::::|                   |------|
|:::::::::|                   |######|
|:::::::::|                   |######|
|:::::::::|                   |######|
|:::::::::|                   |######|
--------------------------------------

*/

// You may need several attempts to get an acceptable "painting"

public class PietMondrianTester {
	private static int width;
	private static int height;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java PietMondrianTester " + 
				"<picture_width> <picture_height>");
			System.exit(-1);
		}
		try {
			width = Integer.parseInt(args[0]);
			height = Integer.parseInt(args[1]);
			if (width < 3 || height < 3) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException ex) {
			System.err.println("Must be more than 3: " + 
				"<picture_width> <picture_height>");
			System.exit(-1);
		}
		Layout[][] canvas = Canvas.generateCanvas(width, height);
		printCanvas(canvas);
	}

	private static void printCanvas(Layout[][] canvas) {
		System.out.println();
		for (Layout[] line : canvas) {
			for (Layout l : line) {
				if (l == null) {
					System.out.print(Layout.toString(Layout.WHITE));
				} else {
					System.out.print(Layout.toString(l));
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}