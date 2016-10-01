package com.interviewbit.strings;

public class Atoi {
	public static void main(String[] args) {
		System.out.println(atoi("9 2704"));
	}

	// http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
	static public int atoi(final String a) {
		if (a == null || a.length() < 1)
			return 0;

		// trim white spaces
		String base = a.trim();

		boolean flag = true;// '+'

		// check negative or positive
		int i = 0;
		if (base.charAt(0) == '-') {
			flag = false;// '-'
			i++;
		} else if (base.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		// calculate value
		while (base.length() > i && base.charAt(i) >= '0' && base.charAt(i) <= '9') {
			result = result * 10 + (base.charAt(i) - '0');
			i++;
		}

		if (!flag)
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}
}
