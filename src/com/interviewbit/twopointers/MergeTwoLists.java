package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoLists {

	public static void main(String[] args) {
		// A : [1 5 8]
		// B : [6 9]

		Integer[] a = { 1, 5, 8 };
		Integer[] b = { 6, 9 };
		merge(new ArrayList<>(Arrays.asList(a)), new ArrayList<>(Arrays.asList(b)));
	}

	static public void merge(int A[], int m, int B[], int n) {

		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}

		while (n > 0) {
			A[m + n - 1] = B[n - 1];
			n--;
		}
	}

	static public void merge1(ArrayList<Integer> a, ArrayList<Integer> b) {
		int m = a.size();
		int n = b.size();

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (k >= 0) {
			// if elements in nums2 has exhausted or nums1 element > nums2
			// element
			if (j < 0 || (i >= 0 && a.get(i) > b.get(j)))
				a.set(k--, a.get(i--));
			else
				a.set(k--, b.get(j--));
		}
		System.out.println("peto");
	}
	
	static public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		for (int idx1 = 0, idx2 = 0; idx2 < b.size(); idx1++) {
			if (idx1 == a.size() || a.get(idx1) > b.get(idx2)) {
				a.add(idx1, b.get(idx2++));
			}
		}
		System.out.println("peto");
	}
}
