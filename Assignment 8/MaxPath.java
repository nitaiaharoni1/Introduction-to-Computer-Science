/*
 * 
 * Assignment number : 8.3
 * 
 * File Name : MaxPath
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

public class MaxPath {

	/**
	 * Testing code - testing the effMaxPath method.
	 */
	public static void main(String[] args) {
		int[][] a = new int[Integer.parseInt(args[0])][Integer
				.parseInt(args[1])];
		int k = 2;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = Integer.parseInt(args[k]);
				k++;
			}
		}
		System.out.println(effMaxPath(a));
	}

	/**
	 * Using the maxPath method with a specific array, and starting coodrinates
	 * to calculate the value of the maximum path.
	 * 
	 * @param arr - a given array.
	 * @return - the max path sum of the matrix.
	 */
	public static int maxPath(int[][] arr) {
		return maxPath(arr, 0, 0);
	}

	/**
	 * Calculates the sum of all the values in a given matrix along the path:
	 * Starts at the top-left corner, coordinates , and end at the bottom-right
	 * corner. At each step, moves either one cell to the right, or one cell
	 * down.
	 * 
	 * @param arr - the given array to calculate.
	 * @param i - index of the row to start.
	 * @param j - index of the column to start.
	 * @return - the max path sum of the matrix.
	 */
	private static int maxPath(int[][] arr, int i, int j) {
		if (i == arr.length - 1 && j == arr[0].length - 1) {
			return arr[i][j];
		} else if (i == arr.length - 1) {
			return arr[i][j] + maxPath(arr, i, j + 1);
		} else if (j == arr[0].length - 1) {
			return arr[i][j] + maxPath(arr, i + 1, j);
		} else {
			return arr[i][j]
					+ Math.max(maxPath(arr, i + 1, j), maxPath(arr, i, j + 1));
		}
	}

	/**
	 * Using the effMaxPath method with a specific array, and starting
	 * coodrinates to calculate the value of the maximum path. Creating a new
	 * memo array, setting every cell of it to a value of -1.
	 * 
	 * @param arr - a given array.
	 * @return - the max path sum of the matrix.
	 */
	public static int effMaxPath(int[][] arr) {
		int[][] memo = new int[arr.length][arr[0].length];
		for (int i = 0; i < memo.length; i++)
			for (int j = 0; j < memo[0].length; j++)
				memo[i][j] = -1;
		return effMaxPath(arr, memo, 0, 0);
	}

	/**
	 * Calculates the sum of all the values in a given matrix along the path:
	 * Starts at the top-left corner, coordinates , and end at the bottom-right
	 * corner. At each step, moves either one cell to the right, or one cell
	 * down. if a path has already been calculated the memo array will contain
	 * and provide the value, so the method will not calculate it again. * The
	 * method uses two arrays; the given array, and the new memo array
	 * 
	 * @param arr - the given array to calculate.
	 * @param memo - memorization array.
	 * @param i - index of the row to start.
	 * @param j - index of the column to start.
	 * @return - the max path sum of the matrix.
	 */
	private static int effMaxPath(int[][] arr, int[][] memo, int i, int j) {
		if (i == arr.length - 1 && j == arr[0].length - 1) {
			return arr[i][j];
		} else if (i == arr.length - 1) {
			return arr[i][j] + effMaxPath(arr, memo, i, j + 1);
		} else if (j == arr[0].length - 1) {
			return arr[i][j] + effMaxPath(arr, memo, i + 1, j);
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		} else {
			memo[i][j] = arr[i][j] + Math.max(effMaxPath(arr, memo, i + 1, j),
					effMaxPath(arr, memo, i, j + 1));
			return memo[i][j];
		}
	}
}