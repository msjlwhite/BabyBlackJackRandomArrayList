/*
Author:J White
Date: 4/18/2019
Peer Reviewer: Steve Scruggs
Task: Baby Blackjack
Write a program that allows a human user to play a single hand of "blackjack" against a dealer.
Pick two values from 1-10 for the player. These are the player's "cards".
Pick two more values from 1-10 for the dealer.
Whoever has the highest total is the winner.
There is no betting, no busting, and no hitting. Save that for real blackjack.

 */

package com.company;

// java libraries used in the program
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    //variable declaration
    ArrayList<Integer> player = new ArrayList<>();        // array that will hold the player's card numbers/amount
    int pCount = 0;                                       // hold the user's current amount total for cards in hand
    int hand = 0;                                         // holds the value of the cards added to the array list and player's hand
    int pSum = 0;                                         // holds the user's final score
    int i;                                                // variable used to control the for loops that will add the
                                                          // cards to the player's or dealer's hand

    String ans;                                           // hold the user's input to control the loop that will add a card to their hand
    Scanner scanner = new Scanner(System.in);             // reads in user's input for adding a card to their hand

    ArrayList<Integer> dealer = new ArrayList<>();        // array that will hold the dealer's card numbers/amount
    int dCount = 0;                                       // hold the dealer's current amount total for cards in hand
    int dHand = 0;                                        // holds the value of the cards added to the array list and dealer's hand
    int dSum = 0;                                         // holds the dealer's final score


    // method to start the blackjack game between the user and "dealer"
    public void game() {

        // generates greeting
        System.out.println("Howdy, Player!");
        System.out.println("You look lucky ... ");
        System.out.println("How about you have a seat and we have us a nice little " +
                "game of Blackjack?");


        // shows/implies that the Dealer gives the player two random cards
        // then generates a random number between 1 and 10
        System.out.println("");
        System.out.println("I reckon, it would help if I told you a little about the game. The object is to get as close to 21");
        System.out.print("without going over using value of the cards in your hand. ");
        System.out.println("Now I will draw two random cards for you, player.");

        System.out.println("");


        // add cards to the player's ArrayList
        for (i = 0; i < 2; i++) {
            player.add((int) (Math.round((Math.random() * 10) + 1)));
            pCount += player.get(i);
        }

        // Reveals the player's current cards
        System.out.println("Player, your first card is [" + player.get(0) + "].");
        System.out.println("Your second card is [" + player.get(1) + "].");
        System.out.println("Your current cards total to: " + pCount);

        System.out.println("");

        // Asks if the user would like to add a card to their hand...
        System.out.println("So player, would you like to 'STAND' with the cards that you already have? Or give your hand a 'HIT' to");
        System.out.print("increase your odds of winning? Please enter 'STAND' to keep your current cards or 'HIT' to add a new one: ");

        // holds the user's choice to STAND or HIT
        ans = scanner.nextLine().toUpperCase();

        // while loop that will allow the user to control whether or not to add cards to the player's hand
        while ((!ans.equals("STAND")) && (!ans.equals(" "))) {

            // for loop to add cards (randomly generated numbers) to the player's hand
            for (i = 0; i < 1; i++) {

                hand = (int) (Math.round((Math.random() * 10) + 1));

                player.add((hand));

                pSum += hand;

            }

            //displays cards currently in the player's hand
            System.out.println("Your current cards are: " + player);
            System.out.print("Please enter 'STAND' to keep your current cards or 'HIT' to add a new one: ");

            // holds the user's choice to STAND or HIT
            ans = scanner.nextLine().toUpperCase();


        } // end of while

        // calculates the player's card amount total then displays it
        pSum = pSum + pCount;
        System.out.println("Your total is: " + pSum);

        System.out.println("");


        // Dealer's turn starts
        System.out.println("It is now the the Dealer's turn.");
        System.out.println("The Dealer draws two cards.");


        // add cards to the dealer's ArrayList (hand)
        for (i = 0; i < 2; i++) {
            dealer.add((int) (Math.round((Math.random() * 10) + 1)));
            dCount += dealer.get(i);
        }

        //adds the dealer's current card amount to the variable that will hold the  final total
        dSum += dCount;

//        System.out.println("The Dealer's current card total is: " + dCount);


        while (dSum < 20) {

            // for loop to add cards to the dealer's hand
            for (i = 0; i < 1; i++) {
                dHand = (int) (Math.round((Math.random() * 10) + 1));

                dealer.add((dHand));

                dSum += dHand;
            }
            System.out.println("The Dealer drew another card ...");

        } // end of while loop

        // prints of the arrayList showing what cards the dealer pulled and the dealer's current score
        System.out.println("The Dealer drew: " + dealer);
        System.out.println("Dealer's total is: " + dSum);

        System.out.println("");

        // Nested to if statement that with determines the game winner and displays a message for the user
        if (pSum == 21) {
            System.out.println("YOU WIN, PARDNER! GREAT JOB!");
            System.out.println("Thanks for playing.");
        } else if (dSum == 21) {
            System.out.println("Dealer WINS! You LOSE, Pardner! Better Luck Next Time.");
            System.out.println("Thanks for playing.");
        }else if ((dSum > 21) && (pSum > 21)){
            System.out.println("It's a BUST!! Neither of us wins!");
            System.out.println("Thanks for playing.");
        } else {
            if (pSum > dSum) {
                if (pSum <= 21) {
                    System.out.println("YOU WIN, PARDNER! GREAT JOB!");
                    System.out.println("Thanks for playing.");
                } else {
                    System.out.println("YOU LOSE, PARDNER! Maybe Next time!");
                    System.out.println("Thanks for playing.");
                }
            } else if (pSum < dSum) {
                if (dSum <= 21) {
                    System.out.println("Dealer WINS! You LOSE, Pardner! Better Luck Next Time.");
                    System.out.println("Thanks for playing.");
                }
                else
                {
                    System.out.println("YOU WIN, PARDNER! GREAT JOB!");
                    System.out.println("Thanks for playing.");
                }
            } else if (pSum == dSum) {
                System.out.println("It's a TIE! Try Again, next time.");
                System.out.println("Thanks for playing.");
            } else {
                System.out.println("It's a BUST!! Neither of us wins!");
                System.out.println("Thanks for playing.");
            }
        } // of nested if statement


        System.out.println("");


    }// end of game() method


} //end of BlackJack {} Class
