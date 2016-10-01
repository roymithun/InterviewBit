package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {

	public static void main(String[] args) {
		Integer[] a = { 5, -2, -1, -10, 10 };
		System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(a)), 5));
	}

	static public int threeSumClosest(ArrayList<Integer> a, int b) {
		int n = a.size();
		if (n < 3)
			return 0;
		
		int result = a.get(1) + a.get(1) + a.get(2);
		
		Collections.sort(a);
		
		for (int i = 0; i < n - 2; ++i) {
			int left = i + 1, right = n - 1;
			while (left < right) {
				int threesum = a.get(i) + a.get(left) + a.get(right);
				if (threesum == b)
					return b;
				else if (threesum < b)
					++left;
				else
					--right;
				if (Math.abs(threesum - b) < Math.abs(result - b))
					result = threesum;
			}
		}
		return result;
	}
}
