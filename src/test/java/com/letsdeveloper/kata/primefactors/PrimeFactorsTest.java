package com.letsdeveloper.kata.primefactors;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {

	@Test
	public void oneHasNotPrimeFactor() {
		assertEquals(asList(), PrimeFactors.computeFactorsFor(1));
	}

	@Test
	public void twoHasOnlyItselfAsAPrimeFactor() {
		assertEquals(asList(2), PrimeFactors.computeFactorsFor(2));
	}

	@Test
	public void threeHasOnlyItselfAsAPrimeFactor() {
		assertEquals(asList(3), PrimeFactors.computeFactorsFor(3));
	}

	@Test
	public void fourHasTwoTimesTwoAsPrimeFactors() {
		assertEquals(asList(2, 2), PrimeFactors.computeFactorsFor(4));
	}

	@Test
	public void fiveHasOnlyItselfAsAPrimeFactor() {
		assertEquals(asList(5), PrimeFactors.computeFactorsFor(5));
	}

	@Test
	public void sixHasTwoAndThreeAsPrimeFactors() {
		assertEquals(asList(2, 3), PrimeFactors.computeFactorsFor(6));
	}

	@Test
	public void eightHasThreeTimesTwoAsPrimeFactors() {
		assertEquals(asList(2, 2, 2), PrimeFactors.computeFactorsFor(8));
	}

	@Test
	public void nineHasTwoTimesThreeAsPrimeFactors() {
		assertEquals(asList(3, 3), PrimeFactors.computeFactorsFor(9));
	}

	@Test
	public void tenHasTwoAndFiveAsPrimeFactors() {
		assertEquals(asList(2, 5), PrimeFactors.computeFactorsFor(10));
	}
}
