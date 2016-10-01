package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParentheses(3));;
	}
	
	// https://github.com/leetcoders/LeetCode-Java/blob/master/GenerateParentheses.java
	// http://stackoverflow.com/questions/23413881/understanding-function-to-generate-parentheses/23414519
	static public List<String> generateParentheses(int n) {
		ArrayList<String> res = new ArrayList<String>();
		generateParenthesesRecursive(res, n, n, "");
		return res;
	}

	static public void generateParenthesesRecursive(ArrayList<String> res, int left, int right, String s) {
		if (left == 0 && right == 0)
			res.add(s);
		if (left > 0)
			generateParenthesesRecursive(res, left - 1, right, s + "(");
		if (right > left)
			generateParenthesesRecursive(res, left, right - 1, s + ")");
	}
}
