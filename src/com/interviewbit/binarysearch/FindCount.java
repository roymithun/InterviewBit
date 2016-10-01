package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCount {

	public static void main(String[] args) {
		Integer[] a = { 5, 7, 7, 8, 8, 10 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
		System.out.println(countNumberOfOccurances(list, 8));
	}

	public int findCount(final List<Integer> a, int b) {
		return countNumberOfOccurances(a, b);
	}

	public static int countNumberOfOccurances(final List<Integer> a, int k) {
		int n = a.size() - 1;
		int firstOccurrence = binarySearchfirstOccurrence(a, 0, n, k);
		int lastOccurrence = binarySearchlastOccurrence(a, 0, n, k);

		if ((firstOccurrence == -1) && (lastOccurrence == -1)) {
			return 0;
		} else if (firstOccurrence == lastOccurrence) {
			return 1;
		} else {
			return (lastOccurrence - firstOccurrence + 1);
		}
	}

	public static int binarySearchfirstOccurrence(final List<Integer> a, int low, int high, int k) {
		if (high >= low) {
			int mid = (low + high) / 2;

			if (((mid == 0) && (a.get(mid) == k)) || ((a.get(mid) == k) && (a.get(mid - 1) < k))) {
				return mid;
			}
			// Favor left half of the array
			else if (a.get(mid) >= k) {
				return binarySearchfirstOccurrence(a, low, mid - 1, k);
			} else {
				return binarySearchfirstOccurrence(a, mid + 1, high, k);
			}
		}

		return -1;
	}

	public static int binarySearchlastOccurrence(final List<Integer> a, int low, int high, int k) {
		if (high >= low) {
			int mid = (low + high) / 2;

			if (((mid == a.size() - 1) && (a.get(mid) == k)) || ((a.get(mid) == k) && (a.get(mid + 1) > k))) {
				return mid;
			}
			// Favor right half of the array
			else if (a.get(mid + 1) <= k) {
				return binarySearchlastOccurrence(a, mid + 1, high, k);
			} else {
				return binarySearchlastOccurrence(a, low, mid - 1, k);
			}
		}

		return -1;
	}
}
