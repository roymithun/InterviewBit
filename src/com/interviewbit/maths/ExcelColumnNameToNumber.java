package com.interviewbit.maths;

public class ExcelColumnNameToNumber {

	static final char BASE_CHAR = 'A';

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(findName(728));
		System.out.println(sb.reverse());

		// 80 = 26*q+r; 26*3+2; 26^1*3+26^0*2
		// 925 =
		System.out.println(findColumnNumberRecursive("AAZ"));
		// int x = (int) (('A' - 'A' + 1) * Math.pow(26, 2)) + (int) (('A' - 'A'
		// + 1) * Math.pow(26, 1))
		// + (int) (('Z' - 'A' + 1) * Math.pow(26, 0));
		// // int x = (int) ('A'*Math.pow(26, 2))+(int) ('A'*Math.pow(26,
		// 1))+(int)
		// // ('C'*Math.pow(26, 0));
		// System.out.println(x);
	}

	// www.geeksforgeeks.org/find-excel-column-name-given-number/
	public static String findName(int n) {
		if (n == 0)
			return "";
		int x = n % 26;

		if (x == 0) {
			char charAppend = (char) (BASE_CHAR + 26 - 1);
			return "" + charAppend + findName((n / 26) - 1);
		} else {
			char charAppend = (char) (BASE_CHAR + x - 1);
			return "" + charAppend + findName(n / 26);
		}
	}

	public static int findColumnNumberIteritive(String s) {
		int n = s.length();
		int p = 0;
		int num = 0;
		for (int i = n - 1; i >= 0; i--) {
			char x = s.charAt(i);
			num += (x - 'A' + 1) * (int) Math.pow(26, p++);
		}

		return num;
	}

	public static int findColumnNumberRecursive(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		char x = s.charAt(0);
		int y = x - 'A' + 1;
		return y * (int) Math.pow(26, n-1) + findColumnNumberRecursive(s.substring(1, n));
	}
}
