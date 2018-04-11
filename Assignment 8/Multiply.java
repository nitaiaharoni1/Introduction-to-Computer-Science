/*
 * 
 * Assignment number : 8.1
 * 
 * File Name : Multiply
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

public class Multiply {

	/**
	 * Testing code - testing the multiply method.
	 */
	public static void main(String[] args) {
		System.out.println(
				multiply(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	/**
	 * The method multiplies 2 given numbers using recursion. 1 * (any number)
	 * will return itself.
	 *
	 * @param a - first given int
	 * @param b - second given int
	 * @return the product of a*b
	 */
	public static int multiply(int a, int b) {
		if (a == 1) {
			return b;
		} else if (a == 0) {
			return 0;
		} else {
			return b + multiply(a - 1, b);
		}
	}
}
