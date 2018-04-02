/* Cameras today can correct “red eye” problems caused
when the photo flash makes eyes look red. Write pseudo-
code for an algorithm that can detect red eyes. Your input is
a pattern of colors, such as that:

...........   ...........   ...........   ..........   ...........
....RRR....   ....RRR....   ....RRR....   ....RR....   ..R........
...RRRRR...   ...RRRRR...   ...RR*RR...   ...RRRR...   .RRR.......
..RR***RR..   ..RR*RRRR..   ..RR***RR..   ..RR**RR..   RR*RR......
..RR***RR..   ..R***RRR..   ..R*****R..   ..RR**RR..   .RRR.......
..RR***RR..   ..RR*RRRR..   ..RR***RR..   ..RR**RR..   ..R........
...RRRRR...   ...RRRRR...   ...RR*RR...   ...RRRR...   ...........
....RRR....   ....RRR....   ....RRR....   ....RR....   ...........
...........   ...........   ...........   ..........   ...........
    yes           no            yes           no           yes

You are given the number of rows and columns. For any
row or column number, you can query the color, which will
be red, black, or something else. If you find that the center
of the black pixels coincides with the center of the red
pixels, you have found a red eye, and your output should
be “yes”. Otherwise, your output is “no”.
*/

import java.io.*;

public class RedEyeDetector {
	public static void main(String[] args) {
		new RedEyeDetector().go();
	}

	public void go() {
		System.out.print("Choose a pattern [1 - 4]: ");
		int option = readOption();
		Layout[][] pattern = null;
		switch (option) {
			case 1: pattern.fill(DEFAULT_1);
				break;
			case 2: pattern.fill(DEFAULT_2);
				break;
			case 3: pattern.fill(DEFAULT_3);
				break;
			case 4: pattern.fill(DEFAULT_4);
				break;
			default: pattern.fill(DEFAULT_0);
				break;
		}
		System.out.println(hasRedEye(pattern) ? "yes" : "no");
	}

	private int readOption() {
		int option = 0;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (IOException | NullPointerException | NumberFormatException ex) {
			System.err.println("Incorrect input. The result below will correspond to the default pattern.");
		}
		return option;
	}

	private boolean hasRedEye(Layout[][] pattern) {
		int jRdStart = 0;
		int jBkStart = 0;
		int jRdCount = 0;
		int jBkCount = 0;
		int jRdCenter = 0;
		int jBkCenter = 0;
		
		int iRdCenter = 0;
		int iBkCenter = 0;

		for (int i = 1; i < pattern.length; i++) {
			for (int j = 1; j < pattern[i].length; j++) {
				// looking for the horizontal center of the red "pixels"
				if (pattern[i][j - 1] != Layout.RED &&
					pattern[i][j - 1] != Layout.BLACK &&
					pattern[i][j] == Layout.RED) {
					jRdStart = j;
					jRdCount++;
				} else if (pattern[i][i - 1] == Layout.RED &&
					pattern[i][j] == Layout.RED ||
					pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] == Layout.BLACK ||
					pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.BLACK ||
					pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.RED) {
					jRdCount++;
				} else if (pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] != Layout.RED &&
					pattern[i][j] != Layout.BLACK) {
					jRdCenter = jRdStart + jRdCount / 2;
				}
				// looking for the horizontal center of the black "pixels"
				if (pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] == Layout.BLACK) {
					jBkStart = j;
					jBkCount++;
				} else if (pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.BLACK &&
					(jBkStart == 0 || jBkCenter != 0)) {
					jBkCount++;
				} else if (pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.RED &&
					jBkStart != 0 && jBkCount != 0 && jBkCenter == 0) {
					jBkCenter = jBkStart + jBkCount / 2;
				}
			}
		}
	}
}