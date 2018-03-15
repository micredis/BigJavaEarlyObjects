/* Write an algorithm to settle the following question: A bank account starts out with
$10,000. Interest is compounded monthly at 6 percent per year (0.5 percent per
month). Every month, $500 is withdrawn to meet college expenses. After how many
years is the account depleted?
*/

/* Consider the previous question. Suppose the numbers ($10,000, 6 percent,
$500) were user selectable. Are there values for which the algorithm you developed
would not terminate? If so, change the algorithm to make sure it always terminates.
*/

import java.io.*;

public class CollegeAccount {
	private double amount = 10000.0;
	private double yearlyInterestPerCent = 6;
	private double monthlyExpenses = 500.0;
	private final String INCORRECT_INPUT = "Incorrect input. Default values are chosen.";

	public static void main(String[] args) {
		new CollegeAccount().go();
	}

	public void go() {
		readInput();
		double monthlyInterestPerCent = yearlyInterestPerCent / 12;
		int year;
		for (year = 0; amount > monthlyExpenses; year++) {
			amount -= monthlyExpenses;
			double monthlyInterest = amount * monthlyInterestPerCent / 100;
			amount += monthlyInterest;
			System.out.format("Year %d. Account status: $%,.2f. Interest: $%,.2f.%n",
				year, amount, monthlyInterest);
			// in case of ever-growing account, terminate the method
			if (monthlyExpenses < monthlyInterest) {
				System.out.println("Account will never be depleted.");
				return;
			}
		}
		System.out.format("The account is depleted after %d "
			+ ((year == 1) ? "year" : "years") + ".%n", year);
	}

	public void readInput() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input an amount on the account, $");
			amount = Double.valueOf(reader.readLine());
			System.out.print("Input a yearly interest, %: ");
			yearlyInterestPerCent = Double.valueOf(reader.readLine());
			System.out.print("Input monthly college expenses, $");
			monthlyExpenses = Double.valueOf(reader.readLine());
			reader.close();
		} catch (NullPointerException | NumberFormatException | IOException ex) {
			System.out.println(INCORRECT_INPUT);
		}
	}
}