
/*

Assignment number   :   2.4

File Name           :   BinAdd

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class BinAdd {
	public static void main(String args[]) {
		String a1 = args[0];
		String a2 = args[1];
		String total = "";
		if (a1.length() < a2.length()) {
			int len1 = a2.length() - a1.length();
			for (int j = 0; j < len1; j++) {
				a1 = "0" + a1;
			}
		} else if (a2.length() < a1.length()) {
			int len2 = a1.length() - a2.length();
			for (int k = 0; k < len2; k++) {
				a2 = "0" + a2;
			}
		}
		int carried = 0;
		for (int i = 0; i < a1.length(); i++) {
			if ((a1.charAt(i) != '0' && a1.charAt(i) != '1') || (a2.charAt(i) != '0' && a2.charAt(i) != '1')) {
				System.out.print("illegal input");
				break;
			}
			int charSum = Character.getNumericValue(a1.charAt(a1.length() - 1 - i))
					+ Character.getNumericValue(a2.charAt(a1.length() - 1 - i)) + carried;
			carried = 0;
			if (charSum > 1) {
				carried = 1;
				charSum = charSum - 2;
			}
			total = charSum + total;
			if (i == a1.length() - 1 && carried == 1) {
				total = 1 + total;
			}
			if (i == a1.length() -1){
				System.out.print(args[0] + " + " + args[1] + " = " + total);
			}
		}

	}
}
