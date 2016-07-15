package com.cmdev.war;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class WarfareTest
{

	@Test
	public void testGoToWar()
	{
		OpenWarfare warfare = new OpenWarfare();
		List<Player> playTesters = new ArrayList<Player>(2);
		Player player1 = new Player(1);
		player1.addCard(new Card(1,1));
		player1.addCard(new Card(2,1));
		Player player2 = new Player(2);
		player2.addCard(new Card(2,2));
		player2.addCard(new Card(3,4));
		playTesters.add(player1);
		playTesters.add(player2);
		List<Card> currentRoundCards = new ArrayList<Card>();
		warfare.goToWar(playTesters, currentRoundCards);
		assertEquals("Too many wars!", 1, warfare.getWarsFought());
		assertEquals("Wrong number of cards go to winner", 4, currentRoundCards.size());
	}
	
}