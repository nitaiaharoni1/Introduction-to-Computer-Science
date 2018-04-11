/*
 * 
 * Assignment number : 8.4
 * 
 * File Name : Sierpinski
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

public class Sierpinski {

	/**
	 * Testing code - testing the sierpinski method.
	 */
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}

	/**
	 * Calling the sierpinski method n times
	 *
	 * @param n - number of times to call the auxiliary function
	 */
	public static void sierpinski(int n) {
		double x1 = 0;
		double y1 = 0;
		double x2 = 1;
		double y2 = 0;
		double x3 = 0.5;
		double y3 = Math.sqrt(3) / 2;
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x1, y1, x3, y3);
		sierpinski(n, x1, y1, x2, y2, x3, y3);
	}

	/**
	 * The method will draw an inner triangle from half of the distance between
	 * three points, n time. using recursuion calls. the method starts with
	 * given 3 coordinates of the big triangle.
	 * 
	 *
	 * @param n - number of recursive calls
	 * @param x1 - X coordinate of the triangle's bottom left corner
	 * @param y1 - Y coordinate of the triangle's bottom left corner
	 * @param x2 - X coordinate of the triangle's bottom right corner
	 * @param y2 - Y coordinate of the triangle's bottom right corner
	 * @param x3 - X coordinate of the top triangle's corner
	 * @param y3 - Y coordinate of the top triangle's corner
	 */
	public static void sierpinski(int n, double x1, double y1, double x2,
			double y2, double x3, double y3) {
		if (n == 1) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x1, y1, x3, y3);
		} else {
			double X1 = (x1 + x2) / 2;
			double Y1 = (y1 + y2) / 2;
			double X2 = (x2 + x3) / 2;
			double Y2 = (y2 + y3) / 2;
			double X3 = (x1 + x3) / 2;
			double Y3 = (y1 + y3) / 2;
			StdDraw.line(X1, Y1, X2, Y2);
			StdDraw.line(X1, Y1, X3, Y3);
			StdDraw.line(X2, Y2, X3, Y3);
			sierpinski(n - 1, x1, y1, X1, Y1, X3, Y3);
			sierpinski(n - 1, X3, Y3, x3, y3, X2, Y2);
			sierpinski(n - 1, X1, Y1, x2, y2, X2, Y2);

		}
	}
}
