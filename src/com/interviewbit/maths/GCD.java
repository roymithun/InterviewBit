package com.interviewbit.maths;

public class GCD {

	public static void main(String[] args) {
		System.out.println("gcd = " + gcdRecursive(14, 8));
	}

	// iterative
	public static int gcdIterative(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static int gcdRecursive(int a, int b) {
		if (b == 0)
			return a;
		return gcdRecursive(b, a % b);
	}
}
