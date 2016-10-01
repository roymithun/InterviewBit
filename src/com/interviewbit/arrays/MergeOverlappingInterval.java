package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingInterval {

	public static void main(String[] args) {

		ArrayList<Interval> intervals = new ArrayList<>();
		// [1,3],[2,6],[8,10],[15,18]
		// intervals.add(new Interval(1, 3));
		// intervals.add(new Interval(2, 6));
		// intervals.add(new Interval(15, 18));
		// intervals.add(new Interval(8, 10));

		// { {6,8}, {1,9}, {2,4}, {4,7} }
		intervals.add(new Interval(6, 8));
		intervals.add(new Interval(1, 9));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(4, 7));

		merge(intervals);
	}

	// http://www.programcreek.com/2012/12/leetcode-merge-intervals/
	// http://www.geeksforgeeks.org/merging-intervals/
	static public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if (intervals == null || intervals.size() <= 1)
			return intervals;

		Collections.sort(intervals, new IntervalComparator());

		ArrayList<Interval> result = new ArrayList<>();
		Interval prev = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);

			if (prev.end >= current.start) {
				Interval mergedInterval = new Interval(prev.start, Math.max(prev.end, current.end));
				prev = mergedInterval;
			} else {
				result.add(prev);
				prev = current;
			}
		}
		result.add(prev);
		return result;
	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}

	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
