package com.cmdev.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private List<Card> playerHand = new ArrayList();
	private int id;

	public Player(int playerId)
	{
		id = playerId;
	}

	public int getId()
	{
		return id;
	}

	public void addCard(Card card) {
		if (card != null)
		{
			playerHand.add(card);
		}
	}

	public void addAll(List<Card> cards)
	{
		playerHand.addAll(cards);
	}
	public int cardsInHand() {
		return playerHand.size();
	}

	public boolean hasMoreCards() {
		return !playerHand.isEmpty();
	}
	public Card topCard() {
		if (cardsInHand() != 0) {
			return playerHand.remove(0);
		} else {
			return null;
		}

	}
	public String toString()
	{
		return "Player id: "+id;
	}
}