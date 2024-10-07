package com.pluralsight;

public class LoopsEx {
    public static void main(String[] args) {
    testWhile();
    testFor();
    vegetables();
    monkey();

    }

    public static void testWhile(){
        boolean end = false;
        while (!end) {
            System.out.println("Hi ");
            if (Math.random() < 0.05){
                end = true;
            }
        }
    }

    public static void testFor(){
        //int numbers = 0;
        for(int i = 0; i < 20; i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }

    public static void vegetables(){
        String[] vegetables = {"apple", "banana", "strawberry", "mulberry", "plantain", "cucumber", "tomato", "potato"};
        
        for (String v : vegetables){
            System.out.println("I love " + v + ".");
        }
    }

    public static void monkey(){
        for (int x = 10; x >= 1; x--){
            if (x>1){
                System.out.println(x + " little monkeys jumping on the bed, " +
                        "one fell of and bumped his head, " +
                        "mommy called the doctor and the doctor said no more monkeys jumping on the bed");
            }else {
                System.out.println("No more monkeys.");
            }
        }
    }

}
