package com.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinsInALine {
	public static void main(String[] args) {
		Integer[] coins = {3, 2, 2, 3, 1, 2};
		System.out.println(maxMoney(new ArrayList<Integer>(Arrays.asList(coins))));
	}

	static int maxMoney(final ArrayList<Integer> coins) {
		int n = coins.size();
		int[][] sum = new int[n][n];
		int[][] dp = new int[n][n];

		// fills upper half of sums matrix
		for (int i = n - 1; i >= 0; i--)
			for (int j = i; j < n; j++)
				sum[i][j] = coins.get(j) + (i == j ? 0 : sum[i][j - 1]);

		for (int i = n - 1; i >= 0; i--)
			for (int j = i; j < n; j++) {
				if (i == j)
					dp[i][j] = coins.get(i);
				else
					dp[i][j] = sum[i][j] - Math.min(dp[i + 1][j], dp[i][j - 1]);
			}
		return dp[0][n - 1];
	}
}
