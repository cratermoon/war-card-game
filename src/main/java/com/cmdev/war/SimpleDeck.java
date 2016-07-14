package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SimpleDeck implements Deck {
	
	private List<Card> deckOfCards;

	public void create(int numberOfSuits, int numberOfRanks)
	{
		deckOfCards = new ArrayList<Card>(numberOfSuits * numberOfRanks);
		/* We do this 1-based to avoid confusion about suit/rank 0 */
		for(int suit = 1; suit <= numberOfSuits; suit++)
		{
			for(int rank = 1; rank <= numberOfRanks; rank++)
			{
				deckOfCards.add(new Card(suit, rank));
			}
		}	
	}

	public void shuffle()
	{
		Collections.shuffle(deckOfCards);
	}

	public Card deal()
	{
		if (!deckOfCards.isEmpty())
		{
			return deckOfCards.remove(deckOfCards.size() - 1); // More efficient to deal from the bottom
		} else
		{
			return null;
		}
	}

	public int size() {
		return deckOfCards.size();
	}

	public boolean isEmpty()
	{
		return deckOfCards.isEmpty();
	}
}