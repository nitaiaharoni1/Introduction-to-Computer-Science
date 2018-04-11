/*
 * 
 * Assignment number : 8.5
 * 
 * File Name : Banach
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

public class Banach {

	/**
	 * Testing code - testing the banach method.
	 */
	public static void main(String[] args) {
		banach(Integer.parseInt(args[0]));
	}

	/**
	 * Calling the banach method n times
	 *
	 * @param n - number of times to call the auxiliary function
	 */
	public static void banach(int n) {
		double x = 0.5;
		double y = 0.5;
		double r = 0.25;
		StdDraw.circle(x, y, r);
		banach(n, x, y, r);
	}

	/**
	 * The method will draw 9 new circles scaled down in size by a factor of 3,
	 * n time. using recursuion calls. the method starts with a Given (x,y)
	 * coordinates for the mid-circle point, and a radius size.
	 * 
	 *
	 *
	 * @param n - number of recursive calls
	 * @param x - the X coordinate of the starting point
	 * @param y - the Y coordinate of the starting point
	 * @param r - the radius of the first circle
	 */
	public static void banach(int n, double x, double y, double r) {
		if (n == 1) {
			StdDraw.circle(x, y, r);
		} else {
			StdDraw.circle(x, y, r);
			double[] px = new double[9];
			double[] py = new double[9];
			px[0] = x;
			py[0] = y;
			px[1] = x + r * Math.cos(Math.PI * 1 / 4);
			py[1] = y + r * Math.sin(Math.PI * 1 / 4);
			px[2] = x + r * Math.cos(Math.PI * 2 / 4);
			py[2] = y + r * Math.sin(Math.PI * 2 / 4);
			px[3] = x + r * Math.cos(Math.PI * 3 / 4);
			py[3] = y + r * Math.sin(Math.PI * 3 / 4);
			px[4] = x + r * Math.cos(Math.PI * 4 / 4);
			py[4] = y + r * Math.sin(Math.PI * 4 / 4);
			px[5] = x + r * Math.cos(Math.PI * 5 / 4);
			py[5] = y + r * Math.sin(Math.PI * 5 / 4);
			px[6] = x + r * Math.cos(Math.PI * 6 / 4);
			py[6] = y + r * Math.sin(Math.PI * 6 / 4);
			px[7] = x + r * Math.cos(Math.PI * 7 / 4);
			py[7] = y + r * Math.sin(Math.PI * 7 / 4);
			px[8] = x + r * Math.cos(Math.PI * 8 / 4);
			py[8] = y + r * Math.sin(Math.PI * 8 / 4);
			banach(n - 1, px[0], py[0], r / 3);
			banach(n - 1, px[1], py[1], r / 3);
			banach(n - 1, px[2], py[2], r / 3);
			banach(n - 1, px[3], py[3], r / 3);
			banach(n - 1, px[4], py[4], r / 3);
			banach(n - 1, px[5], py[5], r / 3);
			banach(n - 1, px[6], py[6], r / 3);
			banach(n - 1, px[7], py[7], r / 3);
			banach(n - 1, px[8], py[8], r / 3);
		}
	}
}
