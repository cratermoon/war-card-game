package com.cmdev.war;

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
}