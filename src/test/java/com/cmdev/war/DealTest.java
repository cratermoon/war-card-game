package com.cmdev.war;

import static org.junit.Assert.*;

import org.junit.*;

public class DealTest {

	boolean isShuffled = false;

	private Deck mockDeck = new Deck() {
		public void create(int numberOfSuits, int numberOfRanks) {};
		public void shuffle() { isShuffled = true; };
		public Card deal(){ return new Card(1,1); };
		public int numberOfCards() { return  52; };
		public boolean hasMoreCards() {
			return true;
		}
	};


	@Test
	public void testDeal() {
		mockDeck.create(4, 12);
		assertFalse("New deck should not be shuffled", isShuffled);
		mockDeck.shuffle();
		assertTrue("Deck should be shuffled", isShuffled);
	}
	
}