/* In order to estimate the cost of painting a house, a painter needs to know the surface
area of the exterior. Develop an algorithm for computing that value. Your inputs are
the width, length, and height of the house, the number of windows and doors, and
their dimensions. (Assume the windows and doors have a uniform size.)
*/

import java.io.*;

public class SurfaceArea {
	private String[] houseDimensions;
	private String[] aperturesNumber;
	private String[] windowDimensions;
	private String[] doorDimensions;

	public static void main(String[] args) {
		new SurfaceArea().go();
	}

	public void go() {
		readData();
		try {
			double width = Double.parseDouble(houseDimensions[0]);
			double length = Double.parseDouble(houseDimensions[1]);
			double height = Double.parseDouble(houseDimensions[2]);
			int numWindows = Integer.parseInt(aperturesNumber[0]);
			int numDoors = Integer.parseInt(aperturesNumber[1]);
			double wWidth = Double.parseDouble(windowDimensions[0]);
			double wHeight = Double.parseDouble(windowDimensions[1]);
			double dWidth = Double.parseDouble(doorDimensions[0]);
			double dHeight = Double.parseDouble(doorDimensions[1]);
			House house = new House(width, length, height,
				numWindows, numDoors,
				new Window(wWidth, wHeight), new Door(dWidth, dHeight));
			System.out.format("The surface area of the exterior is %,f m^2%n",
				house.getSurfaceArea());
		} catch (NullPointerException | NumberFormatException ex) {
			System.out.println("Incorrect input. Terminate.");
		}
	}

	public void readData() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the width, the length and the height " + "of a house separated by spaces, m: ");
			houseDimensions = reader.readLine().split(" ");
			System.out.println("Enter the number of windows and doors " + "separated by the space: ");
			aperturesNumber = reader.readLine().split(" ");
			System.out.println("Enter the standard window dimensions " + "separated by the space, m x m: ");
			windowDimensions = reader.readLine().split(" ");
			System.out.println("Enter the standard door dimensions " + "separated by the space, m x m: ");
			doorDimensions = reader.readLine().split(" ");
			reader.close();
		} catch (IOException ex) {
			System.out.println("Incorrect input. Terminate.");
		}
	}

	class House {
		private double width;
		private double length;
		private double height;
		private int numWindows;
		private int numDoors;
		private Window window;
		private Door door;

		House(double width, double length, double height,
			int numWindows, int numDoors,
			Window window, Door door) {
			this.width = width;
			this.length = length;
			this.height = height;
			this.numWindows = numWindows;
			this.numDoors = numDoors;
			this.window = window;
			this.door = door;
		}

		double getSurfaceArea() {
			double overalHouseSA = 2 * (width * height + 
				width * length + length * height);
			double windowsSA = numWindows * window.getSurfaceArea();
			double doorsSA = numDoors * door.getSurfaceArea();
			return (overalHouseSA - windowsSA - doorsSA);
		}
	}

	class Window {
		private double wWidth;
		private double wHeight;

		Window(double width, double height) {
			this.wWidth = width;
			this.wHeight = height;
		}

		double getSurfaceArea() {
			return (this.wWidth * this.wHeight);
		}
	}

	class Door {
		private double dWidth;
		private double dHeight;

		Door(double width, double height) {
			this.dWidth = width;
			this.dHeight = height;
		}

		double getSurfaceArea() {
			return (this.dWidth * this.dHeight);
		}
	}
}