package com.letsdeveloper.kata.fizzbuzz;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

	@Test
	public void shouldReturnNumberIfNotDevisibleByThreeAndFive() {
		assertThatAnswerFor(1, is("1"));
		assertThatAnswerFor(2, is("2"));
		assertThatAnswerFor(4, is("4"));
		assertThatAnswerFor(7, is("7"));
	}

	@Test
	public void shouldReturnFizzForMultiplesOfThree() {
		assertThatAnswerFor(3, is("Fizz"));
		assertThatAnswerFor(6, is("Fizz"));
	}

	@Test
	public void shouldReturnBuzzForMultiplesOfFive() {
		assertThatAnswerFor(5, is("Buzz"));
		assertThatAnswerFor(10, is("Buzz"));
	}

	@Test
	public void shouldReturnFizzBuzzForMultiplesOfThreeAndFive() {
		assertThatAnswerFor(15, is("FizzBuzz"));
		assertThatAnswerFor(30, is("FizzBuzz"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowForZero() {
		FizzBuzz.getAnswerFor(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowForMinus1() {
		FizzBuzz.getAnswerFor(-1);
	}

	private void assertThatAnswerFor(int number, Matcher<String> matcher) {
		assertThat(FizzBuzz.getAnswerFor(number), matcher);
	}
}
