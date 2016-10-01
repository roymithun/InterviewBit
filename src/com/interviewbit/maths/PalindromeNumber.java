package com.interviewbit.maths;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12421));
	}

	public static boolean isPalindrome(int a) {
		String s = String.valueOf(a);

		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
