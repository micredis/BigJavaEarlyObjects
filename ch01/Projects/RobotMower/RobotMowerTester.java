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
	public static void main(String[] args) {
		Lawn lawn = new Lawn(12, 9);
		Robot robot = new Robot(1, 7);
		lawn.setMower(robot.getX(), robot.getY());
		System.out.println("Initial state of the field:");
		lawn.printField();
		//
		lawn.mow(robot.getX(), robot.getY());
		robot.move();
		lawn.setMower(robot.getX(), robot.getY());
		//
		System.out.println("After using a robot:");
		lawn.printField();
		System.out.println(Layout.BORDER == lawn.getField()[1][1]);
		/*String b = Layout.toString(Layout.BORDER);
		System.out.println("The symbol of the border is: " + b);*/
		/*for (Layout l : Layout.values()) {
			System.out.println(l);
		}*/
	}

	static void printField(String[][] field) {
		System.out.println();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}