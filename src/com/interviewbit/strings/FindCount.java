package com.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCount {

	public static void main(String[] args) {
		Integer[] a = { 5, 7, 7, 8, 8, 10 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
		System.out.println(findCount(list, 8));
	}

	static public int findCount(final List<Integer> a, int b) {
		return findCountRecursive(a, b, 0, a.size() - 1);
	}

	static int findCountRecursive(final List<Integer> a, int b, int low, int high) {
		int result = 0;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (b == a.get(mid)) {
				high = mid;
			} else if (b < a.get(mid))
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		if (high < low || a.get(0) != b) {
		    // that means no occurrence
		    return 0;
		}
		// remember first occurrence
		int first = low;
		// search last occurrence, must be between low and a.length-1 inclusive
		high = a.size() - 1;
		// now, we always have a[low] == x and high is the index of the last occurrence or later
		while(low < high) {
		    // bias middle towards high now
		    int mid = low + (high+1-low)/2;
		    if (a.get(mid) > b) {
		        // the last occurrence must come before index middle
		        high = mid-1;
		    } else {
		        // last known occurrence
		        low = mid;
		    }
		}
		// high is now index of last occurrence
		return (high - first + 1);
	}
}
