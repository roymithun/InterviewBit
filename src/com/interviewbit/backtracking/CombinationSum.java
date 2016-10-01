package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum {

	public static void main(String[] args) {
		ArrayList<Integer> candidates = new ArrayList<>(Arrays.asList(new Integer[] { 2, 3, 6, 7 }));
		System.out.println(combinationSum(candidates, 7));
	}

	static public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Collections.sort(candidates);
		Set<Integer> path = new HashSet<Integer>();
		combinationSumRe(candidates, target, 0, path, res);
		return res;
	}

	static void combinationSumRe(ArrayList<Integer> candidates, int target, int start, Set<Integer> path,
			ArrayList<ArrayList<Integer>> res) {
		if (target == 0) {
			ArrayList<Integer> p = new ArrayList<Integer>(path);
			res.add(p);
			return;
		}
		for (int i = start; i < candidates.size() && target >= candidates.get(i); ++i) {
			if(target < candidates.get(i)) 
	            return;
	 
			path.add(candidates.get(i));
			combinationSumRe(candidates, target - candidates.get(i), i, path, res);
			path.remove(path.size() - 1);
		}
	}
}
