package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchForaRange {

	public static void main(String[] args) {

		Integer[] a = { 5, 7, 7, 8, 8, 10 };
		searchRange(new ArrayList<>(Arrays.asList(a)), 8);
	}

	static public ArrayList<Integer> searchRange(ArrayList<Integer> a, int target) {

		ArrayList<Integer> result = new ArrayList<>();
		result.add(-1);
		result.add(-1);

		int lower = getLowerBound(a, target);
		int upper = getUpperBound(a, target);

		if (lower <= upper) {
			result.set(0, lower);
			result.set(1, upper);
		}
		return result;
	}

	private static int getLowerBound(ArrayList<Integer> a, int target) {
		int n = a.size();
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a.get(mid).intValue() < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}

	private static int getUpperBound(ArrayList<Integer> a, int target) {
		int n = a.size();
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a.get(mid).intValue() <= target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return right;
	}

}
