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
		// mow the lawn
		int untreatedLawnArea = lawnWidth * lawnHeight;
		// TODO: replace 0 with perimeter?
		while (untreatedLawnArea > 0) {
			Layout nextUnit = robot.nextUnit(lawn.getField());
			if (nextUnit == Layout.GRASS) {
				lawn.mow(robot.getX(), robot.getY());
				robot.move();
				lawn.setMower(robot.getX(), robot.getY());
			}
			untreatedLawnArea--;
		}
		/*System.out.println("Initial state of the field:");
		lawn.printField();
		// Thread.sleep(500);
		
		lawn.mow(robot.getX(), robot.getY());
		robot.move();
		lawn.setMower(robot.getX(), robot.getY());
		//
		System.out.println("After using a robot:");
		lawn.printField();
		System.out.println(Layout.BORDER == lawn.getField()[1][1]);
		System.out.println(robot.nextUnit(lawn.getField()));
		robot.turnRight();
		System.out.println(robot.nextUnit(lawn.getField()));
		robot.turnRight();
		System.out.println(robot.nextUnit(lawn.getField()));*/
		/*String b = Layout.toString(Layout.BORDER);
		System.out.println("The symbol of the border is: " + b);*/
		/*for (Layout l : Layout.values()) {
			System.out.println(l);
		}*/
	}
}