/* You want to decide whether you should drive your car to work or take the train.
You know the one-way distance from your home to your place of work, and the
fuel efficiency of your car (in miles per gallon). You also know the one-way price
of a train ticket. You assume the cost of gas at $4 per gallon, and car maintenance at
5 cents per mile. Write an algorithm to decide which commute is cheaper.
*/

import java.io.*;

public class CheaperCommute {
	private double distance;
	// fuel efficiency (miles per gallon)
	private double mpg;
	private double ticketPrice;
	private double gallonPrice;
	// car's maintenance per mile
	private double maintenancePerMile;

	public static void main(String[] args) {
		new CheaperCommute().go();
	}

	public void go() {
		loadParam();
		Double drivePrice = getDrivePrice();
		Double tcktPrice = getTicketPrice();
		System.out.format("Estimated expenditures: $%.2f by train and $%.2f by car.%n",
			tcktPrice, drivePrice);
		if (tcktPrice > drivePrice) {
			System.out.println("Drive the car.");
		} else if (tcktPrice < drivePrice) {
			System.out.println("Take the train.");
		} else {
			System.out.println("You may either take the train or drive the car.");
		}
	}

	public void loadParam() {
		try {
			System.out.print("Enter the one-way distance, mls: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			setDistance(Double.parseDouble(reader.readLine()));
			System.out.print("Enter the car's fuel efficiency, mpg: ");
			setMpg(Double.parseDouble(reader.readLine()));
			System.out.print("Enter the one-way price of a train ticket: $");
			setTicketPrice(Double.parseDouble(reader.readLine()));
			setGasPrice(4.0);
			System.out.format("Gas price is $%.2f per gallon%n", gallonPrice);
			setCarMaintenance(0.05);
			System.out.format("Car maintenance is $%.2f per mile%n", maintenancePerMile);
		} catch (NullPointerException | IOException | NumberFormatException ex) {
			System.out.println("Incorrect input. Terminate program.");
		}
	}

	public double getDrivePrice() {
		double glnPrice = getGasPrice();
		double dstnc = getDistance();
		double effic = getMpg();
		double maintPerMile = getCarMaintenance();
		double fuelPrice = glnPrice * dstnc / effic;
		double maintenancePrice = dstnc * maintPerMile;
		return fuelPrice + maintenancePrice;
	}

	public double getDistance() {
		return this.distance;
	}

	public double getMpg() {
		return this.mpg;
	}

	public double getTicketPrice() {
		return this.ticketPrice;
	}

	public double getGasPrice() {
		return this.gallonPrice;
	}

	public double getCarMaintenance() {
		return this.maintenancePerMile;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setMpg(double mpg) {
		this.mpg = mpg;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public void setGasPrice(double gallonPrice) {
		this.gallonPrice = gallonPrice;
	}

	public void setCarMaintenance(double maintenancePerMile) {
		this.maintenancePerMile = maintenancePerMile;
	}
}