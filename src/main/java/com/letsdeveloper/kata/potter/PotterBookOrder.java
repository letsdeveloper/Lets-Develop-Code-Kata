package com.letsdeveloper.kata.potter;

import java.util.Map;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;

public class PotterBookOrder {

	private static final int SINGLE_BOOK_PRICE = 800;

	private static final Map<Integer, Double> DISCOUNT_FACTOR = ImmutableMap.<Integer, Double> builder()
			.put(5, 0.75)
			.put(4, 0.80)
			.put(3, 0.90)
			.put(2, 0.95)
			.put(1, 1.00)
			.build();

	private Multiset<PotterBook> books = EnumMultiset.create(PotterBook.class);

	public int getTotalInCents() {
		int total = 0;
		Multiset<PotterBook> remainingBooks = EnumMultiset.create(books, PotterBook.class);
		while (getNumberOfBooks(remainingBooks) > 0) {
			int numberOfDistinctBooks = getNumberOfDistinctBooks(remainingBooks);
			total += numberOfDistinctBooks * SINGLE_BOOK_PRICE * DISCOUNT_FACTOR.get(numberOfDistinctBooks);
			removeOneIssueOfEachBook(remainingBooks);
		}
		return total;
	}

	private void removeOneIssueOfEachBook(Multiset<PotterBook> remainingBooks) {
		for (PotterBook book : PotterBook.values()) {
			remainingBooks.remove(book, 1);
		}
	}

	private int getNumberOfBooks(Multiset<PotterBook> remainingBooks) {
		return remainingBooks.size();
	}

	private int getNumberOfDistinctBooks(Multiset<PotterBook> remainingBooks) {
		return remainingBooks.elementSet().size();
	}

	public void addBook(PotterBook book) {
		books.add(book);
	}

}
