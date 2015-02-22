package com.letsdeveloper.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Integer> computeFactorsFor(int n) {
		ArrayList<Integer> factors = new java.util.ArrayList<Integer>();

		for (int candidate = 2; n > 1; candidate++) {
			for (; n % candidate == 0; n /= candidate) {
				factors.add(candidate);
			}
		}

		return factors;
	}

}
