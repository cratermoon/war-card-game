package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PlayingDeck implements Deck
{
	private List<Card> playingDeck;

	public void create( int numberOfSuits, int numberOfRanks )
	{
		playingDeck = new ArrayList<Card>(numberOfSuits * numberOfRanks);
		/* We do this 1-based to avoid confusion about suit/rank 0 */
		for(int suit = 1; suit <= numberOfSuits; suit++)
		{
			for(int rank = 1; rank <= numberOfRanks; rank++)
			{
				playingDeck.add(new Card(suit, rank));
			}
		}	
	}

	public void shuffle()
	{
		Collections.shuffle(playingDeck);
	}

	public Card deal()
	{
		if (hasMoreCards())
		{
			return playingDeck.remove(playingDeck.size() - 1); // More efficient to deal from the bottom
		} else
		{
			return null;
		}
	}

	public int numberOfCards()
	{
		return playingDeck.size();
	}

	public boolean hasMoreCards()
	{
		return !playingDeck.isEmpty();
	}
}