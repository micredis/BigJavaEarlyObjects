/* Imagine that you and a number of friends go to a luxury restaurant, and when you
ask for the bill you want to split the amount and the tip (15 percent) between all.
Write pseudocode for calculating the amount of money that everyone has to pay.
Your program should print the amount of the bill, the tip, the total cost, and the
amount each person has to pay. It should also print how much of what each person
pays is for the bill and for the tip.
*/

import java.io.*;

public class SplitTheBill {
	private double billAmount;
	private double tipFrac;
	private int numPeople;
	private static final String FORMAT = "%25s : $%7.2f%n";

	public static void main(String[] args) {
		new SplitTheBill().go();
	}

	public void go() {
		if (this.readData() > 0) {
			System.out.println();
			this.printBill();
		}
	}

	// read data and initialize fields;
	// return 1 if all fields initialized correctly;
	// return -1 otherwise
	public int readData() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Bill amount: $");
			this.billAmount = Double.parseDouble(reader.readLine());
			System.out.print("Tip, %: ");
			this.tipFrac = Double.parseDouble(reader.readLine()) / 100;
			System.out.print("Number of friends: ");
			this.numPeople = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (IOException | NullPointerException | NumberFormatException ex) {
			System.out.println("Invalid input. Program terminated.");
			return (-1);
		}
		return 1;
	}

	public void printBill() {
		double tip = this.tipFrac * this.billAmount;
		double total = billAmount + tip;
		double totalPerPerson = (this.numPeople > 0) ? total / this.numPeople : total;
		double billPerPerson = (this.numPeople > 0) ? billAmount / this.numPeople : billAmount;
		double tipPerPerson = (this.numPeople > 0) ? tip / this.numPeople : tip;
		System.out.format(FORMAT, "A m o u n t", billAmount);
		System.out.format(FORMAT, "T i p", tip);
		System.out.format(FORMAT, "T O T A L  C O S T", total);
		System.out.println(" ------------------------------------");
		System.out.format(FORMAT, "Amount (per person)", billPerPerson);
		System.out.format(FORMAT, "Tip (per person)", tipPerPerson);
		System.out.format(FORMAT, "TOTAL COST (per person)", totalPerPerson);
	}
}