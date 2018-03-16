/* The value of π can be computed according to the following formula:

π       1   1   1   1
- = 1 - - + - - - + - - ...
4       3   5   7   9

Write an algorithm to compute π. Because the formula is an infinite series and an
algorithm must stop after a finite number of steps, you should stop when you have
the result determined to six significant dig­its.
*/

public class Pi {
	private static double error = 1E-6;

	public static void main(String[] args) {
		Pi.printPi();
	}

	public static void printPi() {
		System.out.format("%.6f%n", getPi());
	}

	public static double getPi() {
		double num = -1;
		int denom = 3;
		double delta = num / denom;
		double approx = 1 + delta;
		while (4 * Math.abs(delta) > error) {
			num *= (-1);
			denom += 2;
			delta = num / denom;
			approx += delta;
		}
		return 4 * approx;
	}
}