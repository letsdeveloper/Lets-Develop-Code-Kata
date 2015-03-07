package com.letsdeveloper.kata.stringcalculator;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

	private String delimiter;
	private String numbers;

	private StringCalculator(String delimiter, String numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	private int sum() {
		ensureNoNegativeNumbers();
		return getNumbers().sum();
	}

	private void ensureNoNegativeNumbers() {
		String negativeNumberSequence = getNumbers().filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!negativeNumberSequence.isEmpty()) {
			throw new IllegalArgumentException("negative number: " + negativeNumberSequence);
		}
	}

	private IntStream getNumbers() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numbers.split(delimiter))
					.mapToInt(Integer::parseInt)
					.map(n -> n % 1000);
		}
	}

	public static int sum(String input) {
		return parseInput(input).sum();
	}

	private static StringCalculator parseInput(String input) {
		if (input.startsWith("//")) {
			String[] headerAndNumberSequence = input.split("\n", 2);
			String delimiter = parseDelimiter(headerAndNumberSequence[0]);
			return new StringCalculator(delimiter, headerAndNumberSequence[1]);
		} else {
			return new StringCalculator(",|\n", input);
		}
	}

	private static String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}
		return Stream.of(delimiter.split("]\\["))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}

}
