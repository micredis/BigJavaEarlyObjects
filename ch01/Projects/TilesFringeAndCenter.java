/* Write an algorithm to create a tile pattern composed of black
and white tiles, with a fringe of black tiles all around and
two or three black tiles in the center, equally spaced from the
boundary. The inputs to your algorithm are the total number
of rows and columns in the pattern.

XXXXXXXXX
X       X
X       X
X  XXX  X
X       X
X       X
XXXXXXXXX

*/

public class TilesFringeAndCenter {
	private int iMax; // number of rows
	private int jMax; // number of columns

	public static void main(String[] args) {
		new TilesFringeAndCenter().go(args);
	}

	public void go(String[] args) {
		if (args.length < 2) {
			System.out.println("The number of rows and columns must be specified! E.g.:");
			System.out.println("java TilesFringeAndCenter 7 9");
			return;
		}
		try {
			this.iMax = Integer.parseInt(args[0]);
			this.jMax = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex) {
			System.out.println("Incorrect prameters. Program terminated.");
			return;
		}
		if (this.iMax % 2 == 0) {
			System.out.println("The number of rows must be odd.");
			return;
		}
		this.printTiles();
	}

	public void printTiles() {
		for (int i = 0; i < iMax; i++) {
			int iMid = iMax / 2;
			for (int j = 0; j < jMax; j++) {
				int jMid = jMax / 2;
				if (i == 0 || i == iMax - 1 ||
					j == 0 || j == jMax - 1 ||
					i == iMid && iMax > 4 &&
					// check whether it's 2 or 3 tiles in the middle
					// (depending on an odd/even number of columns)
					(jMax % 2 == 0 && jMax > 5 && j >= jMid - 1 && j <= jMid ||
						jMax % 2 != 0 && jMax > 6 && j >= jMid - 1 && j <= jMid + 1)) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}