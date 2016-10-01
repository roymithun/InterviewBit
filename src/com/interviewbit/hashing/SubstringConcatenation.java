package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {

	public static void main(String[] args) {
		String base = "barafoofoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> list = findSubstring(base, new ArrayList<>(Arrays.asList(words)));
		System.out.println();
	}

	// sliding window + hashmap
	// http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/
	// https://github.com/leetcoders/LeetCode-Java/blob/master/SubstringwithConcatenationofAllWords.java
	static public List<Integer> findSubstring(String s, ArrayList<String> words) {
		int n = words.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || n == 0) {
			return result;
		}

		// frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
		}

		int len = words.get(0).length();

		for (int j = 0; j < len; j++) {
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;
			int count = 0;// count total qualified words so far

			for (int i = j; i <= s.length() - len; i = i + len) {
				String sub = s.substring(i, i + len);
				if (map.containsKey(sub)) {
					// set frequency in current map
					currentMap.put(sub, currentMap.containsKey(sub) ? currentMap.get(sub) + 1 : 1);
					count++;

					while (currentMap.get(sub) > map.get(sub)) {
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start = start + len;
					}

					if (count == n) {
						result.add(start); // add to result

						// shift right and reset currentMap, count & start point
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}
				} else {
					currentMap.clear();
					start = i + len;
					count = 0;
				}
			}
		}

		return result;
	}
}
