package com.cmdev.war;

import static org.junit.Assert.*;

import org.junit.*;

public class WarDeckTest {

	private WarDeck testDeck;
	 /* standard playing card deck */
	private int numberOfTestSuits = 4;
	private int numberOfTestRanks = 13;

	@Before
	public void setupDeck() {
		testDeck = new WarDeck(numberOfTestSuits, numberOfTestRanks);
		assertTrue("Deck should have cards in it", testDeck.hasMoreCards());
	}

	@Test
	public void testDeckSize()
	{
		assertEquals("Wrong number of cards in deck!", numberOfTestSuits*numberOfTestRanks, testDeck.numberOfCards());
	}
}