/* The ancient Babylonians had an algorithm for determining the square root of a num-
ber a. Start with an initial guess of a / 2. Then find the average of your guess g and
a / g. That’s your next guess. Repeat until two consecutive guesses are close enough.
Write pseudocode for this algorithm.
*/

import java.io.*;

public class SquareRootBabylon {

	public static void main(String[] args) {
		new SquareRootBabylon().go();
	}

	public void go() {
		double a = readA();
		while (a < 0) {
			a = readA();
		}
		System.out.format("The square root of %f is %f%n", a, sqrtBab(a));
	}

	// return input from the console as a double if it was a number;
	// return -1 otherwise
	public double readA() {
		double num = -1;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please, input a positive number: ");
			num = Double.parseDouble(reader.readLine());
		} catch (NullPointerException | NumberFormatException | IOException ex) {
		} finally {
			return num;
		}
	}

	// return square root of a number
	public double sqrtBab(double a) {
		double error = 1E-7;
		double g = a / 2;
		while (Math.abs(g - ((g + a / g) / 2)) > error) {
			g = (g + a / g) / 2;
		}
		return g;
	}
}