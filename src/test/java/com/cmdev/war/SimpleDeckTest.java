package com.cmdev.war;

import static org.junit.Assert.*;

import org.junit.*;

public class SimpleDeckTest {

	private SimpleDeck testDeck;
	 /* standard playing card deck */
	private int numberOfTestSuits = 4;
	private int numberOfTestRanks = 13;

	@Before
	public void setupDeck() {
		testDeck = new SimpleDeck();
		testDeck.create(numberOfTestSuits, numberOfTestRanks);
	}

	@Test
	public void testDeckIsNotEmpty()
	{
		assertFalse("Deck should have cards in it", testDeck.isEmpty());
	}

	@Test
	public void testDeckSize()
	{
		int expectedCardCount = numberOfTestSuits*numberOfTestRanks;
		assertEquals(expectedCardCount + "cards expected in SimpleDeck", expectedCardCount, testDeck.size());
	}
}