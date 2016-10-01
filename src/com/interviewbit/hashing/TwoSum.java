package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	public static void main(String[] args) {
		Integer[] a = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9,
				-4, 4, -8 };
		ArrayList<Integer> list = twoSum(Arrays.asList(a), -3);
		System.out.println();
	}

	// https://leetcode.com/discuss/19298/very-short-and-simple-java-code-for-two-sum
	// https://github.com/leetcoders/LeetCode-Java/blob/master/TwoSum.java
	static public ArrayList<Integer> twoSum(final List<Integer> a, int target) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.size(); ++i) {
			int diff = target - a.get(i);
			if (map.get(diff) != null) {
				result.add(map.get(diff));
				result.add(i + 1);
				return result;
			} else {
				if (!map.containsKey(a.get(i)))
					map.put(a.get(i), i + 1);
			}
		}
		return result;
	}
}
