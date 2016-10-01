package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartionProblem
{

	public static void main(String[] args)
	{
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(new Integer[] { 1000000, 1000000 }));

		ArrayList<Integer> m = new ArrayList<>(Arrays.asList(new Integer[] { 762, 798, 592, 899, 329 }));
		System.out.println(paint(6, 10, m));
	}

	// http://stackoverflow.com/a/28095738/2694480
	private static final int MOD = 10000003;

	static public int paint(int A, int B, ArrayList<Integer> C)
	{

		long res = Long.MAX_VALUE;
		long low = 0;
		long high = Long.MAX_VALUE;
		long mid;

		while (low <= high)
		{

			mid = low + ((high - low) >> 1);

			boolean status = possible(A, B, C, mid);

			if (status)
			{
				res = mid;
				high = mid - 1;
			} else
			{
				low = mid + 1;
			}
		}

		return (int) (res % MOD);

	}

	static private boolean possible(int A, int B, ArrayList<Integer> C, long time)
	{

		int n = C.size();
		int index = 0;
		long total;

		for (int i = 0; i < A && index < n; i++)
		{

			total = 0;

			while (total < time && index < n)
			{
				total += (1L * C.get(index) * B);
				if (total > time)
					break;
				index++;
			}
		}

		if (index != n)
			return false;

		return true;
	}

	static public int paint1(int k, int t, ArrayList<Integer> l)
	{
		int n = l.size();

		int MAX = Math.max(n, k);

		long[][] M = new long[MAX + 1][MAX + 1];
		int cum[] = new int[MAX + 1];
		Arrays.fill(cum, 0);
		for (int i = 1; i <= n; i++)
			cum[i] = cum[i - 1] + l.get(i - 1);

		for (int i = 1; i <= n; i++)
			M[i][1] = cum[i];
		for (int i = 1; i <= k; i++)
			M[1][i] = l.get(0);

		for (int i = 2; i <= k; i++)
		{
			for (int j = 2; j <= n; j++)
			{
				long best = Integer.MAX_VALUE;
				for (int p = 1; p <= j; p++)
				{
					best = Math.min(best, Math.max(M[p][i - 1], cum[j] - cum[p]));
				}
				M[j][i] = best;
			}
		}
		long ans = (M[n][k] * t) % 10000003;
		return (int) ans;
	}
}
