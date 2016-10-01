package com.interviewbit.maths;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		Integer[] a = {4, 0, 2, 1, 3};
		arrange(new ArrayList<>(Arrays.asList(a)));
	}

	static public void arrange(ArrayList<Integer> a) {
		int n = a.size();
		for (int i = 0; i < n; i++)
			a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);

		for (int i = 0; i < n; i++)
			a.set(i, a.get(i) / n);

	}
}
