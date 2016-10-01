package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpSearchForaRange {

	public static void main(String[] args) {
		Integer[] a = { 5, 7, 7, 8, 8, 10 };
		ArrayList<Integer> list = searchRange(new ArrayList<>(Arrays.asList(a)), 8);
		System.out.println();
	}

	static public ArrayList<Integer> searchRange(final List<Integer> a, int b) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int low = 0;
		int high = a.size() - 1;

		result = search(a, b, low, high);

		return result;

	}

	static public ArrayList<Integer> search(List<Integer> a, int target, int low, int high) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (a == null || a.size() == 0) {
			result.add(0, -1);
			result.add(1, -1);
			return result;
		}

		if (low > high) {
			result.add(0, -1);
			result.add(1, -1);
			return result;
		}

		if (a.size() == 1) {
			result.add(0, 0);
			result.add(1, 0);
			return result;
		}
		int mid = (low + high) / 2;
		if (a.get(mid) > target)
			return search(a, target, low, mid - 1);
		else if (a.get(mid) < target)
			return search(a, target, mid + 1, high);
		else {
			result.add(0, mid);
			result.add(1, mid);

			int t1 = mid;
			while (t1 > low && a.get(t1) == a.get(t1 - 1)) {
				t1--;
				result.set(0, t1);
			}

			int t2 = mid;
			while (t2 < high && a.get(t2) == a.get(t2 + 1)) {
				t2++;
				result.set(1, t2);
			}

			return result;
		}
	}
}
