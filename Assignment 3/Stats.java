
/*

Assignment number   :   3.4

File Name           :   Stats 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Stats {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Empty Input.");
			return;
		}
		double avgSum = 0;
		double absSum = 0;
		double wordsCount = args.length;
		for (int i = 0; i < wordsCount; i++) {
			avgSum += Integer.parseInt(args[i]);
		}
		double average = avgSum / wordsCount;
		for (int j = 0; j < wordsCount; j++) {
			absSum += Math.abs(average - Integer.parseInt(args[j]));
		}
		double absDiv = absSum / wordsCount;
		System.out.println("The average is " + average 
				+ ". The absolute deviation is " + absDiv + ".");
	}
}
