package com.interviewbit.maths;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = -1146467285;
		// System.out.println(reverse(x));

		int y = reverse(x);
		System.out.println("rev = " + y);
	}

	static int reverse(int a) {
		long k = a;
		boolean isNegtive = false;
		if (k < 0) {
			k = 0 - k;
			isNegtive = true;
		}

		long rev = 0;

		while (k != 0) {
			long x = k % 10;
			rev = 10 * rev + x;
			k = k / 10;
		}

//		System.out.println("rev = " + rev);
		if (rev > Integer.MAX_VALUE)
			return 0;
		return isNegtive ? 0 - ((int) rev) : (int) rev;
	}
}
