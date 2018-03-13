/* Write a program that prints a two-column list of your friends’ birthdays. In the first
column, print the names of your best friends; in the second, print their birthdays.
*/

import java.util.*;

public class FriendsList {
	//private Map<String, 
	public static void main(String[] args) {
		//new FriendsList().printFriendsList(Alice, Bob, Charlie);
		Calendar birthday = new GregorianCalendar();
		System.out.println(birthday.get(Calendar.YEAR) + "-"
			+ (int) (birthday.get(Calendar.MONTH) + 1) + "-" + birthday.get(Calendar.DATE));
	}
}