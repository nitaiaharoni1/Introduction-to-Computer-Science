/*

Assignment number   :   3.5

File Name           :   FindFirstRepeat 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class FindFirstRepeat {

	public static void main(String[] args) {
		int reElement = 0;
		loops: for (int i = 0; i < args.length - 1; i++) {
			for (int j = i + 1; j < args.length; j++) {
				if (Integer.parseInt(args[i]) == Integer.parseInt(args[j])) {
					reElement = Integer.parseInt(args[i]);
					System.out.println("First repeating element is: " 
					+ reElement);
					break loops;
				}
			}
		}
		if (reElement == 0) {
			System.out.println("No repeating elements");
		}

	}
}
