/* Consider a robot that has been placed in a maze. The right-hand rule
tells you how to escape from a maze: Always have the right hand next to
a wall, and eventually you will find an exit. The robot can:
•	 Move forward by one unit.
•	 Turn left or right.
•	 Sense what is in front of it: a wall, an exit, or neither.
Write an algorithm that lets the robot escape the maze. You may assume
that there is an exit that is reachable by the right-hand rule. Your
challenge is to deal with situations in which the path turns. The robot
can’t see turns. It can only see what is directly in front of it.
*/

public class MazeBotTester {
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
			return;
		}
		// place the robot in the room
		Robot robot = new Robot(robotInitPosX, robotInitPosY);
		roomPlan[robotInitPosY][robotInitPosX] = Layout.ROBOT;
		printRoom(roomPlan);
		// if the robot is not in a corner or at a border,
		// move it to the right border
		if (robotInitPosX != 1 && robotInitPosX != roomWidth - 2 &&
			robotInitPosY != 1 && robotInitPosY != roomHeight - 2) {
			while (robot.getX() < roomWidth - 2) {
				makeMove(robot, roomPlan);
			}
		}
		// face the robot left if it's in the top row
		// or in the first left column except if it's
		// in the top right corner or in the bottom
		// left corner
		if (robotInitPosY == 1 && robotInitPosX != roomWidth - 2 ||
			robotInitPosX == 1 && robotInitPosY != roomHeight - 2) {
			robot.turnLeft();
			robot.turnLeft();
		}
		// face the robot up if it's in the top right corner
		if (robotInitPosY == 1 && robotInitPosX == roomWidth - 2) {
			robot.turnLeft();
		}
		Layout nextUnit = robot.nextUnit(roomPlan);
		Layout firstUnit = nextUnit;
		int windowsCount = 0;
		boolean isWindowContinue = false;
		int perimeterUnits = 2 * (roomWidth + roomHeight - 2);
		// move counterclockwise along the wall
		// until all the units of the inside
		// perimeter (perimeterUnits - 4 corner units) are traversed
		while (perimeterUnits > 4) {
			nextUnit = robot.nextUnit(roomPlan);
			if (nextUnit == Layout.FLOOR) {
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
		printRoom(roomPlan);
		// we must not count the first window twice if it's long
		// and we've started and finished traversing at its middle
		if (firstUnit == Layout.WINDOW && nextUnit == Layout.WINDOW) {
			windowsCount--;
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