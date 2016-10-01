package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	public static void main(String[] args) {
		ArrayList<Integer> base = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 }));
		ArrayList<ArrayList<Integer>> result = permute(base);
		System.out.println();
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/Permutations.java
	static public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> base) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		boolean[] free = new boolean[base.size()];
		Arrays.fill(free, true);
		permuteRecursive(base, result, path, free);
		return result;
	}

	static public void permuteRecursive(ArrayList<Integer> base, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> path, boolean[] free) {
		int n = base.size();
		if (path.size() == n) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(path);
			result.add(tmp);
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (free[i] == true) {
				free[i] = false;
				path.add(base.get(i));
				permuteRecursive(base, result, path, free);
				path.remove(path.size() - 1);
				free[i] = true;
			}
		}

	}
}
