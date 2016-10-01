package com.interviewbit.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargetstRectangleArea {

	public static void main(String[] args) {
		Integer[] a = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(new ArrayList<>(Arrays.asList(a))));
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/LargestRectangleinHistogram.java
	// http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
	static public int largestRectangleArea(ArrayList<Integer> height) {
		int res = 0;
		int n = height.size();
		Stack<Integer> stk = new Stack<Integer>();
		int i = 0;
		while (i < n) {
			if (stk.isEmpty() == true || (height.get(i) >= height.get(stk.peek()))) {
				stk.push(i++);
			} else {
				int idx = stk.pop();
				int width = stk.isEmpty() ? i : (i - stk.peek() - 1);
				res = Math.max(res, width * height.get(idx));
			}
		}
		while (stk.isEmpty() == false) {
			int idx = stk.pop();
			int width = stk.isEmpty() ? n : (n - stk.peek() - 1);
			res = Math.max(res, width * height.get(idx));
		}
		return res;
	}
}
