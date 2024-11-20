package com.pluralsight;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Hand hand;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hand = new Hand();
    }

    public Player(){

    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static String input(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
