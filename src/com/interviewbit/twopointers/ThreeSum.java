package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// -1 0 1 2 -1 -4
		Integer[] a = { -1, 0, 1, 2, -1, -4 };
		Integer[] b = { 1, -3, -2, -4, -2, -3, 4, 3, 0, 4, 4, 4, -4, 4, -5 };
		Integer[] c = { 0, 0, 0 };
		// Arrays.sort(a);
		// System.out.println(Arrays.toString(a));
		// Integer[] a = { -25, -10, -7, -3, 2, 4, 8, 10 };
		threeSum(new ArrayList<>(Arrays.asList(a)));
	}

	static public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int n = a.size();
		if (a.size() < 3)
			return result;

		// sort array
		Collections.sort(a);

		for (int i = 0; i < n - 2; i++) {
			// avoid duplicate solutions
			if (i == 0 || a.get(i).intValue() > a.get(i - 1).intValue()) {
				int negate = -a.get(i).intValue();

				int start = i + 1;
				int end = n - 1;

				while (start < end) {
					// case 1
					if (a.get(start).intValue() + a.get(end).intValue() == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(start));
						temp.add(a.get(end));

						result.add(temp);
						start++;
						end--;

						// avoid duplicate solutions
						while (start < end && a.get(end).intValue() == a.get(end + 1).intValue())
							end--;

						while (start < end && a.get(start).intValue() == a.get(start - 1).intValue())
							start++;
					} else if (a.get(start).intValue() + a.get(end).intValue() < negate) {
						// case 2
						start++;
					} else {
						// case 3
						end--;
					}
				}

			}
		}

		return result;
	}

	static public List<List<Integer>> threeSum1(ArrayList<Integer> a) {
		Collections.sort(a);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = a.size();

		for (int i = 0; i < n - 3; i++) {
			// avoid duplicate solutions
			while (i - 1 >= 0 && i < n - 3 && a.get(i).intValue() == a.get(i - 1).intValue())
				i++;

			int x = a.get(i);
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int y = a.get(start);
				int z = a.get(end);
				System.out.printf("x=%s, y=%s, z=%s\n", x, y, z);
				if (x + y + z == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(x);
					tmp.add(y);
					tmp.add(z);
					result.add(tmp);

					start++;
					end--;

				} else if (x + y + z > 0) {
					end--;
				} else {
					start++;
				}

			}
		}
		return result;
	}

	static public List<List<Integer>> threeSum1(int[] a) {
		Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = a.length;

		for (int i = 0; i < n - 3; i++) {
			// avoid duplicate solutions
			while (i - 1 >= 0 && a[i] == a[i - 1])
				i++;

			int x = a[i];
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int y = a[start];
				int z = a[end];
				if (x + y + z == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(x);
					tmp.add(y);
					tmp.add(z);
					result.add(tmp);

					start++;
					end--;

				} else if (x + y + z > 0) {
					end--;
				} else {
					start++;
				}

			}
		}
		return result;
	}
}
