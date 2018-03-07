/* Modify the program from Exercise E1.16 so that the dialog continues with the mes-
sage “My name is Hal! What would you like me to do?” Discard the user’s input and
display a message such as
I'm sorry, Dave. I'm afraid I can't do that.
Replace Dave with the name that was provided by the user.
*/

/* Reference to the Exercise E1.16:

Type in and run the following program. Then modify it to print “Hello, name!”,
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

public class DialogViewer3 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		JOptionPane.showInputDialog("Hello, " + name + "! My name is Hal! What would you like me to do?");
		JOptionPane.showMessageDialog(null, "I'm sorry, " + name + ". I'm afraid I can't do that.");
	}
}