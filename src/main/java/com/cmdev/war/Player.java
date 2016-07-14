package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> playerHand = new ArrayList();

	public void addCard(Card card) {
		playerHand.add(card);
	}

	public int cardsInHand() {
		return playerHand.size();
	}

	public boolean hasMoreCards() {
		return !playerHand.isEmpty();
	}
	public Card topCard() {
		if (cardsInHand() != 0) {
			return playerHand.remove(cardsInHand() - 1);
		} else {
			return null;
		}

	}
}