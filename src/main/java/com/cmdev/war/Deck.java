package com.cmdev.war;

public interface Deck
{
	public void create( int numberOfSuits, int numberOfRanks );
	public void shuffle();
	public Card deal();
}
