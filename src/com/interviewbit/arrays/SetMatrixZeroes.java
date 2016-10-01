package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// Integer[][] a = { { 1, 0, 2 }, { 2, 3, 5 }, { 2, 0, 5 } };
		Integer[] a1 = { 1, 0, 2 };
		Integer[] a2 = { 2, 3, 5 };
		Integer[] a3 = { 2, 0, 5 };

		ArrayList<List<Integer>> a = new ArrayList<>();
		a.add(Arrays.asList(a1));
		a.add(Arrays.asList(a2));
		a.add(Arrays.asList(a3));
		setZeroes(a);
		System.out.println();
	}

	static public void setZeroes(List<List<Integer>> matrix) {
		int m = matrix.size();
		if (m <= 0)
			return;
		int n = matrix.get(0).size();

		boolean rowHasZero = false;
		boolean colHasZero = false;

		// check if first row has zero
		for (int j = 0; j < n; j++) {
			if (matrix.get(0).get(j) == 0) {
				rowHasZero = true;
				break;
			}
		}

		// check if first column has zero
		for (int i = 0; i < m; i++) {
			if (matrix.get(i).get(0) == 0) {
				colHasZero = true;
				break;
			}
		}

		// mark zeros on first row and column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix.get(i).get(j) == 0) {
					matrix.get(0).set(j, 0);
					matrix.get(i).set(0, 0);
				}
			}
		}

		// use mark to set elements
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0)
					matrix.get(i).set(j, 0);

		// set first column and row
		if (rowHasZero)
			for (int i = 0; i < n; i++)
				matrix.get(0).set(i, 0);
		if (colHasZero)
			for (int i = 0; i < m; i++)
				matrix.get(i).set(0, 0);

	}
}
