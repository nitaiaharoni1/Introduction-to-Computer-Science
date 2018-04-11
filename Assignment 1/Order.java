/*

Assignment number   :   1.4

File Name           :   Order

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Order {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int Max = Math.max(Math.max(a, b), c);
		int Min = Math.min(Math.min(a, b), c);
		int Middle = a + b + c - (Max + Min);
		System.out.println(Max + " " + Middle + " " + Min);

	}

}
