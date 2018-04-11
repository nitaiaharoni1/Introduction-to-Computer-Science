
/*

Assignment number   :   2.5

File Name           :   CalcPI

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class CalcPI {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double insideCircle = 0;
		double outsideCircle = 0;
		for (int i = 0; i <= N; i++) {
			double x = 2.0 * Math.random() - 1.0;
			double y = 2.0 * Math.random() - 1.0;
			if (x * x + y * y <= 1.0) {
				insideCircle++;
			} else {
				outsideCircle++;
			}
		}
		double Pi = (insideCircle / (insideCircle + outsideCircle)) * 4;
		System.out.println("The approximate value of pi after " + N + " iterations is " + Pi);
	}

}
