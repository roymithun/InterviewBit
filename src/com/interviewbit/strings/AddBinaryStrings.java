package com.interviewbit.strings;

import java.util.Stack;

public class AddBinaryStrings {

	public static void main(String[] args) {
		System.out.println(addBinary("100", "11"));
	}

	// http://www.programcreek.com/2014/05/leetcode-add-binary-java/
	static public String addBinary(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;

		int carry = 0;
		int aLen = a.length();
		int bLen = b.length();

		int i = aLen - 1;
		int j = bLen - 1;
		Stack<Integer> stack = new Stack<>();
		while (i >= 0 || j >= 0) {
			int valA = 0;
			int valB = 0;

			if (i >= 0) {
				valA = a.charAt(i) == '0' ? 0 : 1;
				i--;
			}
			if (j >= 0) {
				valB = b.charAt(j) == '0' ? 0 : 1;
				j--;
			}

			int sum = valA + valB + carry;
			if (sum >= 2) {
				stack.push(sum - 2);
				carry = 1;
			} else {
				stack.push(sum);
				carry = 0;
			}
		}

		if (carry == 1)
			stack.push(carry);

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}
