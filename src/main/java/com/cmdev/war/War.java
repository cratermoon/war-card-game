package com.cmdev.war;

public class War
{

public void play( int numberOfSuits,
	int numberOfRanks, int numberOfPlayers )
	{

		Deck deck = new PlayingDeck();
		deck.create(numberOfRanks, numberOfPlayers);
		deck.shuffle();
		deck.deal();
		//deck.hand().untilNoMoreCards();
	}
}
