package com.cmdev.war;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest
{
	@Test
	public void testCreate()
	{
		Card blank = new Card(new Suit(), new Rank());
		assertNotNull("should not be null", blank);
	}
}