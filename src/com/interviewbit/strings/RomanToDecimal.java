package com.interviewbit.strings;

public class RomanToDecimal {

	public static void main(String[] args) {

		System.out.println(RomanToLiteral("XCIX "));
	}

	static int RomanToLiteral(String a) {
		int n = a.length();
		int lastAdded = 0;
		int actual = 0;
		for (int i = n - 1; i >= 0; i--) {

			char c = Character.toUpperCase(a.charAt(i));
			switch (c) {
			case 'I':
				actual = getDecimal(1, lastAdded, actual);
				lastAdded = 1;
				break;
			case 'V':
				actual = getDecimal(5, lastAdded, actual);
				lastAdded = 5;
				break;
			case 'X':
				actual = getDecimal(10, lastAdded, actual);
				lastAdded = 10;
				break;
			case 'L':
				actual = getDecimal(50, lastAdded, actual);
				lastAdded = 50;
				break;
			case 'C':
				actual = getDecimal(100, lastAdded, actual);
				lastAdded = 100;
				break;
			case 'D':
				actual = getDecimal(500, lastAdded, actual);
				lastAdded = 500;
				break;
			case 'M':
				actual = getDecimal(1000, lastAdded, actual);
				lastAdded = 1000;
				break;
			}
		}

		return actual;
	}

	static int getDecimal(int currentToAdd, int lastAdded, int actual) {
		if (lastAdded > currentToAdd)
			return actual - currentToAdd;
		else
			return actual + currentToAdd;
	}
}
