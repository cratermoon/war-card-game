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

	@Test
	public void testProlongedWar()
	{
		OpenWarfare warfare = new OpenWarfare();
		List<Player> playTesters = new ArrayList<Player>(2);
		Player player1 = new Player(1);
		// first round
		player1.addCard(new Card(1,2));
		player1.addCard(new Card(2,5));
		// second round
		player1.addCard(new Card(2,12));
		player1.addCard(new Card(3,12));

		Player player2 = new Player(2);
		// first round
		player2.addCard(new Card(2,2));
		player2.addCard(new Card(3,5));
		// second round
		player2.addCard(new Card(1,12));
		player2.addCard(new Card(3,12));

		playTesters.add(player1);
		playTesters.add(player2);
		List<Card> currentRoundCards = new ArrayList<Card>();
		warfare.goToWar(playTesters, currentRoundCards);
		assertEquals("Wrong number of wars!", 2, warfare.getWarsFought());
		assertEquals("Wrong number of cards go to winner", 4, currentRoundCards.size());

	}
	
}