package com.interviewbit.maths;

import java.util.ArrayList;

public class PrimeSum {

	public static void main(String[] args) {
		// test prime factors
		for (int i : primesum(12)) {
			System.out.println(i + "\t");
		}

	}

	public static ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> numbers = new ArrayList<>();

		int first = 0;
		int second = 0;
		for (int i = 2; i < a; i++) {
			if(numbers.size()>=2)
				break;
			first = i;
			if (isPrime(first)) {
				second = a - first;
				if (isPrime(second)) {
					numbers.add(first);
					numbers.add(second);
				}
			}
		}
		return numbers;
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
}
