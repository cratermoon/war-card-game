package com.cmdev.war;

public class WarGame
{
	public static void main(String[] args)
	{
		System.out.println("Would you like to play a game?");
		War game = new War();
		game.play(4,13,2);
	}

}