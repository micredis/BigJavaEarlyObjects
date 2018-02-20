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
		for (int i = 0; i < height; i += 4) {
			for (int j = 0; j < width; j++) {
				if (isBlack) {
					System.out.print("xxxx");
					isBlack = false;
				} else {
					System.out.print("    ");
					isBlack = true;
				}
			}
			System.out.println();
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

	/*public void printBlackTile() {
		System.out.println("xxxx");
		System.out.println("xxxx");
		System.out.println("xxxx");
		System.out.println("xxxx");		
	}

	public void printWhiteTile() {
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");		
	}*/
}
