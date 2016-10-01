package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
	public static void main(String[] args) {
		List<String> result = letterCombinations("02345");
		System.out.println();
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/LetterCombinationsofaPhoneNumber.java
	static public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		String[] keyboard = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		if (digits == null || digits.length() == 0)
			return res;
		letterCombinationsRe(keyboard, res, digits, "");
		return res;
	}

	static public void letterCombinationsRe(String[] keyboard, ArrayList<String> res, String digits, String s) {
		if (s.length() == digits.length()) {
			res.add(s);
			return;
		}
		String letters = keyboard[digits.charAt(s.length()) - '0'];
		for (int i = 0; i < letters.length(); ++i) {
			letterCombinationsRe(keyboard, res, digits, s + letters.charAt(i));
		}
	}
}
