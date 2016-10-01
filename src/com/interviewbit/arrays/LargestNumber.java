package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	public static void main(String[] args) {
		// System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));

		Integer[] nums = { 3, 30, 34, 5, 9 };
		String s = largestNumber(Arrays.asList(nums));
		System.out.println(s);
	}

	// http://www.programcreek.com/2014/02/leetcode-largest-number-java/
	static public String largestNumber(final List<Integer> nums) {
		int n = nums.size();
		String[] sNums = new String[n];
		for (int i = 0; i < n; i++) {
			sNums[i] = "" + nums.get(i);
		}

		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				int val = rightLeft.compareTo(leftRight);
				return val;

			}
		};

		Arrays.sort(sNums, comp);

		StringBuilder sb = new StringBuilder();
		for (String s : sNums) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	static public String largestNumber(int[] nums) {
		int n = nums.length;
		String[] sNums = new String[n];
		for (int i = 0; i < n; i++) {
			sNums[i] = "" + nums[i];
		}

		Comparator<String> comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				return rightLeft.compareTo(leftRight);

			}
		};

		Arrays.sort(sNums, comp);

		StringBuilder sb = new StringBuilder();
		for (String s : sNums) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
