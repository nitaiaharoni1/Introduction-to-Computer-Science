/*

Assignment number   :   2.1

File Name           :   ClockAdvance

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class ClockAdvance {

	public static void main(String[] args) {
		String time = args[0];
		int add = Integer.parseInt(args[1]);
		int addHour = add / 60;
		int addMin = add % 60;
		int hour = 10 * Character.getNumericValue(time.charAt(0)) + Character.getNumericValue(time.charAt(1));
		int min = 10 * Character.getNumericValue(time.charAt(3)) + Character.getNumericValue(time.charAt(4));
		int newHour = hour + addHour;
		int newMin = min + addMin;
		if (newMin >= 60) {
			newHour++;
			newMin = newMin - 60 * (newMin / 60);
		}
		if (newHour >= 24) {
			newHour = newHour - 24 * (newHour / 24);
		}
		if (newHour < 10) {
			System.out.print("0" + newHour + ":");
		} else {
			System.out.print(newHour + ":");
		}
		if (newMin < 10) {
			System.out.print("0" + newMin);
		} else {
			System.out.print(newMin);
		}

	}

}
