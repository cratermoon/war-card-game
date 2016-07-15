package com.cmdev.war;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class War
{
	private int numberOfSuits;
	private int numberOfRanks;
	private int numberOfPlayers;
	private List<Player> players;
	private long startTime;

	public void setupPlayers() {
		players = new ArrayList(numberOfPlayers);
		for (int playerId = 0; playerId < numberOfPlayers; playerId++) {
			players.add(new Player(playerId+1));
		}

	}
	public void setupGame() {
		WarDeck playingDeck = new WarDeck(numberOfSuits, numberOfRanks);
		System.out.println("Dealing..");
		while (playingDeck.hasMoreCards()) {
			// prefer simple loop vs Iterator here to avoid excessive object creation 
			for (int iter = 0;  playingDeck.hasMoreCards() && (iter < numberOfPlayers); iter++)
			{

				players.get(iter).addCard(playingDeck.dealCard());
			}
		}
		System.out.println("..done");
	}

	// Required as is by design document
	public void play(int numberOfSuits,
		int numberOfRanks, int numberOfPlayers)
	{
		System.out.println("Starting a game of War with "+numberOfPlayers+" players");
		startTime = java.lang.System.currentTimeMillis();
		this.numberOfSuits = numberOfSuits;
		this.numberOfRanks = numberOfRanks;
		this.numberOfPlayers = numberOfPlayers;
		setupPlayers();
		setupGame();

		Battle battle = new Battle();
		while(players.size() > 1)
		{
			battle.battle(players);
		}
		
		endGame();
	}
	public void endGame() {
		Iterator<Player> itr = players.listIterator();
		while(itr.hasNext())
		{
			Player p = itr.next();
			System.out.println("Player " + p.getId() + " has "+p.cardsInHand());
		}
		long playTime = java.lang.System.currentTimeMillis() - startTime;
		System.out.println("Game over man, game over! Play time, in ms: "+ playTime);
	}
}
