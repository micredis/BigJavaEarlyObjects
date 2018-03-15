/* Write a program that prints the product of the
 * first ten positive integers, 1 × 2 × ... × 10.
 * (Use * to indicate multiplication in Java.)
 */

public class Product {
	public static void main(String[] args) {
		System.out.println(new Product().prod(1, 10));
		System.out.println(new Product().prod(-10, -1));
	}

	public long prod(int bottom, int top) {
		if (bottom == top) return bottom;
		return prod(bottom, top - 1) * top;
	}
}