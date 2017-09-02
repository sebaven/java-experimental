package com.svenot.fibonacci;

import java.util.HashMap;

public class Fibonacci {

	private HashMap<Long, Long> memo = new HashMap<>();

	public long getNthValueWithRecursion(long n) {
		if (n < 2) {
			return n;
		}

		return getNthValueWithRecursion(n - 1) + getNthValueWithRecursion(n - 2);
	}

	public long getNthValueWithMemorizedRecursion(long n) {
		if (n < 2) {
			return n;
		}

		if (!memo.containsKey(n)) {
			memo.put(n, getNthValueWithMemorizedRecursion(n - 1) + getNthValueWithMemorizedRecursion(n - 2));
		}

		return memo.get(n);

	}

	public long getNthValueWithLoop(long n) {
		if (n < 2) {
			return n;
		}

		long computed = 1;
		long prev1 = 1;
		long prev2 = 1;
		for (int i = 3; i <= n; i++) {
			computed = prev1 + prev2;
			prev1 = prev2;
			prev2 = computed;
		}
		return computed;
	}

	public long getNthValueWithPhi(long n) {
		if (n < 2) {
			return n;
		}

		double phi = (1 + Math.sqrt(5)) / 2;
		double compute = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
		return Math.round(compute);
	}


	public static void main(String args[]) {
		int n = 10;
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(String.format("Computing the %sth Fibonnaci value:", n));

		long start = System.nanoTime();
		long result = fibonacci.getNthValueWithRecursion(n);
		long time = System.nanoTime() - start;
		System.out.println(String.format("Recursive Fibonacci method computed value %s in %s ms", result, time / 1000000.0));

		start = System.nanoTime();
		result = fibonacci.getNthValueWithMemorizedRecursion(n);
		time = System.nanoTime() - start;
		System.out.println(String.format("Recursize memorized Fibonacci method computed value %s in %s ms", result, time / 1000000.0));

		start = System.nanoTime();
		result = fibonacci.getNthValueWithLoop(n);
		time = System.nanoTime() - start;
		System.out.println(String.format("Looping Fibonacci method computed value %s in %s ms", result, time / 1000000.0));

		start = System.nanoTime();
		result = fibonacci.getNthValueWithPhi(n);
		time = System.nanoTime() - start;
		System.out.println(String.format("Phi Fibonacci method computed value %s in %s ms", result, time / 1000000.0));
	}

}
