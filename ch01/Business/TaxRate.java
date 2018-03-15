/* In the United States there is no federal sales tax, so every state
may impose its own sales taxes. Look on the Internet for the
sales tax charged in five U.S. states, then write a program that
prints the tax rate for five states of your choice.

Sales Tax Rates
---------------
Alaska:      0%
Hawaii:      4%
. . .

*/

import java.util.*;

public class TaxRate {
	private static final Map<String, Float> taxRates;
	static {
		Map<String, Float> map = new TreeMap<>();
		map.put("California", 8.25f);
		map.put("Washington", 6.5f);
		map.put("Alaska", 0.0f);
		map.put("Texas", 6.25f);
		map.put("New Jersey", 7.0f);
		taxRates = Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		new TaxRate().printRates();
	}

	public void printRates() {
		System.out.format("%14s%n", "Sales Tax Rates");
		System.out.println("-----------------");
		for (Map.Entry<String, Float> state : taxRates.entrySet()) {
			String country = state.getKey() + ":";
			String tax = String.format("%.2f", state.getValue()) + "%";
			System.out.format("%-11s %s%n", country, tax);
		}
	}
}