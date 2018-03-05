/*Type in and run the following program. Then modify it to print “Hello, name!”,
displaying the name that the user typed in.

import javax.swing.JOptionPane;

public class DialogViewer2 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		System.out.println(name);
	}
}

*/

import javax.swing.JOptionPane;

public class DialogViewer2 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		System.out.println("Hello, " + name + "!");
	}
}