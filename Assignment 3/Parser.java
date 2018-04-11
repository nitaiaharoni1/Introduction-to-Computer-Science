
/*

Assignment number   :   3.1

File Name           :   Parser

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Parser {
	static String str; // the input text
	static int N; // input size
	static int current; // current position in the text

	/* * Initializes the given string for parsing. */
	public static void init(String s) {
		str = s;
		N = str.length();
		current = 0;
	}

/*
 * * Returns true if there are more characters to process, false otherwise.
 */
public static boolean hasMoreChars() {
	return (current < N) ? true : false;
}

/*
 * * Returns the next character in the text. /* Should be called only if
 * hasMoreChars() is true.
 */
// Side effect: advances current just beyond the character.
public static char nextChar() {
	char Letter1 = str.charAt(current);
	char finalLetter = 0;
	boolean isLetter1 = (Letter1 >= 'a' && Letter1 <= 'z')
			|| (Letter1 >= 'A' && Letter1 <= 'Z' 
			|| Letter1 == '+' || Letter1 == '-');
	if (hasMoreChars() && isLetter1) {
		finalLetter = Letter1;
		current++;
	}
	return finalLetter;
}

/*
 * * Returns the next integer in the text. Should be called only if
 * hasMoreChars() is true. It is assumed that this function is called only
 * if the caller knows that the next char in the string is the beginning of
 * an integer.
 */
// Side effect: advances current just beyond the integer.
public static int nextInt() {
	boolean isDig = (str.charAt(current) >= '0' 
			&& str.charAt(current) <= '9');
	int finalNum = 0;
	if (hasMoreChars() && isDig) {
		String buildNum = "";
		int counter = 0;
		for (int i = 0; i < N - current; i++) {
			boolean nextDig = (str.charAt(current + i) >= '0' 
					&& str.charAt(current + i) <= '9');
				if (nextDig) {
					buildNum = buildNum + str.charAt(current + i);
					counter++;
				} else {
					break;
				}
			}
			current = current + counter;
			finalNum = Integer.parseInt(buildNum);
		}
		return finalNum;
	}

}
