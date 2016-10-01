package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {
	public static void main(String[] args) {
		Integer[] a = { 1, 10, 5 };
		System.out.println(maximumGap(Arrays.asList(a)));
	}

	// http://www.programcreek.com/2014/03/leetcode-maximum-gap-java/
	// https://leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
	// http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf
	static public int maximumGap(final List<Integer> a) {
		if (a == null || a.size() < 2) {
			return 0;
		}
		int n = a.size();

		int max = a.get(0);
		int min = a.get(0);
		for (int i = 1; i < n; i++) {
			max = Math.max(max, a.get(i));
			min = Math.min(min, a.get(i));
		}

		// initialize an array of buckets
		Bucket[] buckets = new Bucket[n + 1]; // project to (0 - n)
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}

		double interval = (double) n / (max - min);
		// distribute every number to a bucket array
		for (int i = 0; i < n; i++) {
			int index = (int) ((a.get(i) - min) * interval);

			if (buckets[index].low == -1) {
				buckets[index].low = a.get(i);
				buckets[index].high = a.get(i);
			} else {
				buckets[index].low = Math.min(buckets[index].low, a.get(i));
				buckets[index].high = Math.max(buckets[index].high, a.get(i));
			}
		}

		// scan buckets to find maximum gap
		int result = 0;
		int prev = buckets[0].high;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].low != -1) {
				result = Math.max(result, buckets[i].low - prev);
				prev = buckets[i].high;
			}

		}

		return result;
	}
}

class Bucket {
	int low;
	int high;

	public Bucket() {
		low = -1;
		high = -1;
	}
}
