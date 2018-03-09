/* Write a program that prints an animal speaking a greeting, similar to (but different
from) the following:

 /\_/\     -----
( ' ' )  / Hello \
(  -  ) <  Junior |
 | | |   \ Coder!/
(__|__)    -----



*/

import java.io.*;

public class AnimalGreeting {
	public static void main(String[] args) {
		new AnimalGreeting().go();
	}

	public void go() {
		System.out.println("Enter a short message: ");
		String message = readln();
		// split message into lines with maximum length of 39 characters
		frogSays(message, 39);
	}

	public String readln() {
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return line;
	}

	public void frogSays(String message, int lineMaxLength) {
		String[] words = message.split(" ");
		int charCount = 0;
		int spaceCount = 0;
		for (int i = 0; i < words.length; ) {
			String word = words[i];
			if (word.length() > lineMaxLength) {
				String fore = word.substring(0, lineMaxLength);
				String hide = word.substring(lineMaxLength);
				word = fore;
				words[i] = hide;
			}
			if (charCount + spaceCount + word.length() < lineMaxLength) {
				System.out.print(word + " ");
				charCount += word.length();
				spaceCount++;
				i++;
			} else if (word.length() == lineMaxLength) {
				System.out.println();
				System.out.println(word);
				charCount = 0;
				spaceCount = 0;
			} else {
				System.out.println();
				charCount = 0;
				spaceCount = 0;
			}
		}
		System.out.println();

		/*String[] textChunks = message.split("\\s");
		System.out.print("           ");
		for (int i = 0; i < message.length() + 2; i++) {
			System.out.print("_");
		}
		System.out.println();
		for (int j = 0; j < textChunks.length; j++) {
			System.out.println("          < " + textChunks[j] + " >");
		}
		System.out.print("           ");
		for (int i = 0; i < message.length() + 2; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("         O");		
		System.out.println("  0__0  o");
		System.out.println(" (    )");
		System.out.println("(_m__m_)");*/
	}
}