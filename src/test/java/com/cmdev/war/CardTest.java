package com.cmdev.war;

import static org.junit.matchers.JUnitMatchers.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest
{
	@Test
	public void testCreate()
	{
		Card blank = new Card(3, 12);
		assertNotNull("should not be null", blank);
		assertEquals("wrong suit", 3, blank.getSuit());
		assertEquals("wrong rank", 12, blank.getRank());
	}

	@Test
	public void testCompare()
	{
		Card lowCard = new Card(0, 1);
		Card highCard = new Card(1, 12);
		Card tieCard = new Card(3, 1);

		assertTrue("low Card should be lower than high Card", lowCard.compareTo(highCard) < 0);
		assertEquals("tie Card should be same than low Card", 0, lowCard.compareTo(tieCard));
		assertTrue("high Card should be higher than low Card", highCard.compareTo(lowCard) > 0);
	}
}