/*Type in and run the following program. Then modify it to show the message “Hello,
your name!”.

import javax.swing.JOptionPane;

public class DialogViewer {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Hello, World!");
	}
}

*/

import javax.swing.JOptionPane;

public class DialogViewer {
	public static void main(String[] args) {
		try {
			JOptionPane.showMessageDialog(null, "Hello, " + args[0] + "!");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("A name in the command line is expected!");
		}
	}
}