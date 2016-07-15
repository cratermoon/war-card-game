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
		ListIterator<Player> playerIterator = players.listIterator();
	
		// Prime the loop
		Player roundWinner = playerIterator.next();
		Card winningCard = roundWinner.topCard();
		Card downCard = roundWinner.topCard();
		cardsPlayedThisRound.add(winningCard);
		cardsPlayedThisRound.add(downCard);
		while(players.size() > 1 && playerIterator.hasNext())
		{
			Player currentPlayer = playerIterator.next();
			if (currentPlayer.hasMoreCards())
			{
				Card nextCard = currentPlayer.topCard();
				downCard = currentPlayer.topCard();
				cardsPlayedThisRound.add(nextCard);
				cardsPlayedThisRound.add(downCard);
				if (nextCard.compareTo(winningCard) > 0)
				{
					//System.out.println("Player "+currentPlayer+ " wins");
					winningCard = nextCard;
					roundWinner = currentPlayer;
				} else if (nextCard.compareTo(winningCard) == 0)
				{
					// wartime
					playerIterator.remove();
				} else {
					System.out.println("Player "+roundWinner+ " wins");
				}
			} else {
				System.out.println("Removing player with no cards");
				playerIterator.remove();
			}
		}
		roundWinner.addAll(cardsPlayedThisRound);
		warsFought++;
		System.out.println(warsFought + " battles");
	}

	public int getWarsFought()
	{
		return warsFought;
	}
}