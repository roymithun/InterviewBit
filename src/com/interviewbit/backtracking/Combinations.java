package com.interviewbit.backtracking;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}
	
	static public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combineRe(n, k, 1, path, res);
        return res;
    }
    
	static void combineRe(int n, int k, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        int m = path.size();
        if (m == k) {
            ArrayList<Integer> p = new ArrayList<>(path);
            res.add(p);
            return;
        }
        for (int i = start; i <= n-(k-m)+1; ++i) {
            path.add(i);
            combineRe(n,k,i+1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
