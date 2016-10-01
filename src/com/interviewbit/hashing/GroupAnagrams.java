package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// String[] s = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] s = { "cat", "dog", "god", "tca" };
		ArrayList<ArrayList<Integer>> list = groupAnagrams(new ArrayList<>(Arrays.asList(s)));
		System.out.println();
	}

	// https://pengweilan.gitbooks.io/leetcode/content/String/group_anagrams.html
	static public ArrayList<ArrayList<Integer>> groupAnagrams(ArrayList<String> s) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < s.size(); i++) {
			char[] strChar = s.get(i).toCharArray();
			Arrays.sort(strChar);
			String key = new String(strChar);

			if (map.containsKey(key)) {
				map.get(key).add(i + 1);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i + 1);
				map.put(key, list);
			}
		}

		for (ArrayList<Integer> val : map.values()) {
			result.add(val);
		}

		return result;
	}
}
