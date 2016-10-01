package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		subsets(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 2 })));
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/Subsets.java
	static public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsetsRe(a, 0, path, res);
		return res;
	}

	static void subsetsRe(ArrayList<Integer> a, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> sub = new ArrayList<Integer>(path);
		res.add(sub);
		for (int i = start; i < a.size(); ++i) {
			path.add(a.get(i));
			subsetsRe(a, i + 1, path, res);
			path.remove(path.size() - 1);
		}
	}

	// my try
	static public List<List<Integer>> subsets1(int[] nums) {
		int n = nums.length;

		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for (int j = 1; j < n; j++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i <= j; i++) {
				temp.add(nums[i]);
			}
			set.add(temp);
		}
		return null;
	}
}
