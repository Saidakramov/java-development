package com.pluralsight;

import static com.pluralsight.Player.input;

public class Main {
    public static void main(String[] args) {


        String player1Name = input("What is the name of a player? ");
        Player player1 = new Player(player1Name);

        String player2Name = input("What is the name of a player? ");
        Player player2 = new Player(player2Name);

        Deck deck = new Deck();
        deck.shuffle();

        // deal 5 cards
        for(int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            player1.getHand().deal(deck.deal());
            player2.getHand().deal(deck.deal());
        }

        int player1Value = player1.getHand().getValue();
        int player2Value = player2.getHand().getValue();
        System.out.println(player1Name + " hand is worth " + player1Value);
        System.out.println(player2Name + " hand is worth " + player2Value);

        int p1Distance = 21 - player1Value;
        int p2Distance = 21- player2Value;
        if (p1Distance < p2Distance){
            System.out.println("Winner : " + player1Name);
        } else if (p2Distance < p1Distance) {
            System.out.println("Winner : " + player2Name);
        } else {
            System.out.println("Its a tie.");
        }
    }
}
