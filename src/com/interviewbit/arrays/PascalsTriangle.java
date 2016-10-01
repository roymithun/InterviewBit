package com.interviewbit.arrays;

import java.util.ArrayList;

public class PascalsTriangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = generate(6);
		System.out.println();
	}

	// http://www.geeksforgeeks.org/pascal-triangle/
	// https://github.com/leetcoders/LeetCode-Java/blob/master/Pascal'sTriangle.java
	static public ArrayList<ArrayList<Integer>>  generate(int numRows) {
		ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
		if (numRows < 1)
			return res;

		for (int line = 1; line <= numRows; line++) {
			int coefficient = 1; // used to represent coefficient(line, i)
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 1; i <= line; i++) {
				// The first value in a line is always 1
				temp.add(coefficient);
				coefficient = coefficient * (line - i) / i;
			}
			res.add(temp);
		}

		return res;
	}
}
