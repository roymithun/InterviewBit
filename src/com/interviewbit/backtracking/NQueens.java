package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	public static void main(String[] args) {
		NQueens nqueens = new NQueens();
		nqueens.solveNQueens(4);
	}

	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		ArrayList<char[]> sol = new ArrayList<char[]>();
		solveNQueensRe(n, 0, 0, 0, sol, res);
		return res;
	}

	public void solveNQueensRe(int n, int row, int ld, int rd, ArrayList<char[]> sol, ArrayList<ArrayList<String>> res) {
		if (row == (1 << n) - 1) {
			ArrayList<String> temp = new ArrayList<>();
			for (int i = 0; i < n; ++i)
				temp.add(String.valueOf(sol.get(i)));
			res.add(temp);
			return;
		}
		int avail = ~(row | ld | rd);
		for (int i = n - 1; i >= 0; --i) {
			int pos = 1 << i;
			if ((int) (avail & pos) != 0) {
				char[] str = new char[n];
				Arrays.fill(str, '.');
				str[i] = 'Q';
				sol.add(str);
				solveNQueensRe(n, row | pos, (ld | pos) << 1, (rd | pos) >> 1, sol, res);
				sol.remove(sol.size() - 1);
			}
		}
	}
}
