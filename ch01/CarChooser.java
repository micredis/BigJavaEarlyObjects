/* You have the choice of buying one of two cars. One is more fuel
 * efficient than the other, but also more expensive. You know the
 * price and fuel efficiency (in miles per gallon, mpg) of both cars.
 * You plan to keep the car for ten years. Assume a price of $4 per
 * gallon of gas and usage of 15,000 miles per year. You will pay
 * cash for the car and not worry about financing costs.
 * Which car is the better deal?
*/

import java.io.*;
import java.util.*;

public class CarChooser {
	private ArrayList<Car> cars;
	private int annualMileage;
	private final double PRICE_PER_GALLON = 4.0;
	private final int years = 10;
	private double minTotalCost = Double.MAX_VALUE;
	private Car bestCar;

	public static void main(String[] args) {
		new CarChooser().go();
	}

	public void go() {
		try {
			cars = new ArrayList<Car>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input your annual mileage, miles: ");
			String sAnnualMileage = reader.readLine();
			if (sAnnualMileage.isEmpty() || !sAnnualMileage.matches("\\d+")) {
				System.out.println("Incorrect input");
				return;
			}
			annualMileage = Integer.parseInt(sAnnualMileage);
			System.out.print("Input the car's price: $");
			String sPrice = reader.readLine();
			System.out.print("Input the car's efficiency, mpg: ");
			String sMpg = reader.readLine();
			while(!sPrice.isEmpty() && !sMpg.isEmpty() &&
				sPrice.matches("\\d*(\\.?)\\d*") && sMpg.matches("\\d*(\\.?)\\d*")) {
				cars.add(new Car(Double.valueOf(sPrice), Double.valueOf(sMpg)));
				System.out.print("Input the car's price: $");
				sPrice = reader.readLine();
				System.out.print("Input the car's efficiency, mpg: ");
				sMpg = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bestCar = cars.get(0);
		for(Car car : cars) {
			double annualFuelConsumed = annualMileage / car.getMpg();
			double annualFuelCost = PRICE_PER_GALLON * annualFuelConsumed;
			double operatingCost = years * annualFuelCost;
			double totalCost = car.getPrice() + operatingCost;
			if (totalCost < minTotalCost) {
				minTotalCost = totalCost;
				bestCar = car;
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Assuming a price of $" + PRICE_PER_GALLON + " per gallon of gas");
		System.out.println("and usage of " + annualMileage + " miles per year for " + years + " years,");
		System.out.println("the better deal is the car that costs $" + bestCar.getPrice());
		System.out.println("and has the fuel efficiency of " + bestCar.getMpg() + " mpg");
	}

	class Car {
		private double price;
		private double mpg;

		Car() {
			this.price = 0.0;
			this.mpg = 0.0;
		}

		Car(double price, double mpg) {
			this.price = price;
			this.mpg = mpg;
		}

		void setPrice(double price) {
			this.price = price;
		}

		void setMpg(double mpg) {
			this.mpg = mpg;
		}

		double getPrice() {
			return this.price;
		}

		double getMpg() {
			return this.mpg;
		}
	}
}