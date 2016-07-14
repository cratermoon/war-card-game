package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class WarDeck
{
	private SimpleDeck playingDeck;

	public WarDeck(int numberOfSuits, int numberOfRanks)
	{
		playingDeck = new SimpleDeck();
		playingDeck.create(numberOfSuits, numberOfRanks);
		playingDeck.shuffle();
	}

	public int numberOfCards()
	{
		return playingDeck.size();
	}

	public boolean hasMoreCards()
	{
		return !playingDeck.isEmpty();
	}

	public Card dealCard() {
		if(hasMoreCards())
		{
			return playingDeck.deal();
		} else
		{
			return null;
		}
	}
}