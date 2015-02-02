package com.letsdeveloper.kata.potter;

import org.junit.Before;
import org.junit.Test;

import static com.letsdeveloper.kata.potter.PotterBook.FIFTH;
import static com.letsdeveloper.kata.potter.PotterBook.FIRST;
import static com.letsdeveloper.kata.potter.PotterBook.FOURTH;
import static com.letsdeveloper.kata.potter.PotterBook.SECOND;
import static com.letsdeveloper.kata.potter.PotterBook.THIRD;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class PotterBookOrderTest {

	private PotterBookOrder order;

	@Before
	public void setUp() {
		order = new PotterBookOrder();
	}

	@Test
	public void noBookCostsNothing() {
		assertThatTotalInCentsIs(0);
	}

	@Test
	public void firstBookCosts8Euros() {
		order.addBook(FIRST);
		assertThatTotalInCentsIs(800);
	}

	@Test
	public void secondBookCosts8Euros() {
		order.addBook(SECOND);
		assertThatTotalInCentsIs(800);
	}

	@Test
	public void thirdBookCosts8Euros() {
		order.addBook(THIRD);
		assertThatTotalInCentsIs(800);
	}

	@Test
	public void fourthBookCosts8Euros() {
		order.addBook(FOURTH);
		assertThatTotalInCentsIs(800);
	}

	@Test
	public void fifthBookCosts8Euros() {
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(800);
	}

	@Test
	public void sameBookTwiceCosts16Euros() {
		order.addBook(FOURTH);
		order.addBook(FOURTH);
		assertThatTotalInCentsIs(1600);
	}

	@Test
	public void twoDifferentBooksReceive5PercentDiscount() {
		order.addBook(THIRD);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(1520);
	}

	@Test
	public void twoBooksDuplicatedReceive5PercentDiscount() {
		order.addBook(FIRST);
		order.addBook(FIRST);
		order.addBook(THIRD);
		order.addBook(THIRD);
		assertThatTotalInCentsIs(3040);
	}

	@Test
	public void threeBooksOnDuplicatedReceive5PercentDiscountOnTwoBooks() {
		order.addBook(FIRST);
		order.addBook(FIRST);
		order.addBook(THIRD);
		assertThatTotalInCentsIs(2320);
	}

	@Test
	public void sameBookThreeTimesCosts24Euros() {
		order.addBook(SECOND);
		order.addBook(SECOND);
		order.addBook(SECOND);
		assertThatTotalInCentsIs(2400);
	}

	@Test
	public void threeDifferentBooksReceive10PercentDiscount() {
		order.addBook(FIRST);
		order.addBook(SECOND);
		order.addBook(THIRD);
		assertThatTotalInCentsIs(2160);
	}

	@Test
	public void fourBooksOneDuplicatedReceive10PercentDiscountOnThreeBooks() {
		order.addBook(SECOND);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(2960);
	}

	@Test
	public void threeBooksDuplicatedReceive10PercentDiscount() {
		order.addBook(SECOND);
		order.addBook(SECOND);
		order.addBook(FIRST);
		order.addBook(FIRST);
		order.addBook(THIRD);
		order.addBook(THIRD);
		assertThatTotalInCentsIs(4320);
	}

	@Test
	public void fiveBooksTwoDuplicatedReceive10PercentOn3BooksAnd5PercentOnTwoBooks() {
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(3680);
	}

	@Test
	public void sameBookFourTimesCosts32Euros() {
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(THIRD);
		assertThatTotalInCentsIs(3200);
	}

	@Test
	public void fourDifferentBooksReceive20PercentDiscount() {
		order.addBook(SECOND);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(2560);
	}

	@Test
	public void fiveBooksOneDuplicatedReceive20PercentDiscountOnFourBooks() {
		order.addBook(SECOND);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(3360);
	}

	@Test
	public void sixBooksTwoDuplicatedReceive20PercentDiscountOn4BooksAnd5PercentOnTwoBooks() {
		order.addBook(FIRST);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(4080);
	}

	@Test
	public void fiveDifferentBooksReceive25PercentDiscount() {
		order.addBook(FIRST);
		order.addBook(SECOND);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(3000);
	}

	@Test
	public void manyDifferentBooksCostsWhatTheyShould() {
		order.addBook(FIRST);
		order.addBook(FIRST);
		order.addBook(FIRST);
		order.addBook(SECOND);
		order.addBook(SECOND);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(THIRD);
		order.addBook(FOURTH);
		order.addBook(FOURTH);
		order.addBook(FIFTH);
		assertThatTotalInCentsIs(3000 + 2560 + 1520 + 800);
	}

	private void assertThatTotalInCentsIs(int value) {
		int actualPriceInCents = order.getTotalInCents();
		assertThat(actualPriceInCents, is(value));
	}
}
