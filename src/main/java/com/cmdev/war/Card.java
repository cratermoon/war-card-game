package com.cmdev.war;

/**
 * immutable
 **/

public class Card
{

	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank)
	{
		suit = suit;
		rank = rank;
	}	

	public Suit getSuit()
	{
		return suit;
	}

	public Rank getRank()
	{
		return rank;
	}
}
