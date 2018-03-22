/*  Write an algorithm that allows a robot R to mow a rectangular
lawn, provided it has been placed in a corner, like this:

XXXXXXXXXXXX
X::::::::::X
X::::::::::X
X::::::::::X
X::::::::::X
X::::::::::X
X::::::::::X
XR:::::::::X
XXXXXXXXXXXX

The robot can:
•	 Move forward by one unit.
•	 Turn left or right.
•	 Sense the color of the ground one unit in front of it.
*/

public class RobotMowerTester {
	private static int lawnWidth;
	private static int lawnHeight;

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 2) {
			System.err.println("Usage: java RobotMowerTester <lawn_width> <lawn_height>");
			System.exit(-1);
		}
		try {
			lawnWidth = Integer.parseInt(args[0]);
			lawnHeight = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex) {
			System.err.println("Must be integers: <lawn_width> <lawn_height>");
			System.exit(-1);
		}
		Lawn lawn = new Lawn(lawnWidth, lawnHeight);
		// if there's no place for the robot
		if (lawnWidth < 3 || lawnHeight < 3) {
			lawn.printField();
			return;
		}
		// place the robot in the bottom left corner
		Robot robot = new Robot(1, lawnHeight - 2);
		lawn.setMower(robot.getX(), robot.getY());
		// initial number of grassUnits is
		// (unitsOverall - unitsOfPerimeter)
		int grassUnits = lawnWidth * lawnHeight - 2 * (lawnWidth + lawnHeight - 2);
		// mow the lawn until only the borders and the robot (1) is left
		while (grassUnits > 1) {
			Layout nextUnit = robot.nextUnit(lawn.getField());
			if (nextUnit == Layout.GRASS) {
				makeMove(robot, lawn);
				grassUnits--;
			} else {
				robot.turnLeft();
			}
		}

		/*String b = Layout.toString(Layout.BORDER);
		System.out.println("The symbol of the border is: " + b);*/
		
		/*for (Layout l : Layout.values()) {
			System.out.println(l);
		}*/
	}

	private static void makeMove(Robot robot, Lawn lawn) throws InterruptedException {
		lawn.mow(robot.getX(), robot.getY());
		robot.move();
		lawn.setMower(robot.getX(), robot.getY());
		lawn.printField();
		Thread.sleep(40);
	}
}