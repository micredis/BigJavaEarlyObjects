/* Write a program that prints a two-column list of your friends’ birthdays. In the first
column, print the names of your best friends; in the second, print their birthdays.
*/

import java.util.*;

public class FriendsList {
	private static final Map<String, Calendar> friends;
	static {
		Map<String, Calendar> map = new TreeMap<>();
		map.put("Alice", new GregorianCalendar(1980, 0, 15));
		map.put("Bob", new GregorianCalendar(1977, 1, 27));
		map.put("Charlie", new GregorianCalendar(1982, 5, 30));
		friends = Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		new FriendsList().printFriendsList(friends);
	}

	public void printFriendsList(Map<String, Calendar> friends) {
		System.out.format("%20s | BIRTHDAY%n", "NAME");
		System.out.println("-------------------------------");
		for (Map.Entry<String, Calendar> friend : friends.entrySet()) {
			String name = friend.getKey();
			Calendar dob = friend.getValue();
			System.out.format("%20s | %tD%n", name, dob);
		}
	}
}