package com.pluralsight;

public class DiceProgram {
    public static void main(String[] args) {
        Dice dice = new Dice();

//        int roll1;
//        int roll2;

        int count2 = 0;
        int count4 = 0;
        int count6 = 0;
        int count7 = 0;

        for(int i = 0; i < 100; i++){
            int roll1 = dice.roll();
            int roll2 = dice.roll();
            System.out.println("Roll " + i + ": " + roll1 + " - " + roll2 + "Sum: " + (roll1 + roll2));

            switch (roll1 + roll2){
                case 2:
                    count2++;
                    break;
                case 4:
                    count4++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
            }
        }
        System.out.println("2: " + count2 +
                "\n4: " + count4 +
                "\n6: " + count6 +
                "\n7: " + count7);
    }
}
