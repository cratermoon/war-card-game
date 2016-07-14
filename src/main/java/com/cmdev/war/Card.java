package com.cmdev.war;

import java.lang.Comparable;

/**
 * immutable
 **/

public class Card implements Comparable<Card>
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

	/*
	 * The rules of War say that suit doesn't matter, only rank
	 * Comparing to the null card means this card outranks it
	 */
	public int compareTo(Card card) {
		// card == null then return 1
		return (card == null ? 1 : this.rank - card.getRank());
	}

	public String toString()
	{
		return "Card suit: "+suit+", rank: "+rank;
	}
}
