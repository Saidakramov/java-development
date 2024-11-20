package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit(){
        // only return the suit if the card is face up
        if(isFaceUp){
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue(){
        // only return the value if the card is face up
        if(isFaceUp){
        // this is the string value of the card
        // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue(){
        // only return the value if the card is face up
        if(isFaceUp){
            // determine point value and return it
            // A = 11
            if (value.equalsIgnoreCase("A"))
                return 11;
            // K, Q, J = 10
            if (value.equalsIgnoreCase("K") || value.equalsIgnoreCase("Q") || value.equalsIgnoreCase("J")) {
                return 10;
            }
            // all numeric cards are equal to their face value
            return switch (value) {
                case "2" -> 2;
                case "3" -> 3;
                case "4" -> 4;
                case "5" -> 5;
                case "6" -> 6;
                case "7" -> 7;
                case "8" -> 8;
                case "9" -> 9;
                case "10" -> 10;
                default -> 0; // In case of an invalid card value
            };
        } else {
            return 0;
        }
    }
    public boolean isFaceUp(){
        return isFaceUp;
    }
    public void flip(){
        isFaceUp = !isFaceUp;
    }
}

