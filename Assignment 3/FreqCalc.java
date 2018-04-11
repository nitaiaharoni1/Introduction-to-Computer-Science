/*

Assignment number   :   3.6

File Name           :   FreqCalc 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class FreqCalc {

	public static void main(String[] args) {
		String str = "";                     
		/*The purpose of the loop is to enable
		the program to run without enclosing the text in quotation marks*/
		for (int e = 0; e < args.length; e++) {   
			str += args[e];
		}
		for (int h=0; h<26; h++){ //Stars loop
			String stars = "";
			for (int k=0; k<array(str)[h]; k++){
				stars+="*";
			}
			System.out.println((char) (97+h) + ":" + stars); //Final Output
		}
	}

	public static int[] array(String s) {
		int[] intArray = new int[26];
		for (int i = 0; i < 26; i++) { //letters loop
			int sumLetters = 0;
			//Each character in the text loop
			for (int j = 0; j < s.length(); j++) { 
				int charValue = (int) s.charAt(j);
				if (charValue == (97 + i) || charValue== (65+i)) {
					sumLetters += 1;
				}
				intArray[i] = sumLetters; 
			}
		}
		return intArray;
	}
}
