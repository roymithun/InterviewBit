package com.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimetoBuyandSellStockIII
{

	public static void main(String[] args)
	{
		Integer[] prices = { 1, 4, 5, 7, 6, 3, 2, 9 };
		System.out.println(maxProfit(Arrays.asList(prices)));
	}

	// https://leetcode.com/discuss/91739/my-explanation-for-o-n-solution
	static public int maxProfit(List<Integer> prices)
	{
		int sell1 = 0;
		int sell2 = 0;

		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;

		for (int i = 0; i < prices.size(); i++)
		{
			buy1 = Math.max(buy1, -prices.get(i));
			sell1 = Math.max(sell1, buy1 + prices.get(i));
			buy2 = Math.max(buy2, sell1 - prices.get(i));
			sell2 = Math.max(sell2, buy2 + prices.get(i));
		}
		return sell2;
	}

	static public int maxProfit1(ArrayList<Integer> prices)
	{
		int n = prices.size();

		if (n <= 1)
			return 0;
		int[] left2right = new int[n];
		int[] right2left = new int[n];

		left2right[0] = 0;
		right2left[n - 1] = 0;

		int minVal = prices.get(0);
		int maxVal = prices.get(n - 1);

		for (int i = 1; i < n; ++i)
		{
			left2right[i] = Math.max(left2right[i - 1], prices.get(i) - minVal);
			minVal = Math.min(minVal, prices.get(i));
		}

		for (int i = n - 2; i >= 0; --i)
		{
			right2left[i] = Math.max(right2left[i + 1], maxVal - prices.get(i));
			maxVal = Math.max(maxVal, prices.get(i));
		}

		int result = left2right[n - 1];
		for (int i = 0; i < n - 1; ++i)
		{
			result = Math.max(result, left2right[i] + right2left[i + 1]);
		}
		return result;
	}
}
