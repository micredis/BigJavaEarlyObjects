/* Consider a robot that is placed in a room. The robot can:
•	 Move forward by one unit.
•	 Turn left or right.
•	 Sense what is in front of it: a wall, a window, or neither.

Write an algorithm that enables the robot, placed anywhere in
the room, to count the number of windows. For example, in the
room below, the robot (marked as R) should find that it has
two windows.

XXX::XXXXXXX
X          X
X          X
X          X
X          X
X          X
X          :
X  R       :
X          X
X          X
XXXXXXXXXXXX

*/

public class RobotWindowCounterTester {
	public static void main(String[] args) throws InterruptedException {
		if (args.length != 4) {
			System.err.println("Usage: java RobotWindowCounterTester <room_width> <room_height> <robot_x_coord> <robot_y_coord>");
			System.exit(-1);
		}
		int roomWidth = 3;
		int roomHeight = 3;
		int robotInitPosX = 1;
		int robotInitPosY = 1;
		try {
			roomWidth = Integer.parseInt(args[0]);
			roomHeight = Integer.parseInt(args[1]);
			robotInitPosX = Integer.parseInt(args[2]);
			robotInitPosY = Integer.parseInt(args[3]);
		} catch (NumberFormatException ex) {
			System.err.println("Must be integers: <room_width> <room_height> <robot_x_coord> <robot_y_coord>");
			System.exit(-1);
		}
		Layout[][] roomPlan = Room.generateRoomPlan(roomWidth, roomHeight);
		// if there's no place for the robot
		if (roomWidth < 3 || roomHeight < 3) {
			printRoom(roomPlan);
			return;
		}
		// if the robot's coordinates are out of the floor
		if (robotInitPosX <= 0 || robotInitPosX >= roomWidth - 1 ||
			robotInitPosY <= 0 || robotInitPosY >= roomHeight - 1) {
			printRoom(roomPlan);
			System.out.println("Error: Robot's position is out of bounds of the floor");
		}
		// place the robot in the room
		Robot robot = new Robot(robotInitPosX, robotInitPosY);
		roomPlan[robotInitPosY][robotInitPosX] = Layout.ROBOT;
		// move the robot to the right border
		while (robot.getX() < roomWidth - 2) {
			makeMove(robot, roomPlan);
		}
		int windowsCount = 0;
		boolean isWindowContinue = false;
		int perimeterUnits = 2 * (roomWidth + roomHeight - 2);
		// move along the wall until all the units of the perimeter are bypassed
		while (perimeterUnits > 0) {
			Layout nextUnit = robot.nextUnit(roomPlan);
			if (nextUnit == Layout.FLOOR) {
				isWindowContinue = false;
				makeMove(robot, roomPlan);
				robot.turnRight();
			} else if (nextUnit == Layout.WALL) {
				isWindowContinue = false;
				robot.turnLeft();
				perimeterUnits--;
			} else if (nextUnit == Layout.WINDOW && !isWindowContinue) {
				isWindowContinue = true;
				windowsCount++;
				robot.turnLeft();
				perimeterUnits--;
			} else if (nextUnit == Layout.WINDOW) {
				isWindowContinue = true;
				robot.turnLeft();
				perimeterUnits--;
			}
		}
		System.out.println("The number of windows is " + windowsCount);
	}

	private static void makeMove(Robot robot, Layout[][] roomPlan) throws InterruptedException {
		roomPlan[robot.getY()][robot.getX()] = Layout.FLOOR;
		robot.move();
		roomPlan[robot.getY()][robot.getX()] = Layout.ROBOT;
		printRoom(roomPlan);
		Thread.sleep(80);
	}

	private static void printRoom(Layout[][] roomPlan) {
		System.out.println();
		for (Layout[] line : roomPlan) {
			for (Layout l : line) {
				System.out.print(Layout.toString(l));
			}
			System.out.println();
		}
		System.out.println();
	}
}