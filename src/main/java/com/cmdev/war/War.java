package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;

public class War
{
	private int numberOfSuits;
	private int numberOfRanks;
	private int numberOfPlayers;
	private List<Player> players;

	public void setupPlayers() {
		players = new ArrayList(numberOfPlayers);
		for (int iter = 0; iter < numberOfPlayers; iter++) {
			players.add(new Player());
		}

	}
	public void setupGame() {
		WarDeck playingDeck = new WarDeck(numberOfRanks, numberOfPlayers);
	}

	/* Required as is by design document */
	public void play(int numberOfSuits,
		int numberOfRanks, int numberOfPlayers)
	{
		this.numberOfSuits = numberOfSuits;
		this.numberOfRanks = numberOfRanks;
		this.numberOfPlayers = numberOfPlayers;
		setupPlayers();
		setupGame();
		endGame();
	}
	public void endGame() {
		System.out.println("Game over man, game over!");
	};
}
