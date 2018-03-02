/* The cafeteria offers a discount card for sale that entitles you, during a certain period,
to a free meal whenever you have bought a given number of meals at the regular
price. The exact details of the offer change from time to time. Describe an algorithm
that lets you determine whether a particular offer is a good buy. What other inputs
do you need?
*/

import java.io.*;

public class DiscoutCardEvaluator {
	private String[] cardParameters;
	private String sDays;
	private String sMealsPerDay;

	public static void main(String[] args) {
		new DiscoutCardEvaluator().go();
	}

	public void go() {
		readData();
		double crdPrice; // the discount card price
		int dsValid; // the number of days when the card is valid
		double mlPrice; // the meal price
		int mlsThreshold; // how many meals you have to buy to get a free one
		int days; // the number of days to buy meals at the cafeteria
		int mealsPerDay; // the average number of meals you buy every day
		try {
			crdPrice = Double.parseDouble(cardParameters[0]);
			dsValid = Integer.parseInt(cardParameters[1]);
			mlPrice = Double.parseDouble(cardParameters[2]);
			mlsThreshold = Integer.parseInt(cardParameters[3]);
			days = Integer.parseInt(sDays);
			mealsPerDay = Integer.parseInt(sMealsPerDay);
		} catch (NullPointerException | NumberFormatException ex) {
			System.out.println("Incorrect input data. Program terminate.");
		}
		int daysEfective = (dsValid < days) ? (days - dsValid) : days;
		double noCardExpenditures = mlPrice * mealsPerDay * days;
		
	}

	public readData() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a discount card parameters, separated by commas with spaces in this order:");
			System.out.println("card price, days valid, meal price, number of meals to buy to get one for free");
			cardParameters = reader.readLine().split(", ");
			System.out.print("Enter the number of days you are going to buy meals at the cafeteria: ");
			String sDays = reader.readLine();
			System.out.print("Enter the average number of meals you buy every day: ");
			String sMealsPerDay = reader.readLine();
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	class DiscountCard {
		private double cardPrice;
		private int daysValid;
		private double mealPrice;
		private int mealsThreshold;  // how many meals you have to buy to get a free one

		DiscountCard() {
			this.cardPrice = 0.0;
			this.daysValid = 0;
			this.mealPrice = 0.0;
			this.mealsThreshold = 0;
		}

		DiscountCard(double cardPrice, int daysValid,
			double mealPrice, int mealsThreshold) {
			this.cardPrice = cardPrice;
			this.daysValid = daysValid;
			this.mealPrice = mealPrice;
			this.mealsThreshold = mealsThreshold;
		}

		void setCardPrice(double cardPrice) {
			this.cardPrice = cardPrice;
		}

		double getCardPrice() {
			return this.cardPrice;
		}

		void setDaysValid(int daysValid) {
			this.daysValid = daysValid;
		}

		int getDaysValid() {
			return this.daysValid;
		}

		void setMealPrice(double mealPrice) {
			this.mealPrice = mealPrice;
		}

		double getMealPrice() {
			return this.mealPrice;
		}

		void setMealsThreshold(int mealsThreshold) {
			this.mealsThreshold = mealsThreshold;
		}

		int getMealsThreshold() {
			return this.mealsThreshold;
		}
	}
}