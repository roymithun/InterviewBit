package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
 0, 0, 0, 1, 1, 2, 2, 3

 L1 i=2, idx=2
 0, 0, 0, 1, 1, 2, 2, 3 
 L2 i=3 idx=2
 0, 0, [1], 1, 1, 2, 2, 3
 L3 i=4 idx=3
 0, 0, 1, [1], 1, 2, 2, 3
 L4 i=5 idx=4
 0, 0, 1, 1, [2], 2, 2, 3
 L5 i=6 idx=5
 0, 0, 1, 1, 2, [2], 2, 3
 L6 i=7 idx=6
 0, 0, 1, 1, 2, 2, [3], 3
 L7 i=8 idx=7
 break

 return idx=7
 */
public class RemoveDuplicatesII {

	public static void main(String[] args) {
		// A = [1,1,1,2,2,3]
		// 1, 2, 2, 3,4
		Integer[] a = { 0, 0, 0, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(a))));
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/RemoveDuplicatesfromSortedArrayII.java
	static int removeDuplicates(ArrayList<Integer> a) {
		int n = a.size();
		if (n <= 2)
			return n;
		int idx = 2;
		for (int i = 2; i < n; ++i) {
			if (a.get(i).intValue() != a.get(idx - 2).intValue())
				a.set(idx++, a.get(i));
		}
		return idx;
	}
}
