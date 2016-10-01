package com.interviewbit.arrays;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {

		Integer[] r1 = { 1, 2, 3 };
		Integer[] r2 = { 4, 5, 6 };
		Integer[] r3 = { 7, 8, 9 };

	}

	// http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
	// http://codereview.stackexchange.com/questions/40246/given-nn-matrix-rotate-it-by-90-degree-to-left-and-right-without-extra-memory
	static public void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		int numConcentricSquares = (int) Math.ceil((n) / 2.0);

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < numConcentricSquares; j++) {
				int temp = a.get(i).get(j);
				// temp = matrix[i][j];
				a.get(i).set(j, a.get(n - 1 - j).get(i));
				// matrix[i][j] = matrix[n-1-j][i];
				a.get(n - 1 - j).set(i, a.get(n - 1 - i).get(n - 1 - j));
				// matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				a.get(n - 1 - i).set(n - 1 - j, a.get(j).get(n - 1 - i));
				// matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				a.get(j).set(n - 1 - i, temp);
				// matrix[j][n-1-i] = temp;
			}
		}
	}

	// http://www.geeksforgeeks.org/rotate-matrix-elements/
	static public void rotate1(ArrayList<ArrayList<Integer>> a) {

		int row = 0, col = 0;
		int prev, curr;

		int m = a.size();
		int n = a.get(0).size();

		while (row < m && col < n) {

			if (row + 1 == m || col + 1 == n)
				break;

			// Store the first element of next row, this
			// element will replace first element of current
			// row
			prev = a.get(row + 1).get(col);

			/* Move elements of first row from the remaining rows */
			for (int i = col; i < n; i++) {
				curr = a.get(row).get(i);
				a.get(row).set(i, prev);
				prev = curr;
			}
			row++;

			/* Move elements of last column from the remaining columns */
			for (int i = row; i < m; i++) {
				curr = a.get(i).get(n - 1);
				a.get(i).set(n - 1, prev);
				prev = curr;
			}
			n--;

			/* Move elements of last row from the remaining rows */
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = a.get(m - 1).get(i);
					a.get(m - 1).set(i, prev);
					prev = curr;
				}
			}
			m--;

			/* Move elements of first column from the remaining rows */
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = a.get(i).get(col);
					a.get(i).set(col, prev);
					prev = curr;
				}
			}
			col++;
		}
	}
}
