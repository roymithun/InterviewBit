package com.interviewbit.maths;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		System.out.println("trailZeros -> " + trailZeros(9));
	}

	// http://www.purplemath.com/modules/factzero.htm
	// http://www.mytechinterviews.com/how-many-trailing-zeros-in-100-factorial
	public static int trailZeros(int n) {
		int i = 1;
		int sum = 0;
		double div = 1;
		while (div >= 1) {
			div = n / Math.pow(5, i++);
			sum += div;
		}
		return sum;
	}
}
