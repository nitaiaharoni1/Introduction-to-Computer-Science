
/*

Assignment number   :   2.2

File Name           :   SumDigits

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class SumDigits {

	public static void main(String[] args) {
		String Num1 = args[0];
		int total = 0;
		for (int i = 0; i < Num1.length(); i++) {
			total = total + Character.getNumericValue(Num1.charAt(i));
		}
		System.out.print(total);
	}
}
