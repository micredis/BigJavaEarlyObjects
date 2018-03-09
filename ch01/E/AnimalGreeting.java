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
		ArrayList<String> lines = new ArrayList<>(splitLines(message, lineMaxLength));

		for (String line : lines) {
			System.out.println(line);
		}

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
}