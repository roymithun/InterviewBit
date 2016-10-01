package com.interviewbit.stacks;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {

		String s = "(a*b)*((c*d))";
		System.out.println(braces(s));
	}

	// http://qa.geeksforgeeks.org/2548/how-to-check-an-expression-contains-redundant-braces-or-not
	static int braces(String s) {
		int n = s.length();
		Stack<Character> stack = new Stack<>();
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != ')')
				stack.push(s.charAt(i));
			else {
				count = 0;
				while (!stack.isEmpty() && stack.peek() != '(') {
					stack.pop();
					count++;
				}
				stack.pop();
				if (count == 0 || count == 1) {
					return 1;
				}
			}
		}
		return 0;
	}
}
