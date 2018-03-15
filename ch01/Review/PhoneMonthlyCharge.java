/* Suppose your cell phone carrier charges you $29.95 for up to 300 minutes of
calls, and $0.45 for each additional minute, plus 12.5 percent taxes and fees. Give
an algorithm to compute the monthly charge from a given number of minutes.
*/

import java.io.*;

public class PhoneMonthlyCharge {
	private final double BASE_FEE = 29.95;
	private final int FREE_MINUTES = 300;
	private final double MINUTE_PRICE = 0.45;
	private final double TAXES = 0.125;
	private int minutesCount;

	public static void main(String[] args) {
		new PhoneMonthlyCharge().go();
	}

	public void go() {
		System.out.print("Input a number of minutes: ");
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			minutesCount = Integer.parseInt(console.readLine());
			console.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int nonFreeMinutes = (minutesCount > FREE_MINUTES) ? (minutesCount - FREE_MINUTES) : 0;
		double totalNoTaxes = nonFreeMinutes * MINUTE_PRICE + BASE_FEE;
		double total = totalNoTaxes * (1 + TAXES);
		System.out.println("Base fee: $" + BASE_FEE);
		System.out.print("Paid minutes: " + nonFreeMinutes + " min * " + MINUTE_PRICE + " $/min = $");
		System.out.println(nonFreeMinutes * MINUTE_PRICE);
		System.out.print("Taxes & fees, %" + ((double) TAXES * 100) + ": $");
		System.out.println(totalNoTaxes * TAXES);
		System.out.println("TOTAL PRICE: $" + total);
	}
}