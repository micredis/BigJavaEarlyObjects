/* Write a program that prints an animal speaking a greeting, similar to (but different
from) the following:

 /\_/\     -----
( ' ' )  / Hello \
(  -  ) <  Junior |
 | | |   \ Coder!/
(__|__)    -----

*/

import java.io.*;
import java.util.*;

public class AnimalGreeting {
	private static final String INDENT_10 = "          ";
	private static final String INDENT_11 = "           ";
	
	public static void main(String[] args) {
		if (args.length > 0) {
			StringBuilder sbMessage = new StringBuilder();
			for (String word : args) {
				sbMessage.append(word);
				sbMessage.append(" ");
			}
			String message = sbMessage.toString().trim();
			// 39 is the max length of a single line of the message
			new AnimalGreeting().frogSays(message, 39);
		} else {
			new AnimalGreeting().frogReadsAndSays();
		}
	}

	public void frogReadsAndSays() {
		System.out.println("Enter a short message: ");
		String message = readln();
		// split the message into lines with maximum length of 39 characters
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
		ArrayList<String> lines = new ArrayList<>(splitLines(message, lineMaxLength));
		if (lines.size() == 1) {
			System.out.print(INDENT_11);
			for (int i = 0; i < lines.get(0).length() + 2; i++) {
				System.out.print("_");
			}
			System.out.println();
			System.out.println(INDENT_10 + "< " + lines.get(0) + " >");
			System.out.print(INDENT_11);
			for (int i = 0; i < lines.get(0).length() + 2; i++) {
				System.out.print("-");
			}
			System.out.println();
		} else if (lines.size() > 1) {
			System.out.print(INDENT_11);
			for (int i = 0; i < lineMaxLength + 2; i++) {
				System.out.print("_");
			}
			System.out.println();
			System.out.print(INDENT_10 + "/ " + lines.get(0));
			for (int i = 0; i < lineMaxLength - lines.get(0).length(); i++) {
				System.out.print(" ");
			}
			System.out.println(" \\");
			for (int j = 1; j < lines.size() - 1; j++) {
				System.out.print(INDENT_10 + "| " + lines.get(j));
				for (int i = 0; i < lineMaxLength - lines.get(j).length(); i++) {
					System.out.print(" ");
				}
				System.out.println(" |");
			}
			System.out.print(INDENT_10 + "\\ " + lines.get(lines.size() - 1));
			for (int i = 0; i < lineMaxLength - lines.get(lines.size() - 1).length(); i++) {
				System.out.print(" ");
			}
			System.out.println(" /");
			System.out.print(INDENT_11);
			for (int i = 0; i < lineMaxLength + 2; i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		printFrog();
	}

	public ArrayList<String> splitLines(String message, int lineMaxLength) {
		ArrayList<String> lines = new ArrayList<>();
		int i = 0;
		while (i < message.length()) {
			lines.add(message.substring(i,
				Math.min(i + lineMaxLength, message.length())));
			i += lineMaxLength;
		}
		return lines;

		/*ArrayList<String> lines = new ArrayList<>();
		String line = "";
		String[] words = message.split(" ");
		int charCount = 0;
		int spaceCount = 0;
		for (int i = 0; i < words.length; ) {
			String word = words[i];
			if (word.length() > lineMaxLength) {
				String fore = word.substring(0, lineMaxLength);
				String hind = word.substring(lineMaxLength);
				word = fore;
				words[i] = hind;
			}
			if (charCount + spaceCount + word.length() < lineMaxLength) {
				//System.out.print(word + " ");
				line += word + " ";
				charCount += word.length();
				spaceCount++;
				i++;
			} else if (word.length() == lineMaxLength) {
				//System.out.println();
				//System.out.println(word);
				lines.add(line);
				line = "";
				lines.add(word);
				lines.add(words[i]);  // temporary line; preserve until the issue is not resolved
				charCount = 0;
				spaceCount = 0;
			} else {
				//System.out.println();
				lines.add(line.trim());
				line = "";
				charCount = 0;
				spaceCount = 0;
			}
		}
		//System.out.println();
		return lines;*/
	}

	public void printFrog() {
		System.out.println("         O");
		System.out.println("  0__0  o");
		System.out.println(" (    )");
		System.out.println("(_m__m_)");
	}
}