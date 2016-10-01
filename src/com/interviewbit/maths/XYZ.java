package com.interviewbit.maths;

import java.util.Stack;

public class XYZ {
	public static void main(String[] args) {
		System.out.println("mystring = "+plusOne("923", "123"));
	}

	static public String plusOne(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		Stack<Integer> stack = new Stack<>();
		int carry = 0;
		int i = 0;
		int j = 0;
		for (i = n1 - 1, j = n2 - 1; i >= 0 && j >= 0; i--, j--) {
			int x = Character.getNumericValue(s1.charAt(i)) + Character.getNumericValue(s2.charAt(j)) + carry;
			if (x > 9) {
				carry = 1;
				stack.add(x % 10);
			} else {
				carry = 0;
				stack.add(x);
			}
		}
		stack.add(carry);

		while (!stack.isEmpty() && stack.peek() == 0)
			stack.pop();

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}
