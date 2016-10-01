package com.interviewbit.maths;

public class PowerOfTwoIntegers {

	public static void main(String[] args) {

		System.out.println(isPower(1024000000));
	}

	// http://www.geeksforgeeks.org/check-if-a-number-can-be-expressed-as-xy-x-raised-to-power-y/
	public static boolean isPower(int base) {
		if (base == 1)
			return true;
		int a = base;
		double sqrt = Math.sqrt(base);
		for (int x = 2; x <= sqrt; x++) {
			int y = 2;
			double p = Math.pow(x, y);

			while (p <= a && p > 0) {
				if (p == a)
					return true;
				y++;
				p = Math.pow(x, y);
			}
		}

		return false;
	}

	/*
	 * wrong approach
	 * 
	 * if (base == 1) return true; int a = base;
	 * 
	 * 
	 * for (int i = 2; i < a; i++) { a = base; while (a != 0 && a % i == 0) { a
	 * /= i; } if (a == 1) return true; }
	 * 
	 * return false;
	 */
}
