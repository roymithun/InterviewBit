package com.interviewbit.binarysearch;

public class PowerFunction {

	public static void main(String[] args) {
		// System.out.println(power(-1, 1, 20));
		System.out.println(power(71045970, 41535484, 64735492));
	}

	// https://www.careercup.com/question?id=22767685
	static public int power(int x, int n, int d) {
		if (x == 0)
			return 0;

		if (n == 0)
			return 1;

		long result = 1;
		long base = x;

		while (n != 0) {
			if (n % 2 > 0)
				result = result * base;
			base = (base * base) % d;
			n = n / 2;
			if (result > d)
				result = result % d;
		}

		if (result < 0)
			return (int) (d + result);
		return (int) result;
	}

	static public int pow(int x, int n, int d) {
		if (x == 0)
			return 0;

		if (n == 0)
			return 1;

		long a = 1;
		long y = x % d;
		if (y < 0)
			y = y + d;
		while (n > 0) {
			if ((n & 1) == 0) {
				a = (a * y) % d;
			}
			y = y * y;
			y = y % d;
			if (y < 0)
				y += d;
			n = n >> 1;
		}
		return (int) a;
	}
}
