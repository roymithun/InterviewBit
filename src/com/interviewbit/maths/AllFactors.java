package com.interviewbit.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AllFactors {

	public static void main(String[] args) {
		// test all factors
		// for (int i : allFactors(1)) {
		// System.out.println(i + "\t");
		// }

		// test prime factors
		// for (int i : sieve(11)) {
		// System.out.println(i + "\t");
		// }

		// test plusOne
		ArrayList<Integer> a = new ArrayList<>();
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);

		for (int i : plusOne(a)) {
			System.out.println(i + "\t");
		}
	}

	public static ArrayList<Integer> allFactors(int n) {

		ArrayList<Integer> factors = new ArrayList<>();
		double sqrtA = Math.sqrt(n);
		for (int i = 1; i <= sqrtA; i++) {
			if (n % i == 0) {
				factors.add(i);
				if (i != sqrtA)
					factors.add(n / i);

			}
		}

		Collections.sort(factors);
		return factors;
	}

	public static ArrayList<Integer> sieve(int a) {
		ArrayList<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= a; i++) {
			if (isPrime(i))
				primes.add(i);
		}
		return primes;
	}

	public static boolean isPrime(int a) {
		if (a < 2)
			return false;
		double sqrtA = Math.sqrt(a);
		for (int i = 2; i <= sqrtA; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	static public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int n = a.size();

		int last = n - 1;
		if (a.get(n - 1) == 9) {
			if (a.get(0) == 0)
				last = n - 1;
			else
				last = n;
		} else if (a.get(0) == 0)
			last = n - 2;

		ArrayList<Integer> list = new ArrayList<>(last + 1);

		Stack<Integer> stack = new Stack<>();
		int carry = 0;
		for (int j = n - 1; j >= 0; j--) {
			int x = a.get(j) + carry;
			if (j == n - 1)
				x += 1;
			if (x == 10) {
				carry = 1;
				stack.add(0);
			} else {
				carry = 0;
				stack.add(x);
			}
		}
		stack.add(carry);

		while (!stack.isEmpty() && stack.peek() == 0)
			stack.pop();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		return list;
	}
}
