/* Write a program that prints the balance of an account after the first, second, and third
year. The account has an initial balance of $1,000 and earns 5 percent interest per year.
*/

public class Balance3Test {
	private double balance = 1000.0;
	private double interest = 0.05;
	private int yearsTotal = 3;

	public static void main(String[] args) {
		new Balance3Test().go();
	}

	public void go() {
		System.out.format("Initial balance: $%.2f%n", this.balance);
		for (int year = 1; year <= this.yearsTotal; year++) {
			this.balance += this.balance * this.interest;
			System.out.format("Year: %2d. Balance: $%.2f%n", year, this.balance);
		}
	}
}