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

public class RobotWindowsCounterTester {
	public static void main(String[] args) {
		Layout[][] roomPlan = Room.generateRoom(12, 11);
		for (Layout[] line : roomPlan) {
			for (Layout l : line) {
				System.out.print(Layout.toString(l));
			}
			System.out.println();
		}
	}
}