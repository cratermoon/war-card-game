package com.cmdev.war;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class OpenWarfare
{
	private int warsFought;

	public void goToWar(List<Player> players, List<Card> cardsPlayedThisRound)
	{
		System.out.println("Let's have a war!");
		// just like battle except for 2 cards at a time?
	
		// Prime the loop
		Player roundWinner = players.get(0);
		Card winningCard = roundWinner.topCard();
		Card downCard = roundWinner.topCard();
		cardsPlayedThisRound.add(winningCard);
		cardsPlayedThisRound.add(downCard);
		warsFought = 0;
		boolean atWar = true;
		while (atWar)
		{
			ListIterator<Player> playerIterator = players.listIterator();
			while(players.size() > 1 && playerIterator.hasNext())
			{
				System.out.println(players.size()+ " armies");
				System.out.println("War round "+ (++warsFought));
				Player currentPlayer = playerIterator.next();
				if (currentPlayer.hasMoreCards())
				{
					Card nextCard = currentPlayer.topCard();
					downCard = currentPlayer.topCard();
					cardsPlayedThisRound.add(nextCard);
					cardsPlayedThisRound.add(downCard);
					if (nextCard.compareTo(winningCard) > 0)
					{
						System.out.println("Player "+currentPlayer+ " wins the war!");
						atWar = false;
						winningCard = nextCard;
						roundWinner = currentPlayer;
					} else if (nextCard.compareTo(winningCard) == 0)
					{
						// wartime
						playerIterator.remove();
					} else {
						atWar = false;
						System.out.println("Player "+roundWinner+ " wins the war");
					}
				} else {
					System.out.println("Removing player with no cards");
					playerIterator.remove();
					if (players.size() == 1)
					{
						atWar = false;
					}
				}
			}			
		}
		roundWinner.addAll(cardsPlayedThisRound);
	}

	public int getWarsFought()
	{
		return warsFought;
	}
}