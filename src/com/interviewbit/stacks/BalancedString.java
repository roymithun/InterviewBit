package com.interviewbit.stacks;

import java.util.Stack;

public class BalancedString {

	public static void main(String[] args) {

		System.out.println(isBalanced("{([])}{}(())"));
	}

	private static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			if (!stack.isEmpty() && hasMatch(stack, chars[i])) {
				stack.pop();
			} else {
				stack.push(chars[i]);
			}
		}
		return stack.isEmpty();
	}

	private static boolean hasMatch(Stack<Character> stack, char c) {
		if (c == ')') {
			if (stack.peek() == '(') {
				return true;
			}
		} else if (c == '}') {
			if (stack.peek() == '{') {
				return true;
			}
		} else if (c == ']') {
			if (stack.peek() == '[') {
				return true;
			}
		}
		return false;
	}
}
