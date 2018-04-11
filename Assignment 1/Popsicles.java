/*

Assignment number   :   1.1

File Name           :   Popsicles

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Popsicles {
	public static void main(String[] args) {
		String Name = args[0];
		int Count = Integer.parseInt(args[1]);
		double Cost = Count * 2.5;
		System.out.println(Name + ", " + Count + " popsicles will cost you " + Cost + " Shekels. Bon appetit.");

	}
}
