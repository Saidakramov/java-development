package com.pluralsight;

public class Dog {
    private String name;
    private String breed;
    private String sound;
    private String walker;

    public Dog(String name, String bread, String sound, String walker) {
        this.name = name;
        this.breed = bread;
        this.sound = sound;
        this.walker = walker;
    }

    public String bark(){
        return name + " says " + sound;
    }

    public String walk(){
        return walker + " is taking for a walk a " + name;
    }

    public String getBread() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }


    public static void main(String[] args) {
        Dog dog1 = new Dog("Bobby", "Pit Bull", "woof", "Antonio");
        Dog dog2 = new Dog("Max", "Chihuahua", "waf waf waf", "Banderas");

        System.out.println(dog1.bark());
        System.out.println(dog2.bark());
    }

}
