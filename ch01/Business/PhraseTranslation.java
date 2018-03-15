/* To speak more than one language is a valuable skill in the labor market
today. One of the basic skills is learning to greet people. Write a program
that prints a two-column list with the greeting phrases shown in the table.
In the first column, print the phrase in English, in the second column,
print the phrase in a language of your choice. If you don’t speak a
language other than English, use an online translator or ask a friend.

List of Phrases to Translate
----------------------------
Good morning.
It is a pleasure to meet you.
Please call me tomorrow.
Have a nice day!

*/

import java.util.*;

public class PhraseTranslation {
	private static final Map<String, String> phrases;
	static {
		Map<String, String> map = new HashMap<>();
		map.put("Good morning.", "Доброе утро.");
		map.put("It is a pleasure to meet you.", "Приятно познакомиться.");
		map.put("Please call me tomorrow.", "Пожалуйста, позвоните мне завтра.");
		map.put("Have a nice day!", "Хорошего дня!");
		phrases = Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		System.out.format("%35s | TRANSLATION%n", "PHRASE");
		System.out.println("------------------------------------|" + 
			"-----------------------------------");
		for (Map.Entry<String, String> phrase : phrases.entrySet()) {
			System.out.format("%35s | %s%n", phrase.getKey(), phrase.getValue());
		}
	}
}