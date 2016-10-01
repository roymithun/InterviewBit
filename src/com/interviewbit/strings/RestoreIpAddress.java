package com.interviewbit.strings;

import java.util.ArrayList;

public class RestoreIpAddress {

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/RestoreIPAddresses.java
	static public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		dfs(s, new String(), 0, 0, res);
		return res;
	}

	static public void dfs(String s, String ip, int start, int step, ArrayList<String> res) {
		int n = s.length();
		if (step == 4 && start == n) {
			res.add(ip);
			// return;
		}
		if (step == 4)
			return;
		if (n - start > (4 - step) * 3)
			return;
		if (n - start < 4 - step)
			return;
		if (ip.length() != 0)
			ip += ".";
		int num = 0;
		for (int i = start; i < start + 3 && i < n; ++i) {
			num = num * 10 + s.charAt(i) - '0';
			if (num > 255)
				break;
			ip += s.charAt(i);
			dfs(s, ip, i + 1, step + 1, res);
			if (num == 0)
				break;
		}
	}
}
