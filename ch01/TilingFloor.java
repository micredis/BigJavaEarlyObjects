/* Write an algorithm for tiling a rectangular bathroom floor with
alternating black and white tiles measuring 4 × 4 inches. The floor
dimensions, measured in inches, are multiples of 4.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TilingFloor {
	private int width = 0;
	private int height = 0;
	private final String INCORRECT_INPUT = "Incorrect input";

	public static void main(String[] args) {
		new TilingFloor().go();
	}

	public void go() {
		readInput();
		boolean isBlack = true;
		for (int i = 0; i < height / 4; i++) {
			printRow(width / 4, isBlack);
			isBlack = !isBlack;
		}
	}

	public void readInput() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input width, inches: ");
			String sWidth = reader.readLine();
			if (!sWidth.isEmpty() && sWidth.matches("\\d+")) {
				width = Integer.parseInt(sWidth);
			} else {
				System.out.println(INCORRECT_INPUT);
				reader.close();
				return;
			}
			System.out.print("Input height, inches: ");
			String sHeight = reader.readLine();
			if (!sHeight.isEmpty() && sHeight.matches("\\d+")) {
				height = Integer.parseInt(sHeight);
			} else {
				System.out.println(INCORRECT_INPUT);
				reader.close();
				return;
			}
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printRow(int numOfTiles, boolean isFirstBlack) {
		// tiles are 4 x 4 inches:
		// xxxx
		// xxxx
		// xxxx
		// xxxx
		for (int i = 0; numOfTiles > 0 && i < 4; i++) {
			boolean isBlack = isFirstBlack;
			for (int j = 0; j < numOfTiles; j++) {
				if (isBlack) {
					System.out.print("xxxx");
				} else {
					System.out.print("    ");
				}
				isBlack = !isBlack;
			}
			System.out.println();
		}
	}
}
