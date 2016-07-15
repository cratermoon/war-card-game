package com.cmdev.war;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class Battle
{

	private int battlesFought;

	public void battle(List<Player> players)
	{
		ListIterator<Player> playerIterator = players.listIterator();
		List<Card> cardsPlayedThisRound = new ArrayList<Card>(players.size());

		// Prime the loop
		Player roundWinner = playerIterator.next();
		Card winningCard = roundWinner.topCard();
		cardsPlayedThisRound.add(winningCard);
		//System.out.println("Battle time!");
		while(players.size() > 1 && playerIterator.hasNext())
		{
			Player currentPlayer = playerIterator.next();
			if (currentPlayer.hasMoreCards())
			{
				Card nextCard = currentPlayer.topCard();
				cardsPlayedThisRound.add(nextCard);
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
		battlesFought++;
		System.out.println(battlesFought + " battles");
	}

	public int getBattlesFought()
	{
		return battlesFought;
	}
}