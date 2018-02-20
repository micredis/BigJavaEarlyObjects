/* You put $10,000 into a bank account that earns 5 percent interest per year. How many
years does it take for the account balance to be double the original?
*/

import java.io.*;

public class Investment {
	private double balance;
	private double goal;
	private double interest;

	public static void main(String[] args) {
		new Investment().go();
	}

	public void go() {
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input an amount to put in a bank: $");
			balance = Double.valueOf(console.readLine());
			goal = balance * 2.0;
			System.out.print("Input an interest rate, %: ");
			interest = Double.valueOf(console.readLine()) / 100;
			console.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.print("The number of years to double the original amount of $" + balance);
		int year = 0;
		while (balance < goal) {
			balance += balance * interest;
			year++;
		}
		String yearPlural = (year > 1) ? "years" : "year";
		System.out.println(" is " + year + " " + yearPlural);
	}
}