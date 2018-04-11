
/*

Assignment number   :   2.3

File Name           :   Happy

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Happy {

	public static void main(String args[]) {
		String numStr = args[0];
		String total = numStr;
		int numInt = Integer.parseInt(numStr);
		for (int i = 0; i <= 100; i++) {
			int Count = 0;
			for (int j = 0; j < numStr.length(); j++) {
				int Dig = Character.getNumericValue(numStr.charAt(j));
				Count = (int) (Count + Math.pow(Dig, 2));
			}
			total = total + " " + Count;
			numStr = Integer.toString(Count);
			if (Count == 1) {
				System.out.print(numInt + " is happy, as follows: \n" + total);
				break;
			}
		}
		if (Integer.parseInt(numStr) != 1) {
			System.out.print(numInt + " is unhappy :(");
		}

	}
}
