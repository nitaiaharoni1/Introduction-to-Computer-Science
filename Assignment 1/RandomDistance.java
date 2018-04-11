/*

Assignment number   :   1.3

File Name           :   RandomDistance

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class RandomDistance {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int x1 = (int) Math.round((Math.random() * (b - a) + a));
		int x2 = (int) Math.round((Math.random() * (b - a) + a));
		int y1 = (int) Math.round((Math.random() * (b - a) + a));
		int y2 = (int) Math.round((Math.random() * (b - a) + a));

		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		System.out.println("The distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") + is " + distance);

	}

}
