package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		Point[] points = { new Point(0, 0), new Point(1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0),
				new Point(0, 2) };
		// System.out.println(maxPoints(points));
	}

	// http://yucoding.blogspot.in/2013/12/leetcode-question-max-points-on-line.html
	// http://rleetcode.blogspot.in/2014/01/max-points-on-linejava.html
	// http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
	// https://github.com/leetcoders/LeetCode-Java/blob/master/MaxPointsOnALine.java
	public int maxPoints2(ArrayList<Integer> A, ArrayList<Integer> B) {

		HashMap<Double, Integer> hashMap = new HashMap<>();

		if (A == null || B == null)
			return -1;

		if (A.size() == 0)
			return 0;

		int n = A.size();
		int x1, y1, x2, y2;
		int val;
		int max = 0;

		for (int i = 0; i < n; i++) {

			x1 = A.get(i);
			y1 = B.get(i);
			hashMap.clear();

			for (int j = 0; j < n; j++) {

				if (i == j)
					continue;

				x2 = A.get(j);
				y2 = B.get(j);

				double slope = y2 - y1;
				int den = x2 - x1;

				if (den == 0)
					slope = Double.POSITIVE_INFINITY;
				else
					slope = slope / den;

				val = 1;

				if (hashMap.containsKey(slope)) {
					val = hashMap.get(slope) + 1;
				}

				hashMap.put(slope, val);

			}

			for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
				val = entry.getValue();
				max = Math.max(max, val);
			}
		}

		return max + 1;
	}

	static public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
		int result = 0;
		int n = x.size();

		for (int i = 0; i < n; ++i) {
			HashMap<Double, Integer> m = new HashMap<Double, Integer>();
			int count = 1, vertical = 0;
			for (int j = i + 1; j < n; ++j) {
				double slope = Double.POSITIVE_INFINITY;
				if (x.get(i) != x.get(j)) {
					slope = (double) (y.get(i) - y.get(j)) / (double) (x.get(i) - x.get(j));
					if (slope == -0.0)
						slope = 0.0;
				} else if (y.get(i) == y.get(j)) {
					vertical += 1;
					continue;
				}
				int tmp = 2;
				if (m.containsKey(slope)) {
					tmp = m.get(slope) + 1;
				}
				m.put(slope, tmp);
				count = Math.max(count, tmp);
			}
			result = Math.max(result, count + vertical);
		}
		return result;
	}

	// static public int maxPoints(Point[] points) {
	// int result = 0;
	// int n = points.length;
	// for (int i = 0; i < n; ++i) {
	// HashMap<Double, Integer> m = new HashMap<Double, Integer>();
	// int count = 1, vertical = 0;
	// for (int j = i + 1; j < n; ++j) {
	// double slope = Double.MIN_VALUE;
	// if (points[i].x != points[j].x) {
	// slope = (double) (points[i].y - points[j].y) / (points[i].x -
	// points[j].x);
	// if (slope == -0.0)
	// slope = 0.0;
	// } else if (points[i].y == points[j].y) {
	// vertical += 1;
	// continue;
	// }
	// int tmp = 2;
	// if (m.containsKey(slope)) {
	// tmp = m.get(slope) + 1;
	// }
	// m.put(slope, tmp);
	// count = Math.max(count, tmp);
	// }
	// result = Math.max(result, count + vertical);
	// }
	// return result;
	// }

	public int maxPoints1(ArrayList<Integer> x, ArrayList<Integer> y) {

		int n = x.size();
		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < n; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < n; j++) {
				// handle duplicates and vertical
				if (x.get(i) == x.get(j)) {
					if (y.get(i) == y.get(j)) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = y.get(j) == y.get(i) ? Double.POSITIVE_INFINITY : ((double) (y.get(j) - y.get(i)))
							/ (x.get(j) - x.get(i));

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
		}

		return max;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}