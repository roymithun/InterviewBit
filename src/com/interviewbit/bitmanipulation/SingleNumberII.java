package com.interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumberII {

	public static void main(String[] args) {
		Integer[] a = { 2, 2, 1, 0, 1, 2, 0, 1, 3, 0 };
		System.out.println(singleNumber(new ArrayList<>(Arrays.asList(a))));
	}

	// leetcode.com/discuss/857/constant-space-solution?show=2542#a2542
	static int singleNumber(ArrayList<Integer> a) {
		int n = a.size();

		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < n; i++) {
			twos |= ones & a.get(i);
			ones ^= a.get(i);
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
