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
			case 1: pattern = Layout.fill11x9(Layout.DEFAULT_1);
				break;
			case 2: pattern = Layout.fill11x9(Layout.DEFAULT_2);
				break;
			case 3: pattern = Layout.fill10x9(Layout.DEFAULT_3);
				break;
			case 4: pattern = Layout.fill11x9(Layout.DEFAULT_4);
				break;
			default: pattern = Layout.fill11x9(Layout.DEFAULT_0);
				break;
		}
		try {
			printPattern(pattern);
			System.out.println(hasRedEye(pattern) ? "YES" : "NO");
		} catch (NullPointerException ex) {
			System.err.println("pattern is null");
			ex.printStackTrace();
		}
	}

	private int readOption() {
		int option = 0;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (IOException | NullPointerException | NumberFormatException ex) {
			System.err.println("Incorrect input. The result below will correspond to the default pattern:");
		}
		if (option > 4) {
			System.out.println("There's no option #" + option +
				". The result below will correspond to the default pattern:");
		}
		return option;
	}

	private boolean hasRedEye(Layout[][] pattern) {
		int iRdStart = 0;
		int iBkStart = 0;
		int iRdCount = 0;
		int iBkCount = 0;
		int iRdCenter = 0;
		int iBkCenter = 0;
		int iRdCenterMax = 0;
		int iBkCenterMax = 0;
		int jRdCenterPrev = 0;
		int jBkCenterPrev = 0;
		for (int i = 1; i < pattern.length; i++) {
			int jRdStart = 0;
			int jBkStart = 0;
			int jRdCount = 0;
			int jBkCount = 0;
			int jRdCenter = 0;
			int jBkCenter = 0;
			for (int j = 1; j < pattern[i].length; j++) {
				// looking for the horizontal center of the red "pixels"
				if (pattern[i][j - 1] != Layout.RED &&
					pattern[i][j - 1] != Layout.BLACK &&
					pattern[i][j] == Layout.RED &&
					jRdStart == 0) {
					jRdStart = j;
					jRdCount++;
				} else if ((pattern[i][i - 1] == Layout.RED &&
					pattern[i][j] == Layout.RED ||
					pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] == Layout.BLACK ||
					pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.BLACK ||
					pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.RED) &&
					jRdStart != 0 && jRdCount != 0 && jRdCenter == 0) {
					jRdCount++;
				} else if (pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] != Layout.RED &&
					pattern[i][j] != Layout.BLACK &&
					jRdCenter == 0) {
					jRdCenter = jRdStart + jRdCount / 2;
					jRdCenterPrev = jRdCenter;
				}
				// looking for the horizontal center of the black "pixels"
				if (pattern[i][j - 1] == Layout.RED &&
					pattern[i][j] == Layout.BLACK) {
					jBkStart = j;
					jBkCount++;
				} else if (pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.BLACK &&
					jBkStart != 0 && jBkCount != 0 && jBkCenter == 0) {
					jBkCount++;
				} else if (pattern[i][j - 1] == Layout.BLACK &&
					pattern[i][j] == Layout.RED &&
					jBkStart != 0 && jBkCount != 0 && jBkCenter == 0) {
					jBkCenter = jBkStart + jBkCount / 2;
					jBkCenterPrev = jBkCenter;
				}
			}
			// looking for the vertical center of the red "pixels"
			if (jRdCenter != 0 && jBkCenter == 0 && iRdStart == 0) {
				iRdStart = i;
				iRdCount++;
			} else if (jRdCenter != 0 && jBkCenter == 0 && iRdStart != 0 ||
				jRdCenter != 0 && jBkCenter != 0) {
				iRdCount++;
			} else if (jRdCenter == 0 && iRdStart != 0) {
				iRdCenter = iRdStart + iRdCount / 2;
				if (iRdCenter > iRdCenterMax) {
					iRdCenterMax = iRdCenter;
				}
			}
			// looking for the vertical center of the black "pixels"
			if (jBkCenter != 0 && iBkCount == 0 && iBkStart == 0) {
				iBkStart = i;
				iBkCount++;
			} else if (jBkCenter != 0 && iBkCount != 0 && iBkStart != 0) {
				iBkCount++;
			} else if (jBkCenter == 0 && iBkCount != 0 && iBkStart != 0) {
				iBkCenter = iBkStart + iBkCount / 2;
				if (iBkCenter > iBkCenterMax) {
					iBkCenterMax = iBkCenter;
				}
			}
		}
		System.out.println("Coordinates (just for the reference):");
		System.out.println();
		System.out.println("iRdCenter = " + iRdCenterMax);
		System.out.println("iBkCenter = " + iBkCenterMax);
		System.out.println("jRdCenter = " + jRdCenterPrev);
		System.out.println("jBkCenter = " + jBkCenterPrev);
		System.out.println();
		System.out.println("The \"red eye\" has been found, " +
			"i.e. the center of the black pixels coincides with " +
			"the center of the red pixels:");
		return iRdCenterMax == iBkCenterMax && jRdCenterPrev == jBkCenterPrev;
	}

	private void printPattern(Layout[][] pattern) {
		System.out.println();
		for (Layout[] line : pattern) {
			for (Layout l : line) {
				System.out.print(Layout.toString(l));
			}
			System.out.println();
		}
		System.out.println();
	}
}