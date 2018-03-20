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
		String[][] field = lawn.getField();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
}