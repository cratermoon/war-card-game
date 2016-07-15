package com.cmdev.war;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class OpenWarfare
{
	public void goToWar(Player winningPlayer, ListIterator<Player> playerIterator, List<Card> currentRoundCards)
	{
		System.out.println("Let's have a war!");
		// Open Warfare has broken out. Players fight fight fight
		// pull two cards, first up, first down
		// compare upcards
		// until upcard wins or a player out of cards
		Card winningCard = null;
		boolean atWar = true;
		while(playerIterator.hasNext() && atWar) {
			Player currentPlayer = playerIterator.next();
			// TODO handle case where topCard is null (it can happen)
			Card upCard = currentPlayer.topCard();
			Card downCard = currentPlayer.topCard();
			currentRoundCards.add(upCard);
			currentRoundCards.add(downCard);
			if (upCard.compareTo(winningCard) > 0) {
				currentPlayer.addCard(upCard);
				currentPlayer.addCard(downCard);
				winningCard = upCard;
				winningPlayer = currentPlayer;
				System.out.println(winningCard + " wins war for "+ currentPlayer);
				atWar = false;
			}
			if(!currentPlayer.hasMoreCards())
			{
				System.out.println("Player "+ currentPlayer.getId() + " is out of cards, removing from game");
				playerIterator.remove();
			}
		}

	}
}