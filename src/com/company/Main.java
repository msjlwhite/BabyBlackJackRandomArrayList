/*
Author:J White
Date: 4/16/2019
Task: Baby Blackjack
Write a program that allows a human user to play a single hand of "blackjack"
against a dealer.

Pick two values from 1-10 for the player. These are the player's "cards".
Pick two more values from 1-10 for the dealer.
Whoever has the highest total is the winner.
There is no betting, no busting, and no hitting. Save that for real blackjack.

*/

package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //calls the BlackJack class to start the game
        BlackJack start = new BlackJack();
        start.game();

    }
}
