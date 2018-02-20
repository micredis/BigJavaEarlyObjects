/* Give an algorithm for find-
ing the most expen­sive photo.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MostExpensive {
	private double maxPrice;
	private int maxPricePosition = 0;

	public static void main(String[] args) {
		new MostExpensive().go();
	}

	public void go() {
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input a list of prices separated by spaces in the next line:");
			String input = console.readLine();
			if (input.isEmpty()) return;
			String[] prices = input.split(" ");
			console.close();

			maxPrice = (prices.length > 0) ? Double.valueOf(prices[0]) : 0.0;
			for (int i = 1; i < prices.length; i++) {
				if (Double.valueOf(prices[i]) > maxPrice) {
					maxPrice = Double.valueOf(prices[i]);
					maxPricePosition = i;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.print("The photo #" + ++maxPricePosition);
		System.out.println(" is the most expensive one and it costs $" + maxPrice);
	}
}