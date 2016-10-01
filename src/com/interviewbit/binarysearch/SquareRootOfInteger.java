package com.interviewbit.binarysearch;

public class SquareRootOfInteger {

	public static void main(String[] args) {
		System.out.println(sqrt(930675566));
	}

	static int sqrt(int a) {
		int left = 1, right = a / 2;
		if (a < 2)
			return a;
		while (left <= right) {
            int mid = (left + right)/2;
            if (a/mid == mid) return mid;
            if (a/mid > mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
	}
}
