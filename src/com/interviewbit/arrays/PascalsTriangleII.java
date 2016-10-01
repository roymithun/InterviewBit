package com.interviewbit.arrays;

import java.util.ArrayList;

public class PascalsTriangleII {

	public static void main(String[] args) {
		ArrayList<Integer> result = getRow(30);
		System.out.println();
	}

	static public ArrayList<Integer> getRow(int rowIndex) {

		double coefficient = 1; // used to represent coefficient(line, i)
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 1; i <= rowIndex + 1; i++) {
			// The first value in a line is always 1
			row.add((int) coefficient);
			coefficient = coefficient * (rowIndex + 1 - i) / i;
		}

		return row;
	}
}
