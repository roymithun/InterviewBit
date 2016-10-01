package com.interviewbit.arrays;

import java.util.Arrays;

public class FirstMissingInteger {

	public static void main(String[] args) {
		int[] a = { 2, 3, 7, 6, 8, -1, -10, 15 };
		int x = firstMissingPositive(a);
		System.out.println("x=" + x + "\n" + Arrays.toString(a));
	}

	// http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
	// http://stackoverflow.com/questions/1586858/find-the-smallest-integer-not-in-a-list
	public static int firstMissingPositive(int[] A) {
		int n = A.length;

		for (int i = 0; i < n; i++) {
			while (A[i] != i + 1) {
				// no need to swap when ith element is out of range [0,n]
				if (A[i] <= 0 || A[i] >= n)
					break;

				// handle duplicate elements
				if (A[i] == A[A[i] - 1])
					break;

				// swap elements
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;
	}

	static int segregate(int[] a) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				swap(a, i, j);
				j++;
			}
		}
		return j;
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
