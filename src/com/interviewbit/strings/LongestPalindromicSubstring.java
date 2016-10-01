package com.interviewbit.strings;

import java.util.Arrays;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println("forgeeksskeegfor");
		System.out.println(findLongestPalindrome("aaaabaaa"));
	}

	public static String findLongestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";

		char[] s2 = addBoundaries(s.toCharArray());
		int[] arrPalindromeSpan = new int[s2.length];
		int centerSpan = 0, rightBoundary = 0;

		// The walking indices to compare if two elements are the same
		int m = 0, n = 0;
		for (int i = 1; i < s2.length; i++) {
			if (i > rightBoundary) {
				arrPalindromeSpan[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int iMirror = centerSpan * 2 - i;
				if (arrPalindromeSpan[iMirror] < (rightBoundary - i)) {
					arrPalindromeSpan[i] = arrPalindromeSpan[iMirror];
					m = -1; // This signals bypassing the while loop below.
				} else {
					arrPalindromeSpan[i] = rightBoundary - i;
					n = rightBoundary + 1;
					m = i * 2 - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				arrPalindromeSpan[i]++;
				m--;
				n++;
			}
			if ((i + arrPalindromeSpan[i]) > rightBoundary) {
				centerSpan = i;
				rightBoundary = i + arrPalindromeSpan[i];
			}
		}
		int len = 0;
		centerSpan = 0;
		for (int i = 1; i < s2.length; i++) {
			if (len < arrPalindromeSpan[i]) {
				len = arrPalindromeSpan[i];
				centerSpan = i;
			}
		}
		char[] ss = Arrays.copyOfRange(s2, centerSpan - len, centerSpan + len + 1);
		return String.valueOf(removeBoundaries(ss));
	}

	private static char[] addBoundaries(char[] cs) {
		if (cs == null || cs.length == 0)
			return "||".toCharArray();

		char[] cs2 = new char[cs.length * 2 + 1];
		for (int i = 0; i < (cs2.length - 1); i = i + 2) {
			cs2[i] = '|';
			cs2[i + 1] = cs[i / 2];
		}
		cs2[cs2.length - 1] = '|';
		return cs2;
	}

	private static char[] removeBoundaries(char[] cs) {
		if (cs == null || cs.length < 3)
			return "".toCharArray();

		char[] cs2 = new char[(cs.length - 1) / 2];
		for (int i = 0; i < cs2.length; i++) {
			cs2[i] = cs[i * 2 + 1];
		}
		return cs2;
	}
}
