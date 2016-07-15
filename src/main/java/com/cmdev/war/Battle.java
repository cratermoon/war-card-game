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
			if(currentPlayer.hasMoreCards())
			{
				/* get the card and add it to the list of cards for this round */
				Card currentCard = currentPlayer.topCard();
				System.out.println("Player "+ currentPlayer.getId() + " has card "+currentCard+ " vs "+winningCard);
				currentRoundCards.add(currentCard);
				// if the player wins, the player's card and the other card(s) go into the player's hand
				if (currentCard.compareTo(winningCard) > 0) {
					currentRoundCards.addCard(winningCard);
					winningCard = currentCard;
					winningPlayer = currentPlayer;
					System.out.println(winningCard + " wins battle for "+ currentPlayer);
				} else if (currentCard.compareTo(winningCard) == 0)
				{
					OpenWarfare warfare = new OpenWarfare();
					warfare.goToWar(winningPlayer, playerIterator, currentRoundCards);
				}
			} else {
				// player is out of the game when they run out of cards
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