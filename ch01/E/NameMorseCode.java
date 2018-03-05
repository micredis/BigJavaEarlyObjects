/* Write a program that prints your name in Morse code, like this:
.... .- .-. .-. -.--
Use a separate call to System.out.print for each letter.
*/

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NameMorseCode {
	private static final Map<Character, String> codeTable;
	static {
		Map<Character, String> map = new HashMap<>();
		map.put('A', ".-");
		map.put('B', "-...");
		map.put('C', "-.-.");
		map.put('D', "-..");
		map.put('E', ".");
		map.put('F', "..-.");
		map.put('G', "--.");
		map.put('H', "....");
		map.put('I', "..");
		map.put('J', ".---");
		map.put('K', "-.-");
		map.put('L', ".-..");
		map.put('M', "--");
		map.put('N', "-.");
		map.put('O', "---");
		map.put('P', ".--.");
		map.put('Q', "--.-");
		map.put('R', ".-.");
		map.put('S', "...");
		map.put('T', "-");
		map.put('U', "..-");
		map.put('V', "...-");
		map.put('W', ".--");
		map.put('X', "-..-");
		map.put('Y', "-.--");
		map.put('Z', "--..");
		codeTable = Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		new NameMorseCode().getItToMorse();
	}

	public void getItToMorse() {
		System.out.print("Enter your name: ");
		char[] input = readInputChars();
		for (char c : input) {
			System.out.print(codeTable.get(Character.toUpperCase(c)) + " ");
		}
		System.out.println();
	}

	public char[] readInputChars() {
		String input = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			input = reader.readLine();
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return input.toCharArray();
	}
}