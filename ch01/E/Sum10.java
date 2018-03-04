/* Write a program that prints the sum of the
 * first ten positive integers, 1 + 2 + ... + 10.
 */

public class Sum10 {

	public static void main(String[] args) {
		System.out.println(new Sum10().sum(10));
		System.out.println(new Sum10().sumRecur(10));
	}

	public int sum(int lim) {
		int sm = 0;
		for (int i = 1; i <= lim; i++) {
			sm += i;
		}
		return sm;
	}

	public int sumRecur(int lim) {
		if (lim == 0) return 0;
		return sumRecur(lim - 1) + lim;
	}
}