package com.cmdev.war;


import java.util.ArrayList;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class BattleTest
{
	List<Player> testPlayers;

	@Test
	public void testBattle() {

		Player player1 = new Player(1);
		Player player2 = new Player(2);
		player1.addCard(new Card(1,1));
		player2.addCard(new Card(1,2));
		testPlayers = new ArrayList<Player>(2);
		testPlayers.add(player1);
		testPlayers.add(player2);
		Battle testBattle = new Battle();
		testBattle.battle(testPlayers);

		assertEquals("Only one battle should have happened", 1, testBattle.getBattlesFought());
		assertEquals("Player 1 should be out of cards", 0, player1.cardsInHand());
		assertEquals("Player 2 should have all the cards", 2, player2.cardsInHand());
	}
	
}