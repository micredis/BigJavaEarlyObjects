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
		System.out.print("Enter a short message: ");
		String message = readln();
		frogSays(message);
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

	public void frogSays(String message) {
		String[] textChunks = message.split("\\s");
		System.out.print("           ");
		for (int i = 0; i < message.length(); i++) {
			System.out.print("_");
		}
		
		/*System.out.println();
		System.out.print("          (");
		for (int j = 0; j < 20; j++) {
			System.out.print(message.substring(j, j + 1) + ")");
		}*/

		for (int j = 0; j < textChunks.length; j++) {
			System.out.println("          (" + textChunks[j] + ")");
		}
		/*System.out.print("             ");
		for (int k = 0; k < message.length(); k++) {
			System.out.print("-");
		}*/
		System.out.println();
		System.out.println("          (___)");		
		System.out.println("          (_)");		
		System.out.println("         O");		
		System.out.println("  0__0  o");
		System.out.println(" (    )");
		System.out.println("(_m__m_)");
	}
}