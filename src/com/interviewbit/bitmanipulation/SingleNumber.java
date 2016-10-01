package com.interviewbit.bitmanipulation;

public class SingleNumber {

	// http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/
	public int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			x = x ^ a;
		}
		return x;
	}
}
