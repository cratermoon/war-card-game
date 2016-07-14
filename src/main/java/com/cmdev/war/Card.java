package com.cmdev.war;

/**
 * immutable
 **/

public class Card
{

	private int suit;
	private int rank;

	public Card(int aSuit, int aRank)
	{
		suit = aSuit;
		rank = aRank;
	}	

	public int getSuit()
	{
		return suit;
	}

	public int getRank()
	{
		return rank;
	}
}
