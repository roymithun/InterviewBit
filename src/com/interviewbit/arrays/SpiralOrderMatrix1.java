package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SpiralOrderMatrix1 {
	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	// 13 14 15 16
	public static void main(String[] args) {

		Integer[] r1 = { 1, 2, 3, 4 };
		Integer[] r2 = { 5, 6, 7, 8 };
		Integer[] r3 = { 9, 10, 11, 12 };
		Integer[] r4 = { 13, 14, 15, 16 };

		List<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(r1)));
		list.add(new ArrayList<>(Arrays.asList(r2)));
		list.add(new ArrayList<>(Arrays.asList(r3)));
		list.add(new ArrayList<>(Arrays.asList(r4)));

		// findSpiralMatrix(list);

		generateMatrix(5);
	}

	// https://rosettacode.org/wiki/Spiral_matrix#Java
	static public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < a; j++) {
				row.add(0);
			}
			matrix.add(row);
		}

		int numConcentricSquares = (int) Math.ceil((a) / 2.0);

		int j;
		int sideLen = a;
		int currentValue = 1;

		for (int i = 0; i < numConcentricSquares; i++) {
			// populate top side
			for (j = 0; j < sideLen; j++) {
				// ArrayList<Integer> row = matrix.get(i);
				matrix.get(i).set(i + j, currentValue++);
			}

			// populate right side
			for (j = 1; j < sideLen; j++) {
				matrix.get(i + j).set(a - 1 - i, currentValue++);
			}

			// populate bottom side
			for (j = sideLen - 2; j > -1; j--) {
				matrix.get(a - 1 - i).set(i + j, currentValue++);
			}

			// populate left side
			for (j = sideLen - 2; j > 0; j--) {
				matrix.get(i + j).set(i, currentValue++);
			}

			sideLen -= 2;
		}

		return matrix;
	}

	// http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
	static ArrayList<Integer> findSpiralMatrix(final List<ArrayList<Integer>> a) {
		ArrayList<Integer> output = new ArrayList<>();

		int i = 0;
		int k = 0; // starting row index
		int m = a.size(); // ending row index
		int l = 0;// starting column index
		int n = a.get(0).size();// ending column index

		while (k < m && l < n) {

			// pull the first row from the remaining rows
			for (i = l; i < n; i++) {
				output.add(a.get(k).get(i));
			}
			k++;

			// pull the last column from the remaining columns
			for (i = k; i < m; ++i) {
				output.add(a.get(i).get(n - 1));
			}
			n--;

			// pull the last row from the remaining rows
			if (k < m) {
				for (i = n - 1; i >= l; i--) {
					output.add(a.get(m - 1).get(i));
				}
				m--;
			}

			if (l < n) {
				for (i = m - 1; i >= k; i--) {
					output.add(a.get(i).get(l));
				}
				l++;
			}

		}
		return output;
	}
}
