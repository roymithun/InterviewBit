package com.interviewbit.twopointers;

import java.util.ArrayList;

public class CountingSort {

	// https://www.youtube.com/watch?v=TTnvXY82dtM
	public static void main(String[] args) {

		int[] a = { 2, 0, 2, 0, 1, 1 };
//		sortColors(a);
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/SortColors.java
	static public void sortColors(ArrayList<Integer> a) {
		int n = a.size();
		if (n <= 1)
			return;
		for (int i = 0, left = 0, right = n - 1; i <= right;) {
			if (a.get(i) == 0) {
				a.set(i++, a.get(left));
				a.set(left++, 0);
			} else if (a.get(i) == 2) {
				a.set(i, a.get(right));
				a.set(right--, 2);
			} else
				i++;
		}
	}

	static public void sortColors1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int[] countArray = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}

		for (int i = 1; i <= 2; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}

		int[] sorted = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int index = countArray[nums[i]] - 1;
			countArray[nums[i]] = countArray[nums[i]] - 1;
			sorted[index] = nums[i];
		}

		System.arraycopy(sorted, 0, nums, 0, nums.length);
	}

	static public void sortColors2(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int[] countArray = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}

		int j = 0;
		int k = 0;
		while (j <= 2) {
			if (countArray[j] != 0) {
				nums[k++] = j;
				countArray[j] = countArray[j] - 1;
			} else {
				j++;
			}
		}
	}
}
