package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetsII {
	public static void main(String[] args) {
		subsetsII(new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 2 })));
	}

	//https://github.com/leetcoders/LeetCode-Java/blob/master/SubsetsII.java
	static public ArrayList<ArrayList<Integer>> subsetsII(ArrayList<Integer> a) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsetsRecursive(a, 0, path, res);
		return res;
	}

	static void subsetsRecursive(ArrayList<Integer> a, int start, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> sub = new ArrayList<Integer>(path);
		res.add(sub);
		for (int i = start; i < a.size(); ++i) {
			if (i != start && a.get(i) == a.get(i - 1))
				continue;
			path.add(a.get(i));
			subsetsRecursive(a, i + 1, path, res);
			path.remove(path.size() - 1);
		}
	}
}
