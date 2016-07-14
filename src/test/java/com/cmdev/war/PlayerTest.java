package com.cmdev.war;

import java.util.Random;

import static org.junit.Assert.*;

import org.junit.*;

public class PlayerTest {
	
	private Player player;
	int testPlayerId = 2187;

	@Before
	public void setup() {
		player = new Player(testPlayerId);
	}

	@Test
	public void testPlayer() {
		assertEquals("Wrong ID for test Player", testPlayerId, player.getId());
		assertFalse("Player should not have any cards yet", player.hasMoreCards());
		assertEquals("Player should have 0 cards", 0, player.cardsInHand());
		assertNull("top card should be null", player.topCard());
	}

	@Test
	public void testPlayerCardHandling() {
		Random rng = new Random();
		int suit = rng.nextInt();
		int rank = rng.nextInt();
		player.addCard(new Card(suit, rank));
		assertEquals("Player should have 1 card", 1, player.cardsInHand());
		assertTrue("Player should have cards left", player.hasMoreCards());
		Card topCard = player.topCard();
		assertNotNull("Player should have one card in hand", topCard);
		assertEquals("Top card should have suit "+ suit, suit, topCard.getSuit());
		assertEquals("Top card should have rank "+ rank, rank, topCard.getRank());

		assertEquals("Player should have no cards", 0, player.cardsInHand());
		assertNull("top card should be null", player.topCard());
	}

	@Test
	public void testPlayerManyCards() {
		Random rng = new Random();
		int numberOfCards = rng.nextInt(26) + 1;
	
		System.out.println(numberOfCards + " cards to be dealt");

		for (int iter = 0; iter < numberOfCards; iter++) {
			int suit = rng.nextInt();
			int rank = rng.nextInt();
			player.addCard(new Card(suit, rank));
			assertEquals("Player should now have hand of size ", iter + 1, player.cardsInHand());
		}

		assertEquals("Player should have been dealt a hand of size ", numberOfCards, player.cardsInHand());
		Card topCard = player.topCard();
		assertNotNull("Player's top card should not be null", topCard);

		/* Give the player back the last card */
		player.addCard(topCard);

		int cardsLeft = numberOfCards;
		for (int iter = 0; iter < numberOfCards; iter++) {
			assertEquals("Before play, player should have a hand of size ", cardsLeft, player.cardsInHand());
			topCard = player.topCard();
			cardsLeft--;
			assertEquals("After play, player should have a hand of size ", cardsLeft, player.cardsInHand());
		}

		assertEquals("Player should have no cards", 0, player.cardsInHand());
		topCard = player.topCard();
		assertNull("top card should be null", player.topCard());
	}
}