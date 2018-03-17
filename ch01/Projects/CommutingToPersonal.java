/*You want to find out which fraction of your car’s use is for commuting to work,
and which is for personal use. You know the one-way distance from your home to
work. For a particular period, you recorded the beginning and ending mileage on the
odometer and the number of work days. Write an algorithm to settle this question.
*/

import java.io.*;

public class CommutingToPersonal {
	private int distance;
	private int mileage;
	private int workdays;
	private static final String ERROR_MSG = "Invalid input. The program terminated.";

	public static void main(String[] args) {
		new CommutingToPersonal().go();
	}

	public void go() {
		try {
			System.out.print("Enter the one-way distance from home to work, mls: ");
			this.setDistance(Integer.parseInt(readln()));
			System.out.print("Enter how many miles have been driven overall, mls: ");
			this.setMileage(Integer.parseInt(readln()));
			System.out.print("Enter the number of workdays: ");
			this.setWorkdays(Integer.parseInt(readln()));
		} catch (NumberFormatException ex) {
			System.out.println(ERROR_MSG);
			return;
		}
		double commuteFrac = this.getCommuteFrac();
		// the mileage of commute can't be more than the overall mileage,
		// i.e. the fraction of commute can't be more than 100%
		if (commuteFrac > 100) {
			System.out.println(ERROR_MSG);
			return;
		}
		System.out.println("--------------------------------------------------------");
		System.out.format("Commute to work is %.2f%s%n", this.getCommuteFrac(), "%");
		System.out.format("Personal use is %.2f%s%n", this.getPersonalUseFrac(), "%");
	}

	String readln() {
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
		} catch (IOException | NullPointerException ex) {
			System.out.println(ERROR_MSG);
		}
		return line;
	}

	double getCommuteFrac() {
		double milesComm = 2 * this.getDistance() * this.getWorkdays();
		return milesComm / this.getMileage() * 100;
	}

	double getPersonalUseFrac() {
		return 100 - this.getCommuteFrac();
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setWorkdays(int workdays) {
		this.workdays = workdays;
	}

	public int getDistance() {
		return this.distance;
	}

	public int getMileage() {
		return this.mileage;
	}

	public int getWorkdays() {
		return this.workdays;
	}
}