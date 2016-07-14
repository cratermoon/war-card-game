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
		List<Card> currentRoundCards = new ArrayList<Card>(players.size());
		Card winningCard = null;
		Player winningPlayer = players.get(0);
		while(players.size() > 1 && playerIterator.hasNext()) {
			Player currentPlayer = playerIterator.next();
			// player is out of the game when they run out of cards
			/* get the card and add it to the list of cards for this round */
			Card currentCard = currentPlayer.topCard();
			currentRoundCards.add(currentCard);
			if (currentCard.compareTo(winningCard) > 0) {
				currentPlayer.addCard(currentCard);
				winningCard = currentCard;
				winningPlayer = currentPlayer;
				System.out.println(winningCard + " wins battle for "+ currentPlayer);
			} else if (currentCard.compareTo(winningCard) == 0)
			{
				OpenWarfare warfare = new OpenWarfare();
				warfare.goToWar(playerIterator, currentRoundCards);
			}
			if(!currentPlayer.hasMoreCards())
			{
				System.out.println("Player "+ currentPlayer.getId() + " is out of cards, removing from game");
				playerIterator.remove();
			}
		}
		battlesFought++;
	}

	public int getBattlesFought()
	{
		return battlesFought;
	}
}