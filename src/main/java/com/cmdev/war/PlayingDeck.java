package com.cmdev.war;

public class PlayingDeck implements Deck
{
	public void create( int numberOfSuits, int numberOfRanks ) {}
	public void shuffle() {}
	public Card deal()
	{
		return new Card(new Suit(), new Rank());
	}
}