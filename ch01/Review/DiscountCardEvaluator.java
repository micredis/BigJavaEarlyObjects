/* The cafeteria offers a discount card for sale that entitles you, during a certain period,
to a free meal whenever you have bought a given number of meals at the regular
price. The exact details of the offer change from time to time. Describe an algorithm
that lets you determine whether a particular offer is a good buy. What other inputs
do you need?
*/

import java.io.*;

public class DiscountCardEvaluator {
	private String[] cardParameters;
	private String sDays;
	private String sMealsPerDay;

	public static void main(String[] args) {
		new DiscountCardEvaluator().go();
	}

	public void go() {
		readData();
		double crdPrice = 0.0; // the discount card price
		int dsValid = 0; // the number of days when the card is valid
		double mlPrice = 0.0; // the meal price
		int mlsThreshold = 0; // how many meals you have to buy to get a free one
		int days = 0; // the number of days to buy meals at the cafeteria
		int mealsPerDay = 0; // the average number of meals you buy every day
		try {
			crdPrice = Double.parseDouble(cardParameters[0]);
			dsValid = Integer.parseInt(cardParameters[1]);
			mlPrice = Double.parseDouble(cardParameters[2]);
			mlsThreshold = Integer.parseInt(cardParameters[3]);
			days = Integer.parseInt(sDays);
			mealsPerDay = Integer.parseInt(sMealsPerDay);
		} catch (NullPointerException | NumberFormatException ex) {
			System.out.println("Incorrect input data. Program terminate.");
			return;
		}
		int daysEffective;
		int daysNotEffective;
		if (dsValid < days) {
			daysEffective = dsValid;
			daysNotEffective = days - dsValid;
		} else {
			daysEffective = days;
			daysNotEffective = 0;
		}
		double sumNoCard = mlPrice * mealsPerDay * days;
		double sumYesCard = mlPrice * (mealsPerDay - mealsPerDay / (mlsThreshold + 1)) * daysEffective
			+ mlPrice * mealsPerDay * daysNotEffective + crdPrice;
		String result = (sumNoCard < sumYesCard) ? "not a good buy"
			: (sumNoCard > sumYesCard) ? "a good buy" : "optional";
		System.out.println("-------------------------------------------------------------------------");
		System.out.format("If you buy a discount card, you would spend $%,.2f, and%n", sumYesCard);
		System.out.format("if you DO NOT buy a discount card, you would spend $%,.2f,%n", sumNoCard);
		System.out.format("which means that the card is %s.%n", result);
	}

	public void readData() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a discount card parameters, separated by commas with spaces in this order:");
			System.out.println("card price, days valid, meal price, number of meals to buy to get one for free");
			this.cardParameters = reader.readLine().split(", ");
			System.out.print("Enter the number of days you are going to buy meals at the cafeteria: ");
			this.sDays = reader.readLine();
			System.out.print("Enter the average number of meals you buy every day: ");
			this.sMealsPerDay = reader.readLine();
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// this class is redundant
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