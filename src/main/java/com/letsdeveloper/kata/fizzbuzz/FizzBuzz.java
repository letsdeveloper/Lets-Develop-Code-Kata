package com.letsdeveloper.kata.fizzbuzz;

public class FizzBuzz {

	public static String getAnswerFor(int number) {
		checkArguments(number);
		return computeAnswer(number);
	}

	private static void checkArguments(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("number smaller 1");
		}
	}

	private static String computeAnswer(int number) {
		String answer = String.valueOf(number);
		if (isMultipleOfThree(number) && isMultipleOfFive(number)) {
			answer = "FizzBuzz";
		} else if (isMultipleOfThree(number)) {
			answer = "Fizz";
		} else if (isMultipleOfFive(number)) {
			answer = "Buzz";
		}
		return answer;
	}

	private static boolean isMultipleOfThree(int number) {
		return number % 3 == 0;
	}

	private static boolean isMultipleOfFive(int number) {
		return number % 5 == 0;
	}

}
