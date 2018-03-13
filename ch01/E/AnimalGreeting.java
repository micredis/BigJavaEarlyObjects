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
			new AnimalGreeting().frogReadsAndSays(39);
		}
	}

	public void frogReadsAndSays(int lineMaxLength) {
		System.out.println("Enter a short message: ");
		String message = readln();
		// split the message into lines with the maximum length of lineMaxLength characters
		frogSays(message, lineMaxLength);
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
		String[] words = message.split(" ");
		ArrayList<String> lines = new ArrayList<>();
		String line = "";
		for (String word : words) {
			String newLine = (line.length() > 0) ? line + " " + word : word;
			if (newLine.length() < lineMaxLength) {
				line = newLine;
			} else if (newLine.length() == lineMaxLength) {
				lines.add(newLine);
				line = "";
			} else if (word.length() >= lineMaxLength) {	// cowsay behavior for the long words
				if (!line.isEmpty()) lines.add(line);
				newLine = word.substring(0, lineMaxLength);
				lines.add(newLine);
				line = word.substring(lineMaxLength);
			} else {	// if (newLine.length() > lineMaxLength && word.length() < lineMaxLength)
				lines.add(line);
				line = word;
			}
		}
		if (!line.isEmpty()) {
			lines.add(line);
		}
		return lines;

		// The version below splits a message into lines of equal length
		// despite the spaces between words, e.g.:
		// "This is a sh
		// ort example o
		// f such a beha
		// vior."

		// ArrayList<String> lines = new ArrayList<>();
		// int i = 0;
		// while (i < message.length()) {
		//	lines.add(message.substring(i,
		//		Math.min(i + lineMaxLength, message.length())));
		//	i += lineMaxLength;
		// }
		// return lines;
	}

	public void printFrog() {
		System.out.println("         O");
		System.out.println("  0__0  o");
		System.out.println(" (    )");
		System.out.println("(_m__m_)");
	}
}