package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		Integer[] a = { 5000, 5000, 5000 };
		System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(a))));
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/RemoveDuplicatesfromSortedArray.java
	static public int removeDuplicates(ArrayList<Integer> a) {
		int n = a.size();
		int idx = 0;
		for (int i = 0; i < n; ++i) {
			if (i == 0 || a.get(i).intValue() != a.get(i - 1).intValue()) {
				a.set(idx++, a.get(i));
			}
		}
		return idx;
	}

	// http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
	public static int removeDuplicatesNaive(ArrayList<Integer> a) {
		if (a.size() < 2)
			return a.size();

		int j = 0;
		int i = 1;

		while (i < a.size()) {
			if (a.get(i).intValue() == a.get(j).intValue()) {
				i++;
			} else {
				j++;
				a.set(j, a.get(i));
				i++;
			}
		}

		return j + 1;
	}

	public static int countUnique(ArrayList<Integer> a) {
		int count = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i).intValue() == a.get(i + 1).intValue()) {
				count++;
			}
		}
		return (a.size() - count);
	}

}
