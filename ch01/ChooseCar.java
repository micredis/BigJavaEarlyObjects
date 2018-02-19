import java.io.*;
import java.util.*;

public class ChooseCar {
	private ArrayList<Car> cars;
	private annualMileage;

	public static void main(String[] args) {
		new ChooseCar().go();
	}

	public void go() {
		try {
			cars = new ArrayList<Car>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input your annual mileage, miles: ");
			annualMileage = reader.readLine();
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
		for(Car car : cars) {
			//double annualFuelConsumed = 
		}
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