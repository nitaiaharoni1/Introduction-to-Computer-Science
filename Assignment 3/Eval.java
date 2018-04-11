/*

Assignment number   :   4.1

File Name           :   MatrixOps 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

/** A library of operations on two-dimensional matrices. */
public class MatrixOps {

	public static void main(String args[]) {
		// Put your testing code here.

		// Creates two matrices, for testing
		int[][] c = { { 7, 2, 1 }, { 3, 6, 1 }, { 5, 1, 4 }, };
		int[][] b = { { 8, 3, 5 }, { 1, 4, 1 }, { 1, 3, 4 }, };

		System.out.printf("Matrix C");
		print(c);
		System.out.printf("Matrix B");
		print(b);
		System.out.printf("Matrix C+B");
		print(add(c, b));
		System.out.printf("Matrix C*B");
		print(mult(c, b));
		System.out.printf("Matrix C*(C+B)");
		// d = c * (c + b)
		int[][] d = mult(c, add(c, b));
		print(d);

		int N = 5;
		int M = 5;
		int range = 10;
		System.out.printf("A random matrix A " + N + "x" + M);
		int[][] a = random(N, M, range);
		print(a);

		System.out.printf("The identity matrix I " + N + "x" + M);
		print(identity(N));

		System.out.printf("A*I = A");
		print(mult(a, identity(N)));

		System.out.printf("I*A = A");
		print(mult(identity(N), a));

		if (equals(mult(identity(N), a), mult(a, identity(N)))) {
			System.out.printf("I*A is equal to A*I!");
			System.out.println();
			System.out.println();
		}

		System.out.printf("A random matrix E " + N + "x" + M);
		int[][] e = random(N, M, range);
		print(e);

		System.out.printf("E transposed = ");
		print(transpose(e));

		if (isSymmetric(add(e, transpose(e)))) {
			System.out.printf("E+E transposed is symetric!");
			System.out.println();
			System.out.println();
		}

		int subi1 = 1;
		int subj1 = 2;
		int subi2 = 3;
		int subj2 = 5;
		System.out.printf("Sub matrix of E (" + subi1 + "," + subj1 + "),(" 
		+ subi2 + "," + subj2 + ")");
		print(subMatrix(e, subi1, subj1, subi2, subj2));

		System.out.println();

	}

	/**
	 * Prints the given matrix.
	 * 
	 * @param the
	 *            matrix to be printed.
	 */
	public static void print(int[][] m) {
		int N = m.length;
		int M = m[0].length;
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < M; j++) {
				System.out.printf("%4s", m[i][j]);
			}
		}
		System.out.println();
		System.out.println();

	}

	/**
	 * Adds the two given matrices. Assumes that they have the same dimensions.
	 * 
	 * @param m1
	 *            - first summand
	 * @param m2
	 *            - second summand
	 * @return the sum of the two matrices
	 */
	public static int[][] add(int[][] m1, int[][] m2) {
		int N = m1.length; // number of rows
		int M = m1[0].length; // number of columns
		int[][] sum = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return sum;
	}

	/**
	 * Checks if the given matrix is symmetric.
	 * 
	 * @param m
	 *            - the matrix to be tested.
	 * @return true if and only if the matrix is symmetric.
	 */
	public static boolean isSymmetric(int[][] m) {
		boolean symetric = true;
		int N = m.length;
		int M = m[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] != m[j][i]) {
					symetric = false;
				}
			}
		}
		return symetric;
	}

	/**
	 * Checks if the two given matrices are equal.
	 * 
	 * @param m1
	 * @param m2
	 * @return true if and only if m1 equals m2.
	 */
	public static boolean equals(int[][] m1, int[][] m2) {
		boolean equal = true;
		int N = m1.length;
		int M = m1[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m1[i][j] != m2[i][j]) {
					equal = false;
				}
			}
		}
		return equal;
	}

	/**
	 * Creates and returns an identity matrix of size N.
	 * 
	 * @param N
	 *            - the size of the identity matrix.
	 * @return the identity matrix of size N
	 */
	public static int[][] identity(int N) {
		int[][] I = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					I[i][j] += 1;
				}
			}
		}
		return I;
	}

	/**
	 * Creates and returns the transpose of the given matrix.
	 * 
	 * @param m
	 *            - the given matrix.
	 * @return a new matrix, which is the transpose of m.
	 */
	public static int[][] transpose(int[][] m) {
		int N = m.length;
		int M = m[0].length;
		int[][] T = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				T[i][j] = m[j][i];
			}
		}
		return T;
	}

	/**
	 * Computes and returns the product of the two given matrices. Assumes that
	 * they have compatible dimensions.
	 * 
	 * @param m1
	 * @param m2
	 * @return the product of m1 and m2
	 */
	public static int[][] mult(int[][] m1, int[][] m2) {
		int N = m1.length; // number of rows
		int M = m2[0].length; // number of columns
		int[][] mult = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					mult[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return mult;
	}

	// Description of the random function:
	// Given: two positive integers (N and M), and some positive integer
	// (range).
	// The method creates and returns a matrix of N rows and M columns,
	// in which every element is an integer between 0 and range, inclusive.
	// The name of the function is 'random'.
	// You need to complete the method signature and implementation.
	public static int[][] random(int N, int M, int range) {
		int[][] random = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				random[i][j] = (int) (Math.random() * (range + 1));
			}
		}
		return random;

	}

	// Description of the sub matrix function:
	// Given: a matrix m and two coordinates specified by the integers
	// i1, j1, i2, and j2. The method returns a matrix which is the subset
	// m. The top-left element of the subset is m(i1,j1), and the bottom-right
	// element is m(i2,j2). Assume that i2>=i1 and j2>=j1.
	// The name of the function is subMatrix.
	// You need to complete the method signature and implementation.

	public static int[][] subMatrix(int[][] m, int i1, int j1, int i2
			, int j2) {
		int N = i2 - i1 + 1;
		int M = j2 - j1 + 1;
		int[][] subMatrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				subMatrix[i][j] = m[i + i1 - 1][j + j1 - 1];
			}
		}
		return subMatrix;
	}
}