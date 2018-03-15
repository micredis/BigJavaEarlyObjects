/* Type in and run the following program. Then modify it to show a different greeting
and image.

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) throws Exception {
		URL imageLocation = new URL("http://horstmann.com/java4everyone/duke.gif");
		JOptionPane.showMessageDialog(null, "Hello", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
	}
}

*/

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) throws Exception {
		URL imageLocation = new URL("http://linuxonlinesolutions.com/wp-content/themes/Indigo/images/logo.png");
		JOptionPane.showMessageDialog(null, "Hello, Micredis!", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
	}
}