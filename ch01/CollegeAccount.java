/* Write an algorithm to settle the following question: A bank account starts out with
$10,000. Interest is compounded monthly at 6 percent per year (0.5 percent per
month). Every month, $500 is withdrawn to meet college expenses. After how many
years is the account depleted?
*/

public class CollegeAccount {
	private double amount = 10000.0;
	private final double yearlyInterestPerCent = 6;
	private final double monthlyExpenses = 500.0;

	public static void main(String[] args) {
		new CollegeAccount().go();
	}

	public void go() {
		double monthlyInterestPerCent = yearlyInterestPerCent / 12;
		int year;
		for (year = 0; amount > monthlyExpenses; year++) {
			amount -= monthlyExpenses;
			double monthlyInterest = amount * monthlyInterestPerCent / 100;
			amount += monthlyInterest;
			System.out.format("Year %d. Account status: $%,.2f. Interest: $%,.2f.%n",
				year, amount, monthlyInterest);
		}
		System.out.format("The account is depleted after %d "
			+ ((year == 1) ? "year" : "years") + ".%n", year);
	}
}