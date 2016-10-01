package com.interviewbit.heapsmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		Integer input[] = { 1, 2, 1, 3, 4, 2, 3 };
		System.out.println(countDistinct(new ArrayList<>(Arrays.asList(input)), 4));
	}

	// http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
	static ArrayList<Integer> countDistinct(ArrayList<Integer> input, int w) {
		ArrayList<Integer> res = new ArrayList<>();

		int distinctCnt = 0;

		HashMap<Integer, Integer> windowMap = new HashMap<>();
		// Populate windowMap from first window of w size
		for (int i = 0; i < w; i++) {
			int n = input.get(i);
			if (windowMap.containsKey(n)) {
				windowMap.put(n, windowMap.get(n) + 1);
			} else {
				windowMap.put(n, 1);
				distinctCnt++;
			}
		}

		res.add(distinctCnt);

		for (int i = w; i < input.size(); i++) {
			int n = input.get(i - w);
			if (windowMap.get(n) == 1) {
				windowMap.remove(n);
				distinctCnt--;
			} else {
				windowMap.put(n, windowMap.get(n) - 1);
			}

			int m = input.get(i);
			if (windowMap.containsKey(m)) {
				windowMap.put(m, windowMap.get(m) + 1);
			} else {
				windowMap.put(m, 1);
				distinctCnt++;
			}

			res.add(distinctCnt);
		}

		return res;
	}
}
