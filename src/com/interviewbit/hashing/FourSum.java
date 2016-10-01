package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		Integer[] a = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> result = fourSum(Arrays.asList(a), 0);
		System.out.println();
	}

	public ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> a, int target) {
		Collections.sort(a);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		int n = a.size();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int k = j + 1;
				int l = n - 1;
	 
				while (k < l) {
					int sum = a.get(i) + a.get(j) + a.get(k) + a.get(l);
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(j));
						temp.add(a.get(k));
						temp.add(a.get(l));
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
	
	static public List<List<Integer>> fourSum(List<Integer> a, int target) {
		int n = a.size();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n < 4)
			return result;
		Collections.sort(a);
		for (int i = 0; i < n; ++i) {
			if (i > 0 && a.get(i).intValue() == a.get(i - 1).intValue())
				continue; // avoid duplicates
			for (int j = i + 1; j < n; ++j) {
				if (j > i + 1 && a.get(j).intValue() == a.get(j - 1).intValue())
					continue; // avoid duplicates
				int twoSum = target - a.get(i) - a.get(j);
				int l = j + 1, r = n - 1;
				while (l < r) {
					int sum = a.get(l) + a.get(r);
					if (sum == twoSum) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(a.get(i));
						tmp.add(a.get(j));
						tmp.add(a.get(l));
						tmp.add(a.get(r));
						result.add(tmp);
						while (l < r && a.get(l + 1) == a.get(l))
							l++; // avoid duplicates
						while (l < r && a.get(r - 1) == a.get(r))
							r--; // avoid duplicates
						l++;
						r--;
					} else if (sum < twoSum)
						l++;
					else
						r--;
				}
			}
		}
		return result;
	}
}
