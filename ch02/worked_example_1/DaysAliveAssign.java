import java.io.*;
import java.time.LocalDate;

public class DaysAliveAssign {
	public static void main(String[] args) {
		try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
			LocalDate todayDate = LocalDate.now();
			Day today = new Day(todayDate.getYear(), todayDate.getMonthValue(), todayDate.getDayOfMonth());
			System.out.println("Enter the day you were born using the format: yyyy-mm-dd");
			String dobString = console.readLine();
			String[] dobParsed = dobString.split("-");
			Day dob = new Day(Integer.parseInt(dobParsed[0]),
								Integer.parseInt(dobParsed[1]),
								Integer.parseInt(dobParsed[2])
								);
			System.out.format("You've been living for %s days%n", today.daysFrom(dob));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}