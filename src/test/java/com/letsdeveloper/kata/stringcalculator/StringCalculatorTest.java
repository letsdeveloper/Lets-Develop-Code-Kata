package com.letsdeveloper.kata.stringcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class StringCalculatorTest {

	@Test
	public void sumsEmptyStringTo0() {
		assertThat(StringCalculator.sum(""), is(0));
	}

	@Test
	public void sumsSingleNumberToItself() {
		assertThat(StringCalculator.sum("5"), is(5));
		assertThat(StringCalculator.sum("42"), is(42));
	}

	@Test
	public void sumsTwoNumbersSeperatedByComma() {
		assertThat(StringCalculator.sum("1,2"), is(3));
		assertThat(StringCalculator.sum("1,3"), is(4));
	}

	@Test
	public void sumsThreeNumbersSeperatedByComma() {
		assertThat(StringCalculator.sum("1,2,3"), is(6));
	}

	@Test
	public void sumsNumbersDelimitedByNewline() {
		assertThat(StringCalculator.sum("1\n2"), is(3));
	}

	@Test
	public void sumsNumbersDelimitedByCommaOrNewline() {
		assertThat(StringCalculator.sum("1,2\n3"), is(6));
	}

	@Test
	public void usesDelimiterSepcified() {
		assertThat(StringCalculator.sum("//;\n1;2"), is(3));
		assertThat(StringCalculator.sum("//.\n2.3.1"), is(6));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void throwsOnNegativeNumber() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3");

		StringCalculator.sum("-3");
	}

	@Test
	public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3,-5,-13");

		StringCalculator.sum("1,-3,5,-5,-13");
	}

	@Test
	public void mapsNumbersAbove1000ToLastThreeDigits() {
		assertThat(StringCalculator.sum("1002"), is(2));
		assertThat(StringCalculator.sum("1040,10002"), is(42));
	}

	@Test
	public void acceptsDelimiterOfArbitraryLength() {
		assertThat(StringCalculator.sum("//[***]\n1***2***3"), is(6));
	}

	@Test
	public void acceptsMultipleDelimiters() {
		assertThat(StringCalculator.sum("//[-][;]\n1-2;3"), is(6));
		assertThat(StringCalculator.sum("//[--][...]\n2--3...4"), is(9));
	}
}
