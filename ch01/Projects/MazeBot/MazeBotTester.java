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

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
X.................X........X......X
X..X.....X.....................X..X
XXXXXXXXXXXXXXX.XXXXXX.XXXXXXXXXX.X
X....X...X........X......X.....X..X
X........X........X............X..X
 ....X...XXXXX.XXXXXXXXXXXX.XXXXXXX
X....X...X........X...X........X..X
XXXXXXX.XXXXXXXX.XX...XXXXXXXX....X
X ................X............X.. 
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

*/

public class MazeBotTester {
	public static void main(String[] args) throws InterruptedException {
		Layout[][] maze = Maze.getDefaultMaze();
		int entranceRow = getEntranceCoord(maze);
		Robot robot = new Robot(0, entranceRow);
		placeRobotAtEntrance(robot, maze);
	}

	// find a gap at the leftmost column of a maze
	// and return the number of its row,
	// assuming that there's just one entrance point
	private static int getEntranceCoord(Layout[][] maze) {
		int i = 0;
		for (; i < maze.length; i++) {
			if (maze[i][0] == Layout.EXIT) {
				return i;
			}
		}
		return i;
	}

	private static void placeRobotAtEntrance(Robot robot, Layout[][] maze) {
		maze[robot.getY()][robot.getX()] = Layout.ROBOT;
		printRoom(maze);
	}

	private static void makeMove(Robot robot, Layout[][] maze) throws InterruptedException {
		maze[robot.getY()][robot.getX()] = Layout.FLOOR;
		robot.move();
		maze[robot.getY()][robot.getX()] = Layout.ROBOT;
		printRoom(maze);
		Thread.sleep(80);
	}

	private static void printRoom(Layout[][] maze) {
		System.out.println();
		for (Layout[] line : maze) {
			for (Layout l : line) {
				System.out.print(Layout.toString(l));
			}
			System.out.println();
		}
		System.out.println();
	}
}