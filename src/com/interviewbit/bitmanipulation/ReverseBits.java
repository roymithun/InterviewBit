package com.interviewbit.bitmanipulation;

import java.util.ArrayList;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(intToString(3,4));
	}

	public static String intToString(int number, int groupSize) {
	    StringBuilder result = new StringBuilder();

	    for(int i = 31; i >= 0 ; i--) {
	        int mask = 1 << i;
	        result.append((number & mask) != 0 ? "1" : "0");

	        if (i % groupSize == 0)
	            result.append(" ");
	    }
	    result.replace(result.length() - 1, result.length(), "");

	    return result.toString();
	}
	
	static void reverseBits(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		while (n != 0) {
			list.add(n % 2);
			n /= 2;
		}

		for (int i : list)
			System.out.print(i);
	}

//	static public long reverse1(long a) {
//		int n = 32;
//	}

	static public long reverse(long a) {
		for (int i = 0; i < 16; i++) {
			a = swapBits(a, i, 32 - i - 1);
		}

		return a;
	}

//	static public long swapBits1(long n, int i, int j) {
//
//	}

	static public long swapBits(long n, long i, long j) {
		long a = (n >> i) & 1;
		long b = (n >> j) & 1;

		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}

		return n;
	}
}
