
/*

Assignment number   :   3.2

File Name           :   Expend

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Expend {
	public static void main(String[] args) {
		Parser.init(args[0]);
		String Letters = "";
		while (Parser.hasMoreChars()) {
			String charAdd = Character.toString(Parser.nextChar());
			int charNumber = Parser.nextInt();
			for (int i = 0; i < charNumber; i++) {
				Letters = Letters + charAdd;
			}
		}
		System.out.println(Letters);
	}
}


