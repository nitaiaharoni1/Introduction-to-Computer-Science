/*
 * 
 * Assignment number : 8.2
 * 
 * File Name : GCD
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

public class GCD {

	/**
	 * Testing code - testing the gcd method.
	 */
	public static void main(String[] args) {
		System.out.println(
				gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	/**
	 * The method finds the greatest common divisor of two integers using
	 * recursion.
	 *
	 * @param p - first given int
	 * @param q - second given int
	 * @return the greatest common divisor of of p*q
	 */
	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}
}
